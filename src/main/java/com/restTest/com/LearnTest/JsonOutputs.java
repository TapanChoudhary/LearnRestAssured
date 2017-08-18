package com.restTest.com.LearnTest;

import static com.jayway.restassured.RestAssured.get;
import com.jayway.restassured.response.Response;

public class JsonOutputs {

	public static void main(String[] args) {
		
		Response response = get("https://int-resourcecenter.cengage.info/__status").prettyPeek();
		
		System.out.println(response.getHeader("version:"));

	}

}
