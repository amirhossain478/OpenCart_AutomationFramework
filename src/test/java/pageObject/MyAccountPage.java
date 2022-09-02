package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
WebDriver dr;
	
	public MyAccountPage(WebDriver dr)
	{
		this.dr=dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
		
}