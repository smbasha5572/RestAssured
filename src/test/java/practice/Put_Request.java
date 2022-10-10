package practice;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put_Request {
    @Test
	public void putRequest() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		
		  RequestSpecification httprequest=RestAssured.given();
		  
		  JSONObject requestparameters=new JSONObject();
		  
		  requestparameters.put("age","29");
		  
		  httprequest.header("Content-Type","application/json");
		  httprequest.body(requestparameters.toJSONString());
		  
		  Response response=httprequest.request(Method.PUT,"/update/21");
		  
		   String responsebody=response.getBody().asPrettyString();
		   
		     System.out.println("responsebody : "+responsebody);
		     
		     Assert.assertEquals(response.getStatusCode(), 200);
		     Assert.assertEquals(responsebody.contains("29"), true);
		  
		  
	}
}
