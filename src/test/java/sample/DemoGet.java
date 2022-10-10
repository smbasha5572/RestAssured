package sample;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DemoGet {
    @Test
	public void getWheatherDetails() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
        RequestSpecification  httprequest= RestAssured.given();
        Response response=httprequest.request(Method.GET,"employee/1");
        String  responseBody=response.getBody().asPrettyString();
        System.out.println("responseBody: "+responseBody);
        
        //status code validation
          int  statuscode=response.getStatusCode();
          System.out.println("statuscode: "+statuscode);
          
          Assert.assertEquals(statuscode,200);
          
          //status line verification
           String statusline=response.getStatusLine();
           System.out.println("statusline: "+statusline);
           
           Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
          
        
        
    	
	}
}
