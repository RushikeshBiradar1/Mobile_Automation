package Preventive_Maintenance;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;

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
import POM.Maintenance;
import io.appium.java_client.MobileBy;


public class ArcadePMTest extends B2{

	@Test(priority = 1)
	public void TwoQuestionTest_MT_01() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
		db.ClickOn_ScheduledPM();
		Maintenance pm = new Maintenance(driver);

		// Wait for the page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Arcade Machines PM 2\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		// Now you can interact with the element
		targetElement.click(); // For example, clicking the target element
		//		   driver.findElement(By.xpath("//android.widget.TextView[@text='Arcade Machines PM']")).click();
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

					//		                // Perform additional actions after selection
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

		Thread.sleep(500); // Wait for finish action to complete
		//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(pm.getFinish_MaintenanceButton()));
		//	        pm.ClickOn_Finish_MaintenanceButton();
		pm.ClickOn_Finish_MaintenanceButton();



		// Navigate to the Completed tab
		pm.ClickOn_FinishedTab();

		// Wait for scroll to complete
		wait.until(ExpectedConditions.presenceOfElementLocated(
				MobileBy.AndroidUIAutomator(uiScrollable)));

		// Find the PM Checklist in Completed tab
		WebElement FinishedPM = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		wait.until(ExpectedConditions.visibilityOf(FinishedPM));

		// Verify the inspection is displayed in the Completed tab
		Assert.assertTrue(FinishedPM.isDisplayed(), "Arcade Machines PM 2 Preventive Maintenance is not showing in the Finished tab!");

		System.out.println("Arcade Machines PM 2 Preventive Maintenance successfully moved to the Finished tab.");



	}
	@Test(priority = 2)
	public void TwoQuestionWithRemarkAndMultiUserPerformTest_MT_02() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
		db.ClickOn_ScheduledPM();
		Maintenance pm = new Maintenance(driver);

		// Wait for the page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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


		pm.ClickOn_Finish_MaintenanceButton();

		// Navigate to the Completed tab
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[4]"))).click();
				
//		// Navigate to the Completed tab
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


	@Test(priority = 3)
	public void Ride_and_AttractionPMTest_MT_03() throws Throwable
	{
		Dashboard db = new Dashboard(driver);
		db.ClickOn_ScheduledPM();
		Maintenance pm = new Maintenance(driver);

		// Wait for the page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Define the UI Automator scroll command to scroll to a specific element
		String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Ride & Attraction\"))";

		// Use MobileBy to find the element with androidUIAutomator
		WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));

		// Optional: Wait for the element to be visible
		wait.until(ExpectedConditions.visibilityOf(targetElement));

		// Now you can interact with the element
		targetElement.click(); // For example, clicking the target element
		//		   driver.findElement(By.xpath("//android.widget.TextView[@text='Arcade Machines PM']")).click();
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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\" Finish Maintenance\"]"))).click();
		//		pm.ClickOn_Finish_MaintenanceButton();



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

	@Test(priority = 4)
	public void SuperBikePMTest_MT_04() throws Throwable
	{

		Dashboard db = new Dashboard(driver);
		db.ClickOn_ScheduledPM();
		Maintenance pm = new Maintenance(driver);

		// Wait for the page to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\" Finish Maintenance\"]")));
		Thread.sleep(2000);
				pm.ClickOn_Finish_MaintenanceButton();



		// Navigate to the Completed tab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[4]"))).click();
		
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






}
