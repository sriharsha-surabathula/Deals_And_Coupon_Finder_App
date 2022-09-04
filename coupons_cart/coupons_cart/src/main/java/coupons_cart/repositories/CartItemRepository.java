package coupons_cart.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import coupons_cart.entity.CartItems;


@Repository
public interface CartItemRepository extends MongoRepository<CartItems, String> {
	
	CartItems findByorderId(String orderId);

}
