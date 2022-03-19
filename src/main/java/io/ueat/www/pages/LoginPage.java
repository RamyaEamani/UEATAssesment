package io.ueat.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By lnk_englishLanguage = By.linkText("en");
	private By txt_username = By.name("input-1002");
	private By txt_password = By.name("input-1003");
	private By btn_login = By.xpath("//button[text()='Login']");

	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(lnk_englishLanguage));
	}

	public void login(String username, String password) {
		driver.findElement(lnk_englishLanguage).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(txt_username));
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(btn_login).click();
	}
}
