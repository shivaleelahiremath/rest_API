package com.farrier.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	
	//GET Method without Header..
	public CloseableHttpResponse getMethodWithOutHeader(String url) throws ClientProtocolException, IOException{
		//Creating the connection
		CloseableHttpClient httpClient= HttpClients.createDefault();
		//http get request
		HttpGet httpGet = new HttpGet(url);
		//hit the GET URL i.e clicking on send button.
		CloseableHttpResponse closablehttpResponse = httpClient.execute(httpGet);
		
		return closablehttpResponse;
		
	}
	
	public void delete(String url) throws ClientProtocolException, IOException{
		
		CloseableHttpClient httpClient= HttpClients.createDefault();
		//http get request
		HttpDelete httpDelete = new HttpDelete(url);
		CloseableHttpResponse closablehttpResponse = httpClient.execute(httpDelete);
		int statusCode = closablehttpResponse.getStatusLine().getStatusCode();
		System.out.println("statusCode -> "+statusCode);

		
	}
}
