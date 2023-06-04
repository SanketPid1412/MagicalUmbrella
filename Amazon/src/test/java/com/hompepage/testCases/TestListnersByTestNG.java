package com.hompepage.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.amzon.utils.ListnerClass.class)
public class TestListnersByTestNG {

	@Test
	public void method1() {
		String str ="";
		Assert.assertNull(str);
	}
}
