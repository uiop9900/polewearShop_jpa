package com.polewearshop.product.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polewearshop.product.dao.ProductDAO;
import com.polewearshop.product.model.Product;

@Service
public class ProductBO {

	@Autowired
	private ProductDAO productDAO;
	
	public void addProduct(Product product) {
		productDAO.insertProduct(product);
	}
	
}
