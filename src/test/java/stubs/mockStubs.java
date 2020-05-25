package stubs;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.github.tomakehurst.wiremock.recording.ResponseDefinitionBodyMatcher;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Contains;
import org.springframework.context.annotation.Description;
import static org.hamcrest.Matchers.containsString;
public class mockStubs {
	
	private int port=8080;
	private String host="localhost";
	WireMockServer wireMockServer;
	
	@BeforeClass
	public void setUp() {
		 wireMockServer = new WireMockRule(wireMockConfig().dynamicPort().dynamicHttpsPort());
      //  WireMockServer wireMockServer = new WireMockServer(port);
		wireMockServer.start();	
		
	}
	
	
	@Test
	@Description("to query for an emloyee information")
	public void stubForQueryEmployees() {
	
		 setUp();
		 
		
			ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
			mockResponse.withStatus(200).withBody("{\r\n" + 
					"    \"employeeId\": 1,\r\n" + 
					"    \"employeeName\": \"pradeep\",\r\n" + 
					"    \"department\": \"IT\"\r\n" + 
					"},\r\n" + 
					"{\r\n" + 
					"    \"employeeId\": 2,\r\n" + 
					"    \"employeeName\": \"roger\",\r\n" + 
					"    \"department\": \"CS\"\r\n" + 
					"},\r\n" + 
					"{\r\n" + 
					"    \"employeeId\": 3,\r\n" + 
					"    \"employeeName\": \"rafa\",\r\n" + 
					"    \"department\": \"EC\"\r\n" + 
					"}").withHeader("Content-Type", "application/json");
			WireMock.configureFor(host,port);
			WireMock.stubFor(WireMock.get(("/getAllEmployees"))
		            .willReturn(mockResponse));
		
		RestAssured.baseURI="http://0.0.0.0:8080/getAllEmployees";
		RestAssured.given()
		.log().all()
		.when()
		.get()
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON);
				
	}
	
	@Test
	@Description("to query for a specific employee")
	public void stubForqueryForOneEmployee() {
	
		 setUp();
		 
		
			ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
			mockResponse.withStatus(200).withBody("{\r\n" + 
					"    \"employeeId\": 1,\r\n" + 
					"    \"employeeName\": \"pradeep\",\r\n" + 
					"    \"department\": \"ss\"\r\n" + 
					"}").withHeader("Content-Type", "application/json");
			WireMock.configureFor(host,port);
			WireMock.stubFor(WireMock.get(("/getAllEmployees"))
		            .willReturn(mockResponse));
		
		RestAssured.baseURI="http://0.0.0.0:8080/employee/pradeep";
		RestAssured.given()
		.log().all()
		.when()
		.get()
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON);
		
	}
	
	@Test
	@Description("to check for login functioality")
	public void stubForlogin() {
	
		 setUp();
		 
		
			ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
			mockResponse.withStatus(200).withHeader("Content-Type", "application/json");
			WireMock.configureFor(host,port);
			WireMock.stubFor(WireMock.get(("/login"))
		            .willReturn(mockResponse));
		
		RestAssured.baseURI="http://0.0.0.0:8080/login";
		Response response = RestAssured.given()
		.log().all()
		.when()
		.get();
		response.prettyPrint();
		if(response.getStatusCode()==200) {
			System.out.println("user has sucesfully loged in..");
		}else {
			System.err.println("unauthorized access...");
		}
		response.toString().equalsIgnoreCase("user pradeep has succesfully logged in");	
		
	}
	@Test
	@Description("to check for logout functioality")
	public void stubForlogout() {
	
		 setUp();
		 
		
			ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
			mockResponse.withStatus(200).withHeader("Content-Type", "application/json");
			WireMock.configureFor(host,port);
			WireMock.stubFor(WireMock.get(("/logout"))
		            .willReturn(mockResponse));
		
		RestAssured.baseURI="http://0.0.0.0:8080/login";
		Response response = RestAssured.given()
		.log().all()
		.when()
		.get();
		response.prettyPrint();
		if(response.getStatusCode()==200) {
			System.out.println("user has sucesfully logged out...");
		}else {
			System.err.println("unexpected error occurred...");
		}
		response.toString().equalsIgnoreCase("user pradeep has succesfully logged out");	
		
	}
	
	@Test()
	@Description("this will create an employee")
	public void stubForCreateEmployee() {
		setUp();
		ResponseDefinitionBuilder response= new  ResponseDefinitionBuilder();
		response.withStatus(201).withBody("{\r\n" + 
				"    \"employeeId\": 1,\r\n" + 
				"    \"employeeName\": \"pradeep\",\r\n" + 
				"    \"department\": \"ss\"\r\n" + 
				"}").withHeader("Content-Type", "application/json");
		
		WireMock.configureFor(host, port);
	 WireMock.stubFor(post("/emplyee")).willReturn(response);
	 
	 RestAssured.baseURI="http://0.0.0.0:8080/employee/";
		ValidatableResponse contentType = RestAssured.given()
		.log().all()
		.when()
		.post()
		.then()
		.log().all()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON);
		contentType.body(containsString("{\r\n" + 
				"    \"employeeId\": 1,\r\n" + 
				"    \"employeeName\": \"pradeep\",\r\n" + 
				"    \"department\": \"IT\"\r\n" + 
				"}"));
		
		  
		
	}
	
	@Test()
	@Description("this will create an employee by list")
	public void stubForCreateEmployeeByList() {
		setUp();
		ResponseDefinitionBuilder response= new  ResponseDefinitionBuilder();
		response.withStatus(201).withBody("{\r\n" + 
				"    \"employeeId\": 1,\r\n" + 
				"    \"employeeName\": \"pradeep\",\r\n" + 
				"    \"department\": \"IT\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"    \"employeeId\": 2,\r\n" + 
				"    \"employeeName\": \"roger\",\r\n" + 
				"    \"department\": \"CS\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"    \"employeeId\": 3,\r\n" + 
				"    \"employeeName\": \"rafa\",\r\n" + 
				"    \"department\": \"EC\"\r\n" + 
				"}").withHeader("Content-Type", "application/json");
		
		WireMock.configureFor(host, port);
	 WireMock.stubFor(post("/emplyee")).willReturn(response);
	 
	 RestAssured.baseURI="http://0.0.0.0:8080/employee/";
		 Response responses = RestAssured.given()
		.log().all()
		.when()
		.post();
		 responses.prettyPrint();
		 if(responses.getStatusCode()==201) {
				System.out.println("user has sucesfully created");
			}else {
				System.err.println("unexecpected error...");
			}
		  
		
	}
	
	
	@Test
	@Description("to delete an employee")
	public void stubFordeleteEmployee() {
	
		 setUp();
		 
		
			ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
			mockResponse.withStatus(200).withBody("{\r\n" + 
					"    \"employeeId\": 1,\r\n" + 
					"    \"employeeName\": \"pradeep\",\r\n" + 
					"    \"department\": \"ss\"\r\n" + 
					"}").withHeader("Content-Type", "application/json");
			WireMock.configureFor(host,port);
			WireMock.stubFor(WireMock.delete(("/delete"))
		            .willReturn(mockResponse));
		
		RestAssured.baseURI="http://0.0.0.0:8080/employee/pradeep";
		RestAssured.given()
		.log().all()
		.when()
		.delete()
		.then()
		.log().all()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON);
		
	}
	
	
	@Description("to update an employee")
	public void stubForUpdateEmployee() {
	
		 setUp();
		 
		
			ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
			mockResponse.withStatus(201).withBody("{\r\n" + 
					"    \"employeeId\": 1,\r\n" + 
					"    \"employeeName\": \"pradeep\",\r\n" + 
					"    \"department\": \"ss\"\r\n" + 
					"}").withHeader("Content-Type", "application/json");
			WireMock.configureFor(host,port);
			WireMock.stubFor(WireMock.patch(("/employee/pradeep"))
		            .willReturn(mockResponse));
		
		RestAssured.baseURI="http://0.0.0.0:8080/employee/pradeep";
		ValidatableResponse contentType = RestAssured.given()
		.log().all()
		.when()
		.delete()
		.then()
		.log().all()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON);
		contentType.body(containsString("employee record has been updated succefully"));
		
	}
	
	@AfterClass
	public void tearDown() {
		if(wireMockServer.isRunning()) 
			wireMockServer.stop();
	}
		
	

}
