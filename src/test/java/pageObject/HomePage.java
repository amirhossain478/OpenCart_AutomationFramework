package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//https://demo.opencart.com/
public class HomePage {
	
	WebDriver dr;
	
	public HomePage(WebDriver dr){
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement linkMyAccount;
	
	@FindBy(linkText="Register")
	WebElement lnkRgister;
	
	@FindBy(linkText="Login")
	WebElement lnkLogin;
	
	
	
	public void clickOnMyAccount() {
		linkMyAccount.click();
	}
	
	public void clickRegister() {
		lnkRgister.click();
	}
	
	public void clickLogin(){
		lnkLogin.click();
	}

}
