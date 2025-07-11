package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TPI {

	//initialiazation
	public TPI(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//Declaration
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Today's\"]")private WebElement TodaysTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Completed\"]")private WebElement CompletedTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Upcoming\"]")private WebElement UpcomingTab;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search\"]")private WebElement SearchBox_OnListingPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Third Party Inspection (TPI)\"]")private WebElement TPIHeader;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement BackButton_OnTPIListing;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")private WebElement FirstTPIOnTodays;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Click To Start\"]")private WebElement ClickOnStartButton;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement YesButton_OnAreYouWantToStartTPI;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")private WebElement NoButton_OnAreYouWantToStartTPI;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement OkButton_OnTPIStartedSuccessfullyPopup;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Click To Finish\"]")private WebElement ClickOnFinishButton;
	@AndroidFindBy(xpath = "(//android.widget.EditText[@text=\"Enter here...\"])[1]")private WebElement InspectionVendor;
	@AndroidFindBy(xpath = "(//android.widget.EditText[@text=\"Enter here...\"])[2]")private WebElement RemarkOnTPIFinishPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Attach Image\"]")private WebElement AttachImageIconOnTPIFinishPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Attach Video\"]")private WebElement AttachVideoIconOnTPIFinishPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")private WebElement SubmitButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cancel\"]")private WebElement CancelButton;
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Shutter\"]")private WebElement CameraShuuterButton;
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Done\"]")private WebElement DoneRightIcon_OnCameraPage;
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Cancel\"]")private WebElement CancelImageIcon_OnCameraPage;
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Retake\"]")private WebElement RetakeIcon_OnCameraPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save\"]")private WebElement SaveButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Clear\"]")private WebElement ClearButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Undo\"]")private WebElement UndoButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Close\"]")private WebElement CloseButton;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Shutter\"]")private WebElement RecordVideoButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement YesButton_OnAreYouSureWanttoFinishTPI;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")private WebElement NoButton_OnAreYouSureWanttoFinishTPI;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"View\"]")private WebElement ViewButton_OnCompletedTab;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement ImageAttached_OnCompletedTPI_PreviewPage;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")private WebElement AllowMetaagrowTORecordAudio_WhileUsingApp_Popup;
    @AndroidFindBy(id = "com.android.camera:id/shutter_button")private WebElement CameraShuuterButtonVivo;
    @AndroidFindBy(id ="com.android.camera:id/done_button")private WebElement DoneRightIcon_OnCameraPageVivo;
   
    public WebElement getCameraShuuterButtonVivo() {
		return CameraShuuterButtonVivo;
	}
	public WebElement getDoneRightIcon_OnCameraPageVivo() {
		return DoneRightIcon_OnCameraPageVivo;
	}
	public WebElement getAllowMetaagrowTORecordAudio_WhileUsingApp_Popup() {
		return AllowMetaagrowTORecordAudio_WhileUsingApp_Popup;
	}
	//Getters
    public WebElement getTodaysTab() {
		return TodaysTab;
	}
	public WebElement getCompletedTab() {
		return CompletedTab;
	}
	public WebElement getUpcomingTab() {
		return UpcomingTab;
	}
	public WebElement getSearchBox_OnListingPage() {
		return SearchBox_OnListingPage;
	}
	public WebElement getTPIHeader() {
		return TPIHeader;
	}
	public WebElement getBackButton_OnTPIListing() {
		return BackButton_OnTPIListing;
	}
	public WebElement getFirstTPIOnTodays() {
		return FirstTPIOnTodays;
	}
	public WebElement getClickOnStartButton() {
		return ClickOnStartButton;
	}
	public WebElement getYesButton_OnAreYouWantToStartTPI() {
		return YesButton_OnAreYouWantToStartTPI;
	}
	public WebElement getNoButton_OnAreYouWantToStartTPI() {
		return NoButton_OnAreYouWantToStartTPI;
	}
	public WebElement getOkButton_OnTPIStartedSuccessfullyPopup() {
		return OkButton_OnTPIStartedSuccessfullyPopup;
	}
	public WebElement getClickOnFinishButton() {
		return ClickOnFinishButton;
	}
	public WebElement getInspectionVendor() {
		return InspectionVendor;
	}
	public WebElement getRemarkOnTPIFinishPage() {
		return RemarkOnTPIFinishPage;
	}
	public WebElement getAttachImageIconOnTPIFinishPage() {
		return AttachImageIconOnTPIFinishPage;
	}
	public WebElement getAttachVideoIconOnTPIFinishPage() {
		return AttachVideoIconOnTPIFinishPage;
	}
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	public WebElement getCancelButton() {
		return CancelButton;
	}
	public WebElement getCameraShuuterButton() {
		return CameraShuuterButton;
	}
	public WebElement getDoneRightIcon_OnCameraPage() {
		return DoneRightIcon_OnCameraPage;
	}
	public WebElement getCancelImageIcon_OnCameraPage() {
		return CancelImageIcon_OnCameraPage;
	}
	public WebElement getRetakeIcon_OnCameraPage() {
		return RetakeIcon_OnCameraPage;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	public WebElement getClearButton() {
		return ClearButton;
	}
	public WebElement getUndoButton() {
		return UndoButton;
	}
	public WebElement getCloseButton() {
		return CloseButton;
	}
	public WebElement getRecordVideoButton() {
		return RecordVideoButton;
	}
	public WebElement getYesButton_OnAreYouSureWanttoFinishTPI() {
		return YesButton_OnAreYouSureWanttoFinishTPI;
	}
	public WebElement getNoButton_OnAreYouSureWanttoFinishTPI() {
		return NoButton_OnAreYouSureWanttoFinishTPI;
	}
	public WebElement getViewButton_OnCompletedTab() {
		return ViewButton_OnCompletedTab;
	}
	public WebElement getImageAttached_OnCompletedTPI_PreviewPage() {
		return ImageAttached_OnCompletedTPI_PreviewPage;
	}
    
	//Business Logic
	public void ClickOn_TodaysTab()
	{
		TodaysTab.click();
	}
	public void ClickOn_CompletedTab()
	{
		CompletedTab.click();
	}
	public void ClickOn_UpcomingTab()
	{
		UpcomingTab.click();
	}
	public void ClickOn_SearchBox_OnListingPage(String Search_TPI)
	{
		SearchBox_OnListingPage.sendKeys(Search_TPI);
	}
	public void CLickOn_TPIHeader()
	{
		TPIHeader.click();
	}
	public void ClickON_BackButton_OnTPIListing()
	{
		BackButton_OnTPIListing.click();
	}
	public void ClickOn_FirstTPIOnTodays()
	{
		FirstTPIOnTodays.click();
	}
	public void ClickOn_ClickOnStartButton()
	{
		ClickOnStartButton.click();
		
	}
	public void CLickOn_YesButton_OnAreYouWantToStartTPI()
	{
		YesButton_OnAreYouWantToStartTPI.click();
	}
	public void Clickon_NoButton_OnAreYouWantToStartTPI()
	{
		NoButton_OnAreYouWantToStartTPI.click();
	}
	public void ClickOn_OkButton_OnTPIStartedSuccessfullyPopup()
	{
		OkButton_OnTPIStartedSuccessfullyPopup.click();
	}
	public void Clickon_ClickOnFinishButton()
	{
		ClickOnFinishButton.click();
	}
	public void ClickOn_InspectorName(String Enter_VendorName)
	{
		InspectionVendor.sendKeys(Enter_VendorName);
	}
	public void ClickOn_RemarkOnTPIFinishPage(String Enter_Remark)
	{
		RemarkOnTPIFinishPage.sendKeys(Enter_Remark);
	}
	public void ClickOn_AttachImageIconOnTPIFinishPage()
	{
		AttachImageIconOnTPIFinishPage.click();
	}
	public void ClickOn_AttachVideoIconOnTPIFinishPage()
	{
		AttachVideoIconOnTPIFinishPage.click();
	}
	public void ClickOn_SubmitButton()
	{
		SubmitButton.click();
	}
	public void ClickOn_CancelButton()
	{
		CancelButton.click();
	}
	public void ClickOn_CameraShuuterButton()
	{
		CameraShuuterButton.click();
	}
	public void ClickOn_DoneRightIcon_OnCameraPage()
	{
		DoneRightIcon_OnCameraPage.click();
	}
	public void ClickOn_CancelImageIcon_OnCameraPage()
	{
		CancelImageIcon_OnCameraPage.click();
	}
	public void ClickOn_RetakeIcon_OnCameraPage()
	{
		RetakeIcon_OnCameraPage.click();
	}
	public void ClickOn_SaveButton()
	{
		SaveButton.click();
	}
	public void ClickOn_ClearButton()
	{
		ClearButton.click();
	}
	public void ClickOn_UndoButton()
	{
		UndoButton.click();
	}
	public void ClickOn_CloseButton()
	{
		CloseButton.click();
	}
	public void ClickOn_RecordVideoButton()
	{
		RecordVideoButton.click();
	}
	public void ClickOn_YesButton_OnAreYouSureWanttoFinishTPI()
	{
		YesButton_OnAreYouSureWanttoFinishTPI.click();
	}
	public void ClickOn_NoButton_OnAreYouSureWanttoFinishTPI()
	{
		NoButton_OnAreYouSureWanttoFinishTPI.click();
	}
	public void ClickOn_ViewButton_OnCompletedTab()
	{
		ViewButton_OnCompletedTab.click();
	}
	public void ClickOn_ImageAttached_OnCompletedTPI_PreviewPage()
	{
		ImageAttached_OnCompletedTPI_PreviewPage.click();
	}
	public void ClickOn_AllowMetaagrowTORecordAudio_WhileUsingApp_Popup()
	{
		AllowMetaagrowTORecordAudio_WhileUsingApp_Popup.click();
	}
	public void CLickcon_CameraShuuterButtonVivo()
	{
		CameraShuuterButtonVivo.click();
	}
	public void ClickOn_DoneRightIcon_OnCameraPageVivo()
	{
		DoneRightIcon_OnCameraPageVivo.click();
	}
	
    
    
}
