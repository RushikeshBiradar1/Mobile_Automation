package PAT;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import General_Utility.B2;
import General_Utility.BaseClass;
import General_Utility.Scroll;
import POM.Dashboard;
import POM.PAT;
import POM.TPI;
import io.appium.java_client.MobileBy;

public class AddReading extends B2{
	
	@Test(priority = 1)
	public void SearchByPATName()
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
				pat.CLickOn_SearchBoX_PATListing("Bowling");
				
				
//	TPI tpi = new TPI(driver);
//	
//	tpi.ClickOn_SearchBox_OnListingPage("Bowling");
	
	
	 // Ensure there is a scrollable view
    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Bowling\"))";

    // Wait for scroll to complete
    wait.until(ExpectedConditions.presenceOfElementLocated(
        MobileBy.AndroidUIAutomator(uiScrollable)));

    // Find and click the element
    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
    wait.until(ExpectedConditions.visibilityOf(targetElement));
//   
    
    
 // Find the PM Checklist in Completed tab
	WebElement BowlingPATName = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
	wait.until(ExpectedConditions.visibilityOf(BowlingPATName));

	// Verify the inspection is displayed in the Completed tab
	Assert.assertTrue(BowlingPATName.isDisplayed(), "Bowling PAT is not showing in the Todays tab!");

	System.out.println("Bowling PAT is searched properly on todays tab.");
}
	
	
	
	
	@Test(priority = 2)
	public void PerformPATWithPassResult() throws Throwable
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
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 3)
	public void PerformPATWithFailResult() throws Throwable
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
		Thread.sleep(5000);
		
	}

}
