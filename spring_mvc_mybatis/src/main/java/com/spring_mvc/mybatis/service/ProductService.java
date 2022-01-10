package com.spring_mvc.mybatis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatis.dao.IProductDAO;
import com.spring_mvc.mybatis.model.ProductVO;

// service 클래스 : 컨트롤러에서 사용할 컴포넌트
@Service
public class ProductService implements IProductService {
	// MyBatis 사용하는 경우 DI 설정
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;

	// 전체 상품 조회
	@Override
	public ArrayList<ProductVO> listAllProduct() {
		return dao.listAllProduct();
	}

	// 상품 정보 등록
	@Override
	public void insertProduct(ProductVO prdVo) {
		dao.insertProduct(prdVo);
	}

	// 상품 정보 수정
	@Override
	public void updateProduct(ProductVO prdVo) {
		// TODO Auto-generated method stub

	}

	// 상품 정보 삭제
	@Override
	public void deleteProduct(String prdNo) {
		// TODO Auto-generated method stub

	}

	// 상세 상품 조회
	@Override
	public ProductVO detailViewProduct(String prdNo) {
		return dao.detailViewProduct(prdNo);
	}

}
