package sample;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_GET_All_Headers_values {
	@Test
	public void getHeadersValue() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		RequestSpecification httprequest = RestAssured.given();
		Response response = httprequest.request(Method.GET, "/employee/1");

		String responsebody = response.getBody().asPrettyString();
		System.out.println("responsebody : " + responsebody);

		Assert.assertEquals(responsebody.contains("Tiger Nixon"),true);
		Assert.assertEquals(response.getStatusCode(), 200);

//		JsonPath jsonpath = response.jsonPath();

//		System.out.println("jsonpath: " + jsonpath);
//
//	       Assert.assertEquals(jsonpath.get("employee_name"),"Tiger Nixon");
//	       Assert.assertEquals(jsonpath.get("employee_salary"),"320800");

	}
}
