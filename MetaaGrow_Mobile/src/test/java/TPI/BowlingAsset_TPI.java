package TPI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import General_Utility.B1;
import General_Utility.B2;
import General_Utility.BaseClass;
import General_Utility.Scroll;
import POM.Dashboard;
import POM.PAT;
import POM.TPI;
import io.appium.java_client.MobileBy;

public class BowlingAsset_TPI extends B2{
	
	@Test(priority = 2)
	public void PerformTPI()
	{
		//wait for the element
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				Scroll sc = new Scroll();
				
				// Scroll to the "TPI" section
				sc.ScrollUsingText(driver, "TPI");
				
			   		Dashboard db = new Dashboard(driver);
				wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));
				
				// Search and select the TPI
				db.ClickOn_TPI();
				TPI tpi = new TPI(driver);
				
				 // Ensure there is a scrollable view
			    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Bowling La\"))";

			    // Wait for scroll to complete
			    wait.until(ExpectedConditions.presenceOfElementLocated(
			        MobileBy.AndroidUIAutomator(uiScrollable)));

			    // Find and click the element
			    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
			    wait.until(ExpectedConditions.visibilityOf(targetElement));
//			    targetElement.click();
			    tpi.ClickOn_FirstTPIOnTodays();
				
				tpi.ClickOn_ClickOnStartButton();
				tpi.CLickOn_YesButton_OnAreYouWantToStartTPI();
				tpi.ClickOn_OkButton_OnTPIStartedSuccessfullyPopup();
				tpi.Clickon_ClickOnFinishButton();
			    tpi.ClickOn_InspectorName("Rushikesh");
//			    tpi.ClickOn_RemarkOnTPIFinishPage("Bowling lane surface inspected and found to be in good condition, with no visible cracks or warping.");
			    tpi.ClickOn_SubmitButton();
			    tpi.ClickOn_YesButton_OnAreYouSureWanttoFinishTPI();
				Thread.holdsLock(6000);
				
				// Navigate to the Completed tab
				tpi.ClickOn_CompletedTab();
				// Wait for scroll to complete
				wait.until(ExpectedConditions.presenceOfElementLocated(
						MobileBy.AndroidUIAutomator(uiScrollable)));

				// Find the PM Checklist in Completed tab
				WebElement CompletedTPI = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
				wait.until(ExpectedConditions.visibilityOf(CompletedTPI));

				// Verify the inspection is displayed in the Completed tab
				Assert.assertTrue(CompletedTPI.isDisplayed(), "Completed TPI is not showing in the Finished tab!");

				System.out.println("Completed TPI successfully moved to the Finished tab.");
	}
	
	@Test(enabled = false)
	public void PerformTPIWithImage()
	{
		//wait for the element
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				Scroll sc = new Scroll();
				
				// Scroll to the "TPI" section
				sc.ScrollUsingText(driver, "TPI");
				
			   		Dashboard db = new Dashboard(driver);
				wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));
				
				// Search and select the TPI
				db.ClickOn_TPI();
				TPI tpi = new TPI(driver);
				
				 // Ensure there is a scrollable view
			    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Bowling La\"))";

			    // Wait for scroll to complete
			    wait.until(ExpectedConditions.presenceOfElementLocated(
			        MobileBy.AndroidUIAutomator(uiScrollable)));

			    // Find and click the element
			    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
			    wait.until(ExpectedConditions.visibilityOf(targetElement));
//			    targetElement.click();
			    tpi.ClickOn_FirstTPIOnTodays();
				
				tpi.ClickOn_ClickOnStartButton();
				tpi.CLickOn_YesButton_OnAreYouWantToStartTPI();
				tpi.ClickOn_OkButton_OnTPIStartedSuccessfullyPopup();
				tpi.Clickon_ClickOnFinishButton();
			    tpi.ClickOn_InspectorName("Rushikesh");
//			    tpi.ClickOn_RemarkOnTPIFinishPage("Bowling lane surface inspected and found to be in good condition, with no visible cracks or warping.");
			 
			    
				// Define the UI Automator scroll command to scroll to a specific element
				String AttachImages = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Attach Image\"))";

				// Use MobileBy to find the element with androidUIAutomator
				WebElement AttachImagesText = driver.findElement(MobileBy.androidUIAutomator(AttachImages)); 
				

				// Optional: Wait for the element to be visible
				wait.until(ExpectedConditions.visibilityOf(AttachImagesText));

				
				boolean isPermissionButtonClicked = false;
				boolean photosmediapopup= false;
				// Repeat this process 5 times
				for (int i = 0; i < 3; i++) {
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
				   

					
				    // Click on the shutter button to take a photo
				    WebElement shutterButton = driver.findElement(By.id("com.android.camera:id/shutter_button"));
				    shutterButton.click();

				    // Click the 'Done' button after the photo is taken
				    WebElement doneButton = driver.findElement(By.id("com.android.camera:id/done_button"));
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
			    
	
			    
			    tpi.ClickOn_SubmitButton();
			    tpi.ClickOn_YesButton_OnAreYouSureWanttoFinishTPI();
				Thread.holdsLock(6000);
				
				// Navigate to the Completed tab
				tpi.ClickOn_CompletedTab();
				// Wait for scroll to complete
				wait.until(ExpectedConditions.presenceOfElementLocated(
						MobileBy.AndroidUIAutomator(uiScrollable)));

				// Find the PM Checklist in Completed tab
				WebElement CompletedTPI = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
				wait.until(ExpectedConditions.visibilityOf(CompletedTPI));

				// Verify the inspection is displayed in the Completed tab
				Assert.assertTrue(CompletedTPI.isDisplayed(), "Completed TPI is not showing in the Finished tab!");

				System.out.println("Completed TPI successfully moved to the Finished tab.");
	}
	
	@Test(priority = 1)
	public void TodaysSearchByTPI()
	{
		//wait for the element
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				Scroll sc = new Scroll();
				
				// Scroll to the "TPI" section
				sc.ScrollUsingText(driver, "TPI");
				
			   		Dashboard db = new Dashboard(driver);
				wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));
				
				// Search and select the TPI
				db.ClickOn_TPI();
				TPI tpi = new TPI(driver);
				
				tpi.ClickOn_SearchBox_OnListingPage("Bowling");
				
				
				 // Ensure there is a scrollable view
			    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Bowling\"))";

			    // Wait for scroll to complete
			    wait.until(ExpectedConditions.presenceOfElementLocated(
			        MobileBy.AndroidUIAutomator(uiScrollable)));

			    // Find and click the element
			    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
			    wait.until(ExpectedConditions.visibilityOf(targetElement));
//			   
			    
			    
			 // Find the PM Checklist in Completed tab
				WebElement CompletedTPI = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
				wait.until(ExpectedConditions.visibilityOf(CompletedTPI));

				// Verify the inspection is displayed in the Completed tab
				Assert.assertTrue(CompletedTPI.isDisplayed(), "Bowling TPI is not showing in the Todays tab!");

				System.out.println("Bowling TPI is searched properly on todays tab.");
	}

}
