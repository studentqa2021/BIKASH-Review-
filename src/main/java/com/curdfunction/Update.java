package com.curdfunction;

import org.testng.asserts.SoftAssert;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Update {
	public static void update() {
		JsonObject json = new JsonObject();
		json.addProperty("NAME", "BIKASH");
		json.addProperty("ADDRESS", "USA");
		json.addProperty("BATCH", "29");
		// converting into Json
		RequestSpecification rs = RestAssured.given();
		rs.body(json.toString());
		rs.header("Content-Type","application/json");
		Response response = rs.post("https://httpbin.org/post");
		System.out.println(response.prettyPrint());
		
		System.out.println("status code found: " +	response.statusCode());
		SoftAssert soft = new SoftAssert();
		//response.statusCode();
		soft.assertEquals(	response.statusCode(), 200);
		
		System.out.println("Response time found :"+response.time());
		soft.assertTrue(response.time()<2000);
		
		System.out.println("data formate found :"+response.contentType());
		soft.assertTrue(response.contentType().contains("json"));
		
		System.out.println("Data should not be null:"+response.body());
		soft.assertTrue(!response.body().equals(null));
		soft.assertAll();
	}

}
