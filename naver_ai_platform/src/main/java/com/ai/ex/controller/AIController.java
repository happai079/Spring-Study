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
import com.ai.ex.service.CFRCelebrityService;

@Controller
public class AIController {
	@Autowired
	private CFRCelebrityService cfrServiceCel;
	
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
}
