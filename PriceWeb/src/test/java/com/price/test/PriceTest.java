package com.price.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


public class PriceTest {
    
    @Test
    public void testAddPrice() throws ClientProtocolException, IOException{
    		HttpClient httpClient = new DefaultHttpClient();
    		String JSON_STRING = "{ \"productId\":\"2\" , \"priceVal\":\"1600.00\"}";
    		StringEntity requestEntity = new StringEntity(
    		    JSON_STRING,
    		    ContentType.APPLICATION_JSON);

    		HttpPost postMethod = new HttpPost("http://localhost:8088/price/putprice");
    		postMethod.setEntity(requestEntity);

    		HttpResponse rawResponse = httpClient.execute(postMethod);
    		String responseString = EntityUtils.toString(rawResponse.getEntity(), "UTF-8");
    		System.out.println(responseString);
    }
    
    
    @Test
    public void getPriceByProductId() throws ClientProtocolException, IOException{
    		HttpClient httpClient = new DefaultHttpClient();
    		HttpGet getMethod = new HttpGet("http://localhost:8088/price/getPrice/2");
    		HttpResponse rawResponse = httpClient.execute(getMethod);
    		String responseString = EntityUtils.toString(rawResponse.getEntity(), "UTF-8");
    		System.out.println(responseString);
    }
    
}