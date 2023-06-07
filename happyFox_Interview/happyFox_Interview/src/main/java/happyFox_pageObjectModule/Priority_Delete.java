package happyFox_pageObjectModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Priority_Delete {
	private RemoteWebDriver driver=null;
	
	public Priority_Delete(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By clickDefault=By.xpath("//span[text()='Assistance required']");
	@FindBy(xpath="//a[contains(@class,'delete-priority-trigger')]")
	WebElement DeleteClick;
	public void clickDel() throws InterruptedException
	{
		Thread.sleep(10000);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(clickDefault)).click();
		DeleteClick.click();
	}
	@FindBy(xpath="//span[text()='Choose Priority']")
	WebElement deletePriorityPath;
	By reason=By.xpath("//li[@class=\"ember-power-select-option\"]");
	public void deletePriority(String name)
	{
		deletePriorityPath.click();
		List<WebElement> option=driver.findElements(reason);
		for(WebElement close:option)
		{
			if(close.getText().equals(name))
			{
				close.click();
				break;
			}
		}
	}
	By finalDelClickPath=By.xpath("//button[@data-test-id='delete-dependants-primary-action']");
	public void finalDelCall()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(finalDelClickPath)).click();
	}
}
