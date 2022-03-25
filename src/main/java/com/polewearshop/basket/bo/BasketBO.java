package com.polewearshop.basket.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.polewearshop.basket.dao.BasketDAO;
import com.polewearshop.basket.model.Basket;

@Service
public class BasketBO {
	
	@Autowired
	private BasketDAO basketDAO;
	
	public void addBasket(Basket basket) {
		basketDAO.addBasket(basket);
	}
	
	public void updateBasketNumberById(int basketId) {
		basketDAO.updateBasketNumberById(basketId);;
	}
}
