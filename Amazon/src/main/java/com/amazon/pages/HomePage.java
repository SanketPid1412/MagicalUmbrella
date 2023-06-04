package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.amazon.locators.AmazonLocators;
import com.amzon.utils.TestInterface;

public class HomePage implements TestInterface{
	
	boolean status = false;
	
	public boolean validateSearchBar(WebDriver driver,String serachInput) {
		status = testUtil.waitForElement(driver, AmazonLocators.searchBar);
		status = testUtil.clickElement(driver, AmazonLocators.searchBar);
		if(!status) {
			Reporter.log("Failed to click on SearchBar",true);
			return false;
		}
		status = testUtil.enterText(driver, AmazonLocators.searchBar, serachInput);
		if(status) {
			Reporter.log(serachInput+" entered in search bar",true);
		}else {
			Reporter.log(serachInput+" Failed to entered in search bar",true);
			return false;
		}
		status = testUtil.clickElement(driver, AmazonLocators.searchButon);
		if(!status) {
			Reporter.log("Failed to click on SearchButton",true);
			return false;
		}
		By category = By.xpath("//span[text()='"+serachInput+"']");
		status = testUtil.waitForElement(driver, category);
		if(status) {
			Reporter.log("The result is dispalying for the searched category "+serachInput,true);
		}else {
			Reporter.log("Faild to dispalying for the searched category "+serachInput,true);
		}
		return status;
	}

}
