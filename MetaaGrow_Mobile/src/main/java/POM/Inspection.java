
package POM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Inspection {
	
	//initialization
	public Inspection(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Declaration
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Scheduled\"]")private WebElement ScheduledTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Completed\"]")private WebElement CompletedTab;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Upcoming\"]")private WebElement UpcomingTab;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup")private WebElement LocationDropdownTab;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement InspectionCalender;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement AdhocChecklistPlusIcon;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")private WebElement FirstInspection;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")private WebElement AlertPopupOnSingleLocation;
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")private WebElement YouHaveSingleLocation_Messege;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement OkButtonOnLocationAlertPopup;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement SectionDropdowIco_OnChecklistDetails;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Enter Here\"]")private WebElement OverallRemarkField_OnChecklistdetails;
	@AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup")private WebElement SelectUsersPerformingThisTaskDropdown;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.ImageView")private WebElement SelectUsersPerformingThisTaskDropdownIcon;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.View")private WebElement SaveButtonInspection_OnInspectionChecklist;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Type something...\"]")private WebElement SearchBox_OnSelectUserPerformingDropdown;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Fernandes\"]")private WebElement SelectFernandes_Text;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement BackButtonIcon;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search\"]")private WebElement SeachField_On_AllTabsOf_Listing;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add Remark\"]")private WebElement AddRemarkButton_OnActionPopup;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Attach Image(s)\"]")private WebElement AttachImagesButton_OnActionPopup;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Raise Ticket\"]")private WebElement RaiseTicketButton_OnActionPopup;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")private WebElement FirstActionPopup;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save & Submit\"]")private WebElement SaveAndSubmitButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save\"]")private WebElement SaveButton;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement AdditionalCostPlusIcon;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Consume Parts\"]")private WebElement ConsumePartsButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Additional Cost\"]")private WebElement AdditionalCostButton;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView")private WebElement AdditionalcostCrossButton;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement BackButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Beverage\"]")private WebElement BeverageAdhocChecklist;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Start\"]")private WebElement StartButtonOnAdhocChecklist;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cancel\"]")private WebElement CancelButtonOnAdhocChecklist;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Enter Remark\"]")private WebElement EnterRemarkOn_Inspection;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")private WebElement InspectionRemarkCrossSign;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")private WebElement SubmitButton_OnRemark;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter details\"]")private WebElement EnterDetailsDropdown_OnAdditionalCostPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Repair cost\"]")	private WebElement RepairCostOption;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Fuel cost\"]")private WebElement FuelCostOption;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Labor cost\"]")private WebElement LaborCostOption;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Enter cost\"]")private WebElement EnterCostField;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Attach Image\"]")private WebElement AttachImageButton_OnAdditionalCostPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add Costs\"]")private WebElement AddCostButton;
	public WebElement getTwelfthActionButton() {
		return twelfthActionButton;
	}

	@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Additional Costs\"])[1]")private WebElement AdditionalCostSection_OnSectionAfterAdding;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement PhotoButton_OnAttachImage;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")private WebElement CancelButton_OnAttachImage;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")private WebElement twelfthActionButton;
	
	
	public WebElement getPhotoButton_OnAttachImage() {
		return PhotoButton_OnAttachImage;
	}
	public WebElement getCancelButton_OnAttachImage() {
		return CancelButton_OnAttachImage;
	}
	public WebElement getEnterDetailsDropdown_OnAdditionalCostPage() {
		return EnterDetailsDropdown_OnAdditionalCostPage;
	}
	public WebElement getRepairCostOption() {
		return RepairCostOption;
	}
	public WebElement getFuelCostOption() {
		return FuelCostOption;
	}
	public WebElement getLaborCostOption() {
		return LaborCostOption;
	}
	public WebElement getEnterCostField() {
		return EnterCostField;
	}
	public WebElement getAttachImageButton_OnAdditionalCostPage() {
		return AttachImageButton_OnAdditionalCostPage;
	}
	public WebElement getAddCostButton() {
		return AddCostButton;
	}
	public WebElement getAdditionalCostSection_OnSectionAfterAdding() {
		return AdditionalCostSection_OnSectionAfterAdding;
	}
	public WebElement getEnterRemarkOn_Inspection() {
		return EnterRemarkOn_Inspection;
	}
	public WebElement getInspectionRemarkCrossSign() {
		return InspectionRemarkCrossSign;
	}
	public WebElement getSubmitButton_OnRemark() {
		return SubmitButton_OnRemark;
	}
	public WebElement getAdditionalcostCrossButton() {
		return AdditionalcostCrossButton;
	}
	public WebElement getBackButton() {
		return BackButton;
	}
	public WebElement getBeverageAdhocChecklist() {
		return BeverageAdhocChecklist;
	}
	public WebElement getStartButtonOnAdhocChecklist() {
		return StartButtonOnAdhocChecklist;
	}
	public WebElement getCancelButtonOnAdhocChecklist() {
		return CancelButtonOnAdhocChecklist;
	}
	public WebElement getAdditionalCostPlusIcon() {
		return AdditionalCostPlusIcon;
	}
	public WebElement getConsumePartsButton() {
		return ConsumePartsButton;
	}
	public WebElement getAdditionalCostButton() {
		return AdditionalCostButton;
	}
