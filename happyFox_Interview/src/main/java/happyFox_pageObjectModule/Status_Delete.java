package happyFox_pageObjectModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Status_Delete {
	private RemoteWebDriver driver=null;
	
	public Status_Delete(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By navigateToStatusPath=By.xpath("//a[text()='Statuses']");
	public void navigateToStatus() throws InterruptedException
	{
		Thread.sleep(10000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(navigateToStatusPath)).click();
	}
	@FindBy(xpath="//div[text()='Issue created']")
	WebElement clickDelPath;
	@FindBy(xpath="//a[text()='Delete']")
	WebElement clickDelPath1;
	public void clickDel()
	{
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			clickDelPath.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			clickDelPath.click();
		}
		clickDelPath1.click();
	}
	
	@FindBy(xpath="//span[text()='Choose Status']")
	WebElement clickDelPath2;
	public void delReason(String name)
	{
		clickDelPath2.click();
		List<WebElement> ele=driver.findElements(By.xpath("//li[@class='ember-power-select-option']"));
		for(WebElement ele1:ele)
		{
			if(ele1.getText().equals(name))
			{
				ele1.click();
				break;
			}
		}
	}
	
	@FindBy(xpath="//button[@data-test-id='delete-dependants-primary-action']")
	WebElement finalClickPath;
	public void finalClick()
	{
		finalClickPath.click();
	}
	@FindBy(xpath="//*[@data-test-id='staff-profile-image']")
	WebElement profilePath;
	@FindBy(xpath="//li[@data-test-id='staff-menu_logout']")
	WebElement logOutPath;
	public void logOut() throws InterruptedException
	{
		Thread.sleep(8000);
		profilePath.click();
		logOutPath.click();
	}
}
