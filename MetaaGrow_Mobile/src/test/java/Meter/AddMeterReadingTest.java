package Meter;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import General_Utility.B1;
import General_Utility.B2;
import General_Utility.BASETEST;
import General_Utility.BaseClass;
import General_Utility.Scroll;
import POM.Dashboard;
import POM.Meter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AddMeterReadingTest extends  BASETEST{
	
	@Test(priority = 1)
	public void TC_MTR_01_AddReadingTest() throws Throwable
	{
		
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();
		
		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "Meter Readings");
		
		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getMeterScheduled()));
		
		// Search and select the meter, then add the reading
		db.ClickOn_MeterScheduled();
		Meter meter = new Meter(driver);
		meter.CLickOn_SearchMeterNameBox("Claw");
		meter.CLickOn_ClawMachineMeter();
		meter.CLickOn_AddReading();
		
		// Change this reading by incrementally at every run time
		
        int NewReading = 200;
		meter.ClickOn_EnterReading(NewReading);
		
		// Save the reading and confirm
		meter.ClickOn_AddReadingButton();
		meter.CLickOn_YesButton_OnSaveThisReadingPopup();
		
		// Scroll to the reading and make sure it is visible
		sc.ScrollUsingText(driver, "200 GHz"); 

		// Wait for the element to be visible after scrolling
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='200 GHz']")));

		// Refind the element after it's visible
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='200 GHz']"));
		System.out.println("Found the reading element: " + element.getText());

		// Verify that the correct reading element is found (assertion)
		Assert.assertTrue(element.getText().contains(String.valueOf(NewReading)), "The newly added reading was not found");
		
		
	}
	
	@Test(priority = 2)
	public void TC_MTR_02_AddReadingWithImageTest() throws Throwable
	{
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();
		
		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "Meter Readings");
		
	   		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getMeterScheduled()));
		
		// Search and select the meter, then add the reading
		db.ClickOn_MeterScheduled();
		
		Meter meter = new Meter(driver);
//		meter.CLickON_MeterScheduleTab();
		meter.CLickOn_SearchMeterNameBox("Claw");
		meter.CLickOn_ClawMachineMeter();
		meter.CLickOn_AddReading();
		
		// Change this reading by incrementally at every run time
        int NewReading = 200;
		meter.ClickOn_EnterReading(NewReading);
		
		meter.ClickcOn_AttachImageOn_AddMeterReadingPage();
		
		  // Handle permission pop-up if it appears
        try {
            WebElement permissionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")));
            permissionButton.click(); // Click the permission button
        } catch (Exception e) {
            // If the permission button is not present, no action is needed for this iteration.
            System.out.println("No permission pop-up for this iteration.");
        }

        try {
            // Wait for the shutter button to be clickable and click on it
        	WebElement shutterButton = wait.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("//android.widget.ImageView[@content-desc=\"Shutter\"]")));
    		Thread.sleep(1000);
    		shutterButton.click();
