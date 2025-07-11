package Inspection;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import General_Utility.B2;
import POM.Dashboard;
import POM.Inspection;
import io.appium.java_client.MobileBy;

public class TestIMG1 extends B2 {

    @Test
    public void Daily_Scoreboard_InspectionTest_TC_I04() throws Throwable {
        Dashboard db = new Dashboard(driver);
        Thread.sleep(3000); // Not recommended, consider using WebDriverWait
        db.ClickOn_InspectionScheduledTab();
Thread.sleep(2000);
        Inspection inspection = new Inspection(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Scroll to "Daily Scoreboard"
        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Food and Bev\"))";
        WebElement targetElement = wait.until(ExpectedConditions.presenceOfElementLocated(
            MobileBy.AndroidUIAutomator(uiScrollable)));
        wait.until(ExpectedConditions.visibilityOf(targetElement));
        targetElement.click();

        // Expand section
        inspection.ClickOn_SectionDropdowIco_OnChecklistDetails();

        
        boolean isPermissionButtonClicked = false;
        boolean isMediaPopupClicked = false;

       

                for (int imgLoop = 1; imgLoop <= 3; imgLoop++) {
    
//                    try {
//                        String actionButtonXPath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView"; // Replace with accurate locator
//
//                    	try {
//                    	    WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actionButtonXPath)));
//                    	    Thread.sleep(2000);
//                    	    actionButton.click();
//                    	} catch (StaleElementReferenceException e) {
//                    	    System.out.println("Stale element. Retrying...");
//                    	    WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actionButtonXPath)));
//                    	    actionButton.click();
//                    	}

                    	
                    	
                        // Click Action Button
//                        String actionButtonXPath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView"; // Replace with accurate locator
//                        WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actionButtonXPath)));
//                        actionButton.click();
//                        System.out.println("[" + imgLoop + "/6] Clicked action button for question " + (answeredQuestions + 1));

                	 try {
                	        // Define both XPaths
                	        String actionButtonXPath1 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";

                	        String actionButtonXPath2 = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView";
                	        
                	        WebElement actionButton = null;

                	        try {
                	            actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actionButtonXPath1)));
                	        } catch (Exception e1) {
                	            System.out.println("First XPath failed, trying second XPath...");
                	            actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actionButtonXPath2)));
                	        }

                	        Thread.sleep(2000);
                	        actionButton.click();
                	
                	
                	
                	
                	
                	
                	
                        // Attach Image
                        WebElement attachImage = wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//android.widget.TextView[@text=\"Attach Image(s)\"]")));
                        attachImage.click();
                        System.out.println("[" + imgLoop + "/6] Clicked Attach Image");

                        Thread.sleep(2000); // Simulate camera/gallery load

                        // Permission Pop-up (only once)
                        if (!isPermissionButtonClicked) {
                            try {
                                WebElement permissionButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                        By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")));
                                permissionButton.click();
                                isPermissionButtonClicked = true;
                                System.out.println("Permission pop-up clicked.");
                            } catch (Exception e) {
                                System.out.println("No permission pop-up.");
                            }
                        }

                        
                        // Take Photo
                        WebElement shutterButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("com.android.camera2:id/shutter_button")));
                        shutterButton.click();
                        System.out.println("[" + imgLoop + "/6] Captured photo");

                        // Done Button
                        WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.id("com.android.camera2:id/done_button")));
                        doneButton.click();
                        System.out.println("[" + imgLoop + "/6] Clicked Done");

                        // Media Popup (only once)
                        if (!isMediaPopupClicked) {
                            try {
                                WebElement mediaPopupButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                                        By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
                                mediaPopupButton.click();
                                isMediaPopupClicked = true;
                                System.out.println("Media permission pop-up clicked.");
                            } catch (Exception e) {
                                System.out.println("No media popup.");
                            }
                        }

                        // Save Image
                        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                                By.xpath("//android.widget.TextView[@text=\"Save\"]")));
                        saveButton.click();
                        System.out.println("[" + imgLoop + "/6] Clicked Save");

                        Thread.sleep(1000); // Optional delay between loops

                    } catch (Exception e) {
                        System.out.println("Error in image loop " + imgLoop + ": " + e.getMessage());
                    }
                }
                
                
                
                

        }

      
}
