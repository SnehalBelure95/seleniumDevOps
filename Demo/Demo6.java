package Demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo6 {

	@Test
	public void user() {
		
		//Create a reference for Response interface
	    Response response;
	    
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a reference variable created above.
	    response = RestAssured.get("http://10.82.48.225:8081/EDUBank/AccountAPI/getAccount?accountNumber=443328602688019");
	    
		// Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Content-Type"
    	String contentType = response.header("Content-Type");
    	System.out.println("Content-Type value: " + contentType);
    	
        // Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Server"
    	String serverType =  response.header("Server");
    	System.out.println("Server value: " + serverType);
    	
    	// Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Date"
	    String date = response.header("Date");
    	System.out.println("Date value: " + date);
    
        // Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Content-Encoding"
    	String contentEnco = response.header("Content-Encoding");
    	System.out.println("Content-Encoding: " + contentEnco);
    	
    	// Reader header is passed with exact header name as argument.
	    // In the below line,we will get header named "Transfer-Encoding"
    	String transferEnco = response.header("Transfer-Encoding");
    	System.out.println("Transfer-Encoding value: " + transferEnco);
    	
	}
}
