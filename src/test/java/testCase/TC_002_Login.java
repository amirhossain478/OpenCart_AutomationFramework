package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_002_Login extends BaseClass {
     
	@Test(groups= {"sanity","master"})
	public void test_Login() throws IOException {
		
		logger.info("Starting TC_002_Login");
		
		try {
			dr.get(rb.getString("appURL"));
			logger.info("HomePage Displayed");

			dr.manage().window().maximize();
			logger.info("maximized the windows");

			HomePage hp = new HomePage(dr);
			logger.info("created object of HomePage");

			hp.clickOnMyAccount();
			logger.info("Click on my account");

			hp.clickLogin();
			logger.info("Click on my login btw");

			LoginPage lp = new LoginPage(dr);
			logger.info("created object of loginpage");

			lp.setEmail(rb.getString("email"));
			logger.info("Provided Email");

			lp.setPassword(rb.getString("password"));
			logger.info("Provided pass");

			lp.clickLogin();
			logger.info("Clicking on login btw");

			boolean targetpage=lp.isMyAccountPageExists();
			if(targetpage) {
				logger.info("Loing success");
				Assert.assertTrue(true);	
			}
			else {
				logger.error("Login failed");
				captureScreen(dr,"test_login");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			logger.fatal("Login failed");
			Assert.fail();
		}

		logger.info("Finished TC_002_Login");

	}

}
