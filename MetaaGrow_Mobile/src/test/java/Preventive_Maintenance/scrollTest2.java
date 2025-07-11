package Preventive_Maintenance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import General_Utility.BaseClass;
import POM.Dashboard;
import POM.Maintenance;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class scrollTest2 extends BaseClass{
	
	@Test
	public void Scroll() throws Throwable
	{
		    Dashboard db = new Dashboard(driver);
		    db.ClickOn_ScheduledPM();
		    Maintenance pm = new Maintenance(driver);
		    pm.ClickOn_FirstPMChecklist();

		    // Wait for the page to load
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Get the screen size to calculate the scroll points
		    Dimension dimension = driver.manage().window().getSize();
		    int startX = dimension.width / 2; // Start in the middle of the screen horizontally
		    int startY = (int) (dimension.height * 0.8); // Start near the bottom (80% of the screen height)
		    int endY = (int) (dimension.height * 0.4); // Scroll to 40% of the screen height (halfway down)

		    // Perform the scroll action (half of the screen)
		    TouchAction action = new TouchAction(driver);
		    action.press(PointOption.point(startX, startY)) // Start from near the bottom
		          .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))) // Optional: wait before moving
		          .moveTo(PointOption.point(startX, endY)) // Scroll towards the top (to 40% of the screen height)
		          .release() // Release the touch action
		          .perform();

		    System.out.println("Scrolled halfway down.");

		    // Define the UI Automator scroll command to scroll to a specific element
		    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Add Signature\"))";

		    // Use MobileBy to find the element with androidUIAutomator
		    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		    // Optional: Wait for the element to be visible
		    wait.until(ExpectedConditions.visibilityOf(targetElement));

		    // Now you can interact with the element
		    targetElement.click(); // For example, clicking the target element
		    Thread.sleep(5000); // Adjust the sleep time as needed
		}
}


