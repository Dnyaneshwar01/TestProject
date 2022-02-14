package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static WebDriver launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver launchFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	public static WebDriver launchEdgeBrowser() {
		System.setProperty("webdriver.edge.driver","C:\\edge\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}

}
