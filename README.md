# RestAssured_Project
This project automates the verification of various restful api's of Restful-booker (https://restful-booker.herokuapp.com/apidoc/index.html).

**The following features are included,**
1. Integrated the TestNG framework as the execution framework to support the customization of the execution flow.
2. Supports the BDD framework using cucumber.
3. Supports the generation of reports using Allure Report.
4. Includes sample code for mocking using Wiremock.
5. Supports the use of static data configuration using Java Properties files and Java Owner Configuration files.

**Covered Testcases,**
1. Assertion of response code
2. Assertion of the response body contains String.
3. Schema validation

**Steps to run the project:**

1. Download and Run the Wiremock using command: **java -jar wiremock-standalone-3.3.1.jar** in a separate command line.
2. Clone the project
3. Run the command: **mvn clean test**
4. To generate the report: **mvn allure: serve**
