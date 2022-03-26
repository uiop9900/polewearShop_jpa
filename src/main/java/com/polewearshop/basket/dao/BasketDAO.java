package com.polewearshop.basket.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.polewearshop.basket.model.Basket;

@Repository
public interface BasketDAO {

	public void addBasket(Basket basket);
	
	public void updateBasketNumberById(
			@Param("id") int basketId,
			@Param("basketNumber") int basketNumber);
}
