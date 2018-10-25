package com.qa.LastAssessment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
	private WebElement ownerButton;
	@FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")
	private WebElement goToAll;
	@FindBy(xpath = "/html/body/app-root/app-owner-list/div/div/div/div/button")
	private WebElement createOwner;
	
	public void goToPeople(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(ownerButton).click().perform();
		action.moveToElement(goToAll).click().perform();
	}
	public void goToAdd(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(createOwner).click().perform();
	}
}
