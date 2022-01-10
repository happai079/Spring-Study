package com.spring_mvc.mybatis.contoller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	// 상품 상제 정보 페이지로 이동
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	// @PathVariableView - 페이지에서 url을 통해 controller로 데이터 전송
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		// 상품번호 전달하고, 해당 상품 정보 받아오기 
		ProductVO prd = service.detailViewProduct(prdNo);
		model.addAttribute("prd", prd);
		return "product/productDetailView";  // 상품 상세 정보 뷰 페이지
	}
	
	// 상품 정보 수정 페이지로 이동 (입력 폼에 기존 정보 보여주기)
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo, Model model) {
		// 상품번호 전달하고, 해당 상품 정보 받아오기 
		ProductVO prd = service.detailViewProduct(prdNo);
		model.addAttribute("prd", prd);
		return "product/updateProductForm";
	}
	
	// 상품 정보 수정
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductVO prd) {	// Command 객체
		service.updateProduct(prd);
		return "redirect:./listAllProduct"; 		// 다시 전체 조회하여 보여줌
	}
}
