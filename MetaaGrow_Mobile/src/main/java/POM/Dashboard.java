package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Dashboard {
	//initialization
	public Dashboard(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Declaration
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Hi Jaxon Brown! Welcome to Pixel Paradise \"]")private WebElement WelcomeText;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Here is your task for today.\"]")private WebElement HereisyourTaskText;
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Scheduled\"])[1]")private WebElement InspectionScheduledTab;;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Open Tickets']/ancestor::android.view.ViewGroup[1]")private WebElement OpenTicketsTab;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]")private WebElement ParkedTicketsTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\" Dashboard\"]")private WebElement DashboardText;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]")private WebElement MeterScheduled;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]")private WebElement MeterOverdue;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup")private WebElement PAT;
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Scheduled\"])[4]")private WebElement TPI;
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Schedule, tab, 2 of 4\"]/android.view.ViewGroup/android.widget.ImageView")private WebElement InspectionBottomIcon;
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Overview, tab, 1 of 4\"]/android.view.ViewGroup")private WebElement HomeIconAtBottom;
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Ticket, tab, 3 of 4\"]/android.view.ViewGroup/android.widget.ImageView")private WebElement TicketsIconAtBottom;
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Synccit, tab, 4 of 4\"]/android.view.ViewGroup")private WebElement AssetIconAtBottom;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement ClusterDashboardIcon;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement OverallCalenderIcon;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement NotificationIcon;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.View")private WebElement HumburgerIcon;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.ImageView")private WebElement OverallScannerIcon;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Change Property\"]")private WebElement ChangePropertyText;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Support\"]")private WebElement SupportText;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]")private WebElement LogoutText;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement YesButton_LogoutPopup;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")private WebElement CancelButtonOn_LogoutPopup;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")private WebElement LogoutPopup;
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Scheduled\"])[2]")private WebElement ScheduledPM;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]")private WebElement OverduePM;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ImageView")private WebElement AdhocPM;
//	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private  WebElement MenuhamburgerIcon;
//	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Change Property\"]")private WebElement ChangePropertyText;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")private WebElement LogoutIcon_OnHome;
	
	public WebElement getLogoutIcon_OnHome() {
		return LogoutIcon_OnHome;
	}
	public WebElement getScheduledPM() {
		return ScheduledPM;
	}
	public WebElement getOverduePM() {
		return OverduePM;
	}
	public WebElement getAdhocPM() {
		return AdhocPM;
	}
	//Getters
	public WebElement getWelcomeText() {
		return WelcomeText;
	}
	public WebElement getHereisyourTaskText() {
		return HereisyourTaskText;
	}
	public WebElement getInspectionScheduledTab() {
		return InspectionScheduledTab;
	}
	public WebElement getOpenTicketsTab() {
		return OpenTicketsTab;
	}
	public WebElement getParkedTicketsTab() {
		return ParkedTicketsTab;
	}
	public WebElement getDashboardText() {
		return DashboardText;
	}
	public WebElement getMeterScheduled() {
		return MeterScheduled;
	}
	public WebElement getMeterOverdue() {
		return MeterOverdue;
	}
	public WebElement getPAT() {
		return PAT;
	}
	public WebElement getTPI() {
		return TPI;
	}
	public WebElement getInspectionBottomIcon() {
		return InspectionBottomIcon;
	}
	public WebElement getHomeIconAtBottom() {
		return HomeIconAtBottom;
	}
	public WebElement getTicketsIconAtBottom() {
		return TicketsIconAtBottom;
	}
	public WebElement getAssetIconAtBottom() {
		return AssetIconAtBottom;
	}
	public WebElement getClusterDashboardIcon() {
		return ClusterDashboardIcon;
	}
	public WebElement getOverallCalenderIcon() {
		return OverallCalenderIcon;
	}
	public WebElement getNotificationIcon() {
		return NotificationIcon;
	}
	public WebElement getHumburgerIcon() {
		return HumburgerIcon;
	}
	public WebElement getOverallScannerIcon() {
		return OverallScannerIcon;
	}
	public WebElement getChangePropertyText() {
		return ChangePropertyText;
	}
	public WebElement getSupportText() {
		return SupportText;
	}
	public WebElement getLogoutText() {
		return LogoutText;
	}
	public WebElement getYesButton_LogoutPopup() {
		return YesButton_LogoutPopup;
	}
	public WebElement getCancelButtonOn_LogoutPopup() {
		return CancelButtonOn_LogoutPopup;
	}
	public WebElement getLogoutPopup() {
		return LogoutPopup;
	}
	
	//Business Logic
	public void CheckWelcomeTextDisplay(WebDriver driver)
	{
		try {
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		        // Wait for the "Hi Biradar!" text to be visible after login
		        wait.until(ExpectedConditions.visibilityOf(WelcomeText));

		        // Get the actual text from the element
		        String actualText = WelcomeText.getText().trim();
		        
		        // Print out the actual text for debugging
		        System.out.println("Actual text from the WelcomeText: " + actualText);
		        
		        // Define the expected text
		        String expectedText = "Hi Jaxon Brown! Welcome to Pixel Paradise"; // You can dynamically update this for different users

		        // Assert that the WelcomeText matches the expected text after login
		        Assert.assertEquals(actualText, expectedText, "Welcome text is incorrect. Login might have failed.");
		        
		        System.out.println("Login successful, Welcome text is displayed correctly!");

		} catch (Exception e) {
		    // Handle exception if element is not found or is not displayed
		    e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}

	}
	public void CheckHereisyourTaskText(WebDriver driver)
	{
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    // Wait for the "Hi Biradar!" text to be visible after login
		    WebElement welcomeText = wait.until(ExpectedConditions.visibilityOf(HereisyourTaskText));

		    // Assert that the text is displayed correctly
		    Assert.assertTrue(welcomeText.isDisplayed(), "Welcome text is not displayed. Login might have failed.");

		    System.out.println("Login successful, Welcome text is displayed!");

		} catch (Exception e) {
		    // Handle exception if element is not found or is not displayed
		    e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}
	}

	public void ClickOn_InspectionScheduledTab()
	{
		InspectionScheduledTab.click();
	}
	public void CLickOn_OpenTicketsTab()
	{
		OpenTicketsTab.click();
	}
	public void ClickOn_ParkedTicketsTab()
	{
		ParkedTicketsTab.click();
	}
	public void VerifyDashboardTextDisplay(WebDriver driver)
	{
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    // Wait for the "Hi Biradar!" text to be visible after login
		    WebElement DashboardText1 = wait.until(ExpectedConditions.visibilityOf(DashboardText));

		    // Assert that the text is displayed correctly
		    Assert.assertTrue(DashboardText1.isDisplayed(), "Dashboard Text is not displayed. Login might have failed.");

		    System.out.println("Login successful, Welcome text is displayed!");

		} catch (Exception e) {
		    // Handle exception if element is not found or is not displayed
		    e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}
	}
	public void ClickOn_MeterScheduled()
	{
		MeterScheduled.click();
	}
	public void ClickOn_MeterOverdue()
	{
		MeterOverdue.click();
	}
	public void ClickOn_PAT()
	{
		PAT.click();
	}
	public void ClickOn_TPI()
	{
		TPI.click();
	}
	public void ClickOn_InspectionBottomIcon()
	{
		InspectionBottomIcon.click();
	}
	public void ClickOn_HomeIconAtBottom()
	{
		HomeIconAtBottom.click();
	}
	public void ClickOn_TicketsIconAtBottom()
	{
		TicketsIconAtBottom.click();
	}
	public void ClickOn_AssetIconAtBottom()
	{
		AssetIconAtBottom.click();
	}
	public void ClickOn_ClusterDashboardIcon()
	{
		ClusterDashboardIcon.click();
	}
	public void ClickOn_OverallCalenderIcon()
	{
		OverallCalenderIcon.click();
	}
	public void ClickOn_NotificationIcon()
	{
		NotificationIcon.click();
	}
	public void ClickOn_HumburgerIcon()
	{
		HumburgerIcon.click();
	}
	public void ClickOn_OverallScannerIcon()
	{
		OverallScannerIcon.click();
	}
	public void ClickOn_ChangePropertyText()
	{
		ChangePropertyText.click();
	}
	public void ClickOn_SupportText()
	{
		SupportText.click();
	}
	public void ClickOn_LogoutText()
	{
		LogoutText.click();
	}
	public void ClickOn_YesButton_LogoutPopup()
	{
		YesButton_LogoutPopup.click();
	}
	public void CLickOn_CancelButtonOn_LogoutPopup()
	{
		CancelButtonOn_LogoutPopup.click();
	}
	public void verifyLogotPopup(WebDriver driver)
	{
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    // Wait for the "Logout" text to be visible after login
		    WebElement welcomeText = wait.until(ExpectedConditions.visibilityOf(LogoutPopup));

		    // Assert that the Logout text is displayed correctly
		    Assert.assertTrue(welcomeText.isDisplayed(), "Welcome text is not displayed. Login might have failed.");

		    System.out.println("Login successful, Welcome text is displayed!");

		} catch (Exception e) {
		    // Handle exception if element is not found or is not displayed
		    e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}
	}
	public void ClickOn_ScheduledPM()
	{
		ScheduledPM.click();
	}
	public void ClickOn_OverduePM()
	{
		OverduePM.click();
	}
	public void ClickOn_AdhocPM()
	{
		AdhocPM.click();
	}
	public void clickOn_LogoutIcon_OnHome()
	{
		LogoutIcon_OnHome.click();
	}
	
	

}
