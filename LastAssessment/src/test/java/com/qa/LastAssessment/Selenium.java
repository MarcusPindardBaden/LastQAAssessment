package com.qa.LastAssessment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Selenium {
	public WebDriver driver = null;
	//Setting up the report
	boolean replaceExisting = false;
	ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Documents\\Key Results file\\SeleniumReport.html",replaceExisting);
	ExtentTest test;
	
	
	
	//initialising the webDriver before we begin 
	@Before
	public void setUp() {
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Admin\\Desktop\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://10.0.10.10:4200/petclinic/welcome");
	
	}
	
	//Quitting the driver
	@After
	public void tearDown() {
		extent.endTest(test);
		extent.flush();
		driver.quit();
	}
	@Test
	public void UserCreation() {
		test = extent.startTest("Verify application Title");
		test.log(LogStatus.INFO, "HomePage loaded");
		HomePage page = PageFactory.initElements(driver, HomePage.class);
		page.goToPeople(driver);
		test.log(LogStatus.INFO, "Users page loaded");
		page.goToAdd(driver);
		test.log(LogStatus.INFO, "Create users loaded");
		CreateOwner page2 = PageFactory.initElements(driver, CreateOwner.class);
		page2.ownerCreation(driver);
		test.log(LogStatus.INFO, "User created");
		OwnersPage page3 = PageFactory.initElements(driver,OwnersPage.class);
		if(page3.areTheyThere() == true) {
			test.log(LogStatus.PASS, "User has been found");
		}
		else {
			test.log(LogStatus.FAIL, "User hasn't been found");
		}
	}
	@Test
	public void UserManipulation() {
		test = extent.startTest("Verify application Title");
		test.log(LogStatus.INFO, "HomePage loaded");
		HomePage page = PageFactory.initElements(driver, HomePage.class);
		page.goToPeople(driver);
		test.log(LogStatus.INFO, "Users page loaded");
		OwnersPage page3 = PageFactory.initElements(driver, OwnersPage.class);
		page3.editUser(driver);
		page3.getTheName(driver);
		
		
	}
}
