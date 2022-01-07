package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@RequestMapping("/product/productForm")
	public String productFormView() {
		return "product/productForm";
	}
	
	// (1) HttpServletRequest 클래스의 getParameter() 메서드 사용
	@RequestMapping("/product/newProduct")
	public String insertProduct(HttpServletRequest request, Model model) {
		String prdNo = request.getParameter("prdNo");
		String prdName = request.getParameter("prdName");
		String prdPrice = request.getParameter("prdPrice");
		String prdMaker = request.getParameter("prdMaker");
		String prdDate = request.getParameter("prdDate");
		String prdQty = request.getParameter("prdQty");
		
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdMaker", prdMaker);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdQty", prdQty);
		
		return "product/productResult";
	}
	
	// (2) @RequestParam 어노테이션 사용
	@RequestMapping("/product/newProduct2")
	public String insertProduct2(@RequestParam("prdNo") String prdNo,
								 @RequestParam("prdName") String prdName,
								 @RequestParam("prdPrice") String prdPrice,
								 @RequestParam("prdMaker") String prdMaker,
								 @RequestParam("prdDate") String prdDate,
								 @RequestParam("prdQty") String prdQty,
								 Model model) {
		
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdMaker", prdMaker);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdQty", prdQty);
		
		return "product/productResult";
	}
	
	// (3) Command 객체 사용
	@RequestMapping("/product/newProduct3")
	public String insertProduct3(Product product) {
		return "product/productCmdResult";
	}
	
	// Command 객체 이름 변경 : @ModleAttribute 어노테이션 사용
	@RequestMapping("/product/newProduct4")
	public String insertProduct4(@ModelAttribute("prd") Product product) {
		return "product/productCmdRenameResult";
	}
	
	// (4) URL을 통한 데이터 전송 : @PathVariable 어노테이션 사용
		@RequestMapping("/product/productModify/{prdNo}")
		public String productModify(@PathVariable String prdNo) {
			// 수정됐다고 가정하고 home으로 이동
			System.out.println(prdNo);
			return "jsp/home";
		}
}
