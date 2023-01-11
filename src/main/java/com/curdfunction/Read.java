package com.curdfunction;

import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Read {
	public static void readData() {
		Response response =RestAssured.get("https://httpbin.org/get");
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
