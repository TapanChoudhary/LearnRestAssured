package com.restTest.com.LearnTest;


import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class ArtifactVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI= "https://google.com";
		
		Response headers = RestAssured
				.get("http://mindappab.cengage.com/__status")
				.then()
				.extract()
				.response();
		System.out.println(headers.asString().split("version\":")[1].split(",")[0]);
		
		System.out.println("=====================================================");
		headers = RestAssured
				.get("https://int-resourcecenter.cengage.info/__status")
				.then()
				.extract()
				.response();
		System.out.println(headers.asString().split("version\":")[1].split("}")[0]);
		
		System.out.println("=====================================================");
		headers = RestAssured.get("http://mindappab-int.cengage.info/__status")
				.then()
				.extract()
				.response();
		System.out.println(headers.asString().split("version\":")[1].split(",")[0]);
		
		System.out.println("=====================================================");
		headers = RestAssured.get("https://mt4-facade-int.cengage.info/services/tools/bundles")
				.then()
				.extract()
				.response();
		System.out.println(headers.asString().split("version\":")[1].split(",")[0]);
		
		System.out.println("=====================================================");
		headers = RestAssured
				.get("https://contentshopper-int.cengage.info/services/tools/bundles/com.cengage.cs.index-core")
				.then()
				.extract()
				.response();
		System.out.println(headers.asString().split("version\":")[1].split(",")[0]);
		
		System.out.println("=====================================================");
		headers = RestAssured
				.get("http://mindtap.cengage.com/mindapp-cxp/status.txt")
				.then()
				.extract()
				.response();
		System.out.println(headers.asString());

	}

}
