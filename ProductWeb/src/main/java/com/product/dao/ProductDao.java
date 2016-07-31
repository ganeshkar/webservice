package com.product.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.product.bean.Product;

public class ProductDao {
	
	@Autowired    
	public SessionFactory sessionFactory;
	
	 
	@SuppressWarnings("unchecked")
	public ArrayList<Product> getProductList()
	{ 
		 return (ArrayList<Product>)sessionFactory.getCurrentSession().createQuery("from Product").list();
	}


	public Integer addProduct(Product prod) {
		return (Integer) sessionFactory.getCurrentSession().save(prod);
	}


	public Product getProductById(int productId) {
		
		return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
	
	}
	
	public void removeProductById(int productId) {
		
		Product product = (Product) sessionFactory.getCurrentSession().load(Product.class, productId);
		sessionFactory.getCurrentSession().delete(product);
	
	}
}
