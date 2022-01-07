package com.spring_mvc.mybatis.contoller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatis.model.ProductVO;
import com.spring_mvc.mybatis.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	// 실행시 index 페이지 열기
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	// 전체 상품 조회
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		ArrayList<ProductVO> prdList = service.listAllProduct();
		model.addAttribute("prdList", prdList);
		return "product/productListView";
	}
	
	// 상품 등록폼으로 이동
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}
	
	// 상품 정보 등록
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductVO prd) {	// Command 객체
		service.insertProduct(prd);
		return "redirect:./listAllProduct"; 		// 다시 전체 조회하여 보여줌
		// return "redirect:/product/listAllProduct";
		// return "/product/productListView";		// 그냥 뷰 페이지로 이동하면 데이터가 안 보임
	}
}
