package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverClass {
	public static RemoteWebDriver driver=null;
	public Properties file=null;
	@BeforeClass
	public void driver() throws FileNotFoundException, IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		file=new Properties();
		file.load(new FileInputStream("C:\\Users\\kmruge\\git\\HappyFox1\\happyFox_Interview\\src\\main\\java\\Base\\File.properties"));
	}
	public void screenShot(ITestResult result) {
		//To Take Screen Shot After completing of each TestCase
		File shot=new File("C:\\Users\\kmruge\\eclipse-workspace\\happyFox_Interview\\ScreenShot\\"+result.getName()+".png");
		File dig=driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(dig, shot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
