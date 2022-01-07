package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	// (2) @RequestParam 어노테이션 사용
	@RequestMapping("/student/newStudent2")
	public String insertStudent2(@RequestParam("no") String no,
								 @RequestParam("name") String name,
								 @RequestParam("year") String year,
								 Model model) {
		
		// view 페이지로 출력 : Model 설정
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// (3) Command 객체 사용 - 자동으로 View Model에 등록
	@RequestMapping("/student/newStudent3")
	public String insertStudent3(Student student) {
		System.out.println(student.getName());
		return "student/studentCmdResult";
	}
	
	// Command 객체 이름 변경 : @ModleAttribute 어노테이션 사용
	@RequestMapping("/student/newStudent4")
	public String insertStudent4(@ModelAttribute("stdInfo") Student student) {
		return "student/studentCmdRenameResult";
	}
	
	// (4) URL을 통한 데이터 전송 : @PathVariable 어노테이션 사용
	@RequestMapping("/student/studentModify/{stdNo}")
	public String studentModify(@PathVariable String stdNo) {
		// 수정됐다고 가정하고 home으로 이동
		System.out.println(stdNo);
		// return "jsp/home";
		// 포워딩: redirect
		return "redirect:/";
	}
	
}
