package Tickets;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import General_Utility.B1;
import General_Utility.B2;
import General_Utility.BaseClass;
import General_Utility.Java_RandomNumber;
import POM.Dashboard;
import POM.Tickets;
import io.appium.java_client.MobileBy;

public class Edit_TicketTest extends B2{



	@Test(priority = 1)
	public void Edit_TicketToBreakdownTest_TKT_08()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);

		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));
		// Now call the method to click on the Open Tickets Tab
		db.CLickOn_OpenTicketsTab();

		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"ADULT BUMPER CAR NF\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		// Now you can interact with the element
		targetElement.click(); // For example, clicking the target element

		// Wait for the first ticket to be clickable and click on it
		Tickets tkt = new Tickets(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getFirstTicket()));
		tkt.CLickOn_FirstTicket();

		//Click On Edit Dropdown
		tkt.ClickOn_EditTicketButton();
		tkt.ClickOn_GeneralType();
		tkt.ClickOn_SelectBreakdownType();

		//Click On Submit Button
		tkt.ClickOn_SubmitButton();
		tkt.ClickOn_YesButton_OnChangeStatusPopup();


	}

	@Test(priority = 2)
	public void Edit_TicketToGeneralTest_TKT_09()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);

		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));
		// Now call the method to click on the Open Tickets Tab
		db.CLickOn_OpenTicketsTab();

		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"ADULT BUMPER CAR NF\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		// Now you can interact with the element
		targetElement.click(); // For example, clicking the target element

		// Wait for the first ticket to be clickable and click on it
		Tickets tkt = new Tickets(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getFirstTicket()));
		tkt.CLickOn_FirstTicket();

		//Click On Edit Dropdown and select General Type
		tkt.ClickOn_EditTicketButton();
		tkt.CLickOn_BreakdownType_OnEditMeter();
		tkt.ClickOn_GeneralType();
	

		//Click On Submit Button
		tkt.ClickOn_SubmitButton();
		tkt.ClickOn_YesButton_OnChangeStatusPopup();


	}
	
	@Test(priority = 3)
	public void ReplyTicketTest_TKT_10()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);
		
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));
		// Now call the method to click on the Open Tickets Tab
		db.CLickOn_OpenTicketsTab();

		// Wait for the first ticket to be clickable and click on it
				Tickets tkt = new Tickets(driver);
				wait.until(ExpectedConditions.elementToBeClickable(tkt.getFirstTicket()));
				tkt.CLickOn_FirstTicket();
				
		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Reply\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		Java_RandomNumber java = new Java_RandomNumber();
				int ran = java.getRandomNum();
		
				// Define the text to search for
				String replyText = "The switch board issue at Line '" + ran + "' has been resolved. Our team has addressed the problem, and everything should now be functioning as expected.";
				
		// Now you can interact with the element
		tkt.ClickOn_ReplyBox_OnTicketInfo(replyText);
	
		String uiScrollable2 = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Submit\"))";
		WebElement SubmitButton = driver.findElement(MobileBy.androidUIAutomator(uiScrollable2));
		
		
	tkt.ClickOn_SubmitButton();
	
	

	// Define the UI Automator scroll command to scroll to the specific reply text
	String uiScrollable1 = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + replyText + "\"))";

	// Use MobileBy to find the element with androidUIAutomator
	WebElement replyElement;
	try {
	    replyElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable1));
	} catch (Exception e) {
	    // If the element is not found, fail the script
	    throw new AssertionError("Reply text not found on the page: " + replyText);
	}

	// Wait for the element to be visible
	wait.until(ExpectedConditions.visibilityOf(replyElement));

	// Verify if the reply text is displayed
	if (replyElement.isDisplayed()) {
	    System.out.println("Reply is successfully displayed on the page. Script passed!");
	} else {
	    throw new AssertionError("Reply text is not displayed on the page. Script failed!");
	}
	
	
	}
	
	@Test(priority = 4)
	public void ReplyTicketWithAttachImagesTest_TKT_11()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);
		
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));
		// Now call the method to click on the Open Tickets Tab
		db.CLickOn_OpenTicketsTab();

		// Wait for the first ticket to be clickable and click on it
				Tickets tkt = new Tickets(driver);
				wait.until(ExpectedConditions.elementToBeClickable(tkt.getFirstTicket()));
				tkt.CLickOn_FirstTicket();
				
		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Reply\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		Java_RandomNumber java = new Java_RandomNumber();
				int ran = java.getRandomNum();
		
				// Define the text to search for
				String replyText = "The switch board issue at Line '" + ran + "' has been resolved. Our team has addressed the problem, and everything should now be functioning as expected.";
				
		// Now you can interact with the element
		tkt.ClickOn_ReplyBox_OnTicketInfo(replyText);
		// Define the UI Automator scroll command to scroll to a specific element
		String AttachImages = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Attach Images\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement AttachImagesText = driver.findElement(MobileBy.androidUIAutomator(AttachImages)); 
		

		// Optional: Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(AttachImagesText));

		 
		boolean isPermissionButtonClicked = false;
		boolean photosmediapopup= false;
		// Repeat this process 5 times
		for (int i = 0; i < 5; i++) {
		    // Now click on the "Attach Image" button
			AttachImagesText.click();
		    
		    if (!isPermissionButtonClicked) {
		        try {
		            // Wait and handle the permission popup if it appears (only the first time)
		            WebElement permissionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")));
		            
		            permissionButton.click(); // Click the permission button
		            isPermissionButtonClicked = true; // Mark the button as clicked
		            System.out.println("Permission pop-up clicked for the first time.");
		        } catch (Exception e) {
		            // If the permission button is not present, no action is needed
		            System.out.println("No permission pop-up for this iteration.");
		        }
		    }
		   
//		    String AttachImagesrecheck = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Attach Images\"))";

			// Use MobileBy to find the element with androidUIAutomator
//			WebElement AttachImagesText1 = driver.findElement(MobileBy.androidUIAutomator(AttachImages)); 
//			
//			// Optional: Wait for the element to be visible
//			wait.until(ExpectedConditions.visibilityOf(AttachImagesText1));
			
		    // Click on the shutter button to take a photo
		    WebElement shutterButton = driver.findElement(By.id("com.android.camera2:id/shutter_button"));
		    shutterButton.click();

		    // Click the 'Done' button after the photo is taken
		    WebElement doneButton = driver.findElement(By.id("com.android.camera2:id/done_button"));
		    doneButton.click();

		    // Click the photos media popup only once
		    if (!photosmediapopup) {
		        try {
		            // Wait and handle the photos/media popup if it appears (only the first time)
		            WebElement photosMediaButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]"))); // Modify XPath as necessary
		            
		            photosMediaButton.click(); // Click the media popup button
		            photosmediapopup = true; // Mark the popup as clicked
		            System.out.println("Photos media popup clicked for the first time.");
		        } catch (Exception e) {
		            // If the photos media popup is not present, no action is needed
		            System.out.println("No photos media popup for this iteration.");
		        }
		    }
		    
		    
		    // Click 'Save' to save the photo
		    WebElement saveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Save']"));
		    saveButton.click();
		   
		}
		
		String uiScrollable2 = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Submit\"))";
		WebElement SubmitButton = driver.findElement(MobileBy.androidUIAutomator(uiScrollable2));
		
		
	tkt.ClickOn_SubmitButton();
	
	

	// Define the UI Automator scroll command to scroll to the specific reply text
	String uiScrollable1 = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + replyText + "\"))";

	// Use MobileBy to find the element with androidUIAutomator
	WebElement replyElement;
	try {
	    replyElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable1));
	} catch (Exception e) {
	    // If the element is not found, fail the script
	    throw new AssertionError("Reply text not found on the page: " + replyText);
	}

	// Wait for the element to be visible
	wait.until(ExpectedConditions.visibilityOf(replyElement));

	// Verify if the reply text is displayed
	if (replyElement.isDisplayed()) {
	    System.out.println("Reply is successfully displayed on the page. Script passed!");
	} else {
	    throw new AssertionError("Reply text is not displayed on the page. Script failed!");
	}
	
	
	}
	

}
