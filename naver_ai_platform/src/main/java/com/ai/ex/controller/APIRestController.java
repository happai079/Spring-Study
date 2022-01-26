package com.ai.ex.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ai.ex.model.ObjectVO;
import com.ai.ex.model.PoseVO;
import com.ai.ex.service.ChatbotService;
import com.ai.ex.service.OCRService;
import com.ai.ex.service.ObjectDetectionService;
import com.ai.ex.service.PoseEstimationService;
import com.ai.ex.service.STTService;
import com.ai.ex.service.TTSService;

@RestController
public class APIRestController {
	@Autowired
	private OCRService ocrService;

	@Autowired
	private PoseEstimationService poseService;
	
	@Autowired
	private ObjectDetectionService objectService;
	
	@Autowired
	private STTService sttService;

	@Autowired
	private TTSService ttsService;

	@Autowired
	private ChatbotService chatService;
	
	// OCR
	@RequestMapping("/clovaOCR")
	public String ocrUplaod(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		String uploadPath = "C:/upload/";
		
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		File file1 = new File(filePathName);
		
		file.transferTo(file1);
		
		String result = ocrService.clovaOCRService(filePathName);
		// System.out.println(result);
		return result;
	}
	
	// 포즈인식
	@RequestMapping("/poseDetect")
	public ArrayList<PoseVO> poseDetect(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		// 1. 파일 저장 경로 설정: 실제 서비스되는 위치(프로젝트 외부에 저장)
		String uploadPath = "C:/upload/";
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File file1 = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(file1);
		
		ArrayList<PoseVO> poseList = poseService.poseEstimate(filePathName);
		
		return poseList;	
	}
	
	// 객체 탐지
	@RequestMapping("/objectDetect")
	public ArrayList<ObjectVO> objectDetect(@RequestParam("uploadFile") MultipartFile file) throws IOException {
		// 1. 파일 저장 경로 설정: 실제 서비스되는 위치(프로젝트 외부에 저장)
		String uploadPath = "C:/upload/";
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File file1 = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(file1);
		
		ArrayList<ObjectVO> objectList = objectService.clovaObjectDetect(filePathName);
		
		return objectList;	
	}
	
	// TTS
	@RequestMapping("/clovaTTS2")
	public String  clovaTTS(@RequestParam("uploadFile") MultipartFile file,
							@RequestParam("speeker") String speeker) {		
		
		String result = "";
		
		try {
			// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
			String uploadPath = "C:/upload/";
			
			// 2. 원본 파일 이름 알아오기
			String originalFileName = file.getOriginalFilename();
			String filePathName = uploadPath + originalFileName;
			
			// 3. 파일 생성
			File file1 = new File(filePathName);
			
			// 4. 서버로 전송
			file.transferTo(file1);				
			
			// 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
			// 서비스에서 저장된 파일명 받아오기
			result = ttsService.clovaTextToSpeech(filePathName, speeker);			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result; // 저장된 음성 파일명 반환
	}
	
	// STT
	@RequestMapping("/clovaSTT2")
	public String  clovaSTT(@RequestParam("uploadFile") MultipartFile file) {		
		
		String result = "";
		
		try {
			// 1. 파일 저장 경로 설정 : 실제 서비스되는 위치 (프로젝트 외부에 저장)
			String uploadPath = "C:/upload/";
			
			// 2. 원본 파일 이름 알아오기
			String originalFileName = file.getOriginalFilename();
			String filePathName = uploadPath + originalFileName;
			
			// 3. 파일 생성
			File file1 = new File(filePathName);
			
			// 4. 서버로 전송
			file.transferTo(file1);				
			
			// 서비스에 파일 path와 파일명 전달  -> 서비스 메소드에서 변경
			// 서비스에서 반환된 PoseVO 리스트 저장
			result = sttService.clovaSpeechToText(filePathName);			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 쳇봇
	@RequestMapping("/chatbot")
	public String chatbot(@RequestParam("message") String message) {
		String result = chatService.main(message);
		return result;
	}
	
	// 챗봇 TTS
	@RequestMapping("/chatbotTTS")
	public String  chatbotTTS(@RequestParam("message") String message ) {
		String result = ttsService.chatbotTextToSpeech(message);
		return result;  // voiceFileName;  // 저장된 음성 파일명 반환
	}
}
