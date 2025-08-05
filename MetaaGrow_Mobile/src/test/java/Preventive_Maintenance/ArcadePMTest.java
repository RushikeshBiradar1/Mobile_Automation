package Preventive_Maintenance;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import General_Utility.B1;
import General_Utility.B2;
import General_Utility.BaseClass;
import POM.Dashboard;
import POM.Inspection;
import POM.Maintenance;
import io.appium.java_client.MobileBy;


public class ArcadePMTest extends B2{


	////////////////// First Test Case /////////////////
	@Test(priority = 1)
	public void TC_PM01_VerifyMaintenance_Scheduled_CountOnDashboard()
	{

		Dashboard db = new Dashboard(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on Inspection Scheduled Tab (if needed)
		wait.until(ExpectedConditions.elementToBeClickable(db.getScheduledPM()));

		try {
			// Updated XPath based on your request
			By scheduledCountLocator = By.xpath(
					"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.TextView[2]");


			// Wait for the element to be visible
			WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(scheduledCountLocator));

			// Extract and print the text (count)
			String countText = countElement.getText();
			System.out.println("✅ Scheduled Inspection Count: " + countText);

			// Assertions to validate the element and the numeric value
			Assert.assertTrue(countElement.isDisplayed(), "✅ Count element is displayed");
			Assert.assertTrue(countText.matches("\\d+"), "✅ Count is a valid number");

		} catch (TimeoutException e) {
			Assert.fail("❌ 'Scheduled' count element not found with updated XPath.");
		}

	}



	//////////////////Second Test Case /////////////////
	@Test(priority = 2)
	public void TC_PM02_VerifyMaintenance_OverdueCountOnDashboard()
	{

		Dashboard db = new Dashboard(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on Inspection Scheduled Tab (if needed)
		wait.until(ExpectedConditions.elementToBeClickable(db.getScheduledPM()));

		try {
			// XPath to the count inside the Overdue subtab — assuming 2nd TextView holds the count
			By overdueCountLocator = By.xpath(
					"//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView[2]");

			// Wait for the element to be visible
			WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(overdueCountLocator));

			// Extract and print the text (count)
			String countText = countElement.getText();
			System.out.println("✅ Overdue Maintenance Count: " + countText);

			// Assertions to validate the element and the numeric value
			Assert.assertTrue(countElement.isDisplayed(), "✅ Count element is displayed");
			Assert.assertTrue(countText.matches("\\d+"), "✅ Count is a valid number");

		} catch (TimeoutException e) {
			Assert.fail("❌ 'Overdue' count element not found with updated XPath.");
		}

	}




	//////////////////3rd Test Case /////////////////
	
	@Test(priority = 3)
	public void TC_PM03_Maintenance_ListingPage_GlobalSearchFunctionality() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
		Maintenance pm = new Maintenance(driver);
		// Wait for PM list to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(  db.getScheduledPM())).click();

		Thread.sleep(1000);

		// Wait for search box visible
		wait.until(ExpectedConditions.visibilityOf(pm.getSearchField_OnPM_AllTabs()));

		// Click to focus the search box before sending text
		WebElement searchBox = (pm.getSearchField_OnPM_AllTabs());
		searchBox.click();
		searchBox.clear();
		searchBox.sendKeys("Arcade Machines PM");

