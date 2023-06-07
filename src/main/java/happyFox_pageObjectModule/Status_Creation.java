package happyFox_pageObjectModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Status_Creation {
	private RemoteWebDriver driver=null;
	
	public Status_Creation(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@data-test-id='module-switcher_trigger']")
	WebElement menu;
	@FindBy(xpath="//li[contains(@data-test-id,'module-switcher')]/a[text()='Statuses']")
	WebElement click_status;
	public void menu()
	{
		menu.click();
		click_status.click();
	}
	@FindBy(xpath="//button[@class='hf-mod-create']")
	WebElement newStatusPath;
	public void newStatus()
	{
		newStatusPath.click();
	}
	
	@FindBy(xpath="//input[@aria-label='Status Name']")
	WebElement statusNamePath;
	public void statusName(String name)
	{
		statusNamePath.sendKeys(name);
	}
	
	@FindBy(xpath="//div[@aria-label='Behavior']/span[contains(@class,'selected-item')]")
	WebElement behaviorPath;
	public void behaviorAssert(String expected)
	{
		String text=behaviorPath.getText();
		Assert.assertEquals(text, expected);
	}
	
	@FindBy(xpath="//*[@aria-label='Description']")
	WebElement descriptionPath;
	public void addDescription(String text)
	{
		descriptionPath.sendKeys(text);
	}
	
	@FindBy(xpath="//button[@data-test-id='add-status']")
	WebElement addStatusPath;
	public void clickCreate()
	{
		addStatusPath.click();
	}
	
	@FindBy(xpath="//div[text()='Issue created']/ancestor::tr")
	WebElement visible;
	@FindBy(xpath="//div[text()='Issue created']/ancestor::tr//a[text()='Make Default']")
	WebElement makeDefaultPath;
	public void makeDefault()
	{
		Actions act=new Actions(driver);
		act.moveToElement(visible).perform();
		driver.findElement(By.xpath("//div[text()='Issue created']/ancestor::tr//a[text()='Make Default']")).click();
	}
}
