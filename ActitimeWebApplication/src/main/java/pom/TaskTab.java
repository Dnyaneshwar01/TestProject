package pom;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TaskTab {
//	@FindBy (xpath="//a[text()='Open Tasks']")
//	private WebElement openTask;
	
	@FindBy (xpath="(//td[@class='pagetitle'])[1]")
	private WebElement openTaskText;
	
	@FindBy (xpath="//span[text()='Create Tasks']")
	private WebElement createTask;
	
	@FindBy (xpath="//div[@class='lightBoxTitle']")
	private WebElement createNewTaskText;
	
	@FindBy (xpath="//table[@id='ext-comp-1313']")
	private WebElement selectCustomer;
	
	@FindBy (xpath="//input[@id='createTasksPopup_newCustomer']")
	private WebElement  customerName;
	
	@FindBy (xpath="//input[@id='createTasksPopup_newProject']")
	private WebElement ProjectName;
	
	@FindBy (xpath="(//input[@placeholder='Enter task name'])[1]")
	private WebElement taskName;
	
	@FindBy (xpath="//button[@id='ext-gen63']")
	private WebElement setDeadline;
	
	@FindBy (xpath="//table[@class='x-date-inner']//tbody//tr[6]//td[1]")
	private WebElement selectDate;
	
	@FindBy (xpath="//button[@id='ext-gen73']")
	private WebElement typeOfWork;
	
	@FindBy (xpath="(//input[@type='checkbox'])[8]")
	private WebElement checkboxForAutoAdd;
	
	@FindBy (xpath="//span[@class='buttonTitle']")
	private WebElement createTaskButton;
	
	public TaskTab(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public String verifyOpenTaskText() {
		String text = openTaskText.getText();
		return text;
	}
	public void clickOnCreateTask() {
		createTask.click();
	}
	public String verifyCreateNewTaskText() {
		String text1 = openTaskText.getText();
		return text1;
	}
	public void selectCustomer() {
		Select customer = new Select(selectCustomer);
		customer.selectByVisibleText("- New Customer -");
	}
	public void sendCustomerName(String name) {
		customerName.sendKeys(name);
	}
	public void sendProjectName(String project) {
		ProjectName.sendKeys(project);
	}
	public void sendTaskName(String task) {
		taskName.sendKeys(task);
	}
	public void clickOnSetdeadline() {
		setDeadline.click();
	}
	public void clickOnSetDate() {
		selectDate.click();
	}
	public void selectTypeOfWork() {
		Select typeWork = new Select(typeOfWork);
		typeWork.selectByVisibleText("Additional services");
	}
	public void clickOnAutoCheckbox() {
		checkboxForAutoAdd.click();
	}
	public void clickOnCreateTaskButton() {
		createTaskButton.click();
	}


}
