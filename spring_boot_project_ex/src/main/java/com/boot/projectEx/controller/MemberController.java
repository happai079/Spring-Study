package com.boot.projectEx.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.projectEx.model.MemberVO;
import com.boot.projectEx.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	// 로그인 폼으로 이동
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	
	// 로그인 처리 : id와 pwd 전달 받아서 로그인 체크
	@ResponseBody
	@RequestMapping("/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) {
		MemberVO member = service.loginCheck(param);
		String loginResult = "fail";
		
		if(member != null) {
			session.setAttribute("sid", member.getMemId());
			loginResult = "success";
		}

		return loginResult;
	}
	
}
