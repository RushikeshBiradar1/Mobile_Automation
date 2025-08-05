package Inspection;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;

public class InspectionTest extends B2{
	
	 @Test(priority = 0)
	public void TC_I09_Inspection_ListingPage_GlobalSearchFunctionality() throws Throwable
	{
		  Dashboard db = new Dashboard(driver);
			// Wait for inspection list to load
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.elementToBeClickable(  db.getInspectionScheduledTab())).click();

			 Inspection inspection = new Inspection(driver);
			
			 Thread.sleep(1000);
			    // Perform search for "Food and Beverage"
//			    inspection.ClickOn_SearchField_OnInspectionListing_and_onInstantChecklistpage("Food and Beverage");

			 // Wait for search box visible
			    wait.until(ExpectedConditions.visibilityOf(inspection.getSearchField_OnInspectionListing_and_onInstantChecklistpage()));

			    // Click to focus the search box before sending text
			    WebElement searchBox = (inspection.getSearchField_OnInspectionListing_and_onInstantChecklistpage());
			    searchBox.click();
			    searchBox.clear();
			    searchBox.sendKeys("Food and Beverage");

			    // Optionally hide keyboard (sometimes helps)
			    try {
			        driver.hideKeyboard();
			    } catch (Exception e) {
			        // Keyboard might already be hidden, ignore
			    }

			    // Now wait for the search result
			    By resultLocator = By.xpath("//android.widget.TextView[contains(@text, 'Food and Beverage')]");
			    try {
			        wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
			        System.out.println("✅ 'Food and Beverage' is displayed in search results.");
			    } catch (TimeoutException e) {
			        Assert.fail("❌ 'Food and Beverage' not found in search results.");
			    }

	}
	  @Test(priority = 1)
	  public void TC_I03_Food_and_BeverageTwoQuestionInspectionTest() throws Throwable
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
		    WebElement targetElement = driver.findElement(AppiumBy.androidUIAutomator(uiScrollable));
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
		    
		    inspection.ClickOn_SelectUsersPerformingThisTaskDropdownIcon();
//		   driver.findElement(By.xpath("new UiSelector().textContains(\"Fernandes\")")).click();
		   driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector().scrollable(true))" +
				    ".scrollIntoView(new UiSelector().textContains(\"Fernandes\"))")).click();
		    Thread.sleep(2000);
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
	  public void TC_I02_Opening_ChecklistTwoQuestionInspectionwithRemarkandUserTest() throws Throwable
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
	  public void TC_I02_VR_HeadsetInspectionTest()
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
	  public void TC_I04_Daily_Scoreboard_InspectionTest()
	  {
	  
		  Dashboard db = new Dashboard(driver);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(  db.getInspectionScheduledTab())).click();
//		  db.ClickOn_InspectionScheduledTab();
  
		 Inspection inspection = new Inspection(driver);


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
		
		inspection.ClickOn_OverallRemarkField_OnChecklistdetails("Overall Remark added successfully");
		  
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
	  
	  @Test(priority = 5)
	  public void TC_I08_SubmitEmptyChecklist_Validation() {
		    Dashboard db = new Dashboard(driver);
		    Inspection inspection = new Inspection(driver);

		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    try {
		        // Click on "Inspection Scheduled" tab
		        WebElement scheduledTab = wait.until(ExpectedConditions.elementToBeClickable(db.getInspectionScheduledTab()));
		        scheduledTab.click();
		        System.out.println("Clicked on Inspection Scheduled tab.");

		        // Scroll to the checklist item
		        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true))"
		                            + ".scrollIntoView(new UiSelector().textContains(\"Q3 HVAC Main\"))";
		        WebElement Q3_HVAC_Inspection = wait.until(ExpectedConditions.presenceOfElementLocated(
		            MobileBy.AndroidUIAutomator(uiScrollable)));
		        wait.until(ExpectedConditions.visibilityOf(Q3_HVAC_Inspection));
		        Q3_HVAC_Inspection.click();
		        System.out.println("Clicked on 'Q3 HVAC Main' checklist item.");

		        Thread.sleep(6000);
		        // Click Save & Submit without filling checklist
		     // After checklist is clicked
		        WebElement saveSubmitBtn = wait.until(ExpectedConditions.elementToBeClickable(inspection.getSaveAndSubmitButton()));
		       inspection.ClickOn_SaveAndSubmitButton();
