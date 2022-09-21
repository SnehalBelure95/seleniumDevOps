package Demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo12 {

	@Test
	public void user() throws IOException, JSONException {
		
		// Create a reference for Response interface
		Response response;

		// Specify the base URI to the RESTful web service
		RestAssured.baseURI = "http://10.82.48.225:8081/EDUBank/AccountAPI";

		// Get the RequestSpecification of the request that you want to sent to the server
		RequestSpecification request = RestAssured.given();

		// Add a header stating the Request body is a JSON
		request.header("Content-Type", "application/json");

		// Create an object for JSONObject class
		JSONObject requestParams = new JSONObject();

		// Path from where the excel file has to be read
		String path = "C:\\Users\\doddi.sowmya\\Desktop\\accno.xlsx";

		// File input stream which needs the input as the file location
		FileInputStream fis = new FileInputStream(path);

		// Workbook reference of the excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Sheet which needs to be accessed from within the workbook
		XSSFSheet sheet = wb.getSheetAt(0);

		// Count the number of rows
		int rowNo = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Iterate the AccountNumber/AccountHolderName/IFSCCode
		for (int i = 1; i <= rowNo; i++) {

			// We can add key-Value pairs using put method
			requestParams.put("accountNumber", sheet.getRow(i).getCell(0).getStringCellValue());
			requestParams.put("accountHolderName", sheet.getRow(i).getCell(1).getStringCellValue());
			requestParams.put("ifsc", sheet.getRow(i).getCell(2).getStringCellValue());

			// Add string form of JSON to the body of the request
			request.body(requestParams.toString());

			// Post the request and check the response
			response = request.post("/accountVerification");

		}

	}

}
