package happyFox_TestClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.driverClass;
import happyFox_pageObjectModule.Priority_Creation;
import happyFox_pageObjectModule.Priority_Delete;
import happyFox_pageObjectModule.Status_Creation;
import happyFox_pageObjectModule.Status_Delete;
import happyFox_pageObjectModule.Ticket_Creation;
import happyFox_pageObjectModule.Verifing_Created_TT;
import happyFox_pageObjectModule.logInClass;
@Listeners(ForScreenShot.Listener.class)
public class Test_1_2_3 extends driverClass {
	private Ticket_Creation TT=null;
	private logInClass login=null;
	private Status_Creation status=null;
	private Priority_Creation priority=null;
	private Priority_Delete delPriority=null;
	private Status_Delete delStatus=null;
	private Verifing_Created_TT TTCreated=null;
	@BeforeClass
	private void objInstance()
	{
		login=new logInClass(driver);
		status=new Status_Creation(driver);
		priority=new Priority_Creation(driver);
		delPriority=new Priority_Delete(driver);
		delStatus=new Status_Delete(driver);
		TT=new Ticket_Creation(driver);
		TTCreated=new Verifing_Created_TT(driver);
		
	}
	//Scenarios 1 as per the requirement
	@Test(priority=1)
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
	//Scenario 2 as per requirement
	@Test(priority=4)
	void ticketCreation() throws InterruptedException
	{
		TT.ticketDetail("First Service - Royal Enfield", "First service for royal enfield.");
		TT.contactDetails("Murugesh K", "kmrugeshwin.it@gmail.com");
		TT.clickCreate();
	}
	@Test(priority=5)
	void ticketVerification() throws InterruptedException
	{
		TTCreated.navigateToStaffWindow();
		TTCreated.navigateToTT();
		TTCreated.checkingDefaultStatus();
		TTCreated.TTReply("Reply to customer query");
		TTCreated.changingTTStatus("Completed", "Medium");
		
	}
	//Scenario 3 as per requirement
	@Test(priority=6)
	void priorityDelete() throws InterruptedException
	{
		delPriority.clickDel();
		delPriority.deletePriority("Low");
		delPriority.finalDelCall();
	}
	@Test(priority=7)
	void statusDelete() throws InterruptedException
	{
		delStatus.navigateToStatus();
		delStatus.clickDel();
		delStatus.delReason("Completed");
		delStatus.finalClick();
		delStatus.logOut();
	}
}