//            driver.findElement(By.id("com.android.camera:id/shutter_button")).click();
//    		driver.findElement(By.id("com.android.camera:id/done_button")).click();
//    		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Save\"]")).click();
            
            
    		// Click the 'Done' button after the photo is taken

    		WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
    				By.xpath("//android.widget.ImageButton[@content-desc=\"Done\"]")));
    		doneButton.click();
    		
        } catch (TimeoutException e) {
            System.out.println("Camera shutter button not found or not clickable within the time limit");
        }
        boolean photosmediapopup= false;
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
        
        
        // Click 'Save' to save the photo
        WebElement saveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Save']"));
        saveButton.click();
        
     // Save the reading and confirm
     		meter.ClickOn_AddReadingButton();
     		meter.CLickOn_YesButton_OnSaveThisReadingPopup();
     		
     		// Scroll to the reading and make sure it is visible
     		sc.ScrollUsingText(driver, "200 GHz"); 

     		// Wait for the element to be visible after scrolling
     		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='200 GHz']")));

     		// Refind the element after it's visible
     		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='200 GHz']"));
     		System.out.println("Found the reading element: " + element.getText());

     		// Verify that the correct reading element is found (assertion)
     		Assert.assertTrue(element.getText().contains(String.valueOf(NewReading)), "The newly added reading was not found");
		
			}
	}
	
	@Test(priority = 3)
	public void TC_MTR_03_SearchMeterFromList() throws Throwable {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    Scroll sc = new Scroll();

	    // Scroll to the "Meter Readings" section
	    sc.ScrollUsingText(driver, "Meter Readings");

	    Dashboard db = new Dashboard(driver);
	    wait.until(ExpectedConditions.elementToBeClickable(db.getMeterScheduled())).click();

	    Meter meter = new Meter(driver);

	    // Dynamic meter name input
	    String expectedMeterName = "Claw Machine 1 Meter";  // Can be pulled from Excel or properties
	    meter.CLickOn_SearchMeterNameBox("Claw");

	    // Create dynamic XPath using partial meter name
	    By resultLocator = By.xpath("//android.widget.TextView[contains(@text,'" + expectedMeterName + "')]");

	    try {
	        // Wait for and verify the meter name is displayed
	        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));

	        Assert.assertTrue(result.isDisplayed(), "✅ '" + expectedMeterName + "' is displayed.");
	        System.out.println("✅ '" + expectedMeterName + "' is displayed in the list.");

	       

	    } catch (TimeoutException e) {
	        // Meter not found
	        Assert.fail("❌ '" + expectedMeterName + "' was NOT found in the meter list.");
	    } catch (Exception ex) {
	        Assert.fail("❌ Unexpected error while verifying meter list: " + ex.getMessage());
	    }

	    // Try clicking back safely
	    try {
	        WebElement backButton = driver.findElement(By.xpath(".//android.widget.ImageView"));
	        if (backButton.isDisplayed()) {
	            backButton.click();
	            System.out.println("⬅️ Navigated back successfully.");
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("ℹ️ Back button not found, skipping back navigation.");
	    }
	}

	@Test(priority = 4)
	public void TC_MTR_04_VerifyReadingDateCalendar() throws Throwable {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Scroll sc = new Scroll();

	    // Scroll to the "Meter Readings" section
	    sc.ScrollUsingText(driver, "Meter Readings");

	    Dashboard db = new Dashboard(driver);
	    wait.until(ExpectedConditions.elementToBeClickable(db.getMeterScheduled()));

	    // Navigate to Scheduled Meter section
	    db.ClickOn_MeterScheduled();

	    Meter meter = new Meter(driver);
	    meter.CLickOn_SearchMeterNameBox("Claw");
	    meter.CLickOn_ClawMachineMeter();

	    // Expected date to verify
	    String expectedDate = "29 Oct, 2025";

	    // Wait for the element that has the expected date
	    WebElement readingDate = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//android.widget.TextView[@text='" + expectedDate + "']")));

	    // Assert the reading date is displayed
	    Assert.assertTrue(readingDate.isDisplayed(), "❌ Reading date not displayed or incorrect.");

	    System.out.println("✅ Reading date is correctly displayed as: " + expectedDate);
	}
	
	
	
	@Test(priority = 5)
	public void TC_MTR_05_DeleteLatestReadingTest()
	{
		//wait for the element
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				Scroll sc = new Scroll();
				
				// Scroll to the "Meter Readings" section
				sc.ScrollUsingText(driver, "Meter Readings");
				
			   		Dashboard db = new Dashboard(driver);
				wait.until(ExpectedConditions.elementToBeClickable(db.getMeterScheduled()));
				
				// Search and select the meter, then add the reading
				db.ClickOn_MeterScheduled();
				
				Meter meter = new Meter(driver);
				meter.CLickOn_SearchMeterNameBox("Claw");
				meter.CLickOn_ClawMachineMeter();

				meter.scrollToElement(driver);

			
				 // Step 5: Locate and click on the delete (cross) icon
			    try {
			        // Use the known (but fragile) XPath for now
			        By deleteIcon = By.xpath("//android.view.ViewGroup[9]//android.widget.ImageView");

			        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
			        deleteButton.click();
			        System.out.println("✅ Clicked on delete icon.");

			        // Step 6: Confirm deletion in popup
			        meter.CLickOn_YesButton_OnDeleteReadingPopup();
			        System.out.println("✅ Confirmed deletion of the reading.");

			    } catch (TimeoutException e) {
			        System.out.println("❌ Delete icon not found or not clickable.");
			        Assert.fail("Delete icon not found or not clickable.");
			    } catch (Exception e) {
			        System.out.println("❌ Unexpected error during deletion: " + e.getMessage());
			        Assert.fail("Unexpected exception during delete operation.");
			    }
				
	}		
	
}
