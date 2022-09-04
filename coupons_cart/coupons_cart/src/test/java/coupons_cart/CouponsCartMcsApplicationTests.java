package coupons_cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import coupons_cart.entity.CartItems;
import coupons_cart.exceptions.OrderRequestException;
import coupons_cart.repositories.CartItemRepository;
import coupons_cart.service.CartItemsService;


@SpringBootTest
class CouponsCartMcsApplicationTests {

	@Autowired
	private CartItemsService service;
	
	@MockBean
	private CartItemRepository repository;
	
	@Test
	@DisplayName("The Get All Order Test is Running....")
	public void fetchAllOrdersTest() {
		when(repository.findAll()).thenReturn(Stream
				.of(new CartItems("abc","abc","abc",12,12,"1234"),new CartItems("abc","abc","abc",12,12,"1234")).collect(Collectors.toList()));
		assertEquals(2, service.fetchAllOrders().size());
	}
	
	@Test
	@DisplayName("The Add Order Test is Running....")
	public void addorderTest() {
		CartItems cartItems = new CartItems("abc","abc","abc",12,12,"1234");
		when(repository.save(cartItems)).thenReturn(cartItems);
		assertEquals("Added Successfully", service.addorder(cartItems));
	}
	
	@Test
	@DisplayName("The Delete by Id Test is Running....")
	@Disabled
	public void deleteByIdTest() {
		String id = "abc";
		CartItems cartItems = new CartItems("abc","abc","abc",12,12,"1234");
		repository.save(cartItems);
		service.deleteById(id);
		
	}
	@Test
	public void updateProductTest() {
		CartItems cartItems = new CartItems("abc","abc","abc",12,12,"1234");
		repository.save(cartItems);
		CartItems cartItems1 = new CartItems("cde","cde","abc",12,12,"1234");
		assertEquals(null, service.update(cartItems1));
		
		
	}
	
}