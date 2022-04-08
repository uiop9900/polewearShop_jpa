package com.polewearshop.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.polewearshop.product.bo.ProductBO;
import com.polewearshop.product.bo.ProductImagesBO;
import com.polewearshop.product.model.Product;
import com.polewearshop.product.model.ProductView;
import com.polewearshop.product.model.ProductViewCompact;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductBO productBO;
	
	@Autowired
	private ProductImagesBO productImagesBO;
	
	
	// 쇼핑몰 메인 화면
	@RequestMapping("/main_view")
	public String main(Model model) {
		model.addAttribute("viewName", "product/main");
		
		List<ProductViewCompact> productList = productBO.generateProductViewCompactList();
		model.addAttribute("productList", productList);
		return "template/layout";
	}
	
	// 쇼핑몰 세부화면
	@RequestMapping("/shop_view")
	public String shopPageView(
			@RequestParam("type") String type,
			Model model
			) {
		List<ProductViewCompact> productList = productBO.generateProductViewCompactListByType(type);
		
		model.addAttribute("type", type);
		model.addAttribute("productList", productList);
		model.addAttribute("viewName", "product/shop" );
		
		return "template/layout";
	}
	
	//상품세부화면
	@RequestMapping("/shop_detailed_view")
	public String shopDetailedView(
			Model model,
			@RequestParam("type") String type,
			@RequestParam("productId") int productId
			) {
		
		
		ProductView product = productBO.generateProductViewById(productId);
		String mainImagePath = productImagesBO.getOneProductImagePathByProductId(productId);
		//productId를 통해 reviewList를 가져오고자 함
		
		model.addAttribute("mainImagePath", mainImagePath);
		model.addAttribute("product", product);
		model.addAttribute("type", type);
		model.addAttribute("productId", productId);
		
		model.addAttribute("viewName", "product/shop_detailed");
		return "template/layout";
	}
	
	// 쇼핑몰 베스트화면
	@RequestMapping("/best_list_view")
	public String bestView(Model model) {
		
		List<ProductViewCompact> productList = productBO.generateProductViewCompactListforBest();
		
		
		model.addAttribute("productList", productList);
		model.addAttribute("viewName", "product/best_list");
		return "template/layout";
	}
}
