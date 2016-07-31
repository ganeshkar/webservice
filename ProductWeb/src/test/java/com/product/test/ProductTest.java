package com.product.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Test;


public class ProductTest {

    
    @Test
    public void testAddProduct() throws ClientProtocolException, IOException{
    		HttpClient httpClient = new DefaultHttpClient();
    		//String JSON_STRING = "{ \"name\":\"Head First Java\" , \"productType\":\"BOOKS\" , \"count\":\"20\"}";
    		//String JSON_STRING = "{ \"name\":\"Sring in action\" , \"productType\":\"BOOKS\" , \"count\":\"30\"}";
    		String JSON_STRING = "{ \"name\":\"Moto G4 Plus\" , \"productType\":\"ELECTRONICS\" , \"count\":\"2\"}";
    		StringEntity requestEntity = new StringEntity(
    		    JSON_STRING,
    		    ContentType.APPLICATION_JSON);

    		HttpPost postMethod = new HttpPost("http://localhost:8080/product/putproduct");
    		postMethod.setEntity(requestEntity);

    		HttpResponse rawResponse = httpClient.execute(postMethod);
    		
    		String responseString = EntityUtils.toString(rawResponse.getEntity(), "UTF-8");
    		System.out.println(responseString);
    }
    
    
    @Test
    public void testGetProductList() throws ClientProtocolException, IOException{
    		HttpClient httpClient = new DefaultHttpClient();
    		HttpGet getMethod = new HttpGet("http://localhost:8080/product/getProducts");
    		HttpResponse rawResponse = httpClient.execute(getMethod);
    		
    		String responseString = EntityUtils.toString(rawResponse.getEntity(), "UTF-8");
    		System.out.println(responseString);
    }
    
    
    @Test
    public void testGetProductListByProductId() throws ClientProtocolException, IOException{
    		HttpClient httpClient = new DefaultHttpClient();
    		HttpGet getMethod = new HttpGet("http://localhost:8080/product/getProducts/1");
    		HttpResponse rawResponse = httpClient.execute(getMethod);
    		
    		String responseString = EntityUtils.toString(rawResponse.getEntity(), "UTF-8");
    		System.out.println(responseString);
    }
    
    @Test
    public void testDeleteProductByProductId() throws ClientProtocolException, IOException{
    		HttpClient httpClient = new DefaultHttpClient();
    		HttpDelete getMethod = new HttpDelete("http://localhost:8080/product/deleteProduct/1");
    		HttpResponse rawResponse = httpClient.execute(getMethod);
    		
    		String responseString = EntityUtils.toString(rawResponse.getEntity(), "UTF-8");
    		System.out.println(responseString);
    }
    
}