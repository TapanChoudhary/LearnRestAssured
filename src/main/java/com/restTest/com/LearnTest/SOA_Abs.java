package com.restTest.com.LearnTest;

import static com.jayway.restassured.RestAssured.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jayway.restassured.response.Response;

import groovy.json.JsonException;

public class SOA_Abs {

	public static void main(String[] args) throws JsonException {

		String mt4FacadeNamePath = "statuses.name";
		Map<String, String> keyValues = new HashMap<String, String>();
		String Url = "https://mt4-facade-int.cengage.info/services/tools/bundles";

		Response resp = get(Url);

		ArrayList<String> artifacts = resp.jsonPath().get("statuses.name");
		ArrayList<String> versions = resp.jsonPath().get("statuses.version");

		Iterator<String> keys = artifacts.iterator();
		Iterator<String> values = versions.iterator();

		while (keys.hasNext() && values.hasNext()) {
			keyValues.put(keys.next(), values.next());
		}

		System.out.println(keyValues.get("MT4 :: Facade :: API"));

	}

}
