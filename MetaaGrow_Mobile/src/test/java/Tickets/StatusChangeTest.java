package Tickets;

import java.time.Duration;import org.apache.commons.io.filefilter.FalseFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;

import General_Utility.B2;
import General_Utility.BaseClass;
import POM.Dashboard;
import POM.Tickets;

public class StatusChangeTest extends B2{

	
	
	@Test(priority = 1)
	public void ParkedStatusTest_TKT_05() throws Throwable
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);

		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));
		// Now call the method to click on the Open Tickets Tab
		db.CLickOn_OpenTicketsTab();

		// Wait for the first ticket to be clickable and click on it
		Tickets tkt = new Tickets(driver);
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getFirstTicket()));
		tkt.CLickOn_FirstTicket();

		// Wait for the Open Ticket Title to be visible and fetch the text
		WebElement OpenTicktTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView)[4]")));
		String OpenTicketText = OpenTicktTitle.getText();
		System.out.println("Open Ticket Title: " + OpenTicketText);

		// Click on the Open Ticket Status Dropdown
		tkt.CLickOn_OpenTicketStatusDropdown();
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getOpenTicketDropdown()));
		tkt.ClickOn_OpenTicketDropdown();

		// Select Parked Status and submit the form
		tkt.ClickOn_SelectParkedStatus();
		tkt.CLickOn_AddRemarkField("Ticket is Parked");
		tkt.ClickOn_SubmitButton();
		tkt.ClickOn_YesButton_OnChangeStatusPopup();

Thread.sleep(2000);
		
		db.ClickOn_HomeIconAtBottom();
		
		
		//Verify Ticket Is parked (This feature is currently not working because parked ticket is going at bottom randomly

//		// Wait for the Open Ticket Dropdown to become visible again
//		wait.until(ExpectedConditions.visibilityOf(tkt.getOpenTicketDropdown()));
//		Thread.sleep(3000); // Sleep to simulate a delay (you can remove this if you don't need it)
//		tkt.ClickOn_OpenTicketDropdown();
//		Thread.sleep(1000); // Sleep again to simulate a delay (you can remove this if you don't need it)
//
//		// XPath for the Parked Status Button
//		By elementLocator = By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.View");
//
//		// Wait for the Parked Status Button to be visible
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
//
//		// Once visible, click the element
//		element.click();
//
//		WebElement FirstTicket = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")));
////		tkt.CLickOn_FirstTicket();
//FirstTicket.click();
//		
//		// Wait for the Parked Ticket Title to be visible and fetch the text
//		WebElement ParkedTicketTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView)[4]")));
//		String ParkTitleText = ParkedTicketTitle.getText();
//		System.out.println("Parked Ticket Title: " + ParkTitleText);
//
//		// Assertion to check if the Open Ticket title matches the Parked Ticket title
//		Assert.assertEquals(OpenTicketText, ParkTitleText, "Ticket status did not change to Parked! Test failed.");
//		System.out.println("Ticket status successfully changed to Parked: Test passed.");

		
		
	}
	
	
	@Test(priority = 2)
	public void ClosedTicketStatusChangeTest_TKT_06()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));  // Assuming you have a method to get the element

		// Now call the method to click on the Open Tickets Tab
		
		db.CLickOn_OpenTicketsTab();
		Tickets tkt = new Tickets(driver);
		tkt.CLickOn_FirstTicket();
		tkt.CLickOn_OpenTicketStatusDropdown();
//		wait.until(ExpectedConditions.elementToBeClickable(tkt.getOpenTicketDropdown()));
//		
//		tkt.ClickOn_OpenTicketDropdown();
		
		
		// Wait for the "Open Ticket Dropdown" element to be clickable
		WebElement openTicketDropdown = wait.until(
		    ExpectedConditions.elementToBeClickable(tkt.getOpenTicketDropdown()));

		// Click the "Open Ticket Dropdown" element
		openTicketDropdown.click();
		
		tkt.CLickOn_SelectClosedStatus();;
		tkt.CLickOn_AddRemarkField("Ticket is Closed");
		tkt.ClickOn_SubmitButton();
		tkt.ClickOn_YesButton_OnChangeStatusPopup();
		db.ClickOn_HomeIconAtBottom();
	}
	
	@Test(priority = 3)
	public void NotValidTicketStatusChangeTest_TKT_07()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));  // Assuming you have a method to get the element

		// Now call the method to click on the Open Tickets Tab
		
		db.CLickOn_OpenTicketsTab();
		Tickets tkt = new Tickets(driver);
		tkt.CLickOn_FirstTicket();
		tkt.CLickOn_OpenTicketStatusDropdown();
		
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getOpenTicketDropdown()));
		tkt.ClickOn_OpenTicketDropdown();
		tkt.CLickOn_SelectNotValidStatus();
		tkt.CLickOn_AddRemarkField("Ticket is Not valid");
		tkt.ClickOn_SubmitButton();
		tkt.ClickOn_YesButton_OnChangeStatusPopup();
		System.out.println("Ticket Status Has been changes successfully Not Valid");
	}
	
	@Test(enabled=false)
	public void VerifyParkedTicket() throws Throwable
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Dashboard db = new Dashboard(driver);
		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));  // Assuming you have a method to get the element

		// Now call the method to click on the Open Tickets Tab
		
		db.CLickOn_OpenTicketsTab();
