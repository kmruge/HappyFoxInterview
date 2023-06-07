package happyFox_pageObjectModule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ticket_Creation {
	private RemoteWebDriver driver=null;
	
	public Ticket_Creation(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id_subject")
	WebElement subjectPath;
	@FindBy(xpath="//div[@id='cke_1_contents']/div")
	WebElement messPath;
	public void ticketDetail(String sub, String mess)
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://interview.supporthive.com/new");
		driver.findElement(By.xpath("//a[@title='Login']")).click();
		driver.findElement(By.xpath("//a[text()='create a new ticket']")).click();
		subjectPath.sendKeys(sub);
		messPath.sendKeys(mess);
	}
	
	@FindBy(id="id_name")
	WebElement namePath;
	@FindBy(id="id_email")
	WebElement emailPath;
	public void contactDetails(String name, String mail)
	{
		namePath.sendKeys(name);
		emailPath.sendKeys(mail);
	}
	
	@FindBy(id="submit")
	WebElement clickCreatePath;
	public void clickCreate() throws InterruptedException
	{
		clickCreatePath.click();
		Thread.sleep(10000);
	}
}
