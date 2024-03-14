Flight Reservation System - TEST

Flight Reservation System is a web application designed to facilitate the booking of flight tickets online. This README provides instructions for automating tests for this system.

Application Details

URL: Flight Reservation System - https://flight-reservation.cx24.net/
Project Structure

CodeMaxProject: Root directory of the automation project.
pages: Page object classes.
test: Test classes for each test case.
src/test/java/com/qa: Source code for test cases.
Test 1: Valid Flight Reservation,
Test 2: Empty Payment,
Test 3: Empty Fields,

utilities: Utility classes for reading data from Excel files and configuration.
com.qa.utilities,
ExcelDataReader.java,
ReadConfig.java,
XLUtils.java,

configuration: config.properties

excel: Excel files containing test data.
/excel/man-.jpg,
/excel/testdata22.xlsx

screenshots: Test output after each test.

test-output: TestNG test results.

pom.xml: Maven project configuration file.

testng.xml: TestNG suite configuration file.

Prerequisites
Java, Maven, Selenium WebDriver, TestNG

Setup Instructions
Clone the repository to your local machine.
Import the project into Eclipse or your preferred IDE.
Configure the project build path and dependencies using Maven.
Ensure the required web drivers (edgedriver).
Update the test data in Excel files located in the excel directory.
Run the testng.xml file or individual test classes to execute the tests.

Frameworks and Concepts Used
Hybrid framework,
DataDrivern,
TestNG,
Object-Oriented Programming (OOPS) concepts,
Screenshots captured after each test execution.
