package practice;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Delete_Request {
   @Test
	public void deleteRequest() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		 RequestSpecification  httprequest=RestAssured.given();
		 
		Response response=httprequest.request(Method.DELETE,"/delete/2");
		
	     String	responsebody=response.getBody().asPrettyString();
	     
	     System.out.println("responsebody : "+responsebody);
	     
	     Assert.assertEquals(response.getStatusCode(), 200);
	     Assert.assertEquals(responsebody.contains("success"),true);
		 
		 
		 
		   
	}
}
