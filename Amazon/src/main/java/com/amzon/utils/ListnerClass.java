package com.amzon.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.amazon.testBase.TestBase;

public class ListnerClass implements ITestListener,TestInterface{
	
	public void onTestStart(ITestResult result) {
		Reporter.log("Test case execution has been started",true);
	}
	public void onFinish(ITestContext context) {
		Reporter.log("Test case execution has been Finished",true);
	}
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		Reporter.log("Test case execution has been Failed for "+methodName+"",true);
		TestBase.takeSnap(methodName+testUtil.timeStamp());
	}
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test case execution has been passed",true);
	}
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test case execution has been Skipped",true);
	}

}
