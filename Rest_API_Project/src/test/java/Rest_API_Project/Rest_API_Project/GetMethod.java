package Rest_API_Project.Rest_API_Project;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetMethod {
	
	@Test
	public void user() {
		
		//Create a reference for Response interface
	    Response response;
	    
		// Make a request to the server by specifying the method Type and the method URL.
		// This will return the Response from the server. Store the response in a reference variable created above.
	    response = RestAssured.get("http://10.82.48.225:8081/EDUBank/AccountAPI/getAccount?accountNumber=443328602688019");
	    
	    //print the message body of the response received from the server
	    String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	    
	}

	public void GetMethods() {
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		
		RequestSpecification request= RestAssured.given();
		
		Response response= request.get();
		Headers resposerheser= response.headers();
		System.out.println(resposerheser.toString());
		System.out.println("Status Code Of Response");
		System.out.println(response.getStatusCode());
		System.out.println("Body Of Response");
		System.out.println(response.asPrettyString());
		System.out.println("Headers Of Response----------");
		System.out.println(response.getHeaders());
		System.out.println("For Loop To Iterate Headers Of Response");
		Headers AllHeaders= response.headers();
		for(Header H: AllHeaders ) {
			System.out.println(H);
		}
		System.out.println("Iterator Headers Of Response");
		Iterator<Header> it = AllHeaders.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("Assert/ Validate Response, Headers");
		System.out.println("Assert Status Code");
		int StatusCode= response.statusCode();
		Assert.assertEquals(StatusCode, 200);
		System.out.println("Assert Content Type");
		String ContentType= response.contentType();
		Assert.assertEquals(ContentType, "application/json; charset=utf-8");
		
		ResponseBody body= response.getBody();
		System.out.println(body.asString());
		System.out.println(body.asString().contains("George"));
		Assert.assertEquals(body.asString().contains("George"), true);
		Assert.assertEquals(body.asString().toLowerCase().contains("first_name"), true);

		
		
	}
	
	
		
		
	
	
	public void BDDStyleGetMethod() {
		String baseURI="https://reqres.in";
		RestAssured.given().baseUri(baseURI)
		.when().get("/api/users?page=2")
		.then().statusCode(200).statusLine("");
		
	}

	public static void main(String[] args) {

		GetMethod g= new GetMethod();
		//g.parseJsonArrayToReadValues();
		//g.GetMethods();
		
		
//		Response res= given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users?page=2");
//		double statuscode=res.getStatusCode();
//		System.out.println(statuscode);
//		Assert.assertEquals(statuscode, 200,"Correct");
//		System.out.println(res.getTime());
//	    System.out.println(res.getStatusLine());
//	    System.out.println(res.getContentType());
//	    System.out.println(res.asPrettyString());
//	    System.out.println(res.headers());
//	    System.out.println(res.header("Server"));
//	    System.out.println(res.header("Content-Type"));
		
		String inputJson=  "{\r\n"
		+ "  \"page\": 2,\r\n"
		+ "  \"per_page\": 6,\r\n"
		+ "  \"total\": 12,\r\n"
		+ "  \"total_pages\": 2,\r\n"
		+ "  \"data\": [\r\n"
		+ "    {\r\n"
		+ "      \"id\": 7,\r\n"
		+ "      \"email\": \"michael.lawson@reqres.in\",\r\n"
		+ "      \"first_name\": \"Michael\",\r\n"
		+ "      \"last_name\": \"Lawson\",\r\n"
		+ "      \"avatar\": \"https://reqres.in/img/faces/7-image.jpg\"\r\n"
		+ "    },\r\n"
		+ "    {\r\n"
		+ "      \"id\": 8,\r\n"
		+ "      \"email\": \"lindsay.ferguson@reqres.in\",\r\n"
		+ "      \"first_name\": \"Lindsay\",\r\n"
		+ "      \"last_name\": \"Ferguson\",\r\n"
		+ "      \"avatar\": \"https://reqres.in/img/faces/8-image.jpg\"\r\n"
		+ "    },\r\n"
		+ "    {\r\n"
		+ "      \"id\": 9,\r\n"
		+ "      \"email\": \"tobias.funke@reqres.in\",\r\n"
		+ "      \"first_name\": \"Tobias\",\r\n"
		+ "      \"last_name\": \"Funke\",\r\n"
		+ "      \"avatar\": \"https://reqres.in/img/faces/9-image.jpg\"\r\n"
		+ "    },\r\n"
		+ "    {\r\n"
		+ "      \"id\": 10,\r\n"
		+ "      \"email\": \"byron.fields@reqres.in\",\r\n"
		+ "      \"first_name\": \"Byron\",\r\n"
		+ "      \"last_name\": \"Fields\",\r\n"
		+ "      \"avatar\": \"https://reqres.in/img/faces/10-image.jpg\"\r\n"
		+ "    },\r\n"
		+ "    {\r\n"
		+ "      \"id\": 11,\r\n"
		+ "      \"email\": \"george.edwards@reqres.in\",\r\n"
		+ "      \"first_name\": \"George\",\r\n"
		+ "      \"last_name\": \"Edwards\",\r\n"
		+ "      \"avatar\": \"https://reqres.in/img/faces/11-image.jpg\"\r\n"
		+ "    },\r\n"
		+ "    {\r\n"
		+ "      \"id\": 12,\r\n"
		+ "      \"email\": \"rachel.howell@reqres.in\",\r\n"
		+ "      \"first_name\": \"Rachel\",\r\n"
		+ "      \"last_name\": \"Howell\",\r\n"
		+ "      \"avatar\": \"https://reqres.in/img/faces/12-image.jpg\"\r\n"
		+ "    }\r\n"
		+ "  ],\r\n"
		+ "  \"support\": {\r\n"
		+ "    \"url\": \"https://reqres.in/#support-heading\",\r\n"
		+ "    \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
		+ "  }\r\n"
		+ "}";
		
		JSONObject inputJSONOBject= new JSONObject(inputJson);
		getKey(inputJSONOBject, "text");
		
//		String inputJson = "{\n" + 
//				"  \"myObjects\": [\n" + 
//				"    {\n" + 
//				"      \"code\": \"PQ\",\n" + 
//				"      \"another_objects\": [\n" + 
//				"        {\n" + 
//				"          \"attr1\": \"value1\",\n" + 
//				"          \"attr2\": \"value2\",\n" + 
//				"          \"attrN\": \"valueN\"\n" + 
//				"        },\n" + 
//				"        {\n" + 
//				"          \"attr1\": \"value1\",\n" + 
//				"          \"attr2\": \"value2\",\n" + 
//				"          \"attrN\": \"valueN\"\n" + 
//				"        }\n" + 
//				"      ]\n" + 
//				"    }\n" + 
//				"  ]\n" + 
//				"}";
//		JSONObject inputJSONOBject = new JSONObject(inputJson);
//
//		getKey(inputJSONOBject, "attr1");
		
	 
	    
	   
		
	}

	public static void parseObject(JSONObject json, String key) {
		// System.out.println(json.has(key));
		System.out.println(json.get(key));
	}

	public static void getKey(JSONObject json, String key) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {

					if (json.get(nextKeys) instanceof JSONObject) {

						if (exists == false) {
							getKey(json.getJSONObject(nextKeys), key);
						}

					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSOn = new JSONObject(jsonarrayString);

							if (exists == false) {
								getKey(innerJSOn, key);
							}

						}

					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}

		} else {
			parseObject(json, key);
		}

	}
	

	

}