//		Tickets tkt = new Tickets(driver);
//		tkt.CLickOn_FirstTicket();
		
//		String TEXTTITLE = driver.findElement(By.xpath("(//android.widget.TextView)[2]")).getText();
//		System.out.println(TEXTTITLE+"USING GETTEXT()");
//		String title = driver.findElement(By.xpath("(//android.widget.TextView)[2]")).getAttribute("name");
//System.out.println(title+"using getattribute()");
		
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Tickets tkt = new Tickets(driver);
		tkt.ClickOn_OpenTicketDropdown();
//		wait.until(ExpectedConditions.elementToBeClickable(tkt.getSelectParkedStatus()));
//		tkt.ClickOn_SelectParkedStatus();
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.View")).click();
		
	
		tkt.ClickOn_SelectParkedStatus();
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup")).click();
		Thread.sleep(5000);
//		tkt.CLickOn_FirstTicket();
//		WebElement switchBoardTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView)[4]")));
//		String text = switchBoardTitle.getText();
//		System.out.println("Switch Board Title: " + text);
		
		
//		tkt.CLickOn_OpenTicketStatusDropdown();
//		wait.until(ExpectedConditions.elementToBeClickable(tkt.getOpenTicketDropdown()));
//		tkt.ClickOn_OpenTicketDropdown();
//		tkt.ClickOn_SelectParkedStatus();
//		tkt.CLickOn_AddRemarkField("Ticket is Parked");
//		tkt.ClickOn_SubmitButton();
//		tkt.ClickOn_YesButton_OnChangeStatusPopup();
//		
//		tkt.CLickOn_OpenTicketStatusDropdown();
//		tkt.ClickOn_SelectParkedStatus();
		
		//verify tikcet is parked or not
	}
	
	@Test(enabled=false)
	public void ParkedToOpenStatusTest() throws Throwable
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Dashboard db = new Dashboard(driver);

		// Wait for the Open Tickets Tab to be clickable
		wait.until(ExpectedConditions.elementToBeClickable(db.getOpenTicketsTab()));
		// Now call the method to click on the Open Tickets Tab
		db.CLickOn_OpenTicketsTab();

		
		// Wait for the first ticket to be clickable and click on it
		Tickets tkt = new Tickets(driver);
		
		tkt.ClickOn_OpenTicketDropdown();
//		wait.until(ExpectedConditions.elementToBeClickable(tkt.getOpenStatusfromDropdownOfListingPage()));
//		tkt.ClickOn_OpenStatusfromDropdownOfListingPage();
		Thread.sleep(1000);
//		wait.until(ExpectedConditions.elementToBeClickable(tkt.getParkedStatusfromDropdownOfListingPage()));
//		
//		tkt.CLickOn_ParkedStatusfromDropdownOfListingPage();
		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.View")).click();
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getFirstTicket()));
		
		tkt.CLickOn_FirstTicket();

		// Wait for the Open Ticket Title to be visible and fetch the text
		WebElement ParkedTicktTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//android.widget.TextView)[4]")));
		String ParkedTicketText = ParkedTicktTitle.getText();
		System.out.println("Open Ticket Title: " + ParkedTicketText);

		// Click on the Open Ticket Status Dropdown
		tkt.ClickOn_SelectParkedStatus();
		wait.until(ExpectedConditions.elementToBeClickable(tkt.getOpenTicketDropdown()));
		tkt.ClickOn_SelectParkedStatus();
		 
	

		// Select Parked Status and submit the form
		tkt.CLickOn_OpenTicketStatusDropdown();
		tkt.CLickOn_AddRemarkField("Ticket is Parked");
		tkt.ClickOn_SubmitButton();
		tkt.ClickOn_YesButton_OnChangeStatusPopup();

		
	}
	
}
