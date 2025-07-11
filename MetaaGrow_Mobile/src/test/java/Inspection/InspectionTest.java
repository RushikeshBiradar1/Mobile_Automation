package Inspection;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import General_Utility.B1;
import General_Utility.B2;
import General_Utility.BaseClass;
import General_Utility.Scroll;
import General_Utility.WebDriver_Utility;
import POM.Dashboard;
import POM.Inspection;
import POM.Maintenance;
import io.appium.java_client.MobileBy;

public class InspectionTest extends B2{
	  @Test(priority = 1)
	  public void TwoQuestionInspectionTest_TC_I01() throws Throwable
	  {
		  Dashboard db = new Dashboard(driver);
		  db.ClickOn_InspectionScheduledTab();
//		 driver.findElement(By.xpath("//android.widget.TextView[@text=\"Food and Beverage Inspection-Bowling Lane \"]")).click();
//		 driver.findElement(By.xpath("//android.widget.TextView[@text=\"A. Facilities\"]")).click();
//		 driver.findElement(By.xpath(""))
		  
		 Inspection inspection = new Inspection(driver);
//		 inspection.CLickon_FirstInspection();
		 
		 
		// Wait for inspection list to load
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Ensure there is a scrollable view
		    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Food and Beverage\"))";

		    // Wait for scroll to complete
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator(uiScrollable)));

		    // Find and click the element
		    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		    wait.until(ExpectedConditions.visibilityOf(targetElement));
		    targetElement.click();
		    
		    //Click On Section in Checklist
//			 inspection.ClickOn_SectionDropdowIco_OnChecklistDetails();
		 
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
		    inspection.ClickOn_SaveAndSubmitButton();

//		    inspection.CLickOn_SaveButtonInspection_OnInspectionChecklist();
		    
		    System.out.println("Checklist Saved Successfully");
		    
		    Thread.sleep(2000);
		 // Wait for the Completed tab to load before clicking
		    wait.until(ExpectedConditions.elementToBeClickable(
		        MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Completed\")")));

		    // Navigate to the Completed tab
		    inspection.clickOn_CompletedTab();

//		    // Ensure the inspection appears in the Completed tab
//		    String uiScrollable1 = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Food and Beverage\"))";

		    // Wait for scroll to complete
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator(uiScrollable)));

		    // Find the inspection element in Completed tab
		    WebElement completedInspection = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		    wait.until(ExpectedConditions.visibilityOf(completedInspection));

		    // Verify the inspection is displayed in the Completed tab
		    Assert.assertTrue(completedInspection.isDisplayed(), "Inspection is not showing in the Completed tab!");

		    System.out.println("Inspection successfully moved to the Completed tab.");
		    
	      
	  }
	  
	  
	  @Test(priority = 2)
	  public void TwoQuestionInspectionwithRemarkandUserTest_TC_I02() throws Throwable
	  {
		  Dashboard db = new Dashboard(driver);
		// Wait for inspection list to load
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(  db.getInspectionScheduledTab())).click();

//		  db.ClickOn_InspectionScheduledTab();

		  
		 Inspection inspection = new Inspection(driver);
//		 inspection.CLickon_FirstInspection();
		 
		 
		

		    // Ensure there is a scrollable view
		    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Opening Checklist\"))";

		    // Wait for scroll to complete
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator(uiScrollable)));

		    // Find and click the element
		    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		    wait.until(ExpectedConditions.visibilityOf(targetElement));
		    targetElement.click();
		    
		    //Click On Section in Checklist
//			 inspection.ClickOn_SectionDropdowIco_OnChecklistDetails();
		 
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
		    
		    inspection.ClickOn_OverallRemarkField_OnChecklistdetails("All inspection points meet the required standards. No issues found.");
		    
		    Thread.sleep(2000);
		    inspection.ClickOn_SelectUsersPerformingThisTaskDropdownIcon();
		    inspection.ClickOn_SelectFernandes_Text();
		    inspection.ClickOn_SelectUsersPerformingThisTaskDropdownIcon();
		    
		    
//    WebDriver_Utility wb = new WebDriver_Utility();
//   Scroll sc = new Scroll();
//   sc.ScrollUsingText(driver, "Save & Submit");
//   inspection.ClickOn_SaveAndSubmitButton();	
		    
		    try {
		        if (inspection.getSaveAndSubmitButton().isDisplayed()) {
		            inspection.ClickOn_SaveAndSubmitButton();
		        }
		    } catch (Exception e) {
		        Scroll sc = new Scroll();
		        sc.ScrollUsingText(driver, "Save & Submit");
		        inspection.ClickOn_SaveAndSubmitButton();
		    }
		    
		    
   
		    System.out.println("Checklist Saved Successfully");
		    
		 // Wait for the Completed tab to load before clicking
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Completed\")")));

		    // Navigate to the Completed tab
		    inspection.clickOn_CompletedTab();

