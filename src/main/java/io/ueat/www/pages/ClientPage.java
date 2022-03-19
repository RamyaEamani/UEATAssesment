package io.ueat.www.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientPage {
	WebDriver driver;
	public ClientPage(WebDriver driver) {
		this.driver=driver;
	}
	private By icon_add = By.xpath("//a[@data-cy='list_add_button']");
	
	public void waitForPageLoad() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(icon_add));
	}
	public void navigateToAddClientPage() {
		driver.findElement(icon_add).click();
	}
}
