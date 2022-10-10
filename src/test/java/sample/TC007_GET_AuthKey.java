package sample;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_GET_AuthKey {
	
	public void getrequestAuthentication() {
	RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	
	//Basic authentication
	PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
	authscheme.setUserName("ToolQa");
	authscheme.setPassword("TestPassword");
	
	 RestAssured.authentication=authscheme;
	
    RequestSpecification httprequest=RestAssured.given();
    
     Response response=httprequest.request(Method.GET,"/employee/1");
     
      String responsebody=response.getBody().asPrettyString();
      System.out.println("responsebody : "+responsebody);
      
      Assert.assertEquals(response.getStatusCode(),200);
      Assert.assertEquals(responsebody.contains("Tiger Nixon"), true);
      
	}
}
