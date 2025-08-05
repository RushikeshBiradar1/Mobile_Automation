package Tickets;

import General_Utility.B2;
import General_Utility.BASETEST;
import General_Utility.BaseClass;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import General_Utility.Java_RandomNumber;
import POM.Dashboard;
import POM.Tickets;
import io.appium.java_client.MobileBy;

public class AssignTicket extends BASETEST{

	@Test(priority = 2)
	public void AssigTicketWIthAllFiledsAnd3Images_TKT_04() throws Throwable
	{
		 Dashboard db = new Dashboard(driver);

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    // Wait for the Open Tickets Tab to be clickable
		    wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab())); // Assuming you have a method to get the element

		    // Now call the method to click on the Open Tickets Tab
		    db.CLickOn_OpenTicketsTab();

		    Tickets tkt = new Tickets(driver);

		    // Raise Ticket button click
//		    tkt.ClickOn_RaiseTicketBUtton();
		   wait.until(ExpectedConditions.elementToBeClickable(tkt.getPlusIcon_Raisetkt_OnTktListing())) .click();
//		    tkt.ClickOn_PlusIcon_Raisetkt_OnTktListing();
		    // Handle pop-ups conditionally
		    try {
		        // Handle "Allow Metaagrow to record audio" pop-up if it appears
		        WebElement allowMetaagrowButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]"));
		        if (allowMetaagrowButton.isDisplayed()) {
		            tkt.ClickOn_AllowMetaagrowTORecordAudio_WhileUsingApp_Popup();
		        }
		    } catch (NoSuchElementException e) {
		        System.out.println("No 'Allow Metaagrow to record audio' pop-up found.");
		    }

		    try {
		        // Handle "Allow Photo and Media" pop-up if it appears
		        WebElement allowPhotoAndMediaButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]"));
		        if (allowPhotoAndMediaButton.isDisplayed()) {
		            tkt.ClickOn_AllowPhotoAndMediaButton();
		        }
		    } catch (NoSuchElementException e) {
		        System.out.println("No 'Allow Photo and Media' pop-up found.");
		    }
		    
		    // Wait for the dropdown to be clickable
		    wait.until(ExpectedConditions.elementToBeClickable(tkt.getSelectTypeDropdown())).click();
		    tkt.CLickOn_SelectGeneralTyep();

		    // Generate random ticket title
		    Java_RandomNumber java = new Java_RandomNumber();
		    int ran = java.getRandomNum();
		    String TicketTitle = "Switch Board Issue at line " + ran;
		    tkt.CLickOn_TicketTitle_TextField(TicketTitle);

		    // Wait and click on a specific item (assuming this is a clickable scroll element)
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"))).click();

		    // Select Technical Department
		    tkt.CLickOn_TechincalDepartmentName();
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"))).click();

		    // Select Users from the dropdown
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getSelectUsersDropdown())).click();  
		//tkt.CLickOn_SelectUsersDropdown();
//		    driver.findElement(By.xpath("//android.widget.TextView[@text=\"Select Users\"]")).click();

		    driver.findElement(By.xpath("//android.widget.TextView[@text=\"Mayur\"]")).click();
		    driver.findElement(By.xpath("//android.widget.TextView[@text=\"Fernandes\"]")).click();
		    driver.findElement(By.xpath("//android.widget.TextView[@text=\"Raj\"]")).click();
		    
		    // Wait for the asset selection and click
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView"))).click();
		    
		    // Select Asset
		  wait.until(ExpectedConditions.elementToBeClickable(tkt.getAssetDropdownOn_RaiseTicket())).click();
