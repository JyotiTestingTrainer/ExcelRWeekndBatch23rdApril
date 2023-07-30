Feature: Search_Customers

Background: All Common steps
					Given User Launch Chrome Browser
    			When User Opens URL "https://admin-demo.nopcommerce.com/login"
    			And User enter Email id as "admin@yourstore.com" and Enter Password as "admin"
    			And User Click on Login button
    			Then Page Title should be "Dashboard / nopCommerce administration"
    			When Click on Customers Menu
    			And Click on Customers Menu Item
    			Then After Customer Page Title should be "Customers / nopCommerce administration"

@Sanity
Scenario: Search Customer by Email id
    			When Enter Email id as "james_pan@nopCommerce.com"
    			And Click on Search button
    			Then User name should be "James Pan"
    			When User click on Logout Link
    			Then After Logout Page Title should be "Your store. Login"
    			And Close Browser
    			
 @Regression  			
Scenario: Search Customer by FirstName
    			When Enter FirstName as "Brenda"
    			And Click on Search button
    			Then User Email id should be "brenda_lindgren@nopCommerce.com"
    			When User click on Logout Link
    			Then After Logout Page Title should be "Your store. Login"
    			And Close Browser