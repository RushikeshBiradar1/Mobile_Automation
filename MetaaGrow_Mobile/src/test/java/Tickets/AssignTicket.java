package Tickets;

import General_Utility.B2;
import General_Utility.BaseClass;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import General_Utility.Java_RandomNumber;
import POM.Dashboard;
import POM.Tickets;
import io.appium.java_client.MobileBy;

public class AssignTicket extends B2{

	@Test(priority = 1)
	public void AssigTicketWIthAllFiledsAnd3Images_TKT_04() throws Throwable
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));  // Assuming you have a method to get the element

		// Now call the method to click on the Open Tickets Tab

		db.CLickOn_OpenTicketsTab();
		Tickets tkt = new Tickets(driver);

		tkt.ClickOn_RaiseTicketBUtton();
		tkt.ClickOn_AllowMetaagrowTORecordAudio_WhileUsingApp_Popup();
		tkt.ClickOn_AllowPhotoAndMediaButton();

		tkt.ClickOn_SelectTypeDropdown();
		tkt.CLickOn_SelectGeneralTyep();
		Java_RandomNumber java = new Java_RandomNumber();
		int ran = java.getRandomNum();
		String TicketTitle="Switch Board Issue at line "+ran;
		tkt.CLickOn_TicketTitle_TextField(TicketTitle);
		// Wait for the element to be clickable and click it

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"))).click();

		//	driver.findElement(By.xpath("//android.widget.TextView[@text='Select Department']")).click();

		// Wait for the next element or any necessary condition before performing the next action
		tkt.CLickOn_TechincalDepartmentName();

		// Wait for the same element again before clicking it
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"))).click();

		//	driver.findElement(By.xpath("//android.widget.TextView[@text='Select Department']")).click();
		tkt.CLickOn_SelectUsersDropdown();

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Mayur\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Fernandes\"]")).click();
		tkt.ClickOn_SearchUsersOn_RaiseTicket("Raj");
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Raj\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView"))).click();

		tkt.CLickOn_AssetDropdownOn_RaiseTicket();
		tkt.CLickON_ADULT_BUMPER_CAR_NF_AssetName();

		//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView
		tkt.CLickoN_MediumTicket();


		//Description
		tkt.CLickon_DescriptionBox_OnRaiseTicket("We have encountered an issue with the switchboard located at line '"+ran+"' in the electrical system.");


		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Attach Image\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable)); 


		// Optional: Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(targetElement));


		boolean isPermissionButtonClicked = false;

		// Repeat this process 5 times
		for (int i = 0; i < 3; i++) {
			// Now click on the "Attach Image" button
			targetElement.click();

			// Handle permission pop-up if it appears
			//	    try {
			//	        // Wait and handle the permission popup if it appears (only once per iteration)
			//	        WebElement permissionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
			//	                By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")));
			//	        permissionButton.click(); // Click the permission button
			//	    } catch (Exception e) {
			//	        // If the permission button is not present, no action is needed for this iteration.
			//	        System.out.println("No permission pop-up for this iteration.");
			//	    }


			if (!isPermissionButtonClicked) {
				try {
					// Wait and handle the permission popup if it appears (only the first time)
					WebElement permissionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")));

					permissionButton.click(); // Click the permission button
					isPermissionButtonClicked = true; // Mark the button as clicked
					System.out.println("Permission pop-up clicked for the first time.");
				} catch (Exception e) {
					// If the permission button is not present, no action is needed
					System.out.println("No permission pop-up for this iteration.");
				}
			}





			// Click on the shutter button to take a photo
			WebElement shutterButton = driver.findElement(By.id("com.android.camera2:id/shutter_button"));
			shutterButton.click();

			// Click the 'Done' button after the photo is taken
			WebElement doneButton = driver.findElement(By.id("com.android.camera2:id/done_button"));
			doneButton.click();

			// Click 'Save' to save the photo
			WebElement saveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Save']"));
			saveButton.click();
		}

		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Raise Ticket\"]"))).click();
		tkt.CLickOn_RaiseTicketButton_OnRaiseTicketPage();
		//	 tkt.CLickOn_RaiseTicketButton_OnRaiseTicketPage();


		tkt.CLickOn_AssignedTab();
		WebElement ticketInList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '" + TicketTitle + "')]")));

		if (!ticketInList.isDisplayed()) {
			System.out.println("Ticket with title '" + TicketTitle + "' not found in the listing.");
			Assert.fail("Ticket with title '" + TicketTitle + "' is not displayed in the listing.");
		} else {
			System.out.println("Test Passed: Ticket with title '" + TicketTitle + "' is displayed in the listing.");
		}

		db.ClickOn_HomeIconAtBottom();

	}


	@Test(priority = 2)  // This will run the test)
	public void AssignTicketTest_TKT_03() throws InterruptedException
	{
		Dashboard db = new Dashboard(driver);
		db.ClickOn_HomeIconAtBottom();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//		Dashboard db = new Dashboard(driver);
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));  // Assuming you have a method to get the element

		// Now call the method to click on the Open Tickets Tab

		db.CLickOn_OpenTicketsTab();
		Tickets tkt = new Tickets(driver);

		tkt.ClickOn_RaiseTicketBUtton();
		//		tkt.ClickOn_AllowMetaagrowTORecordAudio_WhileUsingApp_Popup();
		//		tkt.ClickOn_AllowPhotoAndMediaButton();

		tkt.ClickOn_SelectTypeDropdown();
		tkt.CLickOn_SelectGeneralTyep();
		Java_RandomNumber java = new Java_RandomNumber();
		int ran = java.getRandomNum();
		String TicketTitle="Switch Board Issue at line "+ran;
		tkt.CLickOn_TicketTitle_TextField(TicketTitle);
		// Wait for the element to be clickable and click it

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"))).click();

		//		driver.findElement(By.xpath("//android.widget.TextView[@text='Select Department']")).click();

		// Wait for the next element or any necessary condition before performing the next action
		tkt.CLickOn_TechincalDepartmentName();

		// Wait for the same element again before clicking it
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"))).click();

		//		driver.findElement(By.xpath("//android.widget.TextView[@text='Select Department']")).click();
		tkt.CLickOn_SelectUsersDropdown();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Mayur\"]")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Fernandes\"]")).click();
		tkt.ClickOn_SearchUsersOn_RaiseTicket("Raj");
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Raj\"]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView"))).click();

		//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView
		tkt.CLickoN_MediumTicket();
		tkt.CLickOn_RaiseTicketButton_OnRaiseTicketPage();
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getRaisedTab()));
		tkt.CLickOn_AssignedTab();

		WebElement ticketInList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '" + TicketTitle + "')]")));


		if (!ticketInList.isDisplayed()) {
			System.out.println("Ticket with title '" + TicketTitle + "' not found in the listing.");
			Assert.fail("Ticket with title '" + TicketTitle + "' is not displayed in the listing.");
		} else {
			System.out.println("Test Passed: Ticket with title '" + TicketTitle + "' is displayed in the listing.");
		}

		db.ClickOn_HomeIconAtBottom();
	}
}
