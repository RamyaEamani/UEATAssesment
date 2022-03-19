package io.ueat.www.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public static Properties prop;
	public static WebDriver driver;
	public static String environment;
	@BeforeSuite
	public void readProperties() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("config.properties");
		prop.load(fis);
	}
	@BeforeMethod
	public void openBrowser() {
		String browserName=prop.getProperty("browser");
		environment=prop.getProperty("env");
		if(browserName.toLowerCase().contains("chrome")) {
			driver=BrowserUtils.openChromeDriver();
		}
		if(browserName.toLowerCase().contains("firefox")) {
			driver=BrowserUtils.openFirefoxDriver();
		}
		if(browserName.toLowerCase().contains("ie")) {
			driver=BrowserUtils.openIEDriver();
		}
		driver.get(prop.getProperty(environment+".baseUrl"));
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
