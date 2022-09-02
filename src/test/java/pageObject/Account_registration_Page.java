package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account_registration_Page {

	WebDriver dr;

	public Account_registration_Page(WebDriver dr) {
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}

	@FindBy(name="firstname")
	WebElement txtFirstName;

	@FindBy(name="lastname")
	WebElement txtLastName;

	@FindBy(name="email")
	WebElement txtemail;

	@FindBy(name="telephone")
	WebElement txtTelephone;

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(name="confirm")
	WebElement txtConfirmPassword;

	@FindBy(name="agree")
	WebElement txtchkPolicy;

	@FindBy(xpath="//input[@value='Continue']")
	WebElement btwContinue;

	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!'")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setTelePhone(String tel) {
		txtTelephone.sendKeys(tel);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String cnfpwd) {
		txtConfirmPassword.sendKeys(cnfpwd);
	}

	public void setPrivacyPolicy() {
		txtchkPolicy.click();
	}
	
	public void setClicOnContinue() {
		btwContinue.click();
	}

	public String setGetConfirmationmsg() {
		try {
			return (msgConfirmation.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}








}
