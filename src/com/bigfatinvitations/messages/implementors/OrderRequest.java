package com.bigfatinvitations.messages.implementors;

public class OrderRequest {

	private String customer;
	private String productId;
	private String quantity;
	private String description;
	
	
	
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCustomer() {
		return customer;
	}
	public String getProductId() {
		return productId;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getDescription() {
		return description;
	}
	
	
}
