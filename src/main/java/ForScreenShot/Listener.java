package ForScreenShot;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.driverClass;

public class Listener implements ITestListener{
	
	public void onTestSuccess(ITestResult result) {
		driverClass shot=new driverClass();
		shot.screenShot(result);
	  }
}
