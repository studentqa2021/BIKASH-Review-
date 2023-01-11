package com.APIcucumberTest;

import com.curdfunction.CreateFinalReview;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepDef {
	@Given("setup test data into json & use post method")
	public void setup() {
		CreateFinalReview.postFinal();
	}

	@Then("validate test cases")
	public void postTestCasesValidate() {
		CreateFinalReview.postTestCases();
	}

}
