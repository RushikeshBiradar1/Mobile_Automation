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

import General_Utility.B2;
import General_Utility.BaseClass;
import General_Utility.Java_RandomNumber;
import General_Utility.Scroll;
import POM.Dashboard;
import POM.Inspection;
import POM.Tickets;
import io.appium.java_client.MobileBy;

public class AttachImagesTest extends B2 {

		  @Test(priority = 1)
		    public void Fire_and_Electrical_SixAttachImageTest_TC_I04() throws Throwable {

			  Dashboard db = new Dashboard(driver);
			  Thread.sleep(2000);
			  db.ClickOn_InspectionScheduledTab();
	  Thread.sleep(2000);
			 Inspection inspection = new Inspection(driver);

			// Wait for inspection list to load
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    // Ensure there is a scrollable view
			    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Fire and Electrical\"))";

			    // Wait for scroll to complete
			    wait.until(ExpectedConditions.presenceOfElementLocated(
			        MobileBy.AndroidUIAutomator(uiScrollable)));

			    // Find and click the element
			    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
			    wait.until(ExpectedConditions.visibilityOf(targetElement));
			    targetElement.click();
			    
			    
			    //Click On Section in Checklist
//				 inspection.ClickOn_SectionDropdowIco_OnChecklistDetails();
				 
				 Thread.sleep(2000);
				Images5 im = new Images5();
				im.testcheck();
				
				
				System.out.println("Successfully attached 6 image to checklist");
				
//			Random random = new Random();
//			int totalQuestions = 15;
//			int answeredQuestions = 0;

		
			
//			while (answeredQuestions < totalQuestions) {
//				try {
//					// Fetch fresh list of Yes/No/NA buttons AFTER scrolling
//					List<WebElement> yesButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='Yes']"));
//					List<WebElement> noButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='No']"));
//					List<WebElement> naButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='N/A']"));
//
//					int visibleQuestions = yesButtons.size(); // Number of visible questions at this moment
//
//					for (int i = 0; i < visibleQuestions && answeredQuestions < totalQuestions; i++) {
//						WebElement selectedElement = null;
//						int randomChoice = random.nextInt(3); // 0 = Yes, 1 = No, 2 = N/A
//
//						if (randomChoice == 0 && i < yesButtons.size()) {
//							selectedElement = yesButtons.get(i);
//							System.out.println("Selected 'Yes' for question " + (answeredQuestions + 1));
//						} else if (randomChoice == 1 && i < noButtons.size()) {
//							selectedElement = noButtons.get(i);
//							System.out.println("Selected 'No' for question " + (answeredQuestions + 1));
//						} else if (randomChoice == 2 && i < naButtons.size()) {
//							selectedElement = naButtons.get(i);
//							System.out.println("Selected 'N/A' for question " + (answeredQuestions + 1));
//						} else {
//							// Fallback to any available button
//							if (i < yesButtons.size()) {
//								selectedElement = yesButtons.get(i);
//								System.out.println("Fallback: Selected 'Yes' for question " + (answeredQuestions + 1));
//							} else if (i < noButtons.size()) {
//								selectedElement = noButtons.get(i);
//								System.out.println("Fallback: Selected 'No' for question " + (answeredQuestions + 1));
//							} else if (i < naButtons.size()) {
//								selectedElement = naButtons.get(i);
//								System.out.println("Fallback: Selected 'N/A' for question " + (answeredQuestions + 1));
//							}
//						}
//
//						// Click the selected element
//						if (selectedElement != null) {
//							wait.until(ExpectedConditions.elementToBeClickable(selectedElement));
//							selectedElement.click();
//							answeredQuestions++;  // Increment global counter
//						}
//
//						if (answeredQuestions >= totalQuestions) break;
//					}
//
//					// If we still need to answer more questions, scroll and retry
//					if (answeredQuestions < totalQuestions) {
//						System.out.println("Scrolling to next set of questions...");
//						String scrollCommand = "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()";
//						driver.findElement(MobileBy.AndroidUIAutomator(scrollCommand));
//						Thread.sleep(1500);  // Allow UI to refresh
//
//						// Double-check if new questions actually appeared
//						List<WebElement> checkNewQuestions = driver.findElements(By.xpath("//android.widget.TextView[@text='Yes']"));
//						if (checkNewQuestions.size() < 2 && answeredQuestions < totalQuestions) {
//							System.out.println("Retrying scroll to ensure last questions are loaded...");
//							driver.findElement(MobileBy.AndroidUIAutomator(scrollCommand));
//							Thread.sleep(1500);
//						}
//					}
//
//				} catch (Exception e) {
//					System.out.println("Error selecting response for question " + (answeredQuestions + 1) + ": " + e.getMessage());
//					break;
//				}
//			}
//
//			System.out.println("All 12 questions answered successfully.");
////			Scroll sc = new Scroll();
////			   sc.ScrollUsingText(driver, " Save");
//
////			  inspection.CLickOn_SaveButtonInspection_OnInspectionChecklist();
//			  inspection.ClickOn_SaveAndSubmitButton();    
//			    System.out.println("Checklist Saved Successfully");
//			    
//			 // Wait for the Completed tab to load before clicking
//			    wait.until(ExpectedConditions.presenceOfElementLocated(
//			        MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Completed\")")));
//
//			    // Navigate to the Completed tab
//			    inspection.clickOn_CompletedTab();
//
////			    // Ensure the inspection appears in the Completed tab
//			    // Wait for scroll to complete
//			    wait.until(ExpectedConditions.presenceOfElementLocated(
//			        MobileBy.AndroidUIAutomator(uiScrollable)));
//
//			    // Find the inspection element in Completed tab
//			    WebElement completedInspection = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
//			    wait.until(ExpectedConditions.visibilityOf(completedInspection));
//
//			    // Verify the inspection is displayed in the Completed tab
//			    Assert.assertTrue(completedInspection.isDisplayed(), "Inspection is not showing in the Completed tab!");
//
//			    System.out.println("Inspection successfully moved to the Completed tab.");
    
		  }
		  
