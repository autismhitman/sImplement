package com.neopane.tests;

import java.util.HashMap;

import org.assertj.core.api.Assertions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.neopane.frameworkAnnotations.Annotations;
import com.neopane.pages.OrangeLoginPage;

public final class OrangeLoginTest extends BaseTests {

	private OrangeLoginTest() {}
 
	@Test 
	@Annotations()
	public void validateLogin(HashMap<String, String> hmap) {

 		String title =  new OrangeLoginPage()
				.enterUsername(hmap.get("username"))
				.enterPassword(hmap.get("password"))
				.login()
				.clickAvatar()
				.clickLogout()
				.getTitle();

		Assertions.assertThat(title).isEqualTo("OrangeHRM");

	}
 
}
