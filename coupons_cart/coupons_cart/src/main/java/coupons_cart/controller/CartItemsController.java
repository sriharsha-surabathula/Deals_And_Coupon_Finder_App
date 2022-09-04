package coupons_cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import coupons_cart.entity.CartItems;
import coupons_cart.service.CartItemsService;


@RestController
@RequestMapping("/cartItems")
public class CartItemsController {
	
	
	@Autowired
	private CartItemsService cartItemsService;

	
	@PostMapping("/addorder")
	public String addNeworder( @RequestBody CartItems cartItems ){
			return cartItemsService.addorder( cartItems );		
	}

	@GetMapping("/allOrders")
	public List<CartItems> fetchAllProducts(){
		return  cartItemsService.fetchAllOrders();
	}


	@PostMapping("/updateProduct")
	public CartItems updateProduct(@RequestBody  CartItems cartItems){

		return  cartItemsService.update(cartItems);
	}

	@DeleteMapping("/deleteProduct/{id}")
	 public String deleteProductById(@PathVariable("id") String id)
	 {
		cartItemsService.deleteById(id);
		return "id no "+id+" is deleted";
	 }

}
