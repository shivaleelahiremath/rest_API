package com.farrier.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.farrier.base.TestBase;
import com.farrier.client.RestClient;

public class DeleteAPTTest extends TestBase {

	TestBase testBase;
	String serviceUrl;
	String apiUrl, url;
	RestClient restClient;
	
	@BeforeMethod
	public void setUp(){
		testBase = new TestBase();
		serviceUrl = prop.getProperty("url");
		apiUrl = prop.getProperty("serviceUrl");
		url = serviceUrl + apiUrl;
	}

	@Test
	public void DeleteAPITest() throws ClientProtocolException, IOException{
		restClient = new RestClient();
		restClient.delete(url);
	}
}
