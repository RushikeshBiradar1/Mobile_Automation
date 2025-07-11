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

public class Test1 extends BaseClass{

	@Test
	public void CheckScroll()
	{
		  Dashboard db = new Dashboard(driver);
	        db.ClickOn_ScheduledPM();
	        Maintenance pm = new Maintenance(driver);
	        pm.ClickOn_FirstPMChecklist();

	        // Wait for the page to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        // Declare totalYesButtons and initialize with the number of available "Yes" buttons initially
	        List<WebElement> yesButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='Yes']"));
	        int totalYesButtons = yesButtons.size(); // Update this value

	        for (int i = 1; i <= totalYesButtons; i++) {
	            WebElement elementText = null;

	            // Dynamically create the XPath for the "Yes" button based on the current index
	            String yesButtonXpath = "(//android.widget.TextView[@text='Yes'])[" + i + "]";

	            try {
	                // Try to locate the "Yes" button using the generated XPath
	                elementText = driver.findElement(By.xpath(yesButtonXpath));

	                // Click on the "Yes" button if it is displayed and enabled
	                if (elementText.isDisplayed() && elementText.isEnabled()) {
	                    elementText.click();
	                    System.out.println("Answered 'Yes' for question " + i);
	                    // If the element is not found or not visible, scroll to it
		                System.out.println("Scrolling to find question " + i);

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
	                } else {
	                    System.out.println("Button not clickable for question " + i);
	                    break;  // Exit the loop if the button is not clickable
	                }
	            } catch (Exception e) {
	               

	                // After scrolling, attempt to find the button again using XPath
	                try {
	                    elementText = driver.findElement(By.xpath(yesButtonXpath));
	                    if (elementText.isDisplayed() && elementText.isEnabled()) {
	                        elementText.click();
	                        System.out.println("Scrolled down to find and answer question " + i);
	                        Thread.sleep(2000); // Optional: Adjust sleep to give time for the action to be performed
	                    }
	                } catch (Exception ex) {
	                    System.out.println("Unable to find or click the 'Yes' button even after scrolling.");
	                    break;  // Exit the loop if the button is still not found
	                }
	            }

	            // After clicking, re-fetch the list of "Yes" buttons to handle any new elements added after click
	            yesButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='Yes']"));
	            totalYesButtons = yesButtons.size();  // Update the total number of "Yes" buttons after the click
	        }

	        System.out.println("All 'Yes' buttons clicked.");
	    }
		
	
	}
