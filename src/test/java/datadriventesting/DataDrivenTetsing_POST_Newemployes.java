package datadriventesting;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTetsing_POST_Newemployes {
	@Test
	public void postDataDriven() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		RequestSpecification httprequest = RestAssured.given();

		// recreated data
		JSONObject reqestparameters = new JSONObject();

		reqestparameters.put("name", "loverboy");
		reqestparameters.put("salary", "8000");
		reqestparameters.put("age", "24");

		// add a header stating the request body in a json
		httprequest.header("Content-Type", "application/json");
		// Add json to the body of the request
		httprequest.body(reqestparameters.toJSONString());
		// Post request
		Response response = httprequest.request(Method.POST, "/create");

		// capture response body
		String responsebody = response.getBody().asPrettyString();

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(responsebody.contains("loverboy"), true);

	}

}
