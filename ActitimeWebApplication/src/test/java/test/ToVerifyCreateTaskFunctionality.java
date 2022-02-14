package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import base.Browser;

public class ToVerifyCreateTaskFunctionality extends Browser
{
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome")) {
		driver=launchChromeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	

}
