package Demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo7 {
	
	@Test
	  public void user() {
		
		//Create a reference for Response interface
		Response response;
		
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a reference variable created above.
		response = RestAssured.get("http://10.82.48.225:8081/EDUBank/AccountAPI/getAccount?accountNumber=443328602688019");
		
		//Validating STATUS CODE from response
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "INCorrect status code returned");
		
		//Validating STATUS LINE from response
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 " /*expected value*/, "INCorrect status Line returned");
		
		//Validating CONTENT TYPE from response
		String contentType = response.getContentType();
		Assert.assertEquals(contentType /* actual value */, "application/json;charset=UTF-8" /* expected value */);
		
		//Validating text from response
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("Martin") /*Expected value*/, true /*Actual Value*/, "Response body does not contain martin");
		Assert.assertEquals(responseBody.toLowerCase().contains("martin") /*Expected value*/, true /*Actual Value*/, "Response body does not contain martin");
		
		

	}

}
