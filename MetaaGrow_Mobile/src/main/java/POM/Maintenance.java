package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import General_Utility.Scroll;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Maintenance {
	
	//Initialization
	public Maintenance(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Declaration
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]")private WebElement ScheduledTabOn_Dashboard;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]")private WebElement OverdueTabOn_Dashboard;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")private WebElement FirstPMChecklist;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Overdue\"]")private WebElement OverdueTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Today's\"]")private WebElement TodaysTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Upcoming\"]")private WebElement UpcomingTab;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\\\"android:id/content\\\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[4]")private WebElement FinishedTab;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement PMCalender;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search\"]")private WebElement SearchBox;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Preventive Maintenance\"]")private WebElement PreventiveMaintenanceHeader;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Build, plan and schedule everything needed to keep your asset running smoothly.\"]")private WebElement BuildPlanandscheduleTest;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Maintenance\"]")private WebElement MaintenanceTitle;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ImageView")private WebElement AdhocPM;
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Yes\"])[1]")private WebElement YesResponsefirstChecklist;
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"No\"])[1]")private WebElement No_ResponseFirstChecklist;
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"NA\"])[3]")private WebElement NA_ResponseFirstChecklist;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\" Finish Maintenance\"]")private WebElement Finish_MaintenanceButton;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")private WebElement ChecklistDropdown;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement BackButton;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Enter here...\"]")private WebElement  RemarkField;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup")private WebElement SelectUsersPerformingThisTaskDropdown;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")private WebElement ActionIconFirst;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search\"]")private WebElement SearchField_OnPM_AllTabs;
	
	
	
	//Getters Methods
	public WebElement getScheduledTabOn_Dashboard() {
		return ScheduledTabOn_Dashboard;
	}
	public WebElement getSearchField_OnPM_AllTabs() {
		return SearchField_OnPM_AllTabs;
	}
	public WebElement getOverdueTabOn_Dashboard() {
		return OverdueTabOn_Dashboard;
	}
	public WebElement getFirstPMChecklist() {
		return FirstPMChecklist;
	}
	public WebElement getOverdueTab() {
		return OverdueTab;
	}
	public WebElement getTodaysTab() {
		return TodaysTab;
	}
	public WebElement getUpcomingTab() {
		return UpcomingTab;
	}
	public WebElement getFinishedTab() {
		return FinishedTab;
	}
	public WebElement getPMCalender() {
		return PMCalender;
	}
	public WebElement getSearchBox() {
		return SearchBox;
	}
	public WebElement getPreventiveMaintenanceHeader() {
		return PreventiveMaintenanceHeader;
	}
	public WebElement getBuildPlanandscheduleTest() {
		return BuildPlanandscheduleTest;
	}
	public WebElement getMaintenanceTitle() {
		return MaintenanceTitle;
	}
	public WebElement getAdhocPM() {
		return AdhocPM;
	}
	public WebElement getYesResponsefirstChecklist() {
		return YesResponsefirstChecklist;
	}
	public WebElement getNo_ResponseFirstChecklist() {
		return No_ResponseFirstChecklist;
	}
	public WebElement getNA_ResponseFirstChecklist() {
		return NA_ResponseFirstChecklist;
	}
	public WebElement getFinish_MaintenanceButton() {
		return Finish_MaintenanceButton;
	}
	public WebElement getChecklistDropdown() {
		return ChecklistDropdown;
	}
	public WebElement getBackButton() {
		return BackButton;
	}
	public WebElement getRemarkField() {
		return RemarkField;
	}
	public WebElement getSelectUsersPerformingThisTaskDropdown() {
		return SelectUsersPerformingThisTaskDropdown;
	}
	public WebElement getActionIconFirst() {
		return ActionIconFirst;
	}

	//Business Logic
	public void ClickOn_FirstPMChecklist()
	{
		FirstPMChecklist.click();
	}
	public void ClickOn_OverdueTab()
	{
		OverdueTab.click();
	}
	public void ClickOn_TodaysTab()
	{
		TodaysTab.click();
	}
	public void ClickOn_UpcomingTab()
	{
		UpcomingTab.click();
	}
	public void ClickOn_FinishedTab()
	{
		FinishedTab.click();
	}
	public void ClickOn_PMCalender()
	{
		PMCalender.click();
	}
	public void Clickon_SearchBox()
	{
		SearchBox.click();
	}
	public void Verify_PreventiveMaintenanceHeader(WebDriver driver)
	{
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    // Wait for the "Hi Biradar!" text to be visible after login
		    WebElement welcomeText = wait.until(ExpectedConditions.visibilityOf(PreventiveMaintenanceHeader));

		    // Assert that the text is displayed correctly
		    Assert.assertTrue(welcomeText.isDisplayed(), "Welcome text is not displayed. Login might have failed.");

		    System.out.println("Login successful, Welcome text is displayed!");

		} catch (Exception e) {
		    // Handle exception if element is not found or is not displayed
		    e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}
	}
	public void Verify_BuildPlanandscheduleText(WebDriver driver)
	{
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    // Wait for the "Hi Biradar!" text to be visible after login
		    WebElement welcomeText = wait.until(ExpectedConditions.visibilityOf(BuildPlanandscheduleTest));

		    // Assert that the text is displayed correctly
		    Assert.assertTrue(welcomeText.isDisplayed(), "BuildPlanandscheduleTest text is not displayed. Login might have failed.");

		    System.out.println("Login successful, Welcome text is displayed!");

		} catch (Exception e) {
		    // Handle exception if element is not found or is not displayed
		    e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}
	}
	public void verify_MaintenanceTitle(WebDriver driver)
	{
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    // Wait for the "Hi Biradar!" text to be visible after login
		    WebElement welcomeText = wait.until(ExpectedConditions.visibilityOf(MaintenanceTitle));

		    // Assert that the text is displayed correctly
		    Assert.assertTrue(welcomeText.isDisplayed(), "Maintenance Title text is not displayed. Login might have failed.");

		    System.out.println("Login successful, Welcome text is displayed!");

		} catch (Exception e) {
		    // Handle exception if element is not found or is not displayed
		    e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}
	}
	public void clickon_AdhocPM()
	{
		AdhocPM.click();
	}
	public void ClickOn_YesResponsefirstChecklist()
	{
		YesResponsefirstChecklist.click();
	}
	public void ClicKOn_No_ResponseFirstChecklist()
	{
		No_ResponseFirstChecklist.click();
	}
	public void ClickOn_NA_ResponseFirstChecklist()
	{
		NA_ResponseFirstChecklist.click();
	}
	public void ClickOn_Finish_MaintenanceButton()
	{
		Finish_MaintenanceButton.click();
	}
	public void ClickOn_ChecklistDropdown()
	{
		ChecklistDropdown.click();
	}
	public void ClickOn_BackButton()
	{
		BackButton.click();
	}
	public void ClickOn_RemarkField(String Enter_Remark)
	{
		RemarkField.sendKeys(Enter_Remark);
	}
	public void ClickOn_SelectUsersPerformingThisTaskDropdown(WebDriver driver, String User_Name)
	{
		
		Scroll sc = new Scroll();
		sc.ScrollUsingText(driver, "Raj");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait until the dropdown element is clickable
	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(SelectUsersPerformingThisTaskDropdown));

	    // Click the dropdown to open it
	    dropdown.click();

	    try {
	        // Scroll to the user in the dropdown
	        String uiScrollable = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + User_Name + "\"))";
	        driver.findElement(MobileBy.AndroidUIAutomator(uiScrollable));

	        // Now locate the user element after scrolling
	        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='" + User_Name + "']")));

	        // Click to select the user
	        user.click();
	        
	     // Click the dropdown to close it 
		    dropdown.click();
	    } catch (Exception e) {
	        System.out.println("User selection failed for: " + User_Name + " - " + e.getMessage());
	    }
	}
	public void ClickOn_ActionIconFirst()
	{
		ActionIconFirst.click();
	}
	public void ClickOn_SearchField_OnPM_AllTabs(String Search_PM_Name)
	{
		SearchField_OnPM_AllTabs.sendKeys(Search_PM_Name);
	}

}
