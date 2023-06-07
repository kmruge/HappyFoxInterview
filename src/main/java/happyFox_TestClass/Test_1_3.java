package happyFox_TestClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.driverClass;
import ForScreenShot.Listener;
import happyFox_pageObjectModule.Priority_Creation;
import happyFox_pageObjectModule.Priority_Delete;
import happyFox_pageObjectModule.Status_Creation;
import happyFox_pageObjectModule.Status_Delete;
import happyFox_pageObjectModule.logInClass;
@Listeners(ForScreenShot.Listener.class)
public class Test_1_3  extends driverClass{
	private logInClass login=null;
	private Status_Creation status=null;
	private Priority_Creation priority=null;
	private Priority_Delete delPriority=null;
	private Status_Delete delStatus=null;
	
	@BeforeClass
	private void objInstance()
	{
		login=new logInClass(driver);
		status=new Status_Creation(driver);
		priority=new Priority_Creation(driver);
		delPriority=new Priority_Delete(driver);
		delStatus=new Status_Delete(driver);
		
	}
	
	@Test(priority=1)
	//Scenarios 1 as per the requirement
	//Prioperty File has used to keep the data's please find the property file in base package
	void LogInTest()
	{
		login.userName(file.getProperty("UserName"));
		login.password(file.getProperty("Passward"));
		login.click();
	}
	@Test(priority=2)
	void statusCreation()
	{
		status.menu();
		status.newStatus();
		status.statusName(file.getProperty("StatusName"));
		status.behaviorAssert(file.getProperty("BehaviorSet"));
		status.addDescription(file.getProperty("StatusDescription"));
		status.clickCreate();
		status.makeDefault();
	}
	@Test(priority=3)
	void priorityCreation()
	{
		priority.priorityClick();
		priority.newPriority();
		priority.priorityName(file.getProperty("PriorityName"));
		priority.addDescription(file.getProperty("PriorityDescription"));
		priority.clickCreate();
		priority.makeDefault();
	}
	//Scenarios 3 as per the requirement
	@Test(priority=4)
	void priorityDelete() throws InterruptedException
	{
		delPriority.clickDel();
		delPriority.deletePriority(file.getProperty("priorityDelReason"));
		delPriority.finalDelCall();
	}
	@Test(priority=5)
	void statusDelete() throws InterruptedException
	{
		delStatus.navigateToStatus();
		delStatus.clickDel();
		delStatus.delReason(file.getProperty("statusDelReson"));
		delStatus.finalClick();
		delStatus.logOut();
	}
}
