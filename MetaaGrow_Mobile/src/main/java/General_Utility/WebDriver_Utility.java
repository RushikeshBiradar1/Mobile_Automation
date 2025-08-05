package General_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class WebDriver_Utility {
	static WebDriver driver;
	
//	AndroidDriver sdriver;

//	public static String takeScreenshot(WebDriver sDriver, String tname) throws Throwable
//	{
//		 TakesScreenshot ts=(TakesScreenshot) driver;
//		  File src = ts.getScreenshotAs(OutputType.FILE);
//		  File dest=new File("./screenshot/"+tname+".png");
//		  Files.copy(src, dest);
//		  System.out.println("Screenshot Taken");
//		return tname; 
//	}
	
	
	
	  // Method to capture screenshots
    public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        // Get the current date and time to append to the screenshot name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String finalScreenshotName = screenshotName + "_" + timestamp + ".png";
        
        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        
        // Specify the destination for the screenshot
        String destination = ".\\Screenshots\\" + finalScreenshotName;
        File finalDestination = new File(destination);
        
        // Copy the screenshot to the destination
        FileUtils.copyFile(source, finalDestination);
        
        // Return the path of the saved screenshot
        return destination;
    	
//    	 if (driver == null) {
//    	        System.out.println("❌ Cannot take screenshot: WebDriver is null.");
//    	        return null;
//    	    }
//
//    	    // Get the current date and time to append to the screenshot name
//    	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//    	    String finalScreenshotName = screenshotName + "_" + timestamp + ".png";
//    	    
//    	    try {
//    	        TakesScreenshot ts = (TakesScreenshot) driver;
//    	        File source = ts.getScreenshotAs(OutputType.FILE);
//    	        
//    	        // Specify the destination for the screenshot
//    	        String destination = ".\\Screenshots\\" + finalScreenshotName;
//    	        File finalDestination = new File(destination);
//    	        
//    	        // Copy the screenshot to the destination
//    	        FileUtils.copyFile(source, finalDestination);
//    	        
//    	        System.out.println("✅ Screenshot saved at: " + destination);
//    	        return destination;
//    	    } catch (Exception e) {
//    	        System.out.println("❌ Screenshot failed: " + e.getMessage());
//    	        return null;
//    	    }
    }

	
	
	
	
	
	public void ImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	
	public void ExplicitlyWait(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void verifyPageTitle(String expectedTitle, String PageName)
	{
		String ActualTitle = driver.getTitle();
		if(ActualTitle.equals(expectedTitle))
		{
			System.out.println("Title is matched for "+PageName);
		}
		else
		{
			System.out.println("Title is not matched for"+ PageName);
		}
		
	}
	
	
	/**
	 * to switch the frame by using index(Method Overloading) 
	 */
	
	public void SwitchToFrame(int Index)
	{
		driver.switchTo().frame(Index);
	}
	
	public void SwitchToFrame(String NameOrId)
	{
		driver.switchTo().frame(NameOrId);
	}
	public void SwitchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	/**
	 * To maximize the browser
	 * 
	 * */
	
	public void maximizeTheBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * for selecting dropdown option(Method Overloading)
	 * @param element 
	 * @param index 
	 * @throws Throwable 
	 */
	
	public void selectByIndex(WebElement element, int index) throws Throwable
	{
		Select sel=new Select(element);
		Thread.sleep(2000);
		sel.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element, String value) throws Throwable
	{
		Select sel=new Select(element);
		Thread.sleep(2000);
		sel.selectByValue(value);
	}
	
	public void selectbyvisibleText(WebElement element, String text) throws Throwable
	{
		Select sel=new Select(element);
		Thread.sleep(2000);
		sel.selectByVisibleText(text);
	}
	
	/**
	 *To handle alert popup 
	 */

	public void AcceptConfirmationPopUp(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	public void DismissConfirmationPopUp(WebDriver driver)
	{
		Alert al = driver.switchTo().alert();
		String alertText = al.getText();
		System.out.println(alertText);
		al.dismiss();
	}
	public void NotificationPopup()
	{
		  ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	}
	
	/**
	 * To perform mouse action
	 * @param target 
	 * 
	 * */
	
	public void RightClick(WebElement target)
	{
		Actions act=new Actions(driver);
		act.contextClick(target).perform();
	}
	
	public void DoubleClick(WebElement target)
	{
		Actions act=new Actions(driver);
		act.doubleClick(target).perform();
	}

	public void MoveToElement(WebElement target)
	{
		Actions act=new Actions(driver);
		act.moveToElement(target).perform();
	}
	
	public void DragAndDrop(WebElement src, WebElement dest)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(src, dest).perform();
	}
   
	/**
	 * To perform the scrolling action
	 */
	public void scrollup(WebDriver driver,int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+pixelCount+")");
	}

	public void scrolldown(WebDriver driver,int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,"+(-pixelCount)+")");
	}

	public void scrollLeft(WebDriver driver,int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+(-pixelCount)+",0)");
	}

	public void scrollRight(WebDriver driver,int pixelCount)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+pixelCount+",0)");
	}
	  public static void scrollTillAParticularWebElement(WebDriver driver, WebElement target) {
	        Actions actions = new Actions(driver);
	        actions.moveToElement(target);
	        actions.perform();
	    }
	
	public void getAllOptionsOfDropDown(WebElement element)
	{
		Select sel = new Select(element);
		List<WebElement> allops = sel.getAllSelectedOptions();

		for(WebElement op:allops)
		{
			String text = op.getText();
			System.out.println(text);
		}
	}
	
	public void JumpToPage_DropDown(WebDriver driver, String Enter_No)
	{
		WebElement dp = driver.findElement(By.xpath("//ul[@class='jump-to']//select[@id='RowPerPage']"));
		Select sel=new Select(dp);
		sel.selectByVisibleText(Enter_No);
	}
	public void ShowRows_Dropdown(WebDriver driver,String Enter_No)
	{
		WebElement sd = driver.findElement(By.xpath("(//select[@id='RowPerPage'])[1]"));
		Select sel=new Select(sd);
		sel.selectByVisibleText(Enter_No);
	}
	public void doubleClick_On_Element(WebElement Element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(Element).perform();
		
	}
	
	public void ClickOn_RightSlide_Arrow(WebDriver driver)
	{
         driver.findElement(By.xpath("//section[@class='pagination']//li[6]//a[1]")).click();
	}
	public void ClickOn_LeftSlide_Arrow(WebDriver driver)
	{
		driver.findElement(By.xpath("//section[@class='pagination']//li[1]//a[1]")).click();
	}
	
	public void WebDriverWait_Method(String Enter_Xpath_Of_Webelement)
	{
		 WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wb.until(ExpectedConditions.elementToBeClickable(By.xpath(Enter_Xpath_Of_Webelement)));
	}
	public void WebDriverWait_ElementToBeVisibleMethod(String Enter_Xpath_Of_Webelement)
	{
		 WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(30));
		 wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Enter_Xpath_Of_Webelement)));
	}

	public void DoubleClickAction(WebElement target)
	{
		Actions act = new Actions(driver);
		act.doubleClick(target).perform();
	}
	public void GetTitle()
	{
		driver.getTitle();
	}
	
	public void BackSpaceMethod(String xpath, WebDriver driver) throws Throwable
	{
		Thread.sleep(2000);
		WebElement TextFieldField = driver.findElement(By.xpath(xpath));
		String existingText = TextFieldField.getAttribute("value");
		System.out.println(existingText);
		int length = existingText.length();
		for (int i = 0; i < length; i++) {
		TextFieldField.sendKeys(Keys.BACK_SPACE);
		}
	}
	
	public void SCrollDownMethod() throws Throwable
	{
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//div[@class='scroll-box']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
		wait.until(ExpectedConditions.visibilityOf(element));
		// Get the JavascriptExecutor instance
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Get the height of the scrollable element
		int height = element.getSize().getHeight();
		System.out.println(height);
		// Calculate the amount of pixels to scroll by for each item
		int pixels = height / 10;
		System.out.println(pixels);
		// Scroll down for 10 list items
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(element));
		for (int i = 0; i < 10; i++) {
			// Scroll by the calculated pixels
			js.executeScript("arguments[0].scrollDown += arguments[1];", element, pixels);
			// Wait for the element to load content
			wait.until(ExpectedConditions.visibilityOf(element));
		}
