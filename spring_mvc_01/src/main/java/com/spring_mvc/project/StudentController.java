package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	// home애서 studentForm 페이지 요청 처리
	@RequestMapping("/student/studentForm")
	public String studentFormView() {
		return "student/studentForm";
	}
	
	// (1) HttpServletRequest 클래스의 getParameter() 메서드 사용
	@RequestMapping("/student/newStudent")
	public String insertStudent(HttpServletRequest request, Model model) {
		// 데이터 받기
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
}