		// Optionally hide keyboard (sometimes helps)
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			// Keyboard might already be hidden, ignore
		}

		// Now wait for the search result
		By resultLocator = By.xpath("//android.widget.TextView[contains(@text, 'Arcade Machines PM')]");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
			System.out.println("✅ 'Arcade Machines PM' is displayed in search results.");
		} catch (TimeoutException e) {
			Assert.fail("❌ 'Arcade Machines PM' not found in search results.");
		}

	}

	
          //////////////////4th Test Case /////////////////
	
	@Test(priority = 4)
	public void TC_PM04_SearchOn_Ad_hoc_Page() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
		Maintenance pm = new Maintenance(driver);
		// Wait for PM list to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(  db.getScheduledPM())).click();

		pm.clickon_AdhocPM_PlusIcon();
		Thread.sleep(1000);

		// Wait for search box visible
		wait.until(ExpectedConditions.visibilityOf(pm.getSearchField_OnPM_AllTabs()));

		// Click to focus the search box before sending text
		WebElement searchBox = (pm.getSearchField_OnPM_AllTabs());
		searchBox.click();
		searchBox.clear();
		searchBox.sendKeys("Arcade Machines PM");

		// Optionally hide keyboard (sometimes helps)
		try {
			driver.hideKeyboard();
		} catch (Exception e) {
			// Keyboard might already be hidden, ignore
		}

		// Now wait for the search result
		By resultLocator = By.xpath("//android.widget.TextView[contains(@text, 'Arcade Machines PM')]");
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
			System.out.println("✅ 'Arcade Machines PM' is displayed in search results.");
		} catch (TimeoutException e) {
			Assert.fail("❌ 'Arcade Machines PM' not found in search results.");
		}

	}



	
              //////////////////5th Test Case /////////////////
	@Test(priority = 5)
	public void TC_PM05_SubmitEmptyChecklist_Validation() {
		try {
			Dashboard db = new Dashboard(driver);
			Maintenance pm = new Maintenance(driver);
			// Wait for PM list to load
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(  db.getScheduledPM())).click();


			System.out.println("Clicked on Maintenance Scheduled tab.");

			// Scroll to the checklist item
			String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true))"
					+ ".scrollIntoView(new UiSelector().textContains(\"Arcade Machines PM\"))";
			WebElement Arcade_Machines_PM = wait.until(ExpectedConditions.presenceOfElementLocated(
					MobileBy.AndroidUIAutomator(uiScrollable)));
			wait.until(ExpectedConditions.visibilityOf(Arcade_Machines_PM));
			Arcade_Machines_PM.click();
			System.out.println("Clicked on 'Arcade_Machines_PM' checklist item.");

			Thread.sleep(6000);
			// Click Save & Submit without filling checklist
			// After checklist is clicked
			WebElement saveSubmitBtn = wait.until(ExpectedConditions.elementToBeClickable(pm.getSaveAndSubmitButton()));
			pm.CLickOn_SaveAndSubmitButton();
			//		        saveSubmitBtn.click();
			System.out.println("Clicked on Save & Submit.");



			// Wait briefly for popup (if expected to be slow)
			Thread.sleep(1000); // Optional: adjust if necessary

			// ✅ Wait briefly for the toast message
			WebDriverWait toastWait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement toastMessage = toastWait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//android.widget.Toast | //android.widget.TextView[contains(@text, 'provide all the Responses')]")
					));

			String message = toastMessage.getText();
			System.out.println("Toast message displayed: " + message);

			Assert.assertTrue(message.contains("provide all the Responses"), "Expected toast message not found!");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred in test: " + e.getMessage());
		}

	}

                //////////////////6th Test Case /////////////////
	@Test(priority = 6)
	public void TC_PM06_Ride_and_AttractionPMTest() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
		
		Maintenance pm = new Maintenance(driver);
		

		// Wait for the page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(db.getScheduledPM())).click();

		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Ride & Attraction\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		// Now you can interact with the element
		targetElement.click(); // For example, clicking the target element
		
		// Initialize Random object
		Random random = new Random();

		int totalQuestions = 13; // Total number of questions
		int answeredQuestions = 0; // Track how many have been answered

		while (answeredQuestions < totalQuestions) {
			try {
				// Fetch the visible "Yes", "No", and "N/A" buttons
				List<WebElement> yesButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='Yes']"));
				List<WebElement> noButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='No']"));
				List<WebElement> naButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='N/A']"));

				int visibleQuestions = yesButtons.size(); // Number of questions currently visible (should be 2)

				for (int i = 0; i < visibleQuestions; i++) {
					WebElement selectedElement = null;
					int randomChoice = random.nextInt(3); // 0 for Yes, 1 for No, 2 for N/A

					if (randomChoice == 0 && !yesButtons.isEmpty()) {
						selectedElement = yesButtons.get(i);
						System.out.println("Selected 'Yes' for question " + (answeredQuestions + 1));
					} else if (randomChoice == 1 && !noButtons.isEmpty()) {
						selectedElement = noButtons.get(i);
						System.out.println("Selected 'No' for question " + (answeredQuestions + 1));
					} else if (randomChoice == 2 && !naButtons.isEmpty()) {
						selectedElement = naButtons.get(i);
						System.out.println("Selected 'N/A' for question " + (answeredQuestions + 1));
					} else {
						// If the random selection is not available, choose the first available
						if (!yesButtons.isEmpty()) {
							selectedElement = yesButtons.get(i);
							System.out.println("Fallback: Selected 'Yes' for question " + (answeredQuestions + 1));
						} else if (!noButtons.isEmpty()) {
							selectedElement = noButtons.get(i);
							System.out.println("Fallback: Selected 'No' for question " + (answeredQuestions + 1));
						} else if (!naButtons.isEmpty()) {
							selectedElement = naButtons.get(i);
							System.out.println("Fallback: Selected 'N/A' for question " + (answeredQuestions + 1));
						}
					}

					// Click the selected option
					if (selectedElement != null) {
						wait.until(ExpectedConditions.elementToBeClickable(selectedElement));
						selectedElement.click();
					}

					answeredQuestions++;

					// Stop if all 20 questions are answered
					if (answeredQuestions >= totalQuestions) {
						break;
					}
				}

				// Scroll down to load the next set of questions after every 2 questions
				if (answeredQuestions < totalQuestions) {
					String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
					driver.findElement(MobileBy.AndroidUIAutomator(scrollCommand));
				}

			} catch (Exception e) {
				System.out.println("Error selecting response for question " + (answeredQuestions + 1) + ": " + e.getMessage());
				break;
			}
		}

		System.out.println("All 10 questions answered.");

				wait.until(ExpectedConditions.elementToBeClickable(pm.getSaveAndSubmitButton())).click();
		