//		    // Ensure the inspection appears in the Completed tab
//		    String uiScrollable1 = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Food and Beverage\"))";

		    // Wait for scroll to complete
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator(uiScrollable)));

		    // Find the inspection element in Completed tab
		    WebElement completedInspection = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		    wait.until(ExpectedConditions.visibilityOf(completedInspection));

		    // Verify the inspection is displayed in the Completed tab
		    Assert.assertTrue(completedInspection.isDisplayed(), "Inspection is not showing in the Completed tab!");

		    System.out.println("Inspection successfully moved to the Completed tab.");
		    
	      
	  }
	  
	  @Test(priority = 3)
	  public void VR_HeadsetInspectionTest_TC_I03()
	  {
	  
		  Dashboard db = new Dashboard(driver);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(  db.getInspectionScheduledTab())).click();
//		  db.ClickOn_InspectionScheduledTab();
  
		 Inspection inspection = new Inspection(driver);

		// Wait for inspection list to load
//		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Ensure there is a scrollable view
		    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"VR Headset\"))";

		    // Wait for scroll to complete
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator(uiScrollable)));

		    // Find and click the element
		    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		    wait.until(ExpectedConditions.visibilityOf(targetElement));
		    targetElement.click();
		    
		    //Click On Section in Checklist
//			 inspection.ClickOn_SectionDropdowIco_OnChecklistDetails();
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

		System.out.println("All 12 questions answered successfully.");
//		Scroll sc = new Scroll();
//		   sc.ScrollUsingText(driver, " Save");

//		  inspection.CLickOn_SaveButtonInspection_OnInspectionChecklist();
		
		  inspection.ClickOn_SaveAndSubmitButton();
		
		    System.out.println("Checklist Saved Successfully");
		    
		 // Wait for the Completed tab to load before clicking
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Completed\")")));

		    // Navigate to the Completed tab
		    inspection.clickOn_CompletedTab();

//		    // Ensure the inspection appears in the Completed tab
		    // Wait for scroll to complete
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator(uiScrollable)));

		    // Find the inspection element in Completed tab
		    WebElement completedInspection = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		    wait.until(ExpectedConditions.visibilityOf(completedInspection));

		    // Verify the inspection is displayed in the Completed tab
		    Assert.assertTrue(completedInspection.isDisplayed(), "Inspection is not showing in the Completed tab!");

		    System.out.println("Inspection successfully moved to the Completed tab.");
		    
	  }
	  
	  
	  
	  @Test(priority = 4)
	  public void Daily_Scoreboard_InspectionTest_TC_I04()
	  {
	  
		  Dashboard db = new Dashboard(driver);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(  db.getInspectionScheduledTab())).click();
//		  db.ClickOn_InspectionScheduledTab();
  
		 Inspection inspection = new Inspection(driver);

		// Wait for inspection list to load
//		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Ensure there is a scrollable view
		    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Daily Scoreboard\"))";

		    // Wait for scroll to complete
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator(uiScrollable)));

		    // Find and click the element
		    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		    wait.until(ExpectedConditions.visibilityOf(targetElement));
		    targetElement.click();
		    
		    //Click On Section in Checklist
//			 inspection.ClickOn_SectionDropdowIco_OnChecklistDetails();
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

		System.out.println("All 12 questions answered successfully.");
//		Scroll sc = new Scroll();
//		   sc.ScrollUsingText(driver, " Save");

//		  inspection.CLickOn_SaveButtonInspection_OnInspectionChecklist();
		  
		  inspection.ClickOn_SaveAndSubmitButton();
		
		    System.out.println("Checklist Saved Successfully");
		    
		 // Wait for the Completed tab to load before clicking
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Completed\")")));

		    // Navigate to the Completed tab
		    inspection.clickOn_CompletedTab();

//		    // Ensure the inspection appears in the Completed tab
		    // Wait for scroll to complete
		    wait.until(ExpectedConditions.presenceOfElementLocated(
		        MobileBy.AndroidUIAutomator(uiScrollable)));

		    // Find the inspection element in Completed tab
		    WebElement completedInspection = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
		    wait.until(ExpectedConditions.visibilityOf(completedInspection));

		    // Verify the inspection is displayed in the Completed tab
		    Assert.assertTrue(completedInspection.isDisplayed(), "Inspection is not showing in the Completed tab!");

		    System.out.println("Inspection successfully moved to the Completed tab.");
		    
	  }
}
