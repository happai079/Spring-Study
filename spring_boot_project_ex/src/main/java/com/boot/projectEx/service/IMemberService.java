package com.boot.projectEx.service;

import java.util.HashMap;

import com.boot.projectEx.model.MemberVO;

public interface IMemberService {
	MemberVO loginCheck(HashMap<String, Object> map); // 로그인 
	String idCheck(String memId);	// 아이디 중복 체크
}
