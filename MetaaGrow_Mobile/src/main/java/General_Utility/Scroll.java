package General_Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.time.Duration;

public class Scroll {
	
	public void ScrollUsingText(WebDriver driver, String Enter_Text)
	{
		
		   // Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"" + Enter_Text + "\"))";

	    // Use MobileBy to find the element with androidUIAutomator
	    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

	    // Wait for the page to load
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // Optional: Wait for the element to be visible
	    wait.until(ExpectedConditions.visibilityOf(targetElement));

	    // Now you can interact with the element
//	    targetElement.click(); // For example, clicking the target element
	}
	
	

	public void selectResponse(AndroidDriver driver, String questionText, String responseText) {
	    // Locate the parent container for the checklist
	    WebElement parentElement = driver.findElement(By.xpath("//android.widget.ScrollView"));

	    // Iterate through the child elements to locate the specific question
	    for (WebElement questionContainer : parentElement.findElements(By.xpath("//android.view.ViewGroup"))) {
	        try {
	            // Locate the question based on the provided text
	            WebElement question = questionContainer.findElement(By.xpath(".//android.widget.TextView[@text='" + questionText + "']"));

	            // Locate the specific response button within the question container
	            WebElement responseButton = questionContainer.findElement(By.xpath(".//android.widget.TextView[@text='" + responseText + "']"));

	            // Click the response button
	            responseButton.click();
	            return;
	        } catch (Exception e) {
	            // Scroll down to find the next question
	            Dimension size = driver.manage().window().getSize();
	            int startY = (int) (size.height * 0.8);
	            int endY = (int) (size.height * 0.2);
	            int startX = size.width / 2;
	            new TouchAction(driver)
	                .press(PointOption.point(startX, startY))
	                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                .moveTo(PointOption.point(startX, endY))
	                .release()
	                .perform();
	        } finally {
			}
	    }

	    System.out.println("Question or response not found: " + questionText + " - " + responseText);
	}


}
