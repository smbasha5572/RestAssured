package com.employeeapi.base;


import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	public static RequestSpecification httprequest;
	public static Response response;
	
	
	public Logger logger;
	@BeforeClass
	public void setup() {
//		logger=Logger.getLogger("EmployesRestapi");
	}
}
