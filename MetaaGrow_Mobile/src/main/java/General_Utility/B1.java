package General_Utility;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import POM.Dashboard;
import POM.LoginPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class B1 {
	
	public static AndroidDriver driver;
	 private ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal();

	    // Set up driver for each thread
	    @BeforeClass
	    public void setUp() throws Throwable {
	    	 DesiredCapabilities capabilities = new DesiredCapabilities();
	         
	         capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        
	         capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android"); // Or use physical device name
	       
	         capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\SynccIT\\app-release.apk"); // Provide the path to your APK file
	         capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

	         // Set Appium server URL (make sure Appium server is running on this URL)
	            URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
	            
	            // Initialize AndroidDriver with the URL and Desired Capabilities
	             driver = new AndroidDriver(appiumServerUrl, capabilities);
	        driverThreadLocal.set(driver);
//	        login();
	    }

	    // Retrieve the driver in tests
	    public AppiumDriver getDriver() {
	        return driverThreadLocal.get();
	    }

	    // Clean up
	    @AfterClass
	    public void tearDown() {
//	        if (driverThreadLocal.get() != null) {
//	            driverThreadLocal.get().quit();
//	        }
	    	 driver.closeApp(); 
	    }
	    
//	     Automatically run login before each test case
	    @BeforeMethod
	    public void login() throws Throwable {
//	    	File_Utility file = new File_Utility();
	        try {
	        	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



	    		File_Utility flib=new File_Utility();

	    		String USERNAME = flib.getpropertykeyvalue("user");
	    		String PASSWORD = flib.getpropertykeyvalue("pass");
	    		String Firstpin = flib.getpropertykeyvalue("first");
	    		String SecondPin = flib.getpropertykeyvalue("second");
	    		String ThirdPin = flib.getpropertykeyvalue("third");
	    		String FourthPin = flib.getpropertykeyvalue("fourth");
//	    		WebDriver_Utility wb = new WebDriver_Utility();
//	    		wb.ImplicitlyWait(driver);
	    		LoginPage lp = new LoginPage(driver);
	    		lp.Login(driver, USERNAME, PASSWORD, Firstpin, SecondPin, ThirdPin, FourthPin);
	       

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Login failed");
	        }
	    }
	    
	    
	    @AfterMethod
	 // Method to navigate back until "Dashboard" is visible or perform necessary actions
	 public void navigateBackUntilDashboard(ITestResult result) throws Throwable {
	    	
	    	
	    	
	    	if(ITestResult.FAILURE==result.getStatus())
			{
				
				Listeners lt=new Listeners();
				lt.onTestFailure(driver, result.getName());
			}
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        int backPressCount = 0;
	        int maxBackPresses = 5; // Limit the number of back presses to avoid infinite loops

	        while (backPressCount < maxBackPresses) {
	            try {
	                // Try to find the element "Dashboard"
	                WebElement dashboardText = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\" Dashboard\"]")));
	                
	             // Try to find the element "Dashboard"
	                WebElement HumbergerIcon = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.View")));

	                // If element is found and is visible, proceed with logout actions
	                if (dashboardText.isDisplayed() || HumbergerIcon.isDisplayed()) {
	                    System.out.println("Either Dashboard or Hamburger Icon is visible. Proceeding to click Hamburger Icon...");


	                    // Perform the logout actions
	                    Dashboard db = new Dashboard(driver);
	                    wait.until(ExpectedConditions.elementToBeClickable(db.getHumburgerIcon()));
	                    db.ClickOn_HumburgerIcon();
	                    wait.until(ExpectedConditions.visibilityOf(db.getLogoutText()));
	                    db.ClickOn_LogoutText();
	                    wait.until(ExpectedConditions.elementToBeClickable(db.getYesButton_LogoutPopup()));
	                    db.ClickOn_YesButton_LogoutPopup();

//	                    driver.closeApp(); // Quit the app
		                break; // Exit the loop // This will stop further execution of this method and proceed to the next test
	                }
	            } catch (Exception e) {
	                // If Dashboard is not found, navigate back and increment backPressCount
	                driver.navigate().back();
	                backPressCount++;
	                System.out.println("Navigating back... Attempt " + backPressCount);

	                // Optional: Wait for a few seconds to let the UI settle after pressing back
	                try {
	                    Thread.sleep(2000); // Adjust sleep time as needed (ensure it's reasonable)
	                } catch (InterruptedException ie) {
	                    ie.printStackTrace();
	                }
	            }
	        }

	        // If max back presses reached and dashboard is still not found, fail the test
	        if (backPressCount == maxBackPresses) {
	            Assert.fail("Test failed: Dashboard was not found after pressing back " + maxBackPresses + " times.");
	        }
	    	
	    

	    	
	    }


}