//		pm.CLickOn_SaveAndSubmitButton();



		// Navigate to the Completed tab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Finished\"]"))).click();
		//		pm.ClickOn_FinishedTab();

		// Wait for scroll to complete
		wait.until(ExpectedConditions.presenceOfElementLocated(
				MobileBy.AndroidUIAutomator(uiScrollable)));

		// Find the PM Checklist in Completed tab
		WebElement FinishedPM = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		wait.until(ExpectedConditions.visibilityOf(FinishedPM));

		// Verify the inspection is displayed in the Completed tab
		Assert.assertTrue(FinishedPM.isDisplayed(), "Preventive Maintenance is not showing in the Finished tab!");

		System.out.println("Preventive Maintenance successfully moved to the Finished tab.");
		
	
	}

                 //////////////////7th Test Case /////////////////
	@Test(priority = 7)
	public void TC_PM07_SuperBikePMTest() throws Throwable
	{

		Dashboard db = new Dashboard(driver);
		
		Maintenance pm = new Maintenance(driver);

		// Wait for the page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(db.getScheduledPM())).click();

		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Super Bike\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		// Now you can interact with the element
		targetElement.click(); // For example, clicking the target element
		Random random = new Random();
		int totalQuestions = 15;
		int answeredQuestions = 0;

		while (answeredQuestions < totalQuestions) {
			try {
				// Fetch fresh list of Yes/No/NA buttons AFTER scrolling
				List<WebElement> yesButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='Yes']"));
				List<WebElement> noButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='No']"));
				List<WebElement> naButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='N/A']"));

				int visibleQuestions = yesButtons.size(); // Number of visible questions at this moment

				for (int i = 0; i < visibleQuestions && answeredQuestions < totalQuestions; i++) {
					WebElement selectedElement = null;
					int randomChoice = random.nextInt(3); // 0 = Yes, 1 = No, 2 = N/A

					if (randomChoice == 0 && i < yesButtons.size()) {
						selectedElement = yesButtons.get(i);
						System.out.println("Selected 'Yes' for question " + (answeredQuestions + 1));
					} else if (randomChoice == 1 && i < noButtons.size()) {
						selectedElement = noButtons.get(i);
						System.out.println("Selected 'No' for question " + (answeredQuestions + 1));
					} else if (randomChoice == 2 && i < naButtons.size()) {
						selectedElement = naButtons.get(i);
						System.out.println("Selected 'N/A' for question " + (answeredQuestions + 1));
					} else {
						// Fallback to any available button
						if (i < yesButtons.size()) {
							selectedElement = yesButtons.get(i);
							System.out.println("Fallback: Selected 'Yes' for question " + (answeredQuestions + 1));
						} else if (i < noButtons.size()) {
							selectedElement = noButtons.get(i);
							System.out.println("Fallback: Selected 'No' for question " + (answeredQuestions + 1));
						} else if (i < naButtons.size()) {
							selectedElement = naButtons.get(i);
							System.out.println("Fallback: Selected 'N/A' for question " + (answeredQuestions + 1));
						}
					}

					// Click the selected element
					if (selectedElement != null) {
						wait.until(ExpectedConditions.elementToBeClickable(selectedElement));
						selectedElement.click();
						answeredQuestions++;  // Increment global counter
					}

					if (answeredQuestions >= totalQuestions) break;
				}

				// If we still need to answer more questions, scroll and retry
				if (answeredQuestions < totalQuestions) {
					System.out.println("Scrolling to next set of questions...");
					String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
					driver.findElement(MobileBy.AndroidUIAutomator(scrollCommand));
					Thread.sleep(1500);  // Allow UI to refresh

					// Double-check if new questions actually appeared
					List<WebElement> checkNewQuestions = driver.findElements(By.xpath("//android.widget.TextView[@text='Yes']"));
					if (checkNewQuestions.size() < 2 && answeredQuestions < totalQuestions) {
						System.out.println("Retrying scroll to ensure last questions are loaded...");
						driver.findElement(MobileBy.AndroidUIAutomator(scrollCommand));
						Thread.sleep(1500);
					}
				}

			} catch (Exception e) {
				System.out.println("Error selecting response for question " + (answeredQuestions + 1) + ": " + e.getMessage());
				break;
			}
		}

		System.out.println("All " + answeredQuestions + " questions answered successfully.");

		//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\" Finish Maintenance\"]")));
		Thread.sleep(2000);
		//				pm.ClickOn_Finish_MaintenanceButton();
		pm.CLickOn_SaveAndSubmitButton();



		// Navigate to the Completed tab
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[4]"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Finished\"]"))).click();
		// Navigate to the Completed tab
		//		pm.ClickOn_FinishedTab();

		// Wait for scroll to complete
		wait.until(ExpectedConditions.presenceOfElementLocated(
				MobileBy.AndroidUIAutomator(uiScrollable)));

		// Find the PM Checklist in Completed tab
		WebElement FinishedPM = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		wait.until(ExpectedConditions.visibilityOf(FinishedPM));

		// Verify the inspection is displayed in the Completed tab
		Assert.assertTrue(FinishedPM.isDisplayed(), "Preventive Maintenance is not showing in the Finished tab!");

		System.out.println("Preventive Maintenance successfully moved to the Finished tab.");

	}

	
	
	
	
          //////////////////8th Test Case /////////////////
	@Test(priority = 8)
	public void TC_PM08_SaveDraftPMTest() throws Throwable {
		Dashboard db = new Dashboard(driver);
		db.ClickOn_ScheduledPM();
		Maintenance pm = new Maintenance(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Scroll to target PM checklist
		String checklistText = "Pinsetter Maintenance";
		WebElement targetElement = driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
						".scrollIntoView(new UiSelector().text(\"" + checklistText + "\"))"));
		targetElement.click();

		Random random = new Random();
		int currentIndex = 1;

		while (true) {
			String[] options = {"Yes", "No", "N/A"};
			boolean clicked = false;

			for (int i = 0; i < options.length; i++) {
				String optionXpath = "(//android.widget.TextView[@text='" + options[i] + "'])[" + currentIndex + "]";
				List<WebElement> buttons = driver.findElements(By.xpath(optionXpath));
				if (!buttons.isEmpty()) {
					try {
						WebElement selected = buttons.get(0);
						selected.click();
						clicked = true;
						break;
					} catch (Exception ignored) { }
				}
			}

			if (!clicked) break;
			currentIndex++;
		}

		

		// Scroll to and fill the remark field
		try {
			//	        driver.findElement(MobileBy.AndroidUIAutomator(
			//	            "new UiScrollable(new UiSelector().scrollable(true))" +
			//	            ".scrollIntoView(new UiSelector().textContains(\"Enter here\"))"));

			WebElement remarkField = driver.findElement(
					By.xpath("//android.widget.EditText[contains(@text, 'Enter here')]"));
			remarkField.sendKeys("testing");
			System.out.println("✅ 'testing' sent to remark field successfully.");
		} catch (Exception e) {
			Assert.fail("❌ Remark field not found or not interactable: " + e.getMessage());
		}

		// Save action
		pm.ClickOn_SaveButton();

		try {
			// Wait briefly for popup (if expected to be slow)
			Thread.sleep(1000); // Optional: adjust if necessary

			// ✅ Wait briefly for the toast message
			WebDriverWait toastWait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement toastMessage = toastWait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//android.widget.Toast | //android.widget.TextView[contains(@text, 'Schedule saved successfully')]")
					));

			String message = toastMessage.getText();
			System.out.println("Toast message displayed: " + message);

			Assert.assertTrue(message.contains("Schedule saved successfully"), "Expected toast message not found!");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred in test: " + e.getMessage());
		}


		driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']//android.widget.ImageView")).click();

		boolean visible = false;
		for (WebElement e : driver.findElements(By.xpath("//android.widget.TextView[@text='2/2']"))) {
			if (e.isDisplayed()) {
				visible = true;
				System.out.println("✅ '2/2' is displayed successfully.");
				break;
			}
		}
		if (!visible) Assert.fail("❌ '2/2' is not displayed.");
	}

	
        //////////////////9th Test Case /////////////////
	@Test(priority = 9)
	public void TC_PM09_TwoQuestionTest() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
		
		Maintenance pm = new Maintenance(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.elementToBeClickable(db.getScheduledPM())).click();
		// Scroll to target PM checklist
		String checklistText = "Arcade Machines PM 2";
		WebElement targetElement = driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
						".scrollIntoView(new UiSelector().text(\"" + checklistText + "\"))"));
		targetElement.click();

		Random random = new Random();
		int currentIndex = 1;

		while (true) {
			String[] options = {"Yes", "No", "N/A"};
			boolean clicked = false;

			for (int i = 0; i < options.length; i++) {
				String optionXpath = "(//android.widget.TextView[@text='" + options[i] + "'])[" + currentIndex + "]";
				List<WebElement> buttons = driver.findElements(By.xpath(optionXpath));
				if (!buttons.isEmpty()) {
					try {
						WebElement selected = buttons.get(0);
						selected.click();
						clicked = true;
						break;
					} catch (Exception ignored) { }
				}
			}

			if (!clicked) break;
			currentIndex++;
		}

		System.out.println("All questions answered.");

		Thread.sleep(500); // Wait for finish action to complete
		wait.until(ExpectedConditions.elementToBeClickable(pm.getSaveAndSubmitButton()));
		pm.CLickOn_SaveAndSubmitButton();


		Thread.sleep(500);
		// Navigate to the Completed tab
