package com.price.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.price.bean.Price;

/**
 * The DAO of price service
 * @author Ganesh Kar
 * @version 1.0.0
 *     
 */
public class PriceDao {
	
	@Autowired    
	public SessionFactory sessionFactory;
	
	/**
	 * The product ID.
	 * @param productId
	 * @return
	 * 		The price of a product
	 */
	public Price getPriceByProductId(int productId) {
		
		//Note - We are using product id as the primary key of Price table. It is the same as Product table's primary table.
		return (Price) sessionFactory.getCurrentSession().get(Price.class, productId); 
		
	}
	
	
	/**
	 * 
	 * @param price
	 * @return
	 * The price ID.
	 */
	public Integer addPrice(Price price) {
		return (Integer) sessionFactory.getCurrentSession().save(price);
	}

}
