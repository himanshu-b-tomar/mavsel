package com.cardinal.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CommanFunctions {

	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass
	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/usr/bin/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");

			driver = new ChromeDriver(options);
			driver.get("https://www.cardinalhealth.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxBinary fb=new FirefoxBinary();
			fb.addCommandLineOptions("--headless");
			System.getProperty("webdiver.gecko.driver", System.getProperty("user.dir")+"/usr/bin/geckodriver");
			FirefoxOptions fo=new FirefoxOptions();
			fo.setBinary(fb);
			driver=new FirefoxDriver(fo);
		}

	}

	@Test
	public void test1() {
		WebElement ele = driver.findElement(By.xpath("//input[@value='Sign In']"));
		ele.click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
