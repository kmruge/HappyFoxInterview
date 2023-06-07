package happyFox_pageObjectModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Verifing_Created_TT {
	private RemoteWebDriver driver=null;
	private ArrayList<String> defaultSelected=new ArrayList<String>();
	public Verifing_Created_TT(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToStaffWindow()
	{
		Set<String> windowIds=driver.getWindowHandles();
		ArrayList<String> id=new ArrayList<String>(windowIds);
		driver.switchTo().window(id.get(0));
	}
	@FindBy(xpath="//div[@data-test-id='module-switcher_trigger']")
	WebElement menu;
	@FindBy(xpath="//div[contains(text(),'Tickets')]")
	WebElement navigateToTTxpath;
	@FindBy(xpath="//li[@title=\"All Tickets\"]")
	WebElement allTT;
	@FindBy(xpath="//section/div[@class='hf-bulk-selection-item ember-view'][1]//a")
	WebElement createdTTPath;
	
	public void navigateToTT()
	{
		menu.click();
		navigateToTTxpath.click();
		allTT.click();
		createdTTPath.click();
	}
	@FindBy(xpath="//span[@class='hf-ticket-status_name']")
	WebElement TTStatus;
	@FindBy(xpath="//div[@data-test-id='ticket-box_priority']")
	WebElement TTPriority;
	public void checkingDefaultStatus()
	{
		boolean checkTTS=TTStatus.isDisplayed();
		Assert.assertTrue(checkTTS, "TICKET CREATED WITHOUT DEFAULT STATUS");
		boolean checkTTP=TTPriority.isDisplayed();
		Assert.assertTrue(checkTTP, "TICKET CREATED WITHOUT DEFAULT PRIORITY");
		
	}
	@FindBy(xpath="//a[@data-test-id='reply-link']")
	WebElement replyClick;
	@FindBy(xpath="//div[contains(@class,'cke_show_borders')]")
	WebElement replyText;
	@FindBy(xpath="//div[@data-test-id='add-update-ticket-action_change-status_trigger']")
	WebElement statusCheck;
	@FindBy(xpath="//span//div[@data-test-id='ticket-action_change-priority_trigger']")
	WebElement priorityCheck;
	@FindBy(xpath="//div[@data-test-id='editor-add-tags-trigger']")
	WebElement tagCheck;
	public void TTReply(String mess)
	{
		replyClick.click();
		replyText.sendKeys(mess);
		//Storing default status of Ticket(Status, Priority, Tag)
		defaultSelected.add(statusCheck.getText());
		defaultSelected.add(priorityCheck.getText());
		defaultSelected.add(tagCheck.getText());
	}
	
	
	private void optClick(By ele,String name)
	{
		List<WebElement> status=driver.findElements(ele);
		for(WebElement opt:status)
		{
			if(opt.getText().equals(name))
			{
				opt.click();
				break;
			}
		}
	}
	
	By statusOptPath=By.xpath("//div[@class='hf-ticket-attribute_option']");
	By priorityOptPath=By.xpath("//div[@class='hf-ticket-attribute_option']");
	@FindBy(xpath="//div[@data-test-id='editor-add-tags-trigger']")
	WebElement clickTagPath;
	
//	By tagOptPath=By.xpath("//ul[@class='ember-power-select-multiple-options']");
	@FindBy(xpath="//input[@class='ember-power-select-trigger-multiple-input']")
	WebElement tagOptPath;
	@FindBy(xpath="//div[@data-test-id='pop-over-close']")
	WebElement tagClose;
	@FindBy(xpath="//button[@data-test-id='add-update-reply-button']")
	WebElement addReply;
	
	
	@FindBy(xpath="//li[contains(@data-test-id,'module-switcher')]/a[text()='Priorities']")
	WebElement click_priority;
	public void changingTTStatus(String status, String priority) throws InterruptedException
	{
		statusCheck.click();
		Thread.sleep(5000);
		optClick(statusOptPath,status);
		priorityCheck.click();
		Thread.sleep(5000);
		optClick(priorityOptPath,priority);
		clickTagPath.click();
		for(int i=0; i<3;i++)
		{
		String tag=Keys.chord("3"+i,Keys.ENTER);
		tagOptPath.sendKeys(tag);
		}
		tagClose.click();
		
		//Extracting current status of Ticket(Status, Priority, Tag)
		String status1=statusCheck.getText();
		String priority1=priorityCheck.getText();
		String tag1=tagCheck.getText();
		//Verifing status of Status, Priority and Tag
		Assert.assertNotEquals(status1,defaultSelected.get(0));
		System.out.println("State of STATUS has been changed and Verified");
		Assert.assertNotEquals(priority1,defaultSelected.get(1));
		System.out.println("State of PRIORITY has been changed and Verified");
		Assert.assertNotEquals(tag1,defaultSelected.get(2));
		System.out.println("State of TAG has been changed and Verified");
		addReply.click();
		Thread.sleep(8000);
		menu.click();
		click_priority.click();
	}
}
