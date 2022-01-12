package com.multi.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUploadController {
	// 파일 업로드 폼으로 이동
	@RequestMapping("/fileUploadForm")
	public String fileUploadForm() {
		return "upload/fileUploadForm";
	}
}
