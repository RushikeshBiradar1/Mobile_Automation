package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Tickets {
	
	//Initialization
		public Tickets(AndroidDriver driver)
		{
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
		
		//Declaration
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Open\"]")private WebElement OpenTicketDropdown;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Assigned\"]")private WebElement AssignedTab;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Raised\"]")private WebElement RaisedTab;
		@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")private WebElement FirstTicket;
		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.ImageView")private WebElement RaiseTicketBUtton;
		@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]")private WebElement AllowMetaagrowTORecordAudio_WhileUsingApp_Popup;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Select Type\"]")private WebElement SelectTypeDropdown;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"General\"]")private WebElement SelectGeneralTyep;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Breakdown\"]")private WebElement SelectBreakdownType;
		@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Type here\"]")private WebElement TicketTitle_TextField;
		@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup")private WebElement DepartmentDropwn;
		@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Type something...\"]")private WebElement SearchDepartmentOn_RaiseTicket;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Technical\"]") private WebElement TechincalDepartmentName;
		@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup")private WebElement SelectUsersDropdown;
		@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Type something...\"]")private WebElement SearchUsersOn_RaiseTicket;
		@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup")private WebElement AssetDropdownOn_RaiseTicket;
		@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Type something...\"]")private WebElement SearchAssetOn_RaiseTicket;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ADULT BUMPER CAR NF\"]")private WebElement ADULT_BUMPER_CAR_NF_AssetName;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"High\"]")private WebElement HighTicket;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Medium\"]")private WebElement MediumTicket;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Low\"]")private WebElement LowTicket;
		@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")private WebElement AllowPhotoAndMediaButton;
		public WebElement getParkedStatusfromDropdownOfListingPage() {
			return ParkedStatusfromDropdownOfListingPage;
		}
		public WebElement getOpenStatusfromDropdownOfListingPage() {
			return OpenStatusfromDropdownOfListingPage;
		}

		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"General\"]")private WebElement GeneralType;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Breakdown\"]")private WebElement BreakdownType_OnEditMeter;
		public WebElement getBreakdownType_OnEditMeter() {
			return BreakdownType_OnEditMeter;
		}

		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\\\"android:id/content\\\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup/android.view.View")private WebElement ParkedStatusfromDropdownOfListingPage;
		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\\\"android:id/content\\\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup")private WebElement OpenStatusfromDropdownOfListingPage; 
		
		
		public WebElement getGeneralType() {
			return GeneralType;
		}
		public WebElement getAllowPhotoAndMediaButton() {
			return AllowPhotoAndMediaButton;
		}

		@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Description\"]")private WebElement DescriptionBox_OnRaiseTicket;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Attach Image\"]")private WebElement AttachImages_OnRaiseTicket;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Attach Video\"]")private WebElement AttachVideo_OnRaiseTicket;
		@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Raise Ticket\"])[2]")private WebElement RaiseTicketButton_OnRaiseTicketPage;
		@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView")private WebElement CancelTicketCrossSign;
		@AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"Open\"])[2]")private WebElement OpenTicketStatusDropdown;
		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")private WebElement TicketStatusDropdown;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Closed\"]")private WebElement SelectClosedStatus;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Parked\"]")private WebElement SelectParkedStatus;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Not valid\"]")private WebElement SelectNotValidStatus;

		public WebElement getSelectNotValidStatus() {
			return SelectNotValidStatus;
		}

		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView")private WebElement PlusIcon_Raisetkt_OnTktListing;

		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")private WebElement SubmitButton;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Cancel\"]")private WebElement CancelButton;
		@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Add Remark\"]")private WebElement AddRemarkField;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Edit ticket\"]")private WebElement EditTicketButton;
		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")private WebElement PlusIcon_InTicketDetailPage;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Additional Cost\"]")private WebElement AdditionalCost;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Forward Ticket\"]")private WebElement ForwardTicketButton;
		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.ImageView")private WebElement CrossSignOn_TicketInfo;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Edit/View Details\"]")private WebElement EditViewDetailsButton_OnTicketInfo;
		@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Type your reply here\"]")private WebElement ReplyBox_OnTicketInfo;
		@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Attach Images\"]")private WebElement AttachImages_OnTicketInfo;
		@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")private WebElement YesButton_OnChangeStatusPopup;
		@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button2\"]")private WebElement NoButton_OnChangeStatusPopup;
		@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search\"]")private WebElement SearchField_OnTicketListing;
		@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[4]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView")private WebElement TicketStatusDropdownIcon_OnListingPage;
		
		
		public WebElement getADULT_BUMPER_CAR_NF_AssetName() {
			return ADULT_BUMPER_CAR_NF_AssetName;
		}
		public WebElement getSearchField_OnTicketListing() {
			return SearchField_OnTicketListing;
		}
		public WebElement getTicketStatusDropdownIcon_OnListingPage() {
			return TicketStatusDropdownIcon_OnListingPage;
		}
		public WebElement getRaiseTicketButton_OnRaiseTicketPage() {
			return RaiseTicketButton_OnRaiseTicketPage;
		}
		public WebElement getPlusIcon_Raisetkt_OnTktListing() {
			return PlusIcon_Raisetkt_OnTktListing;
		}
		public WebElement getYesButton_OnChangeStatusPopup() {
			return YesButton_OnChangeStatusPopup;
		}
		public WebElement getNoButton_OnChangeStatusPopup() {
			return NoButton_OnChangeStatusPopup;
		}
		//Getters
		public WebElement getOpenTicketDropdown() {
			return OpenTicketDropdown;
		}
		public WebElement getAssignedTab() {
			return AssignedTab;
		}
		public WebElement getRaisedTab() {
			return RaisedTab;
		}
		public WebElement getFirstTicket() {
			return FirstTicket;
		}
		public WebElement getRaiseTicketBUtton() {
			return RaiseTicketBUtton;
		}
		public WebElement getAllowMetaagrowTORecordAudio_WhileUsingApp_Popup() {
			return AllowMetaagrowTORecordAudio_WhileUsingApp_Popup;
		}
		public WebElement getSelectTypeDropdown() {
			return SelectTypeDropdown;
		}
		public WebElement getSelectGeneralTyep() {
			return SelectGeneralTyep;
		}
		public WebElement getSelectBreakdownType() {
			return SelectBreakdownType;
		}
		public WebElement getTicketTitle_TextField() {
			return TicketTitle_TextField;
		}
		public WebElement getDepartmentDropwn() {
			return DepartmentDropwn;
		}
		public WebElement getSearchDepartmentOn_RaiseTicket() {
			return SearchDepartmentOn_RaiseTicket;
		}
		public WebElement getTechincalDepartmentName() {
			return TechincalDepartmentName;
		}
		public WebElement getSelectUsersDropdown() {
			return SelectUsersDropdown;
		}
		public WebElement getSearchUsersOn_RaiseTicket() {
			return SearchUsersOn_RaiseTicket;
		}
		public WebElement getAssetDropdownOn_RaiseTicket() {
			return AssetDropdownOn_RaiseTicket;
		}
		public WebElement getSearchAssetOn_RaiseTicket() {
			return SearchAssetOn_RaiseTicket;
		}
		public WebElement getADULT_BUMPER_CAR_NF_AssetNameAssetName() {
			return ADULT_BUMPER_CAR_NF_AssetName;
		}
		public WebElement getHighTicket() {
			return HighTicket;
		}
		public WebElement getMediumTicket() {
			return MediumTicket;
		}
		public WebElement getLowTicket() {
			return LowTicket;
		}
		public WebElement getDescriptionBox_OnRaiseTicket() {
			return DescriptionBox_OnRaiseTicket;
		}
		public WebElement getAttachImages_OnRaiseTicket() {
			return AttachImages_OnRaiseTicket;
		}
		public WebElement getAttachVideo_OnRaiseTicket() {
			return AttachVideo_OnRaiseTicket;
		}
		public WebElement getCLickOn_RaiseTicketButton_OnRaiseTicketPage() {
			return RaiseTicketButton_OnRaiseTicketPage;
		}
		public WebElement getCancelTicketCrossSign() {
			return CancelTicketCrossSign;
		}
		public WebElement getOpenTicketStatusDropdown() {
			return OpenTicketStatusDropdown;
		}
		public WebElement getTicketStatusDropdown() {
			return TicketStatusDropdown;
		}
		public WebElement getSelectClosedStatus() {
			return SelectClosedStatus;
		}
		public WebElement getSelectParkedStatus() {
			return SelectParkedStatus;
		}
		public WebElement getSubmitButton() {
			return SubmitButton;
		}
		public WebElement getCancelButton() {
			return CancelButton;
		}
		public WebElement getAddRemarkField() {
			return AddRemarkField;
		}
		public WebElement getEditTicketButton() {
			return EditTicketButton;
		}
		public WebElement getPlusIcon_InTicketDetailPage() {
			return PlusIcon_InTicketDetailPage;
		}
		public WebElement getAdditionalCost() {
			return AdditionalCost;
		}
		public WebElement getForwardTicketButton() {
			return ForwardTicketButton;
		}
		public WebElement getCrossSignOn_TicketInfo() {
			return CrossSignOn_TicketInfo;
		}
		public WebElement getEditViewDetailsButton_OnTicketInfo() {
			return EditViewDetailsButton_OnTicketInfo;
		}
		public WebElement getReplyBox_OnTicketInfo() {
			return ReplyBox_OnTicketInfo;
		}
		public WebElement getAttachImages_OnTicketInfo() {
			return AttachImages_OnTicketInfo;
		}
		
		//Business Logic 
		public void ClickOn_OpenTicketDropdown()
		{
			OpenTicketDropdown.click();
		}
		public void CLickOn_AssignedTab()
		{
			AssignedTab.click();
		}
		public void ClickOn_RaisedTab()
		{
			RaisedTab.click();
		}
		public void ClickOn_RaiseTicketBUtton()
		{
			RaiseTicketBUtton.click();
		}
		public void ClickOn_AllowMetaagrowTORecordAudio_WhileUsingApp_Popup()
		{
			AllowMetaagrowTORecordAudio_WhileUsingApp_Popup.click();
		}
		public void ClickOn_SelectTypeDropdown()
		{
			SelectTypeDropdown.click();
		}
		public void CLickOn_SelectGeneralTyep()
		{
			SelectGeneralTyep.click();
		}
		public void ClickOn_SelectBreakdownType()
		{
			SelectBreakdownType.click();
		}
		public void CLickOn_TicketTitle_TextField(String Enter_TicketTitle)
		{
			TicketTitle_TextField.sendKeys(Enter_TicketTitle);
		}
		public void CLickOn_DepartmentDropwn()
		{
			DepartmentDropwn.click();
		}
		public void ClickOn_SearchDepartmentOn_RaiseTicket(String Search_Department)
		{
			SearchDepartmentOn_RaiseTicket.sendKeys(Search_Department);
		}
		public void CLickOn_TechincalDepartmentName()
		{
			TechincalDepartmentName.click();
		}
		public void CLickOn_SelectUsersDropdown()
		{
			SelectUsersDropdown.click();
			
		}
		public void ClickOn_SearchUsersOn_RaiseTicket(String Search_Users)
		{
			SearchUsersOn_RaiseTicket.sendKeys(Search_Users);
		}
		public void CLickOn_AssetDropdownOn_RaiseTicket()
		{
			AssetDropdownOn_RaiseTicket.click();
		}
		public void CLickOn_SearchAssetOn_RaiseTicket(String Enter_AssetName)
		{
			SearchAssetOn_RaiseTicket.sendKeys(Enter_AssetName);
		}
		public void CLickON_ADULT_BUMPER_CAR_NF_AssetName()
		{
			ADULT_BUMPER_CAR_NF_AssetName.click();
		}
		public void CLickOn_HighTicket()
		{
			HighTicket.click();
		}
		public void CLickoN_MediumTicket()
		{
			MediumTicket.click();
		}
		public void CliCkOn_LowTicket()
		{
			LowTicket.click();
		}
		public void CLickon_DescriptionBox_OnRaiseTicket(String Enter_Description)
		{
			DescriptionBox_OnRaiseTicket.sendKeys(Enter_Description);
		}
		public void CLickOn_AttachImages_OnRaiseTicket()
		{
			AttachImages_OnRaiseTicket.click();
		}
		public void ClickOn_AttachVideo_OnRaiseTicket()
		{
			AttachVideo_OnRaiseTicket.click();
		}
		public void CLickOn_RaiseTicketButton_OnRaiseTicketPage()
		{
			RaiseTicketButton_OnRaiseTicketPage.click();
			
		}
		public void CLickOn_CancelTicketCrossSign()
		{
			CancelTicketCrossSign.click();
		}
		public void CLickOn_OpenTicketStatusDropdown()
		{
			OpenTicketStatusDropdown.click();
			
		}
		public void ClickOn_TicketStatusDropdown()
		{
			TicketStatusDropdown.click();
		}
		public void CLickOn_SelectClosedStatus()
		{
			SelectClosedStatus.click();
		}
		public void ClickOn_SelectParkedStatus()
		{
			SelectParkedStatus.click();
			
		}
		public void ClickOn_SubmitButton()
		{
			SubmitButton.click();
		}
		public void ClickOn_CancelButton()
		{
			CancelButton.click();
			
		}
		public void CLickOn_AddRemarkField(String Enter_Remark)
		{
			AddRemarkField.sendKeys(Enter_Remark);
		}
		public void ClickOn_EditTicketButton()
		{
			EditTicketButton.click();
		}
		public void CLickOn_PlusIcon_InTicketDetailPage()
		{
			PlusIcon_InTicketDetailPage.click();
			
		}
		public void ClickOn_AdditionalCost()
		{
			AdditionalCost.click();
			
		}
		public void CLickOn_ForwardTicketButton()
		{
			ForwardTicketButton.click();
		}
		public void ClickOn_CrossSignOn_TicketInfo()
		{
			CrossSignOn_TicketInfo.click();
		}
		public void ClickOn_EditViewDetailsButton_OnTicketInfo()
		{
			EditViewDetailsButton_OnTicketInfo.click();
		}
		public void ClickOn_ReplyBox_OnTicketInfo(String Enter_Reply)
		{
			ReplyBox_OnTicketInfo.sendKeys(Enter_Reply);
		}
		public void ClickOn_AttachImages_OnTicketInfo()
		{
			AttachImages_OnTicketInfo.click();
		}
		public void ClickOn_AllowPhotoAndMediaButton()
		{
			AllowPhotoAndMediaButton.click();
		}
		public void ClickOn_GeneralType()
		{
			GeneralType.click();
		}
		public void CLickOn_FirstTicket()
		{
			FirstTicket.click();
		}
		public void ClickOn_YesButton_OnChangeStatusPopup()
		{
			YesButton_OnChangeStatusPopup.click();
		}
		public void ClickOn_NoButton_OnChangeStatusPopup()
		{
			NoButton_OnChangeStatusPopup.click();
		}
		public void CLickOn_SelectNotValidStatus()
		{
			SelectNotValidStatus.click();
		}
		public void CLickOn_ParkedStatusfromDropdownOfListingPage()
		{
			ParkedStatusfromDropdownOfListingPage.click();
		}
		public void ClickOn_OpenStatusfromDropdownOfListingPage()
		{
			OpenStatusfromDropdownOfListingPage.click();
		}
		public void CLickOn_BreakdownType_OnEditMeter()
		{
			BreakdownType_OnEditMeter.click();
		}
		public void ClickOn_SearchField_OnTicketListing(String Search_Ticket)
		{
			SearchField_OnTicketListing.sendKeys(Search_Ticket);
		}
		public void ClickOn_TicketStatusDropdownIcon_OnListingPage()
		{
			TicketStatusDropdownIcon_OnListingPage.click();
		}
		public void ClickOn_PlusIcon_Raisetkt_OnTktListing()
		{
			PlusIcon_Raisetkt_OnTktListing.click();
		}
		
		
		

}
