package happyFox_pageObjectModule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logInClass {
	private RemoteWebDriver driver=null;
	
	public logInClass(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Store all WebElement associated with login page.
	@FindBy(id="id_username")
	WebElement emailPath;
	
	@FindBy(id="id_password")
	WebElement passwordPath;
	
	@FindBy(id="btn-submit")
	WebElement loginPath;
	
	public void userName(String name)
	{
		driver.get("https://interview.supporthive.com/staff/login/?return_to=%2Fstaff%2F");
		emailPath.sendKeys(name);
	}
	public void password(String password)
	{
		passwordPath.sendKeys(password);
	}
	public void click()
	{
		loginPath.click();
	}

}
