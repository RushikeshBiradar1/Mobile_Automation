package PAT;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import General_Utility.B2;
import General_Utility.BASETEST;
import General_Utility.BaseClass;
import General_Utility.Scroll;
import POM.Dashboard;
import POM.PAT;
import POM.TPI;
import POM.Tickets;
import io.appium.java_client.MobileBy;

public class AddReading extends BASETEST{



	@Test(priority = 1)
	public void TC_PAT_01_SearchPAT_OnTodaysListing() throws Throwable
	{
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();

		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "PAT");

		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));

		// Search and select the meter, then add the reading
		db.ClickOn_PAT();

		PAT pat = new PAT(driver);
		//		pat.CLickOn_SearchBoX_PATListing("Bowling Lane");

		Thread.sleep(1000);

		// Wait for search box visible
		wait.until(ExpectedConditions.visibilityOf(pat.getSearchBoX_PATListing()));

		// Click to focus the search box before sending text
		WebElement searchBox = (pat.getSearchBoX_PATListing());
		searchBox.click();
		searchBox.clear();
		searchBox.sendKeys("Bowling Lane");

		// Optionally hide keyboard (sometimes helps)
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			// Keyboard might already be hidden, ignore
		}

		// Now wait for the search result
		By resultLocator = By.xpath("//android.widget.TextView[contains(@text, 'Bowling Lane')]");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
			System.out.println("✅ 'Bowling Lane' is displayed in search results.");
		} catch (TimeoutException e) {
			Assert.fail("❌ 'Bowling Lane' not found in search results.");
		}
		driver.findElement(By.xpath(".//android.widget.ImageView")).click();


	}

	@Test(priority = 2)
	public void TC_PAT_02_SearchPAT_OnUpcomingListing() throws Throwable
	{
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();

		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "PAT");

		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));

		// Search and select the meter, then add the reading
		db.ClickOn_PAT();


		PAT pat = new PAT(driver);
		//		pat.CLickOn_SearchBoX_PATListing("Bowling Lane");

		wait.until(ExpectedConditions.elementToBeClickable(pat.getUpcomingYab())).click();

		Thread.sleep(1000);

		// Wait for search box visible
		wait.until(ExpectedConditions.visibilityOf(pat.getSearchBoX_PATListing()));

		// Click to focus the search box before sending text
		WebElement searchBox = (pat.getSearchBoX_PATListing());
		searchBox.click();
		searchBox.clear();
		searchBox.sendKeys("Bowling Lane");

		// Optionally hide keyboard (sometimes helps)
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			// Keyboard might already be hidden, ignore
		}

		// Now wait for the search result
		By resultLocator = By.xpath("//android.widget.TextView[contains(@text, 'Bowling Lane')]");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
			System.out.println("✅ 'Bowling Lane' is displayed in search results.");
		} catch (TimeoutException e) {
			Assert.fail("❌ 'Bowling Lane' not found in search results.");
		}
		driver.findElement(By.xpath(".//android.widget.ImageView")).click();


	}


	@Test(priority = 3)
	public void TC_PAT_03_VerifyUpcomingPATDetails() throws Throwable
	{
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();

		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "PAT");

		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));

		// Search and select the meter, then add the reading
		db.ClickOn_PAT();

		PAT pat = new PAT(driver);

		// Tap on the Upcoming tab
		wait.until(ExpectedConditions.elementToBeClickable(pat.getUpcomingYab())).click();
		Thread.sleep(1000);  // Consider replacing this with a dynamic wait if needed

		// Define the locator for "Bowling Lane"
		By resultLocator = By.xpath("//android.widget.TextView[contains(@text, 'Bowling Lane')]");

		try {
			// Wait for it to become visible
			WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));

			// Optional: Click on it
			result.click();

			// Verify it's displayed
			Assert.assertTrue(result.isDisplayed(), "✅ 'Bowling Lane' is displayed with details.");
			System.out.println("✅ 'Bowling Lane' is displayed with details.");

		} catch (TimeoutException e) {
			// Fail the test if not found
			Assert.fail("❌ 'Bowling Lane' not found on Upcoming Listing results.");
		}
		driver.findElement(By.xpath(".//android.widget.ImageView")).click();
	}






	@Test(priority = 4)
	public void TC_PAT_04_PerformPATWithPassResult() throws Throwable
	{
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();

		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "PAT");

		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));

		// Search and select the meter, then add the reading
		db.ClickOn_PAT();

		PAT pat = new PAT(driver);
		//		pat.ClickOn_FirstPAT_OnTodaysPage();

		// Perform PAT test process
		pat.ClickON_PendingPAT_OnTodaysPage();
		pat.ClickOn_AddReading_Button();
		pat.CLickOn_Earth_Continuity_Field("100");
		pat.CLickOn_L_N_Voltage_Field("2000");
		pat.CLickOn_L_E_Voltage_Field("3500");
		pat.CLickOn_N_E_Voltage_Field("2780");
		pat.CLickOn_Load_Current_Field("6500");
		pat.CLickOn_PE_Conductor_Current_Field("3720");
		pat.CLickOn_Pass_Fail_Toggled();
		pat.CLickOn_SubmitButton_OnPATReadingButton();
		pat.CLickOn_YesButton_OnSaveThisReadingPopup();
		

	}

	@Test(priority = 5)
	public void TC_PAT_05_PerformPATWithFailResult() throws Throwable
	{
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();

		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "PAT");

		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));

		// Search and select the PAT, then add the reading
		db.ClickOn_PAT();

		PAT pat = new PAT(driver);
		//		pat.ClickOn_FirstPAT_OnTodaysPage();

		// Perform PAT test process
		pat.ClickON_PendingPAT_OnTodaysPage();
		pat.ClickOn_AddReading_Button();
		pat.CLickOn_Earth_Continuity_Field("4000");
		pat.CLickOn_L_N_Voltage_Field("6500");
		pat.CLickOn_L_E_Voltage_Field("4200");
		pat.CLickOn_N_E_Voltage_Field("6480");
		pat.CLickOn_Load_Current_Field("7500");
		pat.CLickOn_PE_Conductor_Current_Field("3520");
		//		pat.CLickOn_Pass_Fail_Toggled();
		pat.CLickOn_SubmitButton_OnPATReadingButton();
		pat.CLickOn_YesButton_OnSaveThisReadingPopup();
		

	}

	@Test(priority = 6)
	public void TC_PAT_06_PerformPATWith_AttachImage_PassStatus() throws Throwable
	{
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();

		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "PAT");

		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));

		// Search and select the meter, then add the reading
		db.ClickOn_PAT();

		PAT pat = new PAT(driver);
		//		pat.ClickOn_FirstPAT_OnTodaysPage();

		// Perform PAT test process
		pat.ClickON_PendingPAT_OnTodaysPage();
		pat.ClickOn_AddReading_Button();
		pat.CLickOn_Earth_Continuity_Field("100");
		pat.CLickOn_L_N_Voltage_Field("2000");
		pat.CLickOn_L_E_Voltage_Field("3500");
		pat.CLickOn_N_E_Voltage_Field("2780");
		pat.CLickOn_Load_Current_Field("6500");
		pat.CLickOn_PE_Conductor_Current_Field("3720");

		pat.CLickOn_PE_ConductorCurrent_AttachImagesIcon();

		Tickets tkt = new Tickets(driver);

		// Handle permission pop-up if it appears
		try {
			WebDriverWait waitPermission = new WebDriverWait(driver, Duration.ofSeconds(7));
			WebElement permissionButton = waitPermission.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")));
			permissionButton.click(); // Click the permission button
		} catch (Exception e) {
			// If the permission button is not present, no action is needed for this iteration.
			System.out.println("No permission pop-up for this iteration.");
		}

		// Click on the shutter button to take a photo

		WebElement shutterButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//android.widget.ImageView[@content-desc=\"Shutter\"]")));
		Thread.sleep(1000);
		shutterButton.click();

		// Click the 'Done' button after the photo is taken

		WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//android.widget.ImageButton[@content-desc=\"Done\"]")));
		doneButton.click();

		try {
			// Handle "Allow Photo and Media" pop-up if it appears
			WebElement allowPhotoAndMediaButton = driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]"));
			if (allowPhotoAndMediaButton.isDisplayed()) {
				tkt.ClickOn_AllowPhotoAndMediaButton();
			}
		} catch (NoSuchElementException e) {
			System.out.println("No 'Allow Photo and Media' pop-up found.");
		}

		// Click 'Save' to save the photo
		WebElement saveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Save']"));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();


		pat.CLickOn_Pass_Fail_Toggled();
		pat.CLickOn_SubmitButton_OnPATReadingButton();
		pat.CLickOn_YesButton_OnSaveThisReadingPopup();

	}
	@Test(priority = 7)
	public void TC_PAT_07_PerformPATWith_AttachImage_FailStatus() throws Throwable
	{
		//wait for the element
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Scroll sc = new Scroll();

		// Scroll to the "Meter Readings" section
		sc.ScrollUsingText(driver, "PAT");

		Dashboard db = new Dashboard(driver);
		wait.until(ExpectedConditions.elementToBeClickable(db.getPAT()));

		// Search and select the meter, then add the reading
		db.ClickOn_PAT();

		PAT pat = new PAT(driver);
		//		pat.ClickOn_FirstPAT_OnTodaysPage();

		// Perform PAT test process
		pat.ClickON_PendingPAT_OnTodaysPage();
		pat.ClickOn_AddReading_Button();
		pat.CLickOn_Earth_Continuity_Field("100");
		pat.CLickOn_L_N_Voltage_Field("2000");
		pat.CLickOn_L_E_Voltage_Field("3500");
		pat.CLickOn_N_E_Voltage_Field("2780");
		pat.CLickOn_Load_Current_Field("6500");
		pat.CLickOn_PE_Conductor_Current_Field("3720");

		pat.CLickOn_PE_ConductorCurrent_AttachImagesIcon();

		Tickets tkt = new Tickets(driver);

		// Handle permission pop-up if it appears
		try {
			WebDriverWait waitPermission = new WebDriverWait(driver, Duration.ofSeconds(7));
			WebElement permissionButton = waitPermission.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")));
			permissionButton.click(); // Click the permission button
		} catch (Exception e) {
			// If the permission button is not present, no action is needed for this iteration.
			System.out.println("No permission pop-up for this iteration.");
		}

		// Click on the shutter button to take a photo

		WebElement shutterButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//android.widget.ImageView[@content-desc=\"Shutter\"]")));
		Thread.sleep(1000);
		shutterButton.click();

		// Click the 'Done' button after the photo is taken

		WebElement doneButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//android.widget.ImageButton[@content-desc=\"Done\"]")));
		doneButton.click();

		try {

		    WebElement allowBtn = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")));
		    allowBtn.click();
		    System.out.println("Permission granted.");
		} catch (TimeoutException e) {
		    System.out.println("No permission popup appeared.");
		}

		// Click 'Save' to save the photo
		WebElement saveButton = driver.findElement(By.xpath("//android.widget.TextView[@text='Save']"));
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();


//		pat.CLickOn_Pass_Fail_Toggled();
		pat.CLickOn_SubmitButton_OnPATReadingButton();
		pat.CLickOn_YesButton_OnSaveThisReadingPopup();

	}





}
