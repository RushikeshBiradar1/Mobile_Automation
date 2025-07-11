package Preventive_Maintenance;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import General_Utility.BaseClass;

import General_Utility.WebDriver_Utility;
import POM.Dashboard;
import POM.Maintenance;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class PM_ChecklistTest extends BaseClass{
	 AndroidDriver driver;
	@Test
	public void ResponseTest() throws Throwable
	{
		  Dashboard db = new Dashboard(driver);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Get the scheduled PM button and click on it
	        WebElement scheduled = db.getScheduledPM();
	        wait.until(ExpectedConditions.elementToBeClickable(scheduled));

	        // If the scheduled button is displayed, click it
	        if (scheduled.isDisplayed()) {
	            db.ClickOn_ScheduledPM();
	        } else {
	            // If not displayed, click again (you can modify this logic based on your needs)
	            db.ClickOn_ScheduledPM();
	        }

//	        for (int i = 1; a <a.; a++) {
//	        	 WebElement elementText = driver.findElement(By.xpath("(//android.widget.TextView[@text='Yes'])["+i+"]"));
//	 	        
//		
//	        
//	        // Wait for the Maintenance screen to appear
//	        Maintenance pm = new Maintenance(driver);
//	        pm.ClickOn_FirstPMChecklist();
//
//	        try {
//	            // Build the UiScrollable command for the targeted element
//	            String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true))"
//	                                + ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))";
//
//	            // Perform the scroll action
//	            driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
//
//	            System.out.println("Scrolled to the element with text: " + elementText);
//	        } catch (Exception e) {
//	            System.out.println("Error while scrolling to the element: " + e.getMessage());
//	        }
//	    }}
//	
	        
	        // Wait for the "Scheduled PM" button and click it
	        WebElement scheduled1 = db.getScheduledPM();
	        wait.until(ExpectedConditions.elementToBeClickable(scheduled1));
	        db.ClickOn_ScheduledPM();

	        // Navigate to the first PM checklist
	        Maintenance pm = new Maintenance(driver);
	        pm.ClickOn_FirstPMChecklist();

	        // Find all "Yes" buttons initially
	        int i = 1; // Start from the first "Yes" button
	        boolean allYesButtonsClicked = false;

	        while (!allYesButtonsClicked) {
	            // Attempt to find and click the "Yes" button
	            WebElement elementText = null;

	            try {
	                // Try to find the "Yes" button at the current position
	                elementText = driver.findElement(By.xpath("(//android.widget.TextView[@text='Yes'])[" + i + "]"));
	            } catch (Exception e) {
	                // If no element is found, it means the button is not visible in the current scroll area
	                // Now we scroll down
	                String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true))"
	                        + ".scrollIntoView(new UiSelector().text(\"Yes\"))";

	                // Perform the scroll action
	                driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

	                System.out.println("Scrolled down to find the 'Yes' button.");
	                continue; // Skip this iteration and go back to try finding the element again
	            }

	            // Now that the element is found, click it if visible and enabled
	            if (elementText.isDisplayed() && elementText.isEnabled()) {
	                elementText.click();
	                System.out.println("Clicked the 'Yes' button at position: " + i);
	                Thread.sleep(2000); // Optional wait to ensure interaction stability
	                i++; // Move to the next "Yes" button
	            } else {
	                // If the button is not displayed or enabled, move to the next button
	                i++;
	            }

	            // Check if there are still "Yes" buttons visible
	            int totalYesButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='Yes']")).size();
	            if (i > totalYesButtons) {
	                allYesButtonsClicked = true; // If all "Yes" buttons have been clicked, stop the loop
	                System.out.println("All 'Yes' buttons clicked.");
	            }
	        }
	}
}
