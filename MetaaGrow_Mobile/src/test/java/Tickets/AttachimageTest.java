package Tickets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import General_Utility.BaseClass;
import POM.Dashboard;
import POM.Tickets;
import io.appium.java_client.MobileBy;

public class AttachimageTest extends BaseClass {
	
	@Test
	public void image() throws Throwable
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Dashboard db = new Dashboard(driver);
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));  // Assuming you have a method to get the element

		// Now call the method to click on the Open Tickets Tab
		
		db.CLickOn_OpenTicketsTab();
		Tickets tkt = new Tickets(driver);
		 
		tkt.ClickOn_RaiseTicketBUtton();
		tkt.ClickOn_AllowMetaagrowTORecordAudio_WhileUsingApp_Popup();
		tkt.ClickOn_AllowPhotoAndMediaButton();
		Thread.sleep(3000);
		// Define the UI Automator scroll command to scroll to a specific element
				String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Attach Image\"))";

				// Use MobileBy to find the element with androidUIAutomator
				WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

				// Optional: Wait for the element to be visible
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(targetElement));

				// Now you can interact with the element
				targetElement.click(); // For example, clicking the target element
//		tkt.CLickOn_AttachImages_OnRaiseTicket();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")).click();
		driver.findElement(By.id("com.android.camera:id/shutter_button")).click();
		driver.findElement(By.id("com.android.camera:id/done_button")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Save\"]")).click();
		Thread.sleep(7000);
	}

}
