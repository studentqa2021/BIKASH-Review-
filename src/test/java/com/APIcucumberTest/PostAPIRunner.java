package com.APIcucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin={"json:target/cucumber.json"},
		features ={"src/main/resources/postAPI.feature"},
		glue={"com.APIcucumberTest"},
		
		//other options
		monochrome = true
//		dryRun = false,
//		strict = true,
//		tags = {"@Functional_Test","@SmokeTest"}// 1
		
		)

public class PostAPIRunner extends AbstractTestNGCucumberTests {
	

}
