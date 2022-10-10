package sample;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_All_Headers {
     @Test
	public void getAllHeaders() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		  RequestSpecification httprequest=RestAssured.given();
		  
		Response response= httprequest.request(Method.GET,"/employee/1");
		
		  String resbody=response.getBody().asPrettyString();
		  System.out.println("responsebody: "+resbody);
		  
		  
		  Assert.assertEquals(response.getStatusCode(), 200);
		  // getting all  headers
		    Headers headers=response.headers();
		    
		    for(Header header:headers) {
//		    	System.out.println("header: "+header);
		    	System.out.println(header.getName()+"  "+header.getValue());
		    }
		   
		 
	}
}
