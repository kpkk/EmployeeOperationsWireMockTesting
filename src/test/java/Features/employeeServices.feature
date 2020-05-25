Feature: verification of all employee related 

Scenario Outline: to query for all employees
Given : i have the endpoint "<endpoint>"
When  : i hit the endpoint with get operation
Then : i should be able to get the details of all employees

Examples:
|endpoint|
|http://localhost:8081/getAllEmployees|

Scenario Outline: to query a particular employee by name
Given : i have the endpoint "<endpoint>"
When : i hit the endpoint with get operation by passing name as path param
Then : i should be able to get the detasils of all employees

Examples:
|endpoint|
|http://localhost:8081/getEmployee/pradeep|

Scenario Outline: to validate the functionality of creating a new employee
Given : i have the endpoint "<endpoint>"
When : i hit the endpoint by passing requet body and post method
Then : i should be able to verfiy the successmessage

Examples:
|endpoint|
|http://localhost:8081/employee|

Scenario Outline: to validate the functionality of creating a list new employees
Given : i have the endpoint "<endpoint>"
When : i hit the endpoint by passing requet body contains the list of employee details and post method
Then : i should be able to verfiy the response body

Examples:
|endpoint|
|http://localhost:8081/employee/createWithArray|

Scenario Outline: to validate the functionality of creating an array new employees
Given : i have the endpoint "<endpoint>"
When : i hit the endpoint by passing requet body contains the array of employee details and post method
Then : i should be able to verfiy the response body

Examples:
|endpoint|
|http://localhost:8081/employee/createWithArray|

Scenario Outline: to validate the functionality of deleting an employee
Given : i have the endpoint "<endpoint>"
When : i hit the endpoint with path param with delete method
Then : i should be able to verfiy the successmessage

Examples:
|endpoint|
|http://localhost:8081/deleteEmployee/rafa|


Scenario Outline: to validate the functionality of updating a new employee
Given : i have the endpoint "<endpoint>"
When : i hit the endpoint by passing requet body and the path param with update method
Then : i should be able to verfiy the successmessage

Examples:
|endpoint|
|http://localhost:8081/employee/rafa|



