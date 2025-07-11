package General_Utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class Listeners{
	
	public void onTestFailure( WebDriver driver, String tname) throws Throwable
  {
		
	  TakesScreenshot ts=(TakesScreenshot) driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  File dest=new File("./screenshot/"+tname+".png");
	  Files.copy(src, dest);
	  System.out.println("Screenshot Taken"); 
  } 
	public void onTestStart(ITestResult tr)
	{
		System.out.println("Test Started");
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("Test Passed");
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("Test Skipped");
	}
}
