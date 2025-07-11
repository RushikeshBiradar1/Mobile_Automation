package Preventive_Maintenance;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import General_Utility.BaseClass;
import POM.Dashboard;
import POM.Maintenance;
import io.appium.java_client.MobileBy;

public class PMTest extends BaseClass {
	
	@Test
	public void Perform() throws Throwable
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
		            Thread.sleep(2000);  // Optional: Adjust sleep to give time for the action to be performed
		        } else {
		            System.out.println("Button not clickable for question " + i);
		            break;  // Exit the loop if the button is not clickable
		        }
		    } catch (Exception e) {
		        // If the element is not found or not visible, scroll to it
		        System.out.println("Scrolling to find question " + i);

		        // Ensure the scrollable is correctly set
		        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Yes\"))";
		        
		        try {
		            // Use the UiScrollable to scroll until the "Yes" button is visible
		            WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		            wait.until(ExpectedConditions.visibilityOf(targetElement));

		            // After scrolling, attempt to find the button again using XPath
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
