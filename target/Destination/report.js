$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("EmployeeServices.feature");
formatter.feature({
  "line": 1,
  "name": "verification of all employee related",
  "description": "",
  "id": "verification-of-all-employee-related",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "to query for all employees",
  "description": "Given: i have the endpoint\r\nWhen: i hit the endpoint with get operation\r\nThen: i should be able to get the details of all employees",
  "id": "verification-of-all-employee-related;to-query-for-all-employees",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.scenario({
  "line": 8,
  "name": "to query a particular employee by name",
  "description": "Given: i have the endpoint\r\nWhen: i hit the endpoint with get operation by passing name as path param\r\nThen: i should be able to get the detasils of all employees",
  "id": "verification-of-all-employee-related;to-query-a-particular-employee-by-name",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.scenario({
  "line": 13,
  "name": "to validate the functionality of creating a new employee",
  "description": "Given: i have the baseURI and the appliction is running\r\nWhen: i hit the endpoint by passing requet body and post method\r\nThen: i should be able to verfiy the successmessage",
  "id": "verification-of-all-employee-related;to-validate-the-functionality-of-creating-a-new-employee",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.scenario({
  "line": 18,
  "name": "to validate the functionality of creating a list new employees",
  "description": "Given: i have the baseURI and the application is running\r\nWhen: i hit the endpoint by passing requet body contains the list of employee details and post method\r\nThen: i should be able to verfiy the response body",
  "id": "verification-of-all-employee-related;to-validate-the-functionality-of-creating-a-list-new-employees",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.scenario({
  "line": 23,
  "name": "to validate the functionality of creating an array new employees",
  "description": "Given: i have the baseURI and the application is running\r\nWhen: i hit the endpoint by passing requet body contains the array of employee details and post method\r\nThen: i should be able to verfiy the response body",
  "id": "verification-of-all-employee-related;to-validate-the-functionality-of-creating-an-array-new-employees",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.scenario({
  "line": 28,
  "name": "to validate the functionality of updating a new employee",
  "description": "Given: i have the baseURI and the appliction is running\r\nWhen: i hit the endpoint by passing requet body and the path param with update method\r\nThen: i should be able to verfiy the successmessage",
  "id": "verification-of-all-employee-related;to-validate-the-functionality-of-updating-a-new-employee",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.scenario({
  "line": 33,
  "name": "to validate the functionality of deleting an employee",
  "description": "Given: i have the baseURI and the appliction is running\r\nWhen: i hit the endpoint with path param with delete method\r\nThen: i should be able to verfiy the successmessage",
  "id": "verification-of-all-employee-related;to-validate-the-functionality-of-deleting-an-employee",
  "type": "scenario",
  "keyword": "Scenario"
});
});