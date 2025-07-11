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
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


	
	import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.TouchAction;
	import io.appium.java_client.touch.WaitOptions;
	import io.appium.java_client.touch.offset.PointOption;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Dimension;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	import java.time.Duration;
	import java.util.List;

	public class Test05 extends BaseClass {
	    
	    private AndroidDriver driver;

	    @Test
	    public void Perform1() throws Throwable {
	    	Dashboard db = new Dashboard(driver);
	        db.ClickOn_ScheduledPM();
	        Maintenance pm = new Maintenance(driver);
	        pm.ClickOn_FirstPMChecklist();
	        // Wait for the page to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        int questionIndex = 1; // Start with the first question
	        int questionsAnswered = 0;

	        while (questionsAnswered < 3) {
	            try {
	                // Locate the parent container for the checklist
	                WebElement parentElement = driver.findElement(By.xpath("//android.widget.ScrollView"));

	                // Iterate through the child elements to locate the specific question
	                List<WebElement> questionContainers = parentElement.findElements(By.xpath("//android.view.ViewGroup"));
	                boolean foundQuestion = false;

	                for (WebElement questionContainer : questionContainers) {
	                    try {
	                        // Locate the question based on the provided index
	                        WebElement question = questionContainer.findElement(By.xpath("(//android.view.ViewGroup)[" + questionIndex + "]"));

	                        // Locate the specific response button within the question container
	                        WebElement responseButton = questionContainer.findElement(By.xpath(".//android.widget.TextView[@text='Yes']"));

	                        // Click the response button
	                        responseButton.click();
	                        System.out.println("Answered 'Yes' for question " + questionIndex);

	                        foundQuestion = true;
	                        questionsAnswered++;
	                        questionIndex++;
	                        break;
	                    } catch (Exception e) {
	                        // Question not found, continue to next
	                    }
	                }

	                if (!foundQuestion) {
	                    System.out.println("No more questions found.");
	                    break; // Exit loop if no more questions are found
	                }

	                // Scroll logic to simulate a swipe from bottom to top
	                Dimension dimension = driver.manage().window().getSize();
	                int startX = dimension.width / 2;
	                int startY = (int) (dimension.height * 0.8); // Start near the bottom
	                int endY = (int) (dimension.height * 0.2); // End near the top

	                new TouchAction(driver)
	                        .press(PointOption.point(startX, startY))
	                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                        .moveTo(PointOption.point(startX, endY))
	                        .release()
	                        .perform();

	                Thread.sleep(2000);  // Optional: Adjust sleep to give time for the action to be performed

	            } catch (Exception e) {
	                System.out.println("Unable to find or click the 'Yes' button.");
	                break; // Exit the loop if the button is not found or clicked
	            }
	        }

	        System.out.println("All 'Yes' buttons clicked or checklist completed.");

	        pm.ClickOn_Finish_MaintenanceButton();
	        Thread.sleep(5000); // Wait for finish action to complete
	    }
	
	
}
