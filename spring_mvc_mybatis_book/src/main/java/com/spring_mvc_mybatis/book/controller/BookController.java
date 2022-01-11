package com.spring_mvc_mybatis.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc_mybatis.book.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
}
