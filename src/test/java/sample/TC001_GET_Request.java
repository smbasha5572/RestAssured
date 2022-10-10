package sample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET_Request {

	@Test
	public void getweatherDetails() {
		// Specify base URI
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Response object
		Response responce = httpRequest.request(Method.GET, "/employee/1");

		// print response in console window
		String responseBody = responce.getBody().asString();
		System.out.print("Response Body is:" + "\n" + responseBody);

		// status code validatiom
		int statuscode = responce.getStatusCode();
		System.out.println("status code: " + statuscode);

		Assert.assertEquals(statuscode, 200);
		
		//status line verification
		   String statusline=responce.getStatusLine();
		   System.out.println("status line: "+"\n"+statusline);
		   
		   Assert.assertEquals(statusline,"HTTP/1.1 200 OK");

	}
}
