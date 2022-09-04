package coupons_cart.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import coupons_cart.entity.CartItems;
import coupons_cart.exceptions.OrderRequestException;
import coupons_cart.repositories.CartItemRepository;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CartItemsServiceImpl implements CartItemsService {
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	public String addorder(  CartItems cartItems ){
		cartItemRepository.insert( cartItems );
		return ("Added Successfully");		
	}
	
	
    public List<CartItems> fetchAllOrders() {
		return  cartItemRepository.findAll();
    }

	public CartItems update(CartItems cartItems) {
		Optional<CartItems> optionalCartItems = Optional.ofNullable(cartItemRepository.findByorderId(cartItems.getorderId()));
		if(optionalCartItems.isPresent()){
			return  cartItemRepository.save(cartItems);
		}else{
			return null;
		}

	}

	public ResponseEntity<Object> deleteById(String id)
	{
		boolean isUserExist=cartItemRepository.existsById(id);
		 if(isUserExist) {
			 cartItemRepository.deleteById(id);
			 return new ResponseEntity<Object>("user deleted with id "+id,HttpStatus.OK);
		 }
		 else
		 {
		 	throw new OrderRequestException("CAN NOT DELETE AS USER NOT FOUND WITH THIS ID ::");
		 }
	}
}
