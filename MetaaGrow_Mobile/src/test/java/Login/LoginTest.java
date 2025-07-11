package Login;

import org.testng.annotations.Test;

import General_Utility.BaseClass;
import POM.Dashboard;

public class LoginTest extends BaseClass {
	
	@Test
	public void loginTest()
	{
		Dashboard db = new Dashboard(driver);
		db.VerifyDashboardTextDisplay(driver);
//		db.CheckWelcomeTextDisplay(driver);
		
	}

}
