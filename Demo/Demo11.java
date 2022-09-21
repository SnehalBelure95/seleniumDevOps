package Demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo11 {
	
	@Test
	public void user() throws JSONException {
		
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://10.82.48.225:8081/EDUBank/AccountAPI";

		// Get the RequestSpecification of the request that you want to sent to the server
		// The server is specified by the BaseURI that we have specified in the above step
		RequestSpecification request = RestAssured.given();
		
		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Create an object for JSONObject class
		JSONObject requestParams = new JSONObject();
		
		// We can add key-Value pairs using put method
		requestParams.put("accountNumber", "443328602688019");
		requestParams.put("accountHolderName", "Martin Luther");
		requestParams.put("ifsc", "EDUB0000501");

		// Add string form of JSON to the body of the request
		request.body(requestParams.toString());

		// Post the request and check the response
		Response response = request.post("/accountVerification");

		String successCode = response.asString();
		System.out.println(successCode);
		Assert.assertEquals(successCode, "Account details are verified successfully");
	}
}
