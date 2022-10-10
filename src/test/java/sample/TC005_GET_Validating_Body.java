package sample;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_Validating_Body {
    @Test
	public void getBodyValidation() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		
	     RequestSpecification httprequest=RestAssured.given();
	     
	      Response response=httprequest.request(Method.GET,"/employee/1");
	      
	       String responsebody=response.getBody().asPrettyString();
	       System.out.println("responsebody : "+responsebody);
	       
	       Assert.assertEquals(response.getStatusCode(),200);
	       Assert.assertEquals(responsebody.contains("Tiger Nixon"), true);
	}
}
