package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
	//Initialization
	public LoginPage(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	//Declaration
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Username']") private WebElement Username;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']") private WebElement Password;
	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.View") private WebElement SigninButton;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]") private WebElement FournPin_1stDigit;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]") private WebElement FournPin_2ndDigit;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[3]") private WebElement FournPin_3rdDigit;
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]") private WebElement FournPin_4thDigit;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Submit']") private WebElement SubmitButton;
	@AndroidFindBy(id = "android:id/button1") private WebElement TwoFactorNoButton;
	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button") private WebElement WhileUsingThisAppButton;
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")private WebElement MetaagrowNoticationsAllowButton;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SuperNova Gaming Hub\"]")private WebElement SuperNovaGamingHub_PropertyOnLoginPage;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Done\"]")private WebElement DOneButton_OnStep3;
	@AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Search\"]")private WebElement SearchFieldOnSelectPropertyPage_OnStep3;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\" Select Property\"]")private WebElement SelectPropertyTitle_OnStep3;
	
	
	



	public WebElement getSuperNovaGamingHub_PropertyOnLoginPage() {
		return SuperNovaGamingHub_PropertyOnLoginPage;
	}
	public WebElement getDOneButton_OnStep3() {
		return DOneButton_OnStep3;
	}
	public WebElement getSearchFieldOnSelectPropertyPage_OnStep3() {
		return SearchFieldOnSelectPropertyPage_OnStep3;
	}
	public WebElement getSelectPropertyTitle_OnStep3() {
		return SelectPropertyTitle_OnStep3;
	}
	//Getters
	public WebElement getMetaagrowNoticationsAllowButton() {
		return MetaagrowNoticationsAllowButton;
	}
	public WebElement getUsername() {
		return Username;
	}



	public WebElement getPassword() {
		return Password;
	}



	public WebElement getSigninButton() {
		return SigninButton;
	}



	public WebElement getFournPin_1stDigit() {
		return FournPin_1stDigit;
	}



	public WebElement getFournPin_2ndDigit() {
		return FournPin_2ndDigit;
	}



	public WebElement getFournPin_3rdDigit() {
		return FournPin_3rdDigit;
	}



	public WebElement getFournPin_4thDigit() {
		return FournPin_4thDigit;
	}



	public WebElement getSubmitButton() {
		return SubmitButton;
	}



	public WebElement getTwoFactorNoButton() {
		return TwoFactorNoButton;
	}



	public WebElement getWhileUsingThisAppButton() {
		return WhileUsingThisAppButton;
	}



	//Business Logic
	public void clickOn_UserName(String Enter_UserName)
	{
		Username.sendKeys(Enter_UserName);
	}
	
	public void ClickOn_Password(String Enter_Password)
	{
		Password.sendKeys(Enter_Password);
	}
	public void ClickOn_SigninButton()
	{
		SigninButton.click();
	}
	public void ClickOn_FournPin_1stDigit(String ENter_1stDigitOfPin)
	{
		FournPin_1stDigit.sendKeys(ENter_1stDigitOfPin);
	}
	public void CLickOn_FournPin_2ndDigit(CharSequence Enter_2ndDigit)
	{
		FournPin_2ndDigit.sendKeys(Enter_2ndDigit);
	}
	public void ClickOn_FournPin_3rdDigit(String Enter_3rdDigit)
	{
		FournPin_3rdDigit.sendKeys(Enter_3rdDigit);
	}
	public void ClickOn_FournPin_4thDigit(String Enter_4thDigit)
	{
		FournPin_4thDigit.sendKeys(Enter_4thDigit);
	}
	public void ClickOn_SubmitButton()
	{
		SubmitButton.click();
	}
	public void ClickOn_TwoFactorNoButton()
	{
		TwoFactorNoButton.click();
	}
	public void ClickOn_WhileUsingThisAppButton()
	{
		WhileUsingThisAppButton.click();
	}
	public void CLickOn_MetaagrowNoticationsAllowButton()
	{
		MetaagrowNoticationsAllowButton.click();
	}
	public void CLickON_SuperNovaGamingHub_PropertyOnLoginPage()
	{
		SuperNovaGamingHub_PropertyOnLoginPage.click();
	}
	public void ClickOn_DOneButton_OnStep3()
	{
		DOneButton_OnStep3.click();
	}
	public void ClickOn_SearchFieldOnSelectPropertyPage_OnStep3(String Search_Property)
	{
		SearchFieldOnSelectPropertyPage_OnStep3.sendKeys(Search_Property);
	}
	public void Verify_SelectPropertyTitle_OnStep3(WebDriver driver)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    // Wait for the "Hi Biradar!" text to be visible after login
		    WebElement welcomeText = wait.until(ExpectedConditions.visibilityOf(SelectPropertyTitle_OnStep3));

		    // Assert that the text is displayed correctly
		    Assert.assertTrue(welcomeText.isDisplayed(), "SelectPropertyTitle_OnStep3 text is not displayed. Login might have failed.");

		    System.out.println("SelectPropertyTitle_OnStep3 text is displayed!");

		} catch (Exception e) {
		    // Handle exception if element is not found or is not displayed
		    e.printStackTrace();
		    Assert.fail("Test failed: " + e.getMessage());
		}
	}
	public void Login(WebDriver driver, String UserName, String PassWord, String FirstDigitPin, String SecondDigitPin, String ThirdDigitPin, String FourthDigitPin)
	{
		 try {
//	        	
	            // Initialize WebDriverWait with a timeout of 10 seconds
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for a maximum of 10 seconds
	            
	            // Wait for the permission allow button to be clickable and then click
	            // Wait up to 5 seconds for the Allow button to be visible, then click it if it's present
	            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));
