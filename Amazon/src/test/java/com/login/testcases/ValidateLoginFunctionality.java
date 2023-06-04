package com.login.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.amazon.constans.AmazonConstants;
import com.amazon.testBase.TestBase;
@Listeners(com.amzon.utils.ListnerClass.class)
public class ValidateLoginFunctionality extends TestBase {
	
	boolean status;
	@Test
	public void validateLogin() {
		status = loginPage.login(driver,userName , password);
		Assert.assertTrue(status);
	}
	
	@Test
	public void validateInvalidPhoneNumberErrorMessage() {
		String incorrectUserName = AmazonConstants.incorrectUserName;
		String invalidPhoneNumberErrorMessage = AmazonConstants.invalidPhoneNumberErrorMessage;
		status=loginPage.validateIncorrectUesrIDErrorMsg(driver,incorrectUserName , invalidPhoneNumberErrorMessage);
		Assert.assertTrue(false);
	}
	@Test
	public void assertionStudy() {
		boolean status= true;
		Assert.assertTrue(status);
		System.out.println("Status is "+status);
	}
}