//		pm.ClickOn_FinishedTab();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Finished\"]"))).click();

		// Wait for scroll to complete
		wait.until(ExpectedConditions.presenceOfElementLocated(
				MobileBy.AndroidUIAutomator(checklistText)));

		// Find the PM Checklist in Completed tab
		WebElement FinishedPM = driver.findElement(MobileBy.androidUIAutomator(checklistText));
		wait.until(ExpectedConditions.visibilityOf(FinishedPM));

		// Verify the inspection is displayed in the Completed tab
		Assert.assertTrue(FinishedPM.isDisplayed(), "Arcade Machines PM 2 Preventive Maintenance is not showing in the Finished tab!");

		System.out.println("Arcade Machines PM 2 Preventive Maintenance successfully moved to the Finished tab.");



	}
	@Test(priority = 10)
	public void TC_PM10_TwoQuestionWithRemarkAndMultiUserPerformTest() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
	
		Maintenance pm = new Maintenance(driver);

		// Wait for the page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(db.getScheduledPM())).click();

		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Arcade PM\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		// Now you can interact with the element
		targetElement.click(); // For example, clicking the target element
		//		driver.findElement(By.xpath("//android.widget.TextView[@text='Arcade Machines PM']")).click();
		// Initialize Random object
		Random random = new Random();

		int currentIndex = 1; // Start with the first question

		while (true) {
			// Dynamically fetch the "Yes", "No", and "N/A" buttons based on the current index
			String yesButtonXpath = "(//android.widget.TextView[@text='Yes'])[" + currentIndex + "]";
			String noButtonXpath = "(//android.widget.TextView[@text='No'])[" + currentIndex + "]";
			String naButtonXpath = "(//android.widget.TextView[@text='N/A'])[" + currentIndex + "]";

			List<WebElement> yesButtons = driver.findElements(By.xpath(yesButtonXpath));
			List<WebElement> noButtons = driver.findElements(By.xpath(noButtonXpath));
			List<WebElement> naButtons = driver.findElements(By.xpath(naButtonXpath));

			// If no options are available, break the loop
			if (yesButtons.isEmpty() && noButtons.isEmpty() && naButtons.isEmpty()) {
				System.out.println("No more 'Yes', 'No', or 'N/A' buttons to click.");
				break;
			}

			WebElement selectedElement = null;
			int randomChoice = random.nextInt(3); // 0 for Yes, 1 for No, 2 for N/A

			if (randomChoice == 0 && !yesButtons.isEmpty()) {
				selectedElement = yesButtons.get(0);
				System.out.println("Randomly selected 'Yes' for question " + currentIndex);
			} else if (randomChoice == 1 && !noButtons.isEmpty()) {
				selectedElement = noButtons.get(0);
				System.out.println("Randomly selected 'No' for question " + currentIndex);
			} else if (randomChoice == 2 && !naButtons.isEmpty()) {
				selectedElement = naButtons.get(0);
				System.out.println("Randomly selected 'N/A' for question " + currentIndex);
			} else {
				// If the chosen option is unavailable, select the first available button
				if (!yesButtons.isEmpty()) {
					selectedElement = yesButtons.get(0);
					System.out.println("Only 'Yes' available for question " + currentIndex);
				} else if (!noButtons.isEmpty()) {
					selectedElement = noButtons.get(0);
					System.out.println("Only 'No' available for question " + currentIndex);
				} else if (!naButtons.isEmpty()) {
					selectedElement = naButtons.get(0);
					System.out.println("Only 'N/A' available for question " + currentIndex);
				}
			}

			try {
				// Wait for the chosen button to be clickable
				wait.until(ExpectedConditions.elementToBeClickable(selectedElement));

				// Click if the element is visible and enabled
				if (selectedElement.isDisplayed() && selectedElement.isEnabled()) {
					selectedElement.click();
					System.out.println("Answered question " + currentIndex);

					// Increment the index for the next question
					currentIndex++;

					// Perform additional actions after selection
					//		                pm.ClickOn_ActionIconFirst();
					//		                driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")).click();
				} else {
					System.out.println("Button not clickable for question " + currentIndex);
					break;
				}
			} catch (Exception e) {
				System.out.println("Unable to find or click the button for question " + currentIndex);
				break;
			}
		}

		System.out.println("All questions answered.");


		pm.ClickOn_RemarkField("Preventive maintenance completed; all machines cleaned and tested.");

		//		pm.ClickOn_SelectUsersPerformingThisTaskDropdown(driver, "Fernandes");


		//		pm.ClickOn_Finish_MaintenanceButton();
		pm.CLickOn_SaveAndSubmitButton();

		// Navigate to the Completed tab
		//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[4]"))).click();

		//		// Navigate to the Completed tab
//		pm.ClickOn_FinishedTab();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Finished\"]"))).click();

		// Wait for scroll to complete
		wait.until(ExpectedConditions.presenceOfElementLocated(
				MobileBy.AndroidUIAutomator(uiScrollable)));

		// Find the PM Checklist in Completed tab
		WebElement FinishedPM = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		wait.until(ExpectedConditions.visibilityOf(FinishedPM));

		// Verify the inspection is displayed in the Completed tab
		Assert.assertTrue(FinishedPM.isDisplayed(), "Preventive Maintenance is not showing in the Finished tab!");

		System.out.println("Preventive Maintenance successfully moved to the Finished tab.");

	}


	
	




}
