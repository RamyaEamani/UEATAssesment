package io.ueat.www.tests;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.ueat.www.pages.ClientCreationPage;
import io.ueat.www.pages.ClientPage;
import io.ueat.www.pages.LoginPage;
import io.ueat.www.utils.BaseTest;

public class ClientCreationTests extends BaseTest{
	@Test
	public void createClient() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.waitForPageLoad();
		loginPage.login( prop.getProperty("username"), prop.getProperty("password"));
		ClientPage clientPage=new ClientPage(driver);
		clientPage.waitForPageLoad();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(driver.getCurrentUrl(), prop.getProperty(environment+".clientURL"),"Incorrect page URL for client page");
		clientPage.navigateToAddClientPage();
		ClientCreationPage clientCreationPage=new ClientCreationPage(driver);
		clientCreationPage.waitForPageLoad();
		String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		softAssert.assertEquals(driver.getCurrentUrl(), prop.getProperty(environment+".clientCreationURL"),"Incorrect page URL for client creation page");
		clientCreationPage.createClient(prop.getProperty("companytype"), prop.getProperty("companyname")+time, prop.getProperty("companyCode")+time);
		clientCreationPage.validateCreationSucessMessage();
		softAssert.assertAll();
	}

}
