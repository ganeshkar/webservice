package com.price.bean;


/**
 * This Price model
 * @author Ganesh Kar
 * @version 1.0.0
 *     
 */
public class Price {
	
	float priceVal;
	
	int productId;


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

	/**
	 * @return the priceVal
	 */
	public float getPriceVal() {
		return priceVal;
	}

	/**
	 * @param priceVal the priceVal to set
	 */
	public void setPriceVal(float priceVal) {
		this.priceVal = priceVal;
	}

	

}