		  @Test(priority = 2)
		  public void Daily_Scoreboard_InspectionWithActionPopup_Remark_and_TicketTest_TC_I02() throws Throwable
		  {
		  
			  Dashboard db = new Dashboard(driver);
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.elementToBeClickable(  db.getInspectionScheduledTab())).click();
//			  db.ClickOn_InspectionScheduledTab();
	  
			 Inspection inspection = new Inspection(driver);

			// Wait for inspection list to load
//			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			    // Ensure there is a scrollable view
			    String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Fire and Electrical\"))";

			    // Wait for scroll to complete
			    wait.until(ExpectedConditions.presenceOfElementLocated(
			        MobileBy.AndroidUIAutomator(uiScrollable)));

			    // Find and click the element
			    WebElement targetElement = driver.findElement(MobileBy.androidUIAutomator(uiScrollable));
			    wait.until(ExpectedConditions.visibilityOf(targetElement));
			    targetElement.click();
			    
   	        String actionButtonXPath3 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";

      	      WebElement actionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actionButtonXPath3)));
      	    actionButton.click();

      	      
      	    inspection.ClickOn_RaiseTicketButton_OnActionPopup();
      	  Tickets tkt = new Tickets(driver);
      		tkt.ClickOn_AllowMetaagrowTORecordAudio_WhileUsingApp_Popup();
    		tkt.ClickOn_AllowPhotoAndMediaButton();
    		Thread.sleep(3000);
    		tkt.ClickOn_SelectTypeDropdown();
    		tkt.CLickOn_SelectGeneralTyep();
    		Java_RandomNumber java = new Java_RandomNumber();
    		int ran = java.getRandomNum();
    		String TicketTitle="Switch Board Issue at line "+ran;
    		tkt.CLickOn_TicketTitle_TextField(TicketTitle);
    		// Wait for the element to be clickable and click it
    		
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"))).click();
    	
//    		driver.findElement(By.xpath("//android.widget.TextView[@text='Select Department']")).click();

    		// Wait for the next element or any necessary condition before performing the next action
    		tkt.CLickOn_TechincalDepartmentName();

    		// Wait for the same element again before clicking it
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup"))).click();
    		
//    		driver.findElement(By.xpath("//android.widget.TextView[@text='Select Department']")).click();
    		tkt.CLickOn_SelectUsersDropdown();
    		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Mayur\"]")).click();
    		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Fernandes\"]")).click();
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[1]/android.widget.ImageView"))).click();
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Select Priority\"]"))).click();

    		//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.ImageView
    		tkt.CLickoN_MediumTicket();
    		tkt.CLickOn_RaiseTicketButton_OnRaiseTicketPage();
    	
      	    
      	      
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
			Thread.sleep(1000);
    		
    		 String actionButtonXPath12 = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[12]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView";
                                           
     	      WebElement actionButton12 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(actionButtonXPath12)));
     	    actionButton12.click();
     	    inspection.ClickON_AddRemarkButton_OnActionPopup();
     	 
     	  inspection.ClickOn_EnterRemarkOn_Inspection("Added Remark Check");
     	  inspection.ClickOn_SubmitButton_OnRemark();
    		
    		
    		

			System.out.println("All 12 questions answered successfully.");

			
			wait.until(ExpectedConditions.elementToBeClickable(inspection.getSaveAndSubmitButton())).click();
			  
//			  inspection.ClickOn_SaveAndSubmitButton();
			
			    System.out.println("Checklist Saved Successfully");
			    
			 // Wait for the Completed tab to load before clicking
			    wait.until(ExpectedConditions.presenceOfElementLocated(
			        MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Completed\")")));

			    // Navigate to the Completed tab
			    inspection.clickOn_CompletedTab();

//			    // Ensure the inspection appears in the Completed tab
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
