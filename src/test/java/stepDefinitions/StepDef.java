package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage_YourStore;
import pageObject.Search_Customers;

public class StepDef {
	WebDriver driver;
	public LoginPage_YourStore loginP;
	public Search_Customers search_Cust;
	
	@Before(order = 1)
	public void SetUp()
	{
		System.out.println("SetUp");
		WebDriverManager.chromedriver().setup();
	    ChromeOptions option=new ChromeOptions();
	    option.addArguments("--remote-allow-origins=*");
	    driver=new ChromeDriver(option);
	}
	
	@Before(order = 2)
	public void before()
	{
		System.out.println("Before Method");
	}

	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	    
	    loginP=new LoginPage_YourStore(driver);
	    search_Cust=new Search_Customers(driver);
	}

	@When("User Opens URL {string}")
	public void user_opens_url(String url) {
		driver.manage().window().maximize();
	    driver.get(url);
	}

	@When("User enter Email id as {string} and Enter Password as {string}")
	public void user_enter_email_id_as_and_enter_password_as(String emailAdd, String passWord) {
		loginP.enterEmailId(emailAdd);
		loginP.enterPassword(passWord);
	}

	@When("User Click on Login button")
	public void user_click_on_login_button() {
		loginP.clickOnLoginButton();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	    
	}
	@When("Click on Customers Menu")
	public void click_on_customers_menu() {
		search_Cust.clickOnCustomersMenu();
	}

	@When("Click on Customers Menu Item")
	public void click_on_customers_menu_item() {
		search_Cust.clickOnCustomersMenuItem();
	}

	@Then("After Customer Page Title should be {string}")
	public void after_customer_page_title_should_be(String expectedTitle) {
	    String actualTitle=search_Cust.pageTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("Enter Email id as {string}")
	public void enter_email_id_as(String emailAdd) {
		search_Cust.searchCustomerByEmailId(emailAdd);
	}
	@When("Enter FirstName as {string}")
	public void enter_first_name_as(String fn) {
		search_Cust.searchCustomerByFirstName(fn);
	}

	
	@When("Click on Search button")
	public void click_on_search_button() throws InterruptedException {
		search_Cust.clickOnSearchButton();
	}
	@Then("User Email id should be {string}")
	public void user_email_id_should_be(String expEmailid) throws InterruptedException {
	    String actualUsersEmailid=search_Cust.verifyCustomersEmailId();
	    Assert.assertEquals(expEmailid, actualUsersEmailid);
	}
	@Then("User name should be {string}")
	public void user_name_should_be(String expectedName) throws InterruptedException {
	    String actualUserName=search_Cust.verifyCustomersName();
	    Assert.assertEquals(expectedName, actualUserName);
	}

	@When("User click on Logout Link")
	public void user_click_on_logout_link() {
		loginP.clickOnLogoutLink();
	}

	@Then("After Logout Page Title should be {string}")
	public void after_logout_page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("Close Browser")
	public void close_browser() {
	    driver.close();
	}

	@After
	public void cleanUp()
	{
		driver.quit();
	}
}
