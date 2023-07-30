package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_YourStore {
	WebDriver driver;
	
	public LoginPage_YourStore(WebDriver wd)
	{
		driver=wd;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="Email")WebElement email;
	@FindBy (id="Password")WebElement password;
	@FindBy (xpath="//button[@type='submit']")WebElement loginBtn;
	@FindBy (linkText = "Logout")WebElement logoutLink;
	
	public void enterEmailId(String emailId)
	{
		email.clear();
		email.sendKeys(emailId);
	}
	public void enterPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	public void clickOnLoginButton()
	{
		loginBtn.click();
	}
	public void clickOnLogoutLink()
	{
		logoutLink.click();
	}
	
}
