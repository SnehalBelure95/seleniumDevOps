
package Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo2_2 {
	

	@Test
	public void f()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://10.82.48.225:8081/EDUBank/AccountAPI/getAccount";
     
	
		// Get the RequestSpecification of the request that you want to sent to the server. 
		//The server is specified by the BaseURI that we have specified in the above step.
		RequestSpecification httpRequest = RestAssured.given();
		

		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a variable.
		Response response = httpRequest.request(Method.GET, "?accountNumber=443328602688019");
      
		 //print the message body of the response received from the server
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

}
