package happyFox_pageObjectModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Priority_Creation {
	private RemoteWebDriver driver=null;
	
	public Priority_Creation(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@data-test-id='module-switcher_trigger']")
	WebElement menu;
	@FindBy(xpath="//li[contains(@data-test-id,'module-switcher')]/a[text()='Priorities']")
	WebElement priorityClickPath;
	public void priorityClick()
	{
		menu.click();
		priorityClickPath.click();
	}
	@FindBy(xpath="//button[@data-test-id='new-priority']")
	WebElement newPriorityPath;
	public void newPriority()
	{
		newPriorityPath.click();
	}
	@FindBy(xpath="//input[@aria-label='Priority Name']")
	WebElement priorityNamePath;
	public void priorityName(String name)
	{
		priorityNamePath.sendKeys(name);
	}
	@FindBy(xpath="//*[@aria-label='Description']")
	WebElement addDescriptionPath;
	public void addDescription(String name)
	{
		addDescriptionPath.sendKeys(name);
	}
	@FindBy(xpath="//button[@data-test-id='add-priority']")
	WebElement addPriorityPath;
	public void clickCreate()
	{
		addPriorityPath.click();
	}
	@FindBy(xpath="//span[text()='Assistance required']")
	WebElement house;
	@FindBy(xpath="//span[text()='Assistance required']/ancestor::tr//div[text()='Make Default']")
	WebElement clickDefault;
	public void makeDefault()
	{
		//Action class is use to make WebElement visible to window.
		Actions act=new Actions(driver);
		act.moveToElement(house).perform();
		clickDefault.click();
	}
	
}
