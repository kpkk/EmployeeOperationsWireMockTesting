package Runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue= {"stepDefinition"},features="src/test/java/Features/employeeServices.feature",monochrome=true, format= {"pretty","html:target/report","junit:target/results.html"})
public class EmployeeRunner {

}