//		Thread.sleep(2000);
//		// Scroll up for 10 list items
//		for (int i = 0; i < 10; i++) {
//			// Scroll by the negative calculated pixels
//			js.executeScript("arguments[0].scrollTop -= arguments[1];", element, pixels);
//			// Wait for the element to load content
//			wait.until(ExpectedConditions.visibilityOf(element));
//		}
	}
	
	public void windowSwitching(WebDriver driver) throws InterruptedException
	{
		// Wait for the new window to appear
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Adjust the expected window count if necessary

				// Get all window handles
				String parentWindowHandle = driver.getWindowHandle();
				Set<String> allWindowHandles = driver.getWindowHandles();

				// Switch to the new window
				for (String windowHandle : allWindowHandles) {
					if (!windowHandle.equals(parentWindowHandle)) {
						driver.switchTo().window(windowHandle);
						break;
					}
				}
			
				// Verify if the window switch was successful
				if (!driver.getWindowHandle().equals(parentWindowHandle)) {
					System.out.println("Window switched successfully.");
				} else {
					System.out.println("Window switch failed.");
				}
			
				driver.switchTo().window(parentWindowHandle);
	}
	
	  public void performActionIfClickable(WebDriver driver, String Enter_PathOf_Element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds

	        // Define the locator for the button
	        By buttonLocator = By.xpath(Enter_PathOf_Element);

	        try {
	            // Wait for the element to be clickable
	            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(buttonLocator));

	            // Perform the action (click) if the element is clickable
	            clickableElement.click();

	            // Continue with the next actions
	        } catch (Exception e) {
	            // Handle the case where the element is not clickable or an exception occurs
	            System.out.println("The element is not clickable or an error occurred: " + e.getMessage());
	        }
	    }
	public void SelectMultiUserCheckBox(WebDriver driver, String Enter_UserName)
	{
		driver.findElement(By.xpath("//li[span[normalize-space()='"+Enter_UserName+"']]/preceding-sibling::li//input[@type='checkbox']")).click();
	}
	
	public void EscapeMethod(WebDriver driver)
	{
		Actions actions = new Actions(driver);
	    actions.sendKeys(Keys.ESCAPE).perform();
	}

    public void SelectChecklistDueTime(WebDriver driver) {
        try {
          
            // Define the target time (18:00)
            LocalTime targetTime = LocalTime.of(18, 0);
            System.out.println(targetTime);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Find the hour and minute display elements
            WebElement hourDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hour-display")));
            WebElement minuteDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minute-display")));

            // Find the forward and backward icons for hours
            WebElement hourForwardIcon = driver.findElement(By.xpath("//button[@aria-label='Minus a hour']"));
            WebElement hourBackwardIcon = driver.findElement(By.xpath("//button[@aria-label='Minus a hour']"));

            // Find the forward and backward icons for minutes
            WebElement minuteForwardIcon = driver.findElement(By.xpath("//button[@aria-label='Add a minute']"));
            WebElement minuteBackwardIcon = driver.findElement(By.xpath("//button[@aria-label='Minus a minute']"));

            // Convert the current time text to LocalTime
            LocalTime currentTime = LocalTime.parse(hourDisplay.getText() + ":" + minuteDisplay.getText(), formatter);

            // Calculate the number of clicks required
            while (!currentTime.equals(targetTime)) {
                // Update the current time display elements
                hourDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Hour']")));
                minuteDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Minute']")));

                // Get the updated current time
                currentTime = LocalTime.parse(hourDisplay.getText() + ":" + minuteDisplay.getText(), formatter);

                // Adjust hour if needed
                while (currentTime.getHour() != targetTime.getHour()) {
                    if (currentTime.getHour() < targetTime.getHour()) {
                        hourForwardIcon.click();
                    } else {
                        hourBackwardIcon.click();
                    }
                    Thread.sleep(500); // Wait for UI update
                    hourDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hour-display")));
                    currentTime = LocalTime.parse(hourDisplay.getText() + ":" + minuteDisplay.getText(), formatter);
                }

                // Adjust minute if needed
                while (currentTime.getMinute() != targetTime.getMinute()) {
                    if (currentTime.getMinute() < targetTime.getMinute()) {
                        minuteForwardIcon.click();
                    } else {
                        minuteBackwardIcon.click();
                    }
                    Thread.sleep(500); // Wait for UI update
                    minuteDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("minute-display")));
                    currentTime = LocalTime.parse(hourDisplay.getText() + ":" + minuteDisplay.getText(), formatter);
                }
            }

            System.out.println("Time set to: " + targetTime.format(formatter));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
