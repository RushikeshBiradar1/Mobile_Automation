package General_Utility;


	import java.net.URL;
	import java.time.Duration;
import java.util.List;

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
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.AfterTest;

	import POM.Dashboard;
	import POM.LoginPage;
	import io.appium.java_client.AppiumDriver;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.remote.MobileCapabilityType;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class BASETEST {

	    public static AndroidDriver driver;
	    private ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal();

	    private ExtentReports extentReports;
	    private ExtentTest extentTest;

	    // Initialize Extent Reports before any test
	    @BeforeTest
	    public void beforeTest() {
	        try {
	            // Add debug statements to confirm initialization
	            System.out.println("Initializing Extent Report...");

	            // Set up the Extent Report configuration
	            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(".\\ExtentReport\\report.html");
	            sparkReporter.config().setDocumentTitle("Mobile Automation Test Report");
	            sparkReporter.config().setReportName("Rushikesh");

	            // Initialize the ExtentReports object and attach the reporter
	            extentReports = new ExtentReports();
	            extentReports.attachReporter(sparkReporter);

	            // Confirm that the Extent Report has been initialized
	            System.out.println("Extent Report Initialized.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error initializing Extent Report: " + e.getMessage());
	        }
	    }

	    // Set up driver for each thread and initialize Appium
	    @BeforeClass
	    public void setUp() throws Throwable {
	        // Set up Appium capabilities
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
	        capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\SynccIT\\app-release.apk");
	        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

	        // Initialize AndroidDriver with the URL and Desired Capabilities
	        URL appiumServerUrl = new URL("http://127.0.0.1:4723/wd/hub");
	        driver = new AndroidDriver(appiumServerUrl, capabilities);
	        driverThreadLocal.set(driver);
	    }

	    // Retrieve the driver in tests
	    public AppiumDriver getDriver() {
	        return driverThreadLocal.get();
	    }

	    // Automatically run login before each test case
	    @BeforeMethod
	    public void beforeMethod(ITestResult result) throws Throwable {
	        // Create a new test instance for the report
	        createTest(result.getMethod().getMethodName());
	        try {
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	            File_Utility flib = new File_Utility();

	            String USERNAME = flib.getpropertykeyvalue("user");
	            String PASSWORD = flib.getpropertykeyvalue("pass");
	            String Firstpin = flib.getpropertykeyvalue("first");
	            String SecondPin = flib.getpropertykeyvalue("second");
	            String ThirdPin = flib.getpropertykeyvalue("third");
	            String FourthPin = flib.getpropertykeyvalue("fourth");

	            LoginPage lp = new LoginPage(driver);
	            lp.Login(driver, USERNAME, PASSWORD, Firstpin, SecondPin, ThirdPin, FourthPin);
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Login failed");
	        }
	    }

	    // Logging based on the test result (PASS/FAIL)
	    @AfterMethod
	    public void logTestResult(ITestResult result) throws Throwable {
	        try {

	        	
	        	
	        	  // Log result based on test status (PASS/FAIL)
	            if (ITestResult.FAILURE == result.getStatus()) {
	                extentTest.log(Status.FAIL, result.getMethod().getMethodName() + " failed");
	                extentTest.log(Status.FAIL, result.getThrowable());
	                
	                // Take screenshot if failure
	                String path = WebDriver_Utility.takeScreenshot(BASETEST.driver, result.getTestClass().getName() + "." + result.getMethod().getMethodName());
	                extentTest.addScreenCaptureFromPath(path);  // Add the screenshot to the Extent Report
	            } else if (ITestResult.SUCCESS == result.getStatus()) {
	                extentTest.log(Status.PASS, result.getName() + " passed");
	            } else if (ITestResult.SKIP == result.getStatus()) {
	                extentTest.log(Status.SKIP, result.getName() + " skipped");
	            }
	        	
	        	
	        	
//	            
//	         // Check if Dashboard or Hamburger Icon is visible and perform logout
//	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	            int maxBackTaps = 5; // Prevent infinite loops
//	            int backTapCount = 0;
//
//	            while (backTapCount < maxBackTaps) {
//	                try {
//	                    // Check if Dashboard is visible
//	                    WebElement dashboardText = wait.until(
//	                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\" Dashboard\"]")));
//
//	                    WebElement hamburgerIcon = wait.until(
//	                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.View")));
//
//	                    if (dashboardText.isDisplayed() || hamburgerIcon.isDisplayed()) {
//	                        System.out.println("Dashboard or Hamburger Icon is visible. Proceeding with logout...");
//
//	                        Dashboard db = new Dashboard(driver);
//	                        wait.until(ExpectedConditions.elementToBeClickable(db.getHumburgerIcon()));
//	                        db.ClickOn_HumburgerIcon();
//	                        wait.until(ExpectedConditions.visibilityOf(db.getLogoutText()));
//	                        db.ClickOn_LogoutText();
//	                        wait.until(ExpectedConditions.elementToBeClickable(db.getYesButton_LogoutPopup()));
//	                        db.ClickOn_YesButton_LogoutPopup();
//	                        break;
//	                    }
//	                } catch (Exception e) {
//	                    System.out.println("Dashboard not found yet. Attempting back...");
//
//	                    try {
//	                    	List<WebElement> backButtons = driver.findElements(By.xpath(".//android.widget.ImageView"));
//
//
//	                        boolean clicked = false;
//	                        for ( WebElement btn : backButtons) {
//	                            if (btn.isDisplayed() && btn.isEnabled()) {
//	                                btn.click();
//	                                clicked = true;
//	                                System.out.println("Clicked on back ImageView. Attempt " + (backTapCount + 1));
//	                                break;
//	                            }
//	                        }
//
//	                        if (!clicked) {
//	                            driver.navigate().back();
//	                            System.out.println("No visible ImageView back button. Used driver.navigate().back(). Attempt " + (backTapCount + 1));
//	                        }
//	                    } catch (Exception fallbackEx) {
//	                        // If any exception occurs while clicking, fallback to native back
//	                        driver.navigate().back();
//	                        System.out.println("Exception in ImageView click. Fallback to driver.navigate().back(). Attempt " + (backTapCount + 1));
//	                    }
//
//	                    backTapCount++;
//
//	                    try {
//	                        Thread.sleep(2000); // Allow UI to update
//	                    } catch (InterruptedException ie) {
//	                        ie.printStackTrace();
//	                    }
//	                }
//	            }
//
//	            if (backTapCount == maxBackTaps) {
//	                Assert.fail("Test failed: Dashboard was not found after " + maxBackTaps + " back attempts.");
//	            }
//	            
//	            
//	            
//	        } catch (Exception e) {
//	            e.printStackTrace();
////	         // Log the error in ExtentReports as 'FAIL'
////	            extentTest.log(Status.FAIL, "Error logging result: " + e.getMessage());
//	            // Log the error in ExtentReports, but do not mark the test as failed
//	            extentTest.log(Status.WARNING, "Error during logout process: " + e.getMessage());
//	        } finally {
//	            // Flush the report after each test
//	            extentReports.flush();
//	        }
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            int maxBackTaps = 5;
	            int backTapCount = 0;

	            while (backTapCount < maxBackTaps) {
	                boolean isDashboardVisible = false;
	                boolean isHamburgerVisible = false;

	                try {
	                    WebElement dashboardText = driver.findElement(By.xpath("//android.widget.TextView[@text=' Dashboard']"));
	                    isDashboardVisible = dashboardText.isDisplayed();
	                } catch (Exception e) {
	                    isDashboardVisible = false;
	                }

	                try {
	                    WebElement hamburgerIcon = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\\\"android:id/content\\\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.View"));
	                    isHamburgerVisible = hamburgerIcon.isDisplayed();
	                } catch (Exception e) {
	                    isHamburgerVisible = false;
	                }

	                if (isDashboardVisible || isHamburgerVisible) {
	                    System.out.println("Dashboard or Hamburger Icon is visible. Proceeding with logout...");

	                    Dashboard db = new Dashboard(driver);

	                    try {
	                        wait.until(ExpectedConditions.elementToBeClickable(db.getHumburgerIcon())).click();
	                        wait.until(ExpectedConditions.visibilityOf(db.getLogoutText())).click();
	                        wait.until(ExpectedConditions.elementToBeClickable(db.getYesButton_LogoutPopup())).click();
	                    } catch (Exception clickException) {
	                        System.out.println("Error during logout click: " + clickException.getMessage());
	                    }
	                    break;
	                } else {
	                    System.out.println("Dashboard not found yet. Attempting back...");
	                    try {
	                        List<WebElement> backButtons = driver.findElements(By.xpath(".//android.widget.ImageView"));
	                        boolean clicked = false;
	                        for (WebElement btn : backButtons) {
	                            if (btn.isDisplayed() && btn.isEnabled()) {
	                                btn.click();
	                                clicked = true;
	                                System.out.println("Clicked on back ImageView. Attempt " + (backTapCount + 1));
	                                break;
	                            }
	                        }
	                        if (!clicked) {
	                            driver.navigate().back();
	                            System.out.println("No visible back button. Used navigate().back(). Attempt " + (backTapCount + 1));
	                        }
	                    } catch (Exception fallbackEx) {
	                        driver.navigate().back();
	                        System.out.println("Fallback to driver.navigate().back(). Attempt " + (backTapCount + 1));
	                    }

	                    backTapCount++;
	                    Thread.sleep(2000);
	                }
	            }

	            if (backTapCount == maxBackTaps) {
	                Assert.fail("Test failed: Dashboard was not found after " + maxBackTaps + " back attempts.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            extentTest.log(Status.WARNING, "Error during logout process: " + e.getMessage());
	        } finally {
	            extentReports.flush();
	        }
	    
	      
	            
	            
	            
	    }

	    // Clean up after all tests
	    @AfterClass
	    public void tearDown() {
	        try {
	            extentReports.flush();  // Flush the report after test execution
	            driver.closeApp();  // Close the app
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error during cleanup: " + e.getMessage());
	        }
	    }

	    // Method to create a new test in the Extent Report
	    protected void createTest(String testName) {
	        extentTest = extentReports.createTest(testName);
	    }

	    // After all tests in the suite
	    @AfterTest
	    public void afterTest() {
	        try {
	            // Optionally, finalize or clean-up Extent Reports here if necessary
	            System.out.println("AfterTest method executed");

	            // Flush any remaining reports or data here if needed
	            extentReports.flush(); // Ensures all results are written to the report file
	            System.out.println("Test report has been flushed successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("Error in AfterTest cleanup: " + e.getMessage());
	        }
	    }
	

}
