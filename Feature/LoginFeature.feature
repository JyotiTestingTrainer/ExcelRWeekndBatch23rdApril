Feature: LoginPage_YourStore
@Smoke
  Scenario: Successful Login with Valid Credentials
    			Given User Launch Chrome Browser
    			When User Opens URL "https://admin-demo.nopcommerce.com/login"
    			And User enter Email id as "admin@yourstore.com" and Enter Password as "admin"
    			And User Click on Login button
    			Then Page Title should be "Dashboard / nopCommerce administration"
    			When User click on Logout Link
    			Then After Logout Page Title should be "Your store. Login"
    			And Close Browser

@Sanity @Regression
Scenario Outline: Successful Login with Valid Credentials DDT
    			Given User Launch Chrome Browser
    			When User Opens URL "https://admin-demo.nopcommerce.com/login"
    			And User enter Email id as "<email>" and Enter Password as "<password>"
    			And User Click on Login button
    			Then Page Title should be "Dashboard / nopCommerce administration"
    			When User click on Logout Link
    			Then After Logout Page Title should be "Your store. Login"
    			And Close Browser
    			
    			
Examples:
|email|password|
|admin@yourstore.com|admin|
|test@abc.com|asdf123|