package com.bookerapi.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * The TestNG runner class for running all the feature files
 * 
 * @author Sandhiya
 */
@CucumberOptions(features = "src/test/java/com/bookerapi/features/", glue = { "com.bookerapi.steps",
"com.bookerapi.hooks" }, monochrome = true, publish = true)
public class RunTest extends AbstractTestNGCucumberTests {

}
