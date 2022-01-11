package com.spring_mvc_mybatis.book.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc_mybatis.book.dao.IBookDAO;
import com.spring_mvc_mybatis.book.model.BookVO;

@Service
public class BookService implements IBookService {
	@Autowired
	@Qualifier("IBookDAO")
	IBookDAO dao;

	@Override
	public ArrayList<BookVO> showAllBook() {
		return dao.showAllBook();
	}

	@Override
	public void insertBook(BookVO bookVo) {
		dao.insertBook(bookVo);
	}

	@Override
	public void updateBook(BookVO bookVo) {
		dao.updateBook(bookVo);
	}

	@Override
	public void deleteBook(BookVO bookVo) {
		dao.deleteBook(bookVo);
	}

	@Override
	public BookVO showDetailBook(String bookNo) {
		return dao.showDetailBook(bookNo);
	}

	@Override
	public String bookNoCheck(String bookNo) {
		return dao.bookNoCheck(bookNo);
	}

	@Override
	public ArrayList<BookVO> bookSearch(HashMap<String, Object> map) {
		return dao.bookSearch(map);
	}
	
	
}