//	            WebElement allowButton = null;
//	            try {
//	                // Wait for the "Allow" button to be displayed within 5 seconds
//	                allowButton = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")));
//	            } catch (TimeoutException e) {
//	                // The button was not visible within 5 seconds, you can log or handle this case
//	                System.out.println("Allow button not found within the given time frame.");
//	            }
//
//	            if (allowButton != null && allowButton.isDisplayed()) {
//	                allowButton.click();
//	                System.out.println("Allow button clicked.");
//	            } else {
//	                System.out.println("Allow button not found or not displayed.");
//	            }

	            // Wait for the Username field to be visible and then input text
	            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Username']")));
	            usernameField.sendKeys(UserName);

	            // Wait for the Password field to be visible and then input text
	            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@text='Password']")));
	            passwordField.sendKeys(PassWord);

	            // Wait for the first clickable button and click
	            WebElement firstButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.View")));
	            firstButton.click();

	            // Wait for the next input fields and input values
	            WebElement firstInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")));
	            firstInput.sendKeys(FirstDigitPin);

	            WebElement secondInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")));
	            secondInput.sendKeys(SecondDigitPin);

	            WebElement thirdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[3]")));
	            thirdInput.sendKeys(ThirdDigitPin);

	            WebElement fourthInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]")));
	            fourthInput.sendKeys(FourthDigitPin);

	            // Wait for the Submit button to be clickable and then click
	            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text='Submit']")));
	            submitButton.click();

	            // Wait for the dialog and accept it
	            WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1")));
	            okButton.click();
//	            // Try to find the 'Allow' permission button and check if it's enabled
//	            try {
//	                WebElement permissionButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
//
//	                // If the permission button is found and clickable, click it
//	                if (permissionButton.isEnabled()) {
//	                    permissionButton.click(); // Click on the "Allow" button
//	                } else {
//	                    System.out.println("Permission button is not enabled. Skipping this step.");
//	                }
//	            } catch (Exception e) {
//	                // If the button is not found or not clickable, catch the exception and proceed
//	                System.out.println("Permission button is not available. Proceeding to the next step.");
//	            }

//	            // Wait for the permission allow button to be clickable and then click
//	            WebElement permissionButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
//	            permissionButton.click();

	            // Wait for the app to load or perform any actions here
	            // Now check if the "Select Property" element is visible and click on "SuperNova Gaming Hub" if it is.
//	            try {
//	                WebElement selectPropertyText = wait.until(ExpectedConditions.visibilityOf(SelectPropertyTitle_OnStep3));
//	                System.out.println("Select Property text is visible.");
//
//	                // If "Select Property" is visible, click on "SuperNova Gaming Hub"
//	                WebElement superNovaGamingHubText = wait.until(ExpectedConditions.visibilityOf(SuperNovaGamingHub_PropertyOnLoginPage));
//	                superNovaGamingHubText.click();
//	                System.out.println("SuperNova Gaming Hub clicked.");
//	                
//	                DOneButton_OnStep3.click();
//	            } catch (TimeoutException e) {
//	                // "Select Property" is not visible, continue with the next steps
//	                System.out.println("Select Property is not visible. Continuing with the next steps.");
//	            }
//
//	            // Continue with the rest of the steps (if any) or the end of the login process.
//	            System.out.println("App launched successfully!");
	            System.out.println("App launched successfully!");

	        }  catch (Exception e) {
//	            e.printStackTrace();
//	            System.out.println("Login failed");
	        }
		 
	
	}
}
