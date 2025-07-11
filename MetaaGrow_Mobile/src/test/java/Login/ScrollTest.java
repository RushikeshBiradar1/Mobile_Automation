package Login;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import General_Utility.BaseClass;
import POM.Dashboard;
import POM.Maintenance;
import io.appium.java_client.MobileBy;

public class ScrollTest extends BaseClass {
	
	 // This method performs a scroll action using TouchAction
//	@Test
//    public void sc1() throws Throwable {
//		 // Use MobileBy.androidUIAutomator for UiScrollable
//        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
//        
//        // Scroll down using androidUIAutomator
//        driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
//        Thread.sleep(5000);
//	}

	
	@Test
	public void sc2() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
		db.ClickOn_ScheduledPM();
		Maintenance pm = new Maintenance(driver);
		pm.ClickOn_FirstPMChecklist();

		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Add Signature\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		// Now you can interact with the element
		targetElement.click(); // For example, clicking the target element
		Thread.sleep(5000);
	}
}