//		  tkt.CLickOn_AssetDropdownOn_RaiseTicket();
		    tkt.CLickON_ADULT_BUMPER_CAR_NF_AssetName();

		    // Select Medium Ticket type
		  //click on priority dropdown icon
		  		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.widget.ImageView"))).click();

		  		//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView
		  	wait.until(ExpectedConditions.elementToBeClickable(tkt.getMediumTicket())).click();

		    // Provide Description for the ticket
		    tkt.CLickon_DescriptionBox_OnRaiseTicket("We have encountered an issue with the switchboard located at line '" + ran + "' in the electrical system.");

		    // Scroll and find the "Attach Image" button
		    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Attach Image\"))";
		    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		    // Optional: Wait for the element to be visible
		    wait.until(ExpectedConditions.visibilityOf(targetElement));

		    // Repeat the process of attaching an image
		    for (int i = 0; i < 3; i++) {
		        // Click on the "Attach Image" button
		        targetElement.click();

		        // Handle permission pop-up if it appears
		        try {
		        	WebDriverWait waitPermission = new WebDriverWait(driver, Duration.ofSeconds(7));
		            WebElement permissionButton = waitPermission.until(ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")));
		            permissionButton.click(); // Click the permission button
		        } catch (Exception e) {
		            // If the permission button is not present, no action is needed for this iteration.
		            System.out.println("No permission pop-up for this iteration.");
		        }

		        // Click on the shutter button to take a photo
			    WebElement shutterButton = wait.until(ExpectedConditions.elementToBeClickable(
			            By.xpath("//android.widget.ImageView[@content-desc=\"Shutter\"]")));
			            Thread.sleep(1000);
			            shutterButton.click();

			    // Click the 'Done' button after the photo is taken
			            WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
			                    By.xpath("//android.widget.ImageButton[@content-desc=\"Done\"]")));
			                    doneButton.click();

		        // Click 'Save' to save the photo
		        WebElement saveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Save']"));
		        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		        saveButton.click();
		    }

		    Thread.sleep(1000);
			tkt.CLickOn_RaiseTicketButton_OnRaiseTicketPage();
		    
//		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[contains(@text, \"Raise Ticket\")]"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(tkt.getAssignedTab())).click();

//		tkt.CLickOn_AssignedTab();
		WebElement ticketInList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '" + TicketTitle + "')]")));

		if (!ticketInList.isDisplayed()) {
			System.out.println("Ticket with title '" + TicketTitle + "' not found in the listing.");
			Assert.fail("Ticket with title '" + TicketTitle + "' is not displayed in the listing.");
		} else {
			System.out.println("Test Passed: Ticket with title '" + TicketTitle + "' is displayed in the listing.");
		}

		
	}


	@Test(priority = 1)  // This will run the test)
	public void AssignTicketTest_TKT_03() throws InterruptedException
	{
		Dashboard db = new Dashboard(driver);
//		db.ClickOn_HomeIconAtBottom();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Dashboard db = new Dashboard(driver);
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));  // Assuming you have a method to get the element

		// Now call the method to click on the Open Tickets Tab
		
		db.CLickOn_OpenTicketsTab();
		Tickets tkt = new Tickets(driver);
		
		  wait.until(ExpectedConditions.elementToBeClickable(tkt.getPlusIcon_Raisetkt_OnTktListing())) .click();
		tkt.ClickOn_AllowMetaagrowTORecordAudio_WhileUsingApp_Popup();
		tkt.ClickOn_AllowPhotoAndMediaButton();
		Thread.sleep(5000);
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
		  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Raj\"]")).click();
		  
		  // Wait for the asset selection and click
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView"))).click();
		    
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView"))).click();

		//click on priority dropdown icon
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup/android.widget.ImageView"))).click();

		//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView
	wait.until(ExpectedConditions.elementToBeClickable(tkt.getMediumTicket())).click();

	Thread.sleep(1000);
		tkt.CLickOn_RaiseTicketButton_OnRaiseTicketPage();
//		wait.until(ExpectedConditions.elementToBeClickable(tkt.getAssignedTab())).click();
//		tkt.CLickOn_AssignedTab();

		WebElement ticketInList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, '" + TicketTitle + "')]")));


		if (!ticketInList.isDisplayed()) {
			System.out.println("Ticket with title '" + TicketTitle + "' not found in the listing.");
			Assert.fail("Ticket with title '" + TicketTitle + "' is not displayed in the listing.");
		} else {
			System.out.println("Test Passed: Ticket with title '" + TicketTitle + "' is displayed in the listing.");
		}

		
	}
}
