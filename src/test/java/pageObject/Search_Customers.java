package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Customers {
	WebDriver driver;
	
	public Search_Customers(WebDriver wd)
	{
		driver=wd;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//nav[@class='mt-2']/child::ul/li[4]/child::a")
	WebElement customerMenu;
	
	@FindBy (xpath="//nav[@class='mt-2']/child::ul/li[4]/child::ul/child::li[1]/child::a")
	WebElement customerMenuItem;
	
	@FindBy (id="SearchEmail") WebElement SearchEmail;
	@FindBy (id="SearchFirstName") WebElement SearchFirstName;
	@FindBy (id="search-customers") WebElement SearchBtn;
	@FindBy (xpath="//table[@id='customers-grid']/child::tbody/child::tr[1]/child::td[3]") 
	WebElement userName;
	@FindBy (xpath="//table[@id='customers-grid']/child::tbody/child::tr[1]/child::td[2]") 
	WebElement userEmailId;
	
	public void clickOnCustomersMenu()
	{
		customerMenu.click();
	}
	public void clickOnCustomersMenuItem()
	{
		customerMenuItem.click();
	}
	public String pageTitle()
	{
		return driver.getTitle();
	}
	public void searchCustomerByEmailId(String emailid)
	{
		SearchEmail.sendKeys(emailid);
	}
	public void searchCustomerByFirstName(String fn)
	{
		SearchFirstName.sendKeys(fn);
	}
	public void clickOnSearchButton() throws InterruptedException
	{
		SearchBtn.click();
		Thread.sleep(2000);
	}
	public String verifyCustomersName() throws InterruptedException
	{
		Thread.sleep(2000);
		return userName.getText();
	}
	public String verifyCustomersEmailId() throws InterruptedException
	{
		Thread.sleep(2000);
		return userEmailId.getText();
	}
	
}
