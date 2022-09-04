package coupons_cart.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import java.util.Date;
import java.util.List;

@Document(collection ="CartItems")
public class CartItems {

	@Id
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}






	private String orderId;
	private String coupons_name;
	private String coupons_desc;
	private int coupons_price;
	private int coupons_qty;
	
	

	public String getorderId() {
		return orderId;
	}

	public void setorderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCoupons_name() {
		return coupons_name;
	}

	public void setCoupons_name(String coupons_name) {
		this.coupons_name = coupons_name;
	}

	public String getCoupons_desc() {
		return coupons_desc;
	}

	public void setCoupons_desc(String coupons_desc) {
		this.coupons_desc = coupons_desc;
	}

	public int getCoupons_price() {
		return coupons_price;
	}

	public void setCoupons_price(int coupons_price) {
		this.coupons_price = coupons_price;
	}

	public int getCoupons_qty() {
		return coupons_qty;
	}

	public void setCoupons_qty(int coupons_qty) {
		this.coupons_qty = coupons_qty;
	}
	
	

	public CartItems(String orderId, String coupons_name, String coupons_desc, int coupons_price, int coupons_qty, String id) {
		super();
		
		this.id=id;
		this.orderId = orderId;
		this.coupons_name = coupons_name;
		this.coupons_desc = coupons_desc;
		this.coupons_price = coupons_price;
		this.coupons_qty = coupons_qty;
	}
	
	

	

	
	public CartItems() {
	}

	
}