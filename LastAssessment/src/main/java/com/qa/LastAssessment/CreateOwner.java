package com.qa.LastAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CreateOwner {
	@FindBy(xpath = "//*[@id=\"firstName\"]")
	private WebElement fName;
	@FindBy(xpath = "//*[@id=\"lastName\"]")
	private WebElement lName;
	@FindBy(xpath ="//*[@id=\"address\"]")
	private WebElement address;
	@FindBy(xpath = "//*[@id=\"city\"]")
	private WebElement city;
	@FindBy(xpath = "//*[@id=\"telephone\"]")
	private WebElement telephone;
	@FindBy(xpath = "/html/body/app-root/app-owner-add/div/div/form/div[7]/div/button[2]")
	private WebElement submit;
	
	public void ownerCreation(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(fName).click().perform();
		action.sendKeys("P.").perform();
		action.moveToElement(lName).click().perform();
		action.sendKeys("Sherman").perform();
		action.moveToElement(address).click().perform();
		action.sendKeys("42 Wallaby Way").perform();
		action.moveToElement(city).click().perform();
		action.sendKeys("Sydney").perform();
		action.moveToElement(telephone).click().perform();
		action.sendKeys("01210121012").perform();
		action.moveToElement(submit).click().perform();
	}
}
