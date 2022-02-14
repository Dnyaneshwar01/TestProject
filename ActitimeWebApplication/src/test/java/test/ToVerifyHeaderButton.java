package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import base.Browser;
import pom.HeaderOfActiTime;
import pom.LoginPage;
import utils.Utility;

public class ToVerifyHeaderButton extends Browser
{
	private WebDriver driver;
	private LoginPage loginPage;
	private HeaderOfActiTime headerOfActiTime;
	private SoftAssert softAssert;
	private int testId;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	@BeforeTest
	@Parameters ("browser")
	public void launchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		System.out.println(browser);
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=launchChromeBrowser();
		}
		if(browser.equalsIgnoreCase("Firefox")) {
			driver = launchFirefoxBrowser();
		}
		if(browser.equalsIgnoreCase("Edge")) {
			driver = launchEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	@BeforeClass
	public void createPOMobjects() {
	 loginPage = new LoginPage(driver);
	 headerOfActiTime =new HeaderOfActiTime(driver);	
	}
	@BeforeMethod
	public void loginToApplication() throws EncryptedDocumentException, IOException {
		System.out.println("login Application");
		driver.get("http://localhost/login.do");
		String username = Utility.getDataFromExcelSheet("Sheet1", 1, 0);
		loginPage.sendUserName(username);
		String password = Utility.getDataFromExcelSheet("Sheet1", 1, 1);
		loginPage.sendpassword(password);
		loginPage.clickOnLoginButton();
		System.out.println("login Application Successfully");
	}
	@Test 
	public void toverifyTaskButton() {
		testId = 101;
		softAssert= new SoftAssert();
		
		headerOfActiTime.clickOnTaskButton();
		String url = driver.getCurrentUrl();
		String tital = driver.getTitle();
		softAssert.assertEquals(url,"http://localhost/tasks/otasklist.do");
		softAssert.assertEquals(tital, "actiTIME - Open Tasks" ,"tital of task botton not found");
		System.out.println("testId:101 pass");
		softAssert.assertAll();
	}
	@Test(priority=1)
	public void toverifyReportButton() {
		testId = 102;
		headerOfActiTime =new HeaderOfActiTime(driver);
		headerOfActiTime.clickOnReportButton();
		String url = driver.getCurrentUrl();
		String tital = driver.getTitle();
		
		Assert.assertEquals(url,"http://localhost/reports/reports.do");
		Assert.assertEquals(tital , "actiTIME - Saved Reports");
		System.out.println("testId:102 pass");
	}
	@Test(priority=2)
	public void toverifyUserButton() {
		testId = 103;
		headerOfActiTime.clickOnUserButton();
		String url = driver.getCurrentUrl();
		String tital = driver.getTitle();

		Assert.assertEquals(url,"http://localhost/administration/userlist.do");     //Hard Assert
		Assert.assertEquals(tital,"actiTIME - User List");
		System.out.println("testId:103 pass");

	}
	@AfterMethod
	public void logoutfromActiTime(ITestResult result) throws IOException {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			Utility.getScreenshoot(driver, testId);
		}
		headerOfActiTime.clickOnlogoutButton();
		System.out.println("Appalication logout");
	}
	
	@AfterClass
	public void clearPOMobjects() {
		loginPage = null;
		headerOfActiTime =null;
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
		driver = null;
		System.gc();
		System.out.println("Application close");
	}
}
