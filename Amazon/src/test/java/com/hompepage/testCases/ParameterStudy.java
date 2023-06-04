package com.hompepage.testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterStudy {

	@Test
	@Parameters({ "a", "b"})
	public void method1(int a , int b) {
		System.out.println(a+b);
	}
}
