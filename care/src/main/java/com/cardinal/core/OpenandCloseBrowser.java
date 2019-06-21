package com.cardinal.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenandCloseBrowser {
	public WebDriver driver;

	@BeforeClass
	public void openBrowser() {

		System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver"); 
	
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setBinary("/usr/bin/google-chrome");
		options.addArguments("--headless","window-size=1024,768","--no-sandbox","--disable-dev-shm-usage");

		driver = new ChromeDriver(options);
		driver.get("https://www.cardinalhealth.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void test1() {
		System.out.println("Launching headless Browser");
		String title = driver.getTitle();
		Assert.assertTrue(title.equals("Cardinal Health: Healthcare Solutions, Logistics & Supplies"), "Title not mached");
		System.out.println("Title matched");
		WebElement ele = driver.findElement(By.xpath("//input[@value='Sign In']"));
		System.out.println("Clicking Sign Button");
		ele.click();
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("Closing the browser");
		driver.quit();
	}
}
