package com.java6ASM.service;

import java.util.Collection;

import com.java6ASM.dto.CartDTO;



public interface CartService {

	void addCart(String idProduct);

	Collection<CartDTO> getProduct();

	Double getAmount();

	void deleteProduct(String idProduct);

	void deleteAllProduct();

	void sumQty(String idProduct, int qty);
	
	Long saveOrder(String province, String district, String country);
	
	int countCart();
}
