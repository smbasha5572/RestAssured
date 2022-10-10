package sample;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {
    @Test
	public void getRequest() {
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		  RequestSpecification httprequest=RestAssured.given();
		  
		Response response= httprequest.request(Method.GET,"/employee/1");
		
		  String resbody=response.getBody().asPrettyString();
		  System.out.println("responsebody: "+resbody);
		  
		  //validating headers
//		   String contenttype=response.header("Content-Type");
//		   String xsol=response.header("X-Sol");
//		   String encoding=response.header("Content-Encoding");
		    Headers headers=response.headers();
		    
		    for(Header header:headers) {
//		    	System.out.println("header: "+header);
		    	System.out.println(header.getName()+"  "+header.getValue());
		    }
		   
		   
//		   System.out.println("contenttype: "+contenttype);
//		   System.out.println("xsol: "+xsol);
//		   System.out.println("encoding: "+encoding);
		   
		   
//		   Assert.assertEquals(contenttype, "application/json");
//		   Assert.assertEquals(xsol, "pub_site");
//		   Assert.assertEquals(encoding,"br");
		   
	}
	
}
