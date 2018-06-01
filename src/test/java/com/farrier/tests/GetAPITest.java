package com.farrier.tests;


import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.farrier.base.TestBase;
import com.farrier.client.RestClient;
import com.farrier.utils.TestUtils;

public class GetAPITest extends TestBase{
	TestBase testBase;
	String serviceUrl;
	String apiUrl, url;
	RestClient restClient;
	CloseableHttpResponse closablehttpResponse;
	
	@BeforeMethod
	public void setUp(){
		testBase = new TestBase();
		serviceUrl = prop.getProperty("url");
		apiUrl = prop.getProperty("serviceUrl");
		url = serviceUrl + apiUrl;
	}

	@Test
	public void getAPITest() throws ClientProtocolException, IOException{
		
				restClient = new RestClient();
				closablehttpResponse = restClient.getMethodWithOutHeader(url);
				
				//a. Status Code
				int statusCode = closablehttpResponse.getStatusLine().getStatusCode();
				System.out.println("statusCode -> "+statusCode);
				
				//b. JSON String
				String JSONResponseString = EntityUtils.toString(closablehttpResponse.getEntity(), "UTF-8");
				JSONObject responseJson = new JSONObject(JSONResponseString);
				System.out.println("Response JSON from API -> "+responseJson);
				
				//Get the single value from JSON: Single value assertions: Validating single value 
				//per_page:
				String per_page= TestUtils.getValueByJPath(responseJson, "/per_page");
				System.out.println("value of per page is - > " +per_page);
				Assert.assertEquals(per_page,3);
				
				//get the value from JSON Array 
				String lastName = TestUtils.getValueByJPath(responseJson, "/data[0]/last_name");
				System.out.println(lastName);

				
				//c. All Headers
				Header[] headersArray = closablehttpResponse.getAllHeaders();
				HashMap<String, String> allHeaders = new HashMap<String, String>();
				for(Header header : headersArray){
					allHeaders.put(header.getName(), header.getValue());	
				}
				System.out.println("Header Array -> " +allHeaders);	
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
