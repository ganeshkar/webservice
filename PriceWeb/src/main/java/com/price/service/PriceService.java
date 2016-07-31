package com.price.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.price.bean.Price;
import com.price.dao.PriceDao;

/**
 * This service provides different functionalities on price of products 
 * @author Ganesh Kar
 * @version 1.0.0
 *     
 */
@Transactional
@Path("/price")
public class PriceService {
	
	/**
	 * The instance of <code>PriceDao</code>
	 */
	@Autowired
	PriceDao priceDao;

	/**
	 * 
	 * This method used to get price of a product by product id.
	 * @param productId
	 * @return
	 * 		Price of a product
	 */
	@GET
	@Path("/getPrice/{productId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getPriceByProductId(@PathParam("productId") int productId) {
		Price price = priceDao.getPriceByProductId(productId);
		if(price!= null){
			return Response.status(200).entity(price).build();
		}
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
	}
	
	
	/**
	 * This method is used to persists the price of a product in Database 
	 * @param price
	 * @return
	 * 		The Price
	 */
	@POST
	@Path("/putprice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addPrice(Price price) {
		try{
			int priceId = priceDao.addPrice(price);
			price.setProductId(priceId);
			return Response.status(200).entity(price).build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
