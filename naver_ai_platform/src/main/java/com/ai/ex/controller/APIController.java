package com.ai.ex.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ai.ex.model.CelebrityVO;
import com.ai.ex.model.FaceVO;
import com.ai.ex.service.CFRCelebrityService;
import com.ai.ex.service.CFRFaceRecogService;
import com.ai.ex.service.STTService;
import com.ai.ex.service.TTSService;

@Controller
public class APIController {
	@Autowired
	private CFRCelebrityService cfrServiceCel;

	@Autowired
	private CFRFaceRecogService cfrRecogService;

	@Autowired
	private STTService sttService;

	@Autowired
	private TTSService ttsService;

	@RequestMapping("/")
	public String indexView() {
		return "index";
	}
	
	@RequestMapping("/faceRecogCelForm")
	public String faceRecogCelForm() {
		return "celebrityView";
	}
	
	// 파일 받아서 유명인 얼굴 인식 API 호출 결과
	@RequestMapping("/faceRecogCel")
	public String faceRecogCel(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {
		
		// 1. 파일 저장 경로 설정: 실제 서비스되는 위치(프로젝트 외부에 저장)
		String uploadPath = "C:/upload/";
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File file1 = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(file1);
		
		ArrayList<CelebrityVO> celList = new ArrayList<CelebrityVO>();
		
		// 서비스에서 CelebrityVO 리스트 반환
		celList = cfrServiceCel.clovaFaceRecogCel(filePathName);
		
		// Model에 저장
		model.addAttribute("celList", celList); 
		model.addAttribute("fileName", originalFileName); 
		
		return "celebrityView";
	}
	
	@RequestMapping("/faceRecogForm")
	public String faceRecogForm() {
		return "faceRecogView";
	}
	
	// 얼굴 감지 API 호출
	@RequestMapping("/faceRecog")
	public String faceRecog(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {
		// 1. 파일 저장 경로 설정: 실제 서비스되는 위치(프로젝트 외부에 저장)
		String uploadPath = "C:/upload/";
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File file1 = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(file1);
		
		ArrayList<FaceVO> faceList = new ArrayList<FaceVO>();
		
		// 서비스에서 CelebrityVO 리스트 반환
		faceList = cfrRecogService.faceRecog(filePathName);
		
		// Model에 저장
		model.addAttribute("faceList", faceList); 
		model.addAttribute("fileName", originalFileName); 
		
		return "faceRecogView";	
	}
	
	// OCR
	@RequestMapping("/clovaOCRForm")
	public String clovaOCR() {
		return "ocrView";
	}
	
	// Pose Estimation
	@RequestMapping("/clovaPoseForm")
	public String clovaPoseForm() {
		return "poseView";
	}

	// Object Detection
	@RequestMapping("/clovaObjectForm")
	public String clovaObjectForm() {
		return "objectView";
	}

	// STT(Speech To Text)
	@RequestMapping("/clovaSTTForm")
	public String clovaSTTForm() {
		return "clovaSTTForm";
	}
	
	@RequestMapping("/clovaSTT")
	public String clovaSTT(@RequestParam("uploadFile") MultipartFile file, @RequestParam("language") String language, Model model) throws IOException {
		// 1. 파일 저장 경로 설정: 실제 서비스되는 위치(프로젝트 외부에 저장)
		String uploadPath = "C:/upload/";
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File file1 = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(file1);
		
		String result = sttService.STTservice(filePathName, language);
		model.addAttribute("result", result);
		model.addAttribute("file", originalFileName);
		
		return "clovaSTTForm";
	}
	
	@RequestMapping("/clovaTTSForm")
	public String clovaTTSForm() {
		return "clovaTTSForm";
	}
	
	@RequestMapping("/clovaTTS")
	public String clovaTTS(@RequestParam("uploadFile") MultipartFile file, @RequestParam("speaker") String speaker, Model model) throws IOException {
		// 1. 파일 저장 경로 설정: 실제 서비스되는 위치(프로젝트 외부에 저장)
		String uploadPath = "C:/upload/";
		
		// 2. 원본 파일 이름 알아오기
		String originalFileName = file.getOriginalFilename();
		String filePathName = uploadPath + originalFileName;
		
		// 3. 파일 생성
		File file1 = new File(filePathName);
		
		// 4. 서버로 전송
		file.transferTo(file1);
		
		String result = ttsService.clovaTextToSpeech(filePathName, speaker);
		model.addAttribute("result", result);
		
		return "clovaTTSForm";
	}
	
	// 챗봇
	@RequestMapping("/chatbotForm")
	public String chatbotForm() {
		return "chatbotForm";
	}

	// 챗봇2
	@RequestMapping("/chatbotForm2")
	public String chatbotForm2() {
		return "chatbotForm2";
	}
}
