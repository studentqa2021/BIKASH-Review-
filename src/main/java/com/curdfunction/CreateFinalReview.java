package com.curdfunction;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateFinalReview {
	static Response response;

	public static void postFinal() {
		JsonObject jo = new JsonObject();
		jo.addProperty("Age", "31");

		RequestSpecification reqspf = RestAssured.given();
		reqspf.body(jo.toString());
		reqspf.header("Content-Type", "application/json");

		response = reqspf.post("https://httpbin.org/post");
		System.out.println(response.prettyPrint());
	}

	public static void postTestCases() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(response.statusCode() == 200);

		soft.assertTrue(response.time() < 3000);

		soft.assertTrue(response.contentType().contains("json"));

		soft.assertTrue(!response.body().asString().equals(null));
			
		soft.assertTrue(response.body().asString().contains("Age"));
			
			JsonPath jp= response.jsonPath();
		soft.assertTrue(jp.get("json.Age").toString().contains("31"));
		

		soft.assertAll();

	}

}
