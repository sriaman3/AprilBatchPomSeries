package org.qa.opencart.tests;

import org.qa.opencart.base.BaseTest;
import org.qa.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest {
	
	@BeforeClass
	public void accountLogin() {
		accPage = lp.doLogin("aprilbatch@opencart.com", "123456");
	}
	
	
	@Test(priority=0)
	public void accountPageTitleTest() {
		String title = accPage.getAccountPageTitle();
		Assert.assertEquals(title, AppConstants.ACC_PAGE_TITLE);
	}
	
	@Test
	public void accounPageUrlTest() {
		String url = accPage.getAccountPageUrl();
		Assert.assertTrue(url.contains(AppConstants.ACC_PAGE_URL_FRACTION));
	}

	@Test
	public void logoutbtnExistanceTest() {
		Assert.assertTrue(accPage.isLogoutbtnExist());
	}


}
