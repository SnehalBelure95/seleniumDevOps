package Demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo8 {

	@Test
	public void f() throws IOException {

		// Create a reference for Response interface
		Response response;

		// Path from where the excel file has to be read
		String path = "D:\\get.xlsx";

		// File input stream which needs the input as the file location
		FileInputStream fis = new FileInputStream(path);

		// Workbook reference of the excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Sheet which needs to be accessed from within the workbook
		XSSFSheet sheet = wb.getSheetAt(0);

		// Count the number of rows
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		// Iterate the AccountNumber
		for (int i = 1; i <= rowCount; i++) {

			// Pass the row number and the cell number from where the value has to be
			// fetched
			String accno = sheet.getRow(i).getCell(0).getStringCellValue();
			// Make a request to the server by specifying the method Type and the method
			// URL.
			// This will return the Response from the server. Store the response in a
			// reference variable created above.
			response = RestAssured
					.get("http://10.82.48.225:8081/EDUBank/AccountAPI/getAccount?accountNumber=" + accno + "");
			// print the message body of the response received from the server
			String responseBody = response.getBody().asString();
			System.out.println("Response Body is =>  " + responseBody);
		}

	}

}
