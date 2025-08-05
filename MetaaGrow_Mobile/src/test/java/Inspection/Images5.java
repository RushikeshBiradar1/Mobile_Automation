package Inspection;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import General_Utility.B2;

public class Images5  extends B2{
	
	@Test
	public void testcheck()
	{
//		WebDriver driver=new ChromeDriver();
		boolean isPermissionButtonClicked = false;
		boolean isMediaPopupClicked = false;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
System.out.println("brfore for loop");
		
	    for (int imgLoop = 1; imgLoop <= 2; imgLoop++) {
	        


      	 try {
      	        // Define both XPaths
      	        String actionButtonXPath1 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";

      	        String actionButtonXPath2 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView";
      	        
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
              By.xpath("//android.widget.ImageView[@content-desc=\"Shutter\"]")));
              Thread.sleep(1000);
              shutterButton.click();
              System.out.println("[" + imgLoop + "/6] Captured photo");

              // Done Button
              WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
              By.xpath("//android.widget.ImageButton[@content-desc=\"Done\"]")));
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