//	public WebElement getAdditionalcostCrossIcon() {
//		return AdditionalcostCrossButton;
//	}
	public WebElement getAddRemarkButton_OnActionPopup() {
		return AddRemarkButton_OnActionPopup;
	}
	public WebElement getAttachImagesButton_OnActionPopup() {
		return AttachImagesButton_OnActionPopup;
	}
	public WebElement getSaveAndSubmitButton() {
		return SaveAndSubmitButton;
	}
	public WebElement getSaveButton() {
		return SaveButton;
	}
	public WebElement getRaiseTicketButton_OnActionPopup() {
		return RaiseTicketButton_OnActionPopup;
	}
	public WebElement getFirstActionPopup() {
		return FirstActionPopup;
	}
	public WebElement getSeachField_On_AllTabsOf_Listing() {
		return SeachField_On_AllTabsOf_Listing;
	}
	//Getters Method
	public WebElement getScheduledTab() {
		return ScheduledTab;
	}
	public WebElement getCompletedTab() {
		return CompletedTab;
	}
	public WebElement getSelectUsersPerformingThisTaskDropdownIcon() {
		return SelectUsersPerformingThisTaskDropdownIcon;
	}
	public WebElement getUpcomingTab() {
		return UpcomingTab;
	}
	public WebElement getLocationDropdownTab() {
		return LocationDropdownTab;
	}
	public WebElement getInspectionCalender() {
		return InspectionCalender;
	}
	public WebElement getAdhocChecklistPlusIcon() {
		return AdhocChecklistPlusIcon;
	}
	public WebElement getFirstInspection() {
		return FirstInspection;
	}
	public WebElement getAlertPopupOnSingleLocation() {
		return AlertPopupOnSingleLocation;
	}
	public WebElement getYouHaveSingleLocation_Messege() {
		return YouHaveSingleLocation_Messege;
	}
	public WebElement getOkButtonOnLocationAlertPopup() {
		return OkButtonOnLocationAlertPopup;
	}
	public WebElement getSectionDropdowIco_OnChecklistDetails() {
		return SectionDropdowIco_OnChecklistDetails;
	}
	public WebElement getOverallRemarkField_OnChecklistdetails() {
		return OverallRemarkField_OnChecklistdetails;
	}
	public WebElement getSelectUsersPerformingThisTaskDropdown() {
		return SelectUsersPerformingThisTaskDropdown;
	}
	public WebElement getSaveButtonInspection_OnInspectionChecklist() {
		return SaveButtonInspection_OnInspectionChecklist;
	}
	public WebElement getSearchBox_OnSelectUserPerformingDropdown() {
		return SearchBox_OnSelectUserPerformingDropdown;
	}
	public WebElement getSelectFernandes_Text() {
		return SelectFernandes_Text;
	}
	public WebElement getBackButtonIcon() {
		return BackButtonIcon;
	}
	
	
	//Businees Logic
	public void ClickOn_ScheduledTab()
	{
		ScheduledTab.click();
	}
	public void clickOn_CompletedTab()
	{
		CompletedTab.click();
	}
	public void ClickOn_UpcomingTab()
	{
		UpcomingTab.click();
	}
	public void ClickON_LocationDropdownTab()
	{
		LocationDropdownTab.click();
	}
	public void CLickON_InspectionCalender()
	{
		InspectionCalender.click();
	}
	public void CLickOn_AdhocChecklistPlusIcon()
	{
		AdhocChecklistPlusIcon.click();
	}
	public void CLickon_FirstInspection()
	{
		FirstInspection.click();
	}
	public void CLickcon_AlertPopupOnSingleLocation()
	{
		AlertPopupOnSingleLocation.click();
		
	}
	public void verufy_YouHaveSingleLocation_Messege()
	{
		Assert.assertTrue(YouHaveSingleLocation_Messege.isDisplayed(), "YouHaveSingleLocation_Messege is not display");
	}
	public void ClickOn_OkButtonOnLocationAlertPopup()
	{
		OkButtonOnLocationAlertPopup.click();
	}
	public void ClickOn_SectionDropdowIco_OnChecklistDetails()
	{
		SectionDropdowIco_OnChecklistDetails.click();
	}
	public void ClickOn_OverallRemarkField_OnChecklistdetails(String Enter_Remark)
	{
		OverallRemarkField_OnChecklistdetails.sendKeys(Enter_Remark);
	}
	public void ClickOn_SelectUsersPerformingThisTaskDropdown()
	{
		SelectUsersPerformingThisTaskDropdown.click();
	}
	public void CLickOn_SaveButtonInspection_OnInspectionChecklist()
	{
		SaveButtonInspection_OnInspectionChecklist.click();
	}
	public void ClickOn_SearchBox_OnSelectUserPerformingDropdown(String Search_User)
	{
		SearchBox_OnSelectUserPerformingDropdown.sendKeys(Search_User);
	}
	public void ClickOn_SelectFernandes_Text()
	{
		SelectFernandes_Text.click();
	}
	public void ClickOn_BackButtonIcon()
	{
		BackButtonIcon.click();
	}
	public void ClickOn_SelectUsersPerformingThisTaskDropdownIcon()
	{
		SelectUsersPerformingThisTaskDropdownIcon.click();
	}
	public void ClickOn_SeachField_On_AllTabsOf_Listing(String Search_Inspection_Name)
	{
		SeachField_On_AllTabsOf_Listing.sendKeys(Search_Inspection_Name);
	}
	public void ClickON_AddRemarkButton_OnActionPopup()
	{
		AddRemarkButton_OnActionPopup.click();
	}
	public void ClickOn_AttachImagesButton_OnActionPopup()
	{
		AttachImagesButton_OnActionPopup.click();
	}
	public void ClickOn_RaiseTicketButton_OnActionPopup()
	{
		RaiseTicketButton_OnActionPopup.click();
	}
	public void ClickOn_FirstActionPopup()
	{
		FirstActionPopup.click();
	}
	public void ClickOn_SaveAndSubmitButton()
	{
		SaveAndSubmitButton.click();
	}
	public void ClickOn_SaveButton()
	{
		SaveButton.click();
	}
	public void ClikcOn_AdditionalCostPlusIcon()
	{
		AdditionalCostPlusIcon.click();
	}
	public void ClickOn_ConsumePartsButton()
	{
		ConsumePartsButton.click();
	}
	public void ClickOn_AdditionalCostButton()
	{
		AdditionalCostButton.click();
	}
	public void ClickOn_AdditionalcostCrossIcon()
	{
		AdditionalcostCrossButton.click();
	}
	public void ClickOn_BackButton()
	{
		BackButton.click();
	}
	public void Clickon_BeverageAdhocChecklist()
	{
		BeverageAdhocChecklist.click();
	}
	public void ClicOn_StartButtonOnAdhocChecklist()
	{
		StartButtonOnAdhocChecklist.click();
	}
	
	public void ClickOn_CancelButtonOnAdhocChecklist()
	{
		CancelButtonOnAdhocChecklist.click();
	}
	
	public void ClickOn_EnterRemarkOn_Inspection(String Enter_Remark)
	{
		EnterRemarkOn_Inspection.sendKeys(Enter_Remark);
	}
	public void ClickOn_InspectionRemarkCrossSign()
	{
		InspectionRemarkCrossSign.click();
	}
	public void ClickOn_SubmitButton_OnRemark()
	{
		SubmitButton_OnRemark.click();
	}
	public void ClickoN_EnterDetailsDropdown_OnAdditionalCostPage()
	{
		EnterDetailsDropdown_OnAdditionalCostPage.click();
	}
	public void ClickOn_RepairCostOption()
	{
		RepairCostOption.click();
	}
	public void ClickOn_FuelCostOption()
	{
		FuelCostOption.click();
	}
	public void ClickOn_LaborCostOption()
	{
		LaborCostOption.click();
	}
	public void ClickOn_EnterCostField()
	{
		EnterCostField.click();
	}
	public void ClickOn_AttachImageButton_OnAdditionalCostPage()
	{
		AttachImageButton_OnAdditionalCostPage.click();
	}
	public void ClickOn_AddCostButton()
	{
		AddCostButton.click();
	}
	public void ClickOn_AdditionalCostSection_OnSectionAfterAdding()
	{
		Assert.assertTrue(AdditionalCostSection_OnSectionAfterAdding.isDisplayed(), "Additional Cost Sectopn is not display on listing");
	}
	public void ClickOn_PhotoButton_OnAttachImage()
	{
		PhotoButton_OnAttachImage.click();
	}
	public void ClickOn_CancelButton_OnAttachImage()
	{
		CancelButton_OnAttachImage.click();
	}
	public void ClickOn_twelfthActionButton()
	{
		twelfthActionButton.click();
	}


}
