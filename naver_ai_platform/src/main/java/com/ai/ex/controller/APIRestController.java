package com.ai.ex.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ai.ex.service.OCRService;

@RestController
public class APIRestController {
	@Autowired
	private OCRService ocrService;
	
	// 요청 받아서 서비스 호출 -> 결과 받아서 반환
	@ResponseBody
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
}
