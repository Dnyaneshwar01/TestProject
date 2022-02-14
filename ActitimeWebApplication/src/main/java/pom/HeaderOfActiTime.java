package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderOfActiTime {
	
	@FindBy (xpath="(//td[@class='navItem relative'])[2]")
	private WebElement task;
	
	@FindBy (xpath="(//td[@class='navItem relative'])[3]")
	private WebElement report;
	
	@FindBy (xpath="(//td[@class='navItem relative'])[4]")
	private WebElement users;
	
	@FindBy (xpath="//a[@id='logoutLink']")
	private WebElement logout;
	
	public HeaderOfActiTime(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnTaskButton() {
		task.click();
	}
	public void clickOnReportButton() {
		report.click();
	}
	public void clickOnUserButton() {
		users.click();
	}
	public void clickOnlogoutButton() {
		logout.click();
	}
	
}
