package com.qa.LastAssessment;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OwnersPage {

		@FindBy(linkText = "http://10.0.10.10:4200/petclinic/owners/29")
		private WebElement newUser;
		@FindBy(xpath = "/html/body/app-root/app-owner-detail/div/div/button[2]")
		private WebElement editButton;
		@FindBy(id = "firstName")
		private WebElement fName;
		@FindBy(xpath = "/html/body/app-root/app-owner-edit/div/div/form/div[7]/div/button[2]")
		private WebElement submit;
		@FindBy( xpath = "/html/body/app-root/app-owner-detail/div/div/table[1]/tbody/tr[1]/td/b")
		private WebElement name;
		
		public boolean areTheyThere() {
			try {
				newUser.getLocation();
				return true;
			}
			catch(NoSuchElementException e) {
				return false;
			}
		}
		public void editUser(WebDriver driver) {
			Actions action = new Actions(driver);
			action.moveToElement(newUser).click().perform();
			action.moveToElement(editButton).click().perform();
			action.moveToElement(fName).click().perform();
			action.sendKeys(Keys.BACK_SPACE).click().perform();
			action.sendKeys(Keys.BACK_SPACE).click().perform();
			action.sendKeys("Pete").click().perform();
			action.moveToElement(submit).click().perform();
		}
		public void getTheName(WebDriver driver) {
			Actions action = new Actions(driver);
			action.moveToElement(newUser).click().perform();
			name = driver.findElement(By.xpath("/html/body/app-root/app-owner-detail/div/div/table[1]/tbody/tr[1]/td/b"));
			String names = name.getText();
			
		}
}
	