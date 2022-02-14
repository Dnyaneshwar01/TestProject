package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath="//input[@id='username']")
	private WebElement username;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement password;
	
	@FindBy (xpath="//a[@id='loginButton']")
	private WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void sendUserName(String name)
	{
		username.sendKeys(name);
	}
	public void sendpassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickOnLoginButton()
	{
		login.click();
	}
	
}
