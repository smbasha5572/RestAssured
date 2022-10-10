package sample;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_POST_Request {
    @Test 
   public void postRequest() {
	   //specify base uri
	   RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	   //request payload along with post post request
	   RequestSpecification httprequest= RestAssured.given();
	   
	     JSONObject  requestparam=new JSONObject();
	     requestparam.put("name","test");
	     requestparam.put("salary","123");
	     requestparam.put("age","23");
	     requestparam.put("id",25);
	     
	     httprequest.header("Content-Type","application/json");
	     
	     httprequest.body(requestparam.toJSONString());
	     
	     //response object
	      Response response= httprequest.request(Method.POST,"/create");	
	      
	      //print resonse in console
	        String ressponsebody=response.getBody().asPrettyString();
	         System.out.println("ressponsebody : "+ressponsebody);
	         
	        //status code validation
	          int statuscode=response.getStatusCode();
	          System.out.println("statuscode : "+statuscode);
	          
	          Assert.assertEquals(statuscode,200);
	          
	       //success code validation
	             String successtatus=response.jsonPath().get("status");
	        Assert.assertEquals(successtatus,"success");
	         
   }
	 
	     
}
