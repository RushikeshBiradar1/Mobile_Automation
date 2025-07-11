package POM;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import General_Utility.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PAT {
	
	//initialiazation
	public PAT(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Declaration
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Today's\"]")private WebElement TodaysTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Upcoming\"]")private WebElement UpcomingYab;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search\"]")private WebElement SearchBoX_PATListing;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PAT Testing\"]")private WebElement PATTesting_HeaderOnListing;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement BackButton_OnPATListing;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")private WebElement FirstPAT_OnTodaysPage;
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Pending\"])[1]")private WebElement PendingPAT_OnTodaysPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add Reading\"]")private WebElement AddReading_Button;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.EditText")private WebElement Earth_Continuity_Field;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.EditText")private WebElement L_N_Voltage_Field;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.widget.EditText")private WebElement L_E_Voltage_Field;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[1]/android.widget.EditText")private WebElement N_E_Voltage_Field;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[1]/android.widget.EditText")private WebElement Load_Current_Field;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup[1]/android.widget.EditText")private WebElement PE_Conductor_Current_Field;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[8]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")private WebElement Pass_Fail_Toggle;
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement BackButton_OnPATReadingPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")private WebElement SubmitButton_OnPATReadingButton;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement YesButton_OnSaveThisReadingPopup;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")private WebElement NoButton_OnSaveThisReadingPopup;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Results : Pass\"]")private WebElement ResultPassText_OnAddReadingPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Results : Fail\"]")private WebElement ResultFailText_OnAddReadingPage;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement EarthContinuity_AttachImagesIcon;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement L_N_Voltage_AttachImagesIcon;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement L_E_Voltage_AttachImagesIcon;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement N_E_Voltage_AttachImagesIcon;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement LoadCurrent_AttachImagesIcon;
    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[7]/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement PE_ConductorCurrent_AttachImagesIcon;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")private WebElement WhileUsingTheApp_Popup;
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Shutter\"]")private WebElement CameraShuuterButton;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Done\"]")private WebElement DoneRightIcon_OnCameraPage;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Cancel\"]")private WebElement CancelImageIcon_OnCameraPage;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Retake\"]")private WebElement RetakeIcon_OnCameraPage;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save\"]")private WebElement SaveButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Clear\"]")private WebElement ClearButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Undo\"]")private WebElement UndoButton;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Close\"]")private WebElement CloseButton;

    
    
    
    public WebElement getEarthContinuity_AttachImagesIcon() {
		return EarthContinuity_AttachImagesIcon;
	}
	public WebElement getL_N_Voltage_AttachImagesIcon() {
		return L_N_Voltage_AttachImagesIcon;
	}
	public WebElement getL_E_Voltage_AttachImagesIcon() {
		return L_E_Voltage_AttachImagesIcon;
	}
	public WebElement getN_E_Voltage_AttachImagesIcon() {
		return N_E_Voltage_AttachImagesIcon;
	}
	public WebElement getLoadCurrent_AttachImagesIcon() {
		return LoadCurrent_AttachImagesIcon;
	}
	public WebElement getPE_ConductorCurrent_AttachImagesIcon() {
		return PE_ConductorCurrent_AttachImagesIcon;
	}
	public WebElement getWhileUsingTheApp_Popup() {
		return WhileUsingTheApp_Popup;
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
	//Getters Method
	public WebElement getTodaysTab() {
		return TodaysTab;
	}
	public WebElement getUpcomingYab() {
		return UpcomingYab;
	}
	public WebElement getSearchBoX_PATListing() {
		return SearchBoX_PATListing;
	}
	public WebElement getPATTesting_HeaderOnListing() {
		return PATTesting_HeaderOnListing;
	}
	public WebElement getBackButton_OnPATListing() {
		return BackButton_OnPATListing;
	}
	public WebElement getFirstPAT_OnTodaysPage() {
		return FirstPAT_OnTodaysPage;
	}
	public WebElement getPendingPAT_OnTodaysPage() {
		return PendingPAT_OnTodaysPage;
	}
	public WebElement getAddReading_Button() {
		return AddReading_Button;
	}
	public WebElement getEarth_Continuity_Field() {
		return Earth_Continuity_Field;
	}
	public WebElement getL_N_Voltage_Field() {
		return L_N_Voltage_Field;
	}
	public WebElement getL_E_Voltage_Field() {
		return L_E_Voltage_Field;
	}
	public WebElement getN_E_Voltage_Field() {
		return N_E_Voltage_Field;
	}
	public WebElement getLoad_Current_Field() {
		return Load_Current_Field;
	}
	public WebElement getPE_Conductor_Current_Field() {
		return PE_Conductor_Current_Field;
	}
	public WebElement getPass_Fail_Toggle() {
		return Pass_Fail_Toggle;
	}
	public WebElement getBackButton_OnPATReadingPage() {
		return BackButton_OnPATReadingPage;
	}
	public WebElement getSubmitButton_OnPATReadingButton() {
		return SubmitButton_OnPATReadingButton;
	}
	public WebElement getYesButton_OnSaveThisReadingPopup() {
		return YesButton_OnSaveThisReadingPopup;
	}
	public WebElement getNoButton_OnSaveThisReadingPopup() {
		return NoButton_OnSaveThisReadingPopup;
	}
	public WebElement getResultPassText_OnAddReadingPage() {
		return ResultPassText_OnAddReadingPage;
	}
	public WebElement getResultFailText_OnAddReadingPage() {
		return ResultFailText_OnAddReadingPage;
	}

	//Business Logic 
	public void ClickOn_TodaysTab()
	{
		TodaysTab.click();
		
	}
	public void ClickOn_UpcomingYab()
	{
		UpcomingYab.click();
	}
	public void CLickOn_SearchBoX_PATListing(String Search_PAT)
	{
		SearchBoX_PATListing.sendKeys(Search_PAT);
	}
	public void ClickOn_PATTesting_HeaderOnListing()
	{
		Assert.assertTrue(PATTesting_HeaderOnListing.isDisplayed(), "PAT_Headers Not showing");;
	}
	public void ClickOn_BackButton_OnPATListing()
	{
		BackButton_OnPATListing.click();
	}
	public void ClickOn_FirstPAT_OnTodaysPage()
	{
		FirstPAT_OnTodaysPage.click();
	}
	public void ClickON_PendingPAT_OnTodaysPage()
	{
		PendingPAT_OnTodaysPage.click();
	}
	public void ClickOn_AddReading_Button()
	{
		AddReading_Button.click();
	}
	public void CLickOn_Earth_Continuity_Field(String Enter_Reading)
	{
		Earth_Continuity_Field.sendKeys(Enter_Reading);
	}
	public void CLickOn_L_N_Voltage_Field(String Enter_Reading)
	{
		L_N_Voltage_Field.sendKeys(Enter_Reading);
	}
	public void CLickOn_L_E_Voltage_Field(String Enter_Reading)
	{
		L_E_Voltage_Field.sendKeys(Enter_Reading);
	}
	public void CLickOn_N_E_Voltage_Field(String Enter_Reading)
	{
		N_E_Voltage_Field.sendKeys(Enter_Reading);
	}
	public void CLickOn_Load_Current_Field(String Enter_Reading)
	{
		Load_Current_Field.sendKeys(Enter_Reading);
	}
	public void CLickOn_PE_Conductor_Current_Field(String Enter_Reading)
	{
		PE_Conductor_Current_Field.sendKeys(Enter_Reading);
	}
	public void CLickOn_Pass_Fail_Toggled()
	{
		Pass_Fail_Toggle.click();
	}
	public void CLickOn_BackButton_OnPATReadingPage()
	{
		BackButton_OnPATReadingPage.click();
	}
	public void CLickOn_SubmitButton_OnPATReadingButton()
	{
		SubmitButton_OnPATReadingButton.click();
	}
	public void CLickOn_YesButton_OnSaveThisReadingPopup()
	{
		YesButton_OnSaveThisReadingPopup.click();
	}
	public void CLickOn_NoButton_OnSaveThisReadingPopup()
	{
		NoButton_OnSaveThisReadingPopup.click();
	}
	public void Verify_ResultPassText_OnAddReadingPage()
	{
		Assert.assertTrue(ResultPassText_OnAddReadingPage.isDisplayed(), "Pass Result is not diplay");
	}
	public void Verify_ResultFailText_OnAddReadingPage()
	{
		Assert.assertTrue(ResultFailText_OnAddReadingPage.isDisplayed(), "Fail Result is not diplay");
	}
	public void ClickOn_EarthContinuity_AttachImagesIcon()
	{
		EarthContinuity_AttachImagesIcon.click();
	}
	public void ClickOn_L_N_Voltage_AttachImagesIcon()
	{
		L_N_Voltage_AttachImagesIcon.click();
	}
	public void ClickOn_L_E_Voltage_AttachImagesIcon()
	{
		L_E_Voltage_AttachImagesIcon.click();
	}
	public void ClickOn_N_E_Voltage_AttachImagesIcon()
	{
		N_E_Voltage_AttachImagesIcon.click();
	}
	public void CLickOn_LoadCurrent_AttachImagesIcon()
	{
		LoadCurrent_AttachImagesIcon.click();
	}
	public void CLickOn_PE_ConductorCurrent_AttachImagesIcon()
	{
		PE_ConductorCurrent_AttachImagesIcon.click();
	}
	public void ClickOn_WhileUsingTheApp_Popup()
	{
		WhileUsingTheApp_Popup.click();
	}
	public void ClickOn_CameraShuuterButton()
	{
		CameraShuuterButton.click();
	}
	public void CLickOn_DoneRightIcon_OnCameraPage()
	{	
	DoneRightIcon_OnCameraPage.click();

}
	public void ClickOn_CancelImageIcon_OnCameraPage()
	{
		CancelImageIcon_OnCameraPage.click();
	}
	public void clickOn_RetakeIcon_OnCameraPage()
	{
		RetakeIcon_OnCameraPage.click();
	}
	public void ClickcOn_SaveButton()
	{
		SaveButton.click();
	}
	public void ClickOn_ClearButton()
	{
		ClearButton.click();
	}
	public void CLickOn_UndoButton()
	{
		UndoButton.click();
	}
	public void CLickOn_CloseButton()
	{
		CloseButton.click();
	}
}
