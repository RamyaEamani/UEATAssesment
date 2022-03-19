package io.ueat.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ClientCreationPage {
	WebDriver driver;
	public ClientCreationPage(WebDriver driver) {
		this.driver=driver;
	}

	private By dd_companyType = By.xpath("//select[@data-cy='client_restaurant_companyTypeList']");
	private By txt_resturantCode = By.xpath("//input[@data-cy='client_restaurant_code']");
	private By txt_resturantName = By.xpath("//input[@data-cy='client_restaurant_name']");
	private By btn_save = By.xpath("//button[@label='Save']");
	private By messag_Success = By.xpath("//p[text()='The restaurant has been successfully saved.']");
	
	public void waitForPageLoad() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dd_companyType));
	}
	public void createClient(String companyType,String companyCode,String companyName) {
		Select dd=new Select(driver.findElement(dd_companyType));
		dd.selectByVisibleText(companyType);
		driver.findElement(txt_resturantCode).sendKeys(companyCode);
		driver.findElement(txt_resturantName).sendKeys(companyName);
		driver.findElement(btn_save).click();
	}
	
	public void validateCreationSucessMessage() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(messag_Success));
		Assert.assertEquals(driver.findElement(messag_Success).isDisplayed(), true,"Successful message is missing");
	}
}