//		        saveSubmitBtn.click();
		        System.out.println("Clicked on Save & Submit.");

		      

		        // Wait briefly for popup (if expected to be slow)
		        Thread.sleep(1000); // Optional: adjust if necessary

		        // Check for popup message
		        List<WebElement> popupElements = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='android:id/message']"));

		        if (!popupElements.isEmpty() && popupElements.get(0).isDisplayed()) {
		            System.out.println("Popup is visible: " + popupElements.get(0).getText());

		            // Click OK button using wait to ensure it's interactable
		            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
		            okButton.click();
		            System.out.println("OK button clicked.");
		        } else {
		            // Fail if popup is not visible
		            Assert.fail("Popup message did not appear. Failing test.");
		        }

		    } catch (Exception e) {
		        e.printStackTrace();
		        Assert.fail("Exception occurred in test: " + e.getMessage());
		    }
		
	  }
	  
	  @Test(priority = 6)
		public void TC_I10_Instant_Checklist_ListingPage_GlobalSearchFunctionality() throws Throwable
		{
			  Dashboard db = new Dashboard(driver);
				// Wait for inspection list to load
				    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        wait.until(ExpectedConditions.elementToBeClickable(  db.getInspectionScheduledTab())).click();

				 Inspection inspection = new Inspection(driver);
				
			
				   // click on adhoc checklist plus icon on listing page
				 inspection.CLickOn_AdhocChecklistPlusIcon();
				 Thread.sleep(1000);
				 // Wait for search box visible
				    wait.until(ExpectedConditions.visibilityOf(inspection.getSearchField_OnInspectionListing_and_onInstantChecklistpage()));

				    // Click to focus the search box before sending text
				    WebElement searchBox = (inspection.getSearchField_OnInspectionListing_and_onInstantChecklistpage());
				    searchBox.click();
				    searchBox.clear();
				    searchBox.sendKeys("Game Testing");

				    // Optionally hide keyboard (sometimes helps)
				    try {
				        driver.hideKeyboard();
				    } catch (Exception e) {
				        // Keyboard might already be hidden, ignore
				    }

				    // Now wait for the search result
				    By resultLocator = By.xpath("//android.widget.TextView[contains(@text, 'Game Testing')]");
				    try {
				        wait.until(ExpectedConditions.visibilityOfElementLocated(resultLocator));
				        System.out.println("✅ 'Game Testing' is displayed in search results.");
				    } catch (TimeoutException e) {
				        Assert.fail("❌ 'Gaming Testing' not found in search results.");
				    }

		}
	  @Test(priority = 7)
	  public void TC_I11_VerifyInspection_CountOnDashboard()
	  {

		  Dashboard db = new Dashboard(driver);
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Click on Inspection Scheduled Tab (if needed)
		    wait.until(ExpectedConditions.elementToBeClickable(db.getInspectionScheduledTab()));

		    try {
		        // Locate the sibling count element next to 'Scheduled'
		        By scheduledCountLocator = By.xpath("//android.widget.TextView[@text='Scheduled']/following-sibling::android.widget.TextView");

		        // Wait for it to be visible
		        WebElement countElement = wait.until(ExpectedConditions.visibilityOfElementLocated(scheduledCountLocator));

		        // Extract the dynamic text (count)
		        String countText = countElement.getText();
		        System.out.println("✅ Scheduled Inspection Count: " + countText);

		        // Basic assertion: the element should be visible and count should be numeric
		        Assert.assertTrue(countElement.isDisplayed(), "✅ Count element is displayed");
		        Assert.assertTrue(countText.matches("\\d+"), "✅ Count is a valid number");

		    } catch (TimeoutException e) {
		        Assert.fail("❌ 'Scheduled' count not found next to label.");
		    }
	  }
	  
}
