package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	@RequestMapping("/product/productForm")
	public String productFormView() {
		return "product/productForm";
	}
	
	@RequestMapping("/product/newProduct")
	public String insertProduct(HttpServletRequest request, Model model) {
		String prdNo = request.getParameter("prdNo");
		String prdName = request.getParameter("prdName");
		String prdPrice = request.getParameter("prdPrice");
		String prdMaker = request.getParameter("prdMaker");
		String prdDate = request.getParameter("prdDate");
		String prdQty = request.getParameter("prdQty");
		
		model.addAttribute("no", prdNo);
		model.addAttribute("name", prdName);
		model.addAttribute("price", prdPrice);
		model.addAttribute("company", prdMaker);
		model.addAttribute("date", prdDate);
		model.addAttribute("stock", prdQty);
		
		return "product/productResult";
	}
}
