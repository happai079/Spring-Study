package com.spring_mvc.mybatis.service;

import java.util.ArrayList;

import com.spring_mvc.mybatis.model.ProductVO;

// 인터페이스: 추상 메서드로만 구성된 클래스 - 구현 클래스에서 반드시 구현
public interface IProductService {
	ArrayList<ProductVO> listAllProduct();			// 전체 상품 조회
	void insertProduct(ProductVO prdVo);			// 상품 정보 등록
	void updateProduct(ProductVO prdVo);			// 상품 정보 수정
	void deleteProduct(String prdNo);				// 상품 정보 삭제
	ProductVO detailViewProduct(String prdNo);		// 상세 상품 조회
}
