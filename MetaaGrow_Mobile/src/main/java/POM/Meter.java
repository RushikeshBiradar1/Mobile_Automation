package POM;

import java.time.Duration;

import org.apache.xmlbeans.impl.jam.mutable.MElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class Meter {
	
	//Initialization
	public Meter(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Declaration
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup[1]")private WebElement MeterScheduleTab;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search\"]")private WebElement SearchMeterNameBox;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement MeterReadingIcon;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Claw Machine 1 Meter\"]")private WebElement ClawMachineMeter;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add Reading\"]")private WebElement AddReading;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Claw Machine 1 Meter\"]")private WebElement ClawMeterNameInDetailPage;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Enter meter reading (GHz)\"]")private WebElement EnterReading;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Attach Image\"]")private WebElement AttachImageOn_AddMeterReadingPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add Reading\"]")private WebElement AddReadingButton;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.ImageView")private WebElement CrossSignOnAddMeterReadingPage;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement YesButton_OnSaveThisReadingPopup;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")private WebElement CancelButton_OnSaveThisReadingPopup;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView")private WebElement DeleteLatestReading_CrossSign;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement YesButton_OnDeleteReadingPopup;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement CancelButton_OnDeleteReadingPopup;
	
	//Getters Methods
	public WebElement getMeterScheduleTab() {
		return MeterScheduleTab;
	}
	public WebElement getSearchMeterNameBox() {
		return SearchMeterNameBox;
	}
	public WebElement getMeterReadingIcon() {
		return MeterReadingIcon;
	}
	public WebElement getClawMachineMeter() {
		return ClawMachineMeter;
	}
	public WebElement getAddReading() {
		return AddReading;
	}
	public WebElement getClawMeterNameInDetailPage() {
		return ClawMeterNameInDetailPage;
	}
	public WebElement getEnterReading() {
		return EnterReading;
	}
	public WebElement getAttachImageOn_AddMeterReadingPage() {
		return AttachImageOn_AddMeterReadingPage;
	}
	public WebElement getAddReadingButton() {
		return AddReadingButton;
	}
	public WebElement getCrossSignOnAddMeterReadingPage() {
		return CrossSignOnAddMeterReadingPage;
	}
	public WebElement getYesButton_OnSaveThisReadingPopup() {
		return YesButton_OnSaveThisReadingPopup;
	}
	public WebElement getCancelButton_OnSaveThisReadingPopup() {
		return CancelButton_OnSaveThisReadingPopup;
	}
	public WebElement getDeleteLatestReading_CrossSign() {
		return DeleteLatestReading_CrossSign;
	}
	public WebElement getYesButton_OnDeleteReadingPopup() {
		return YesButton_OnDeleteReadingPopup;
	}
	public WebElement getCancelButton_OnDeleteReadingPopup() {
		return CancelButton_OnDeleteReadingPopup;
	}
	
	//Business Logic
	public void CLickON_MeterScheduleTab()
	{
		MeterScheduleTab.click();
	}
	public void CLickOn_SearchMeterNameBox(String Enter_MeterName)
	{
		SearchMeterNameBox.sendKeys(Enter_MeterName);
	}
	public void ClickOn_MeterReadingIcon()
	{
		MeterReadingIcon.click();
	}
	public void CLickOn_ClawMachineMeter()
	{
		ClawMachineMeter.click();
	}
	public void CLickOn_AddReading()
	{
		AddReading.click();
	}
	public void Verify_ClawMeterNameInDetailPage() {
		Assert.assertTrue(ClawMeterNameInDetailPage.isDisplayed(), "ClawMeter Is not showing in detail page");
	}
	public void ClickOn_EnterReading(int newReading) {
	    // Convert the integer to a string and send it
	    EnterReading.sendKeys(String.valueOf(newReading));
	}
	public void ClickcOn_AttachImageOn_AddMeterReadingPage()
	{
		AttachImageOn_AddMeterReadingPage.click();
		
	}
	public void ClickOn_AddReadingButton()
	{
		AddReadingButton.click();
	}
	public void ClickOn_CrossSignOnAddMeterReadingPage()
	{
		CrossSignOnAddMeterReadingPage.click();
	}
	public void CLickOn_YesButton_OnSaveThisReadingPopup()
	{
		YesButton_OnSaveThisReadingPopup.click();
	}
	public void ClickOn_CancelButton_OnSaveThisReadingPopup()
	{
		CancelButton_OnSaveThisReadingPopup.click();
	}
	public void ClickOn_DeleteLatestReading_CrossSign()
	{
		DeleteLatestReading_CrossSign.click();
	}
	public void CLickOn_YesButton_OnDeleteReadingPopup()
	{
		YesButton_OnDeleteReadingPopup.click();
	}
	public void CLickOn_CancelButton_OnDeleteReadingPopup()
	{
		CancelButton_OnDeleteReadingPopup.click();
	}
	


	public void scrollToElement(AndroidDriver driver) {
	    Dimension size = driver.manage().window().getSize();
	    int startY = (int) (size.height * 0.8);
	    int endY = (int) (size.height * 0.2);
	    int startX = size.width / 2;

	    while (true) {
	        try {
	            WebElement element = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\\\"android:id/content\\\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView"));
	            if (element.isDisplayed()) {
//	            	element.click();
	                break;
	            }
	        } catch (Exception e) {
	            new TouchAction(driver)
	                .press(PointOption.point(startX, startY))
	                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                .moveTo(PointOption.point(startX, endY))
	                .release()
	                .perform();
	        }
	    }
	}


}
