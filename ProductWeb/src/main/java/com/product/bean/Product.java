package com.product.bean;

import com.product.type.ProductType;


/**
 * This Product model
 * @author Ganesh Kar
 * @version 1.0.0
 *     
 */
public class Product {
	
	
	int productId;
	String name;
	ProductType productType;
	int count;
	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}
	/**
	 * @param productType the productType to set
	 */
	
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
