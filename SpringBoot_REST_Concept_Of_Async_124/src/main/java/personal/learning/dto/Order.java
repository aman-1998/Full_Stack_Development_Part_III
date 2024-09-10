package personal.learning.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {
	
	@JsonProperty("productId")
	private int productId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("productType")
	private String productType;
	
	@JsonProperty("qty")
	private int qty;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("trackingId")
	private String trackingId;

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getProductType() {
		return productType;
	}

	public int getQty() {
		return qty;
	}

	public double getPrice() {
		return price;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	@Override
	public String toString() {
		return "Order [productId=" + productId + ", name=" + name + ", productType=" + productType + ", qty=" + qty
				+ ", price=" + price + ", trackingId=" + trackingId + "]";
	}
	
}
