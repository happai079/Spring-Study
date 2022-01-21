package com.ai.ex.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ai.ex.model.CelebrityVO;

@Service
public class CFRCelebrityService {
	
	@Value("${ai.cfr.clientId}")
	private String ID;
	@Value("${ai.cfr.clientSecret}")
	private String SECRETE;
	
	public ArrayList<CelebrityVO> clovaFaceRecogCel(String filePathName) {
		StringBuffer reqStr = new StringBuffer();
		 String clientId = ID;//애플리케이션 클라이언트 아이디값";
	     String clientSecret = SECRETE;//애플리케이션 클라이언트 시크릿값";
	     
	     ArrayList<CelebrityVO> celList = new ArrayList<CelebrityVO>();

        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = filePathName;  // 전송할 이미지 파일
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision/v1/celebrity"; // 유명인 얼굴 인식
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            // multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";
            // file 추가
            String fileName = uploadFile.getName();
            writer.append("--" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-Type: "  + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();
            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--" + boundary + "--").append(LINE_FEED);
            writer.close();
            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString()); // 서버로부터 받은 결과를 콘솔에 출력 (JSON 형태)
                // jsonToList() 메서드 호출하면서 json문자열 전달
                celList = jsonToVoList(response.toString());
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // CelebrityVO 리스트 반환
        return celList;
	}
	
	// API 서버로부토 받은 JSON 형태의 결과 데이터에서 value, confidence 추출
	// VO 리스트 만들어 반환하는 함수
	public ArrayList<CelebrityVO> jsonToVoList(String jsonResultStr){
		ArrayList<CelebrityVO> celList = new ArrayList<CelebrityVO>();		// value, confidence 정보를 담을 리스트
		
		try {
			JSONParser jsonParser = new JSONParser();							// JSONParser 객체
			JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonResultStr);	// JSONObject 객체
			JSONArray celebrityArray = (JSONArray) jsonObj.get("faces");		// JSON 형태의 문자열에서 JSON 오브젝트 "faces"추출해서 JSONArray에 저장 

			if(celebrityArray != null) {
				// JSONArray의 각 요소에서 value와 confidence추출
				for(int i=0; i<celebrityArray.size(); i++) {
					JSONObject tempObj = (JSONObject) celebrityArray.get(i);
					tempObj = (JSONObject) tempObj.get("celebrity");
					String value = (String) tempObj.get("value");
					double confidence = (double) tempObj.get("confidence");
					
					// CelebrityVO 담아 리스트에 추가
					CelebrityVO vo = new CelebrityVO();
					vo.setValue(value);
					vo.setConfidence(confidence);
					
					celList.add(vo);
 				}
			}else {
				// 유명인 못 찾은 경우
				CelebrityVO vo = new CelebrityVO();
				vo.setValue("없음");
				vo.setConfidence(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return celList;
	}
	
}
