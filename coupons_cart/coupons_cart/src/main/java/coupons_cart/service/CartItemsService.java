package coupons_cart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import coupons_cart.entity.CartItems;

public interface CartItemsService {
	
	public String addorder(  CartItems cartItems );
	 public List<CartItems> fetchAllOrders();
	 public CartItems update(CartItems cartItems);
	 public ResponseEntity<Object> deleteById(String id);
	 

}
