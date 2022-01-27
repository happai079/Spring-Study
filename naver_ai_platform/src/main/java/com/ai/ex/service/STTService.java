package com.ai.ex.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.json.JSONObject;
// import org.json.simple.JSONObject;
// import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class STTService {
	@Value("${ai.api.clientId}")
	private String ID;
	@Value("${ai.api.clientSecret}")
	private String SECRET;
	
	public String STTservice(String filePathName, String lang) {
		String clientId = ID;             // Application Client ID";
        String clientSecret = SECRET;     // Application Client Secret";
        String result = "";

        try {
            String imgFile = filePathName;
            File voiceFile = new File(imgFile);

            String language = lang;        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
                result = jsonToString(response.toString());
                resultToFileSave(result);
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
	}
	
	// 챗봇 음성 채팅을 위한 STT
	public String clovaSpeechToText(String filePathName) {
		String clientId = ID;             // Application Client ID";
        String clientSecret = SECRET;     // Application Client Secret";
        
        String result = "";
        
        try {
            String imgFile = filePathName;
            File voiceFile = new File(imgFile);

            String language = "Kor";        // 언어 코드 ( Kor, Jpn, Eng, Chn )
            String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setUseCaches(false);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/octet-stream");
            conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            OutputStream outputStream = conn.getOutputStream();
            FileInputStream inputStream = new FileInputStream(voiceFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            BufferedReader br = null;
            int responseCode = conn.getResponseCode();
            if(responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {  // 오류 발생
                System.out.println("error!!!!!!! responseCode= " + responseCode);
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            String inputLine;

            if(br != null) {
                StringBuffer response = new StringBuffer();
                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                }
                br.close();
                System.out.println(response.toString());
                result = jsonToString(response.toString()); // JSON 문자열에서 텍스트 추출
                resultToFileSave(result); //파일로 저장
                
            } else {
                System.out.println("error !!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return result;
	}
	
	public String jsonToString(String jsonResultStr) {
		String result = "";
		try {
			//JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = new JSONObject(jsonResultStr);
			
			result = (String) jsonObj.get("text"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 추출한 텍스트를 txt 파일로 저장
	public void resultToFileSave(String result) {
		try {
			String fileName = Long.valueOf(new Date().getTime()).toString();
			String filePathName = "C:/upload/" + "stt_" +fileName + ".txt";
			
			FileWriter fw = new FileWriter(filePathName);
			fw.write(result);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
