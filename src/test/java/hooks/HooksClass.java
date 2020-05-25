package hooks;

import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass {
	private int port=8082;
	private String host="http://localhost";
	WireMockServer wireMockServer;
	
	@Before()
	public void setUpMockServer() {
WireMockServer wireMockServer = new WireMockServer(port);
		
		wireMockServer.start();
		ResponseDefinitionBuilder mockResponse=new ResponseDefinitionBuilder();
		mockResponse.withStatus(200);
		WireMock.configureFor(host,port);
		WireMock.stubFor(get(urlEqualTo("/getAllEmployees"))
	            .willReturn(mockResponse));
		
	}
	
	@After()
	public void tearDown() {
		if(wireMockServer.isRunning()) 
			wireMockServer.stop();
		
	}

}
