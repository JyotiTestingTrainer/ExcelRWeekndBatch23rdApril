package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Feature/LoginFeature.feature",".//Feature/Customers.feature"},
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		tags="@Smoke",
		plugin= {"pretty","pretty:target/Cucumber-Reports/Text_Customers_Report.txt"}		
		)


//"html:target/Cucumber-Reports/Html_Customers_Report.html"
//junit:target/Cucumber-Reports/XML_Customers_Report.xml
//json:target/Cucumber-Reports/Json_Customers_Report.json
//pretty:target/Cucumber-Reports/Text_Customers_Report.txt
public class RunClass {
// This will be an Empty
}
