package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	
	@Test(priority=0)
	public void loginPageTitleTest() {
		String title = lp.getLoginPageTitle();
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=1)
	public void loginPageUrlTest() {
		String url = lp.getLoginPageCurrentUrl();
		Assert.assertTrue(url.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}

	@Test(priority=2)
	public void loginTest() {
		accPage = lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccountPageTitle(),AppConstants.ACC_PAGE_TITLE);
		//Please add something
	}
	
	

}
