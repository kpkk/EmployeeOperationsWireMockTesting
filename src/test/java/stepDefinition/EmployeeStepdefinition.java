package stepDefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeStepdefinition {
	
	public Response response;
	
	
	@Given("^: i have the endpoint \"(.*)\"$")
	public void i_have_the_endpoint(String endpoint) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	
		RestAssured.baseURI=endpoint;
	}
	

	@When("^: i hit the endpoint with get operation$")
	public void i_hit_the_endpoint_with_get_operation() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		 response = RestAssured.given().log().all().get();
	    
	}

	@Then("^: i should be able to get the details of all employees$")
	public void i_should_be_able_to_get_the_details_of_all_employees() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response.prettyPrint();
	    
	}

	@When("^: i hit the endpoint with get operation by passing name as path param$")
	public void i_hit_the_endpoint_with_get_operation_by_passing_name_as_path_param() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 response = RestAssured.given().log().all().get();
		
	    
	}

	@Then("^: i should be able to get the detasils of all employees$")
	public void i_should_be_able_to_get_the_detasils_of_all_employees() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		response.prettyPrint();
		/*JsonPath jsonPath = response.jsonPath();
		List<String> list = jsonPath.get();
		
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println(list.size());*/
		
	    
	}

	@Given("^: i have the baseURI and the appliction is running$")
	public void i_have_the_baseURI_and_the_appliction_is_running() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^: i hit the endpoint by passing requet body and post method$")
	public void i_hit_the_endpoint_by_passing_requet_body_and_post_method() throws Throwable {
		
		String body= "{\r\n" + 
				"	\"employeeId\":1,\r\n" + 
				"	\"employeeName\":\"roger\",\r\n" + 
				"	\"department\":\"ec\"\r\n" + 
				"}";
	    // Write code here that turns the phrase above into concrete actions
		
		response = RestAssured.given().log().all().contentType(ContentType.JSON).body(body).post();
		response.prettyPrint();
	    
	}

	@Then("^: i should be able to verfiy the successmessage$")
	public void i_should_be_able_to_verfiy_the_successmessage() throws Throwable {
		
		response.prettyPrint();
		
		//System.out.println(response.prettyPrint());
		//System.out.println(response.getStatusCode());
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Given("^: i have the baseURI and the application is running$")
	public void i_have_the_baseURI_and_the_application_is_running() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^: i hit the endpoint by passing requet body contains the list of employee details and post method$")
	public void i_hit_the_endpoint_by_passing_requet_body_contains_the_list_of_employee_details_and_post_method() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    String body="[{\r\n" + 
	    		"	\"employeeId\":1,\r\n" + 
	    		"	\"employeeName\":\"roger\",\r\n" + 
	    		"	\"department\":\"ec\"\r\n" + 
	    		"},\r\n" + 
	    		"{\r\n" + 
	    		"	\"employeeId\":2,\r\n" + 
	    		"	\"employeeName\":\"rafa\",\r\n" + 
	    		"	\"department\":\"ec\"\r\n" + 
	    		"},\r\n" + 
	    		"{\r\n" + 
	    		"	\"employeeId\":3,\r\n" + 
	    		"	\"employeeName\":\"nole\",\r\n" + 
	    		"	\"department\":\"ec\"\r\n" + 
	    		"}\r\n" + 
	    		"]";
	    
	    Response post = RestAssured.given().log().all().contentType(ContentType.JSON).body(body).post();
	    post.prettyPrint();
	    System.out.println(post.getStatusCode());
	}

	@Then("^: i should be able to verfiy the response body$")
	public void i_should_be_able_to_verfiy_the_response_body() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^: i hit the endpoint by passing requet body contains the array of employee details and post method$")
	public void i_hit_the_endpoint_by_passing_requet_body_contains_the_array_of_employee_details_and_post_method() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^: i hit the endpoint by passing requet body and the path param with update method$")
	public void i_hit_the_endpoint_by_passing_requet_body_and_the_path_param_with_update_method() throws Throwable {
		
		String body="{\r\n" + 
				"	\"employeeId\":1,\r\n" + 
				"	\"employeeName\":\"roger\",\r\n" + 
				"	\"department\":\"ec\"\r\n" + 
				"}";
		
		response = RestAssured.given().log().all()
		.contentType(ContentType.JSON).body(body).post();

	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^: i hit the endpoint with path param with delete method$")
	public void i_hit_the_endpoint_with_path_param_with_delete_method() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response = RestAssured.given().log().all()
		.delete();
	    
	}


}
