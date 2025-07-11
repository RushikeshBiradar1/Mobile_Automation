package Preventive_Maintenance;

import General_Utility.BaseClass;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


public class Test4 extends BaseClass {
	
	@Test
	 public void Perform() throws Throwable {
		  Dashboard db = new Dashboard(driver);
	        db.ClickOn_ScheduledPM();
	        Maintenance pm = new Maintenance(driver);
	        pm.ClickOn_FirstPMChecklist();

	        // Wait for the page to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        int currentIndex = 1; // Start with the first question

	        while (true) {
	            // Dynamically fetch the "Yes" button based on the current index
	            String yesButtonXpath = "(//android.widget.TextView[@text='Yes'])[" + currentIndex + "]";
	            List<WebElement> yesButtons = driver.findElements(By.xpath(yesButtonXpath));

	            if (yesButtons.isEmpty()) {
	                System.out.println("No more 'Yes' buttons to click.");
	                break;  // Exit loop if no more "Yes" buttons are found
	            }

	            WebElement elementText = yesButtons.get(0);

	            try {
	                // Wait for the "Yes" button to be clickable
	                wait.until(ExpectedConditions.elementToBeClickable(elementText));

	                // Check if the element is displayed and enabled
	                if (elementText.isDisplayed() && elementText.isEnabled()) {
	                    elementText.click();
	                    System.out.println("Answered 'Yes' for question " + currentIndex); // Log the click

	                    // After clicking, scroll to find the next "Yes" button
	                    System.out.println("Scrolling after 'Yes' button click...");

	                    // Scroll logic to simulate a swipe from bottom to top
	                    Dimension dimension = driver.manage().window().getSize();
	                    int startX = dimension.width / 2;
	                    int startY = (int) (dimension.height * 0.8); // Start near the bottom
	                    int endY = (int) (dimension.height * 0.6); // End near the top

	                    TouchAction action = new TouchAction(driver);
	                    action.press(PointOption.point(startX, startY))
	                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                        .moveTo(PointOption.point(startX, endY))
	                        .release()
	                        .perform();

	                    Thread.sleep(2000);  // Optional: Adjust sleep to give time for the action to be performed

	                    // Increment the index to click the next "Yes" button
	                    currentIndex++;
	                } else {
	                    System.out.println("Button not clickable for question " + currentIndex);
	                    break;  // Exit the loop if the button is not clickable
	                }
	            } catch (Exception e) {
	                System.out.println("Unable to find or click the 'Yes' button for question " + currentIndex);
	                break;  // Exit the loop if the button is still not found after scrolling
	            }
	        }

	        System.out.println("All 'Yes' buttons clicked.");

	        pm.ClickOn_Finish_MaintenanceButton();
	        Thread.sleep(5000); // Wait for finish action to complete
	}

    }


	


