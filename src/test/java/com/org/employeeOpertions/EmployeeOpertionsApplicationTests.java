package com.org.employeeOpertions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import io.restassured.RestAssured;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeOpertionsApplicationTests {
	
	private int port=8081;
	
	private String host="http://localhost";
	
	private String body="{\n" + 
			"    \"employeeId\": 1,\n" + 
			"    \"employeeName\": \"pradeep\",\n" + 
			"    \"department\": \"ss\"\n" + 
			"}";
	
	@Rule()
	//public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort().dynamicHttpsPort());
	public WireMockRule wireMockRule=new WireMockRule(port);
	WireMockServer server= new WireMockServer(port);

	int port1 = wireMockRule.port();
	int httpsPort = wireMockRule.httpsPort();

	//@Test
	void contextLoads() {
	}
	
	@BeforeClass
	public void configureServer() {	
		
		
		server.start();
		ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
		mockResponse.withStatus(200);
		WireMock.configureFor(host,port);
		WireMock.stubFor(get(urlEqualTo("/getAllEmployees"))
	            .willReturn(mockResponse));
	                //.withHeader("Content-Type", "application/json")));
	                
		
	}
	
	@Test
	@Description("to query for an emloyee information")
	public void queryEmployee() {
		RestAssured.baseURI="http://localhost:8081/getAllEmployees";
		RestAssured.given()
		.log().all()
		.when()
		.get()
		.then()
		.assertThat()
		.statusCode(200);
			
		
	}
	
	//@AfterClass
	public void terDown() {
		if(server.isRunning()) 
		server.stop();
	}
		
	

}
