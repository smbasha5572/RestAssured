package datadriventesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadrivern_POST_MultipleUserss {
   @Test(dataProvider = "xldata")
	public void postMultipleUsers(String name,String salary,String age) {
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		RequestSpecification httprequest = RestAssured.given();

		// recreated data
		JSONObject reqestparameters = new JSONObject();

		reqestparameters.put("name", name);
		reqestparameters.put("salary",salary);
		reqestparameters.put("age", age);

		// add a header stating the request body in a json
		httprequest.header("Content-Type", "application/json");
		// Add json to the body of the request
		httprequest.body(reqestparameters.toJSONString());
		// Post request
		Response response = httprequest.request(Method.POST, "/create");

		// capture response body
		String responsebody = response.getBody().asPrettyString();
		 System.out.println("responsebody : "+responsebody);

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(responsebody.contains(name), true);
		
		
		
}
   
   
	   @DataProvider(name="xldata")
		public String[][]  getData() throws Exception {

			String xlpath = "C:\\Users\\Smbas\\OneDrive\\Desktop\\REST data.xlsx";
			FileInputStream inputsteram = new FileInputStream(xlpath);
			XSSFWorkbook workbook = new XSSFWorkbook(inputsteram);
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int noOFRows = sheet.getPhysicalNumberOfRows();
			int noOfColumns = sheet.getRow(0).getLastCellNum();

			String[][] data = new String[noOFRows - 1][noOfColumns];
			for (int i = 0; i < noOFRows - 1; i++) {
				for (int j = 0; j < noOfColumns; j++) {
					DataFormatter df = new DataFormatter();
					data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
				}
			}
			inputsteram.close();
			return data;
	   }
//		@DataProvider(name="empdataprovider")
//		public String[][] getEmployees(){
//			String empdata[][]= {{"abcd","2344","34"},
//					{"ravi","23448","33"},
//					{"gopi","2233","26"}
//			};
//			return empdata;
//		}

	  
   }
