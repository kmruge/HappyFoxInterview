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
	void LogInTest()
	{
		login.userName("Agent");
		login.password("Agent@123");
		login.click();
	}
	@Test(priority=2)
	void statusCreation()
	{
		status.menu();
		status.newStatus();
		status.statusName("Issue created");
		status.behaviorAssert("Pending");
		status.addDescription("Status when a new ticket is created in HappyFox");
		status.clickCreate();
		status.makeDefault();
	}
	@Test(priority=3)
	void priorityCreation()
	{
		priority.priorityClick();
		priority.newPriority();
		priority.priorityName("Assistance required");
		priority.addDescription("Priority of the newly created tickets");
		priority.clickCreate();
		priority.makeDefault();
	}
	//Scenarios 3 as per the requirement
	@Test(priority=4)
	void priorityDelete() throws InterruptedException
	{
		delPriority.clickDel();
		delPriority.deletePriority("Low");
		delPriority.finalDelCall();
	}
	@Test(priority=5)
	void statusDelete() throws InterruptedException
	{
		delStatus.navigateToStatus();
		delStatus.clickDel();
		delStatus.delReason("Completed");
		delStatus.finalClick();
		delStatus.logOut();
	}
}
