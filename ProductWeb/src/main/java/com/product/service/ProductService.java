package com.product.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import com.product.bean.Product;
import com.product.dao.ProductDao;

/**
 * This service is used to provide different function of a Product
 * @author Ganesh Kar
 * @version 1.0.0
 *     
 */
@Transactional
@Path("/product")
public class ProductService {
	
	/**
	 * The instance of <code>ProductDao</code>
	 */
	@Autowired
	ProductDao productDao;
	
	
	/**
	 * This method is used to get all the available product details from database.
	 * @return
	 * 		List of all available product details	
	 * 
	 */
	@GET
	@Path("/getProducts")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProducts() {
		List<Product> productList = productDao.getProductList();
		if(productList!=null){
			return Response.status(200).entity(productList).build();
		}
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		
	}
	
	
	/**
	 * This method is used to add a product
	 * @return
	 * 		The Product with product id.	
	 * 
	 */
	@POST
	@Path("/putproduct")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addProduct(Product prod) {
		int productId = productDao.addProduct(prod);
		prod.setProductId(productId);
		return Response.status(200).entity(prod).build();
	}
	
	
	/**
	 * This method is used to get a product details by product id.
	 * @return
	 * 		The Product	
	 * 
	 */
	@GET
	@Path("/getProducts/{productId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getProductById(@PathParam("productId") int productId) {
		Product product = productDao.getProductById(productId);
		if(product!=null){
			return Response.status(200).entity(product).build();
		}
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		
	}
	
	/**
	 * This method is used to delete a product by product id.
	 * @param productId
	 * @return
	 * 		If succeeds then 200 response code , other wise 500 error 
	 */
	@DELETE
	@Path("/deleteProduct/{productId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response deleteProductById(@PathParam("productId") int productId) {
		Response response;
		try{
			productDao.removeProductById(productId);
			response = Response.status(200).build();
		}
		catch(Exception e){
			response = Response.status(Status.INTERNAL_SERVER_ERROR).build();
			e.printStackTrace();
		}
		return response;
	}
	
		
}