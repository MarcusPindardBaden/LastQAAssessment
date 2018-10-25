package com.qa.LastAssessment;
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UserStory1 {
	boolean replaceExisting = true;
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Documents\\Key Results file\\RESTAssuredReport.html",replaceExisting);
	ExtentTest test;
	
	RequestSpecification request = null;
	Response response = null;
	Response response2 = null;
	JSONObject visible = null;
	
	@Before
	public void setUp() {
		request = RestAssured.given();
	}
	
	@Test
		public void userStory() {
		test = extent.startTest("Verify application Title");
		test.log(LogStatus.INFO, "We will test to see if we can get and edit the details of George Franklin, the first user on the system");
		test.log(LogStatus.INFO, "We will be selecting George by his ID number (1)");
		request.header("Content-Type", "application/json");
		JSONObject input = new JSONObject();
		input.put("firstName", "Georgie");
		input.put("id", 1);
		input.put("lastName", "Frank");
		input.put("address", "110 W. Liberty St.");
		input.put("city", "Madison");
		input.put("telephone", "6085551023");
		request.body(input);
		test.log(LogStatus.INFO, "We will change his name to 'Georgie Frank'");
		response = request.when().put("http://10.0.10.10:9966/petclinic/api/owners/1");
		response2 = request.get("http://10.0.10.10:9966/petclinic/api/owners/1");
		response2.prettyPrint();
		test.log(LogStatus.INFO, "Now check if the details have successfully updated, with a status code of 204");
		confirm(response.then());
		if(confirm(response.then()) == true) {
			test.log(LogStatus.PASS, "The details have successfully changed");
		}
		else {
			test.log(LogStatus.FAIL, "The details have NOT successfully changed");
		}
		assertEquals(true, confirm(response.then()));
	}
		public boolean confirm(ValidatableResponse validatableResponse) {
			try {
				validatableResponse.statusCode(204);
				return true;
				
			}
			catch(Exception e) {
				return false;
				
			}
	}
		
	@After
	public void tearDown() {
		extent.endTest(test);
		extent.flush();
	}

	
}
