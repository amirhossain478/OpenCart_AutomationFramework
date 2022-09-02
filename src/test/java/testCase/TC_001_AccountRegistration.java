package testCase;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.Account_registration_Page;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
	@Test(groups= {"regression","master"})
	public void test_account_Registration() throws IOException {
		
		try {
		//reading config.properties file
		dr.get(rb.getString("appUrl"));
		logger.info("Home page displayed");
		dr.manage().window().maximize();
		logger.info("maximized the windows");
		
		//create a object of homepage class and get method
		HomePage hp=new HomePage(dr);
		
		hp.clickOnMyAccount();
		logger.info("Click on My Account");
		
		hp.clickRegister();
		logger.info(" Click on register Button");

		//create a object of class account_registration_class
		Account_registration_Page arp=new Account_registration_Page(dr);

		arp.setFirstName("Amir");
		logger.info("Provided first name");
		
		arp.setLastName("Hossain");
		logger.info("Provided last name");
		
		arp.setEmail(randomesstring()+"@gmail.com"); //abc@gmail.con//xyz@gmail.com
		logger.info("Provided email address");
		
		arp.setTelePhone("3476595444");
		logger.info("Provided phone number");
		
		arp.setPassword("abcxyz");
		logger.info("Provided Password");
		
		arp.setConfirmPassword("abcxyz");
		logger.info("Provided confirm Password");
		
		arp.setPrivacyPolicy(); 
		logger.info("click privacy Policy radio button");
		
		arp.setClicOnContinue();
		logger.info("Click on continue button");
		
		String confirmsg =arp.setGetConfirmationmsg();

		if(confirmsg.equals("Your Account Has Been Created!")) {
			logger.info("Account registration Success");
			Assert.assertTrue(true);
			
		}
		else {
			logger.error("Account registration Failed");
			Assert.assertFalse(false);
		}
		
		}
		catch(Exception e){
			captureScreen(dr,"test_account_Registration");
			logger.error("Account registration Failed");
			Assert.fail();	
		}
		logger.info("Finished TC_001_AccountRegistration");
	}
	
	
}
