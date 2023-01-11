package com.restassured_practice;

import org.testng.annotations.Test;

import com.curdfunction.Create;
import com.curdfunction.CreateFinalReview;
import com.curdfunction.Delete;
import com.curdfunction.Read;
import com.curdfunction.Update;
import com.report.ExtentReportAutomation;

public class TestRunner extends ExtentReportAutomation {
	@Test
	public void runcreate() {
//		Create.post();
//		Update.update();
//		Read.readData();
//		Delete.deleteData();
		CreateFinalReview.postFinal();
		CreateFinalReview.postTestCases();
	}
}

