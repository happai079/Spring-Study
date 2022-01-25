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

import com.ai.ex.model.ObjectVO;

@Service
public class ObjectDetectionService {
	
	@Value("${ai.api.clientId}")
	private String ID;
	@Value("${ai.api.clientSecret}")
	private String SECRET;
	
	public ArrayList<ObjectVO> clovaObjectDetect(String filePathName) {
		StringBuffer reqStr = new StringBuffer();
        String clientId = ID;//애플리케이션 클라이언트 아이디값";
        String clientSecret = SECRET;//애플리케이션 클라이언트 시크릿값";
        
        ArrayList<ObjectVO> objectList = new ArrayList<ObjectVO>();

        try {
            String paramName = "image"; // 파라미터명은 image로 지정
            String imgFile = filePathName;
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision-obj/v1/detect"; // 객체 인식
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
                System.out.println(response.toString());
                objectList = jsonToVoList(response.toString());
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objectList;
	}
	
	 
    // API 서버로부터 받은 JSON 형태의 결과 데이터를 전달받아서 name, x1, x2, y1, y2 추출하고
	// ObjectVO 리스트 만들어 반환하는 함수
    public ArrayList<ObjectVO> jsonToVoList(String jsonResultStr){
    	ArrayList<ObjectVO> objectList = new ArrayList<ObjectVO>();
    	String name;
    	double x1, x2, y1, y2;
    	
    	try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(jsonResultStr);
			JSONArray objectArray = (JSONArray) jsonObj.get("predictions");			
			JSONObject obj0 = (JSONObject) objectArray.get(0);
			
			// nameArray 추출
			JSONArray nameArray = (JSONArray) obj0.get("detection_names");
			// boxArray 추출 
			JSONArray boxArray = (JSONArray) obj0.get("detection_boxes");
			
			// name과 box 정보 추출
			for(int i=0; i<nameArray.size(); i++) {
				name = (String) nameArray.get(i);
				
				// 객체별 박스 정보를 가지고 있는 Array
				JSONArray tempArray = (JSONArray) boxArray.get(i);
				x1 = (double) tempArray.get(0);
				y1 = (double) tempArray.get(1);
				x2 = (double) tempArray.get(2);
				y2 = (double) tempArray.get(3);
				
				// vo에 저장
				ObjectVO vo = new ObjectVO();
				vo.setName(name);
				vo.setX1(x1);
				vo.setX2(x2);
				vo.setY1(y1);
				vo.setY2(y2);
				
				// 리스트에 저장
				objectList.add(vo);
			}
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	return objectList;
    }
}
