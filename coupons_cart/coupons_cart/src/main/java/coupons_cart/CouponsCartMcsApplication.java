package coupons_cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient

public class CouponsCartMcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponsCartMcsApplication.class, args);
	}

}
