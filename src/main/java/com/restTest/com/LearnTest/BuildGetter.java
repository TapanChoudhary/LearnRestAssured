package com.restTest.com.LearnTest;

import static com.jayway.restassured.RestAssured.get;

import com.jayway.restassured.response.Response;

public class BuildGetter {
	static String CAS_url = "https://int-mt-cas.cengage.info/services/tools/config/features/text";
	static String CAS_PipeLine_url = "https://int-mt-caspipeline.cengage.info/services/tools/config/features/text";
	static String CAS_Renderer_url = "http://cas-renderer.cengage.com/cas-instance-profile/1.1.0/int/cas-instance-profile.json";

	enum Artifacts {
		CAS_CORE("cas.core", CAS_url, 2), CAS_CANONICAL("cas.canonical", CAS_url, 2), SOCOM_SGI("socom", CAS_url,
				2), CAS_EIT("eit", CAS_url, 2), CAS_PIPELINE("cas.pipeline", CAS_PipeLine_url,
						2), CAS_PIPELINE_CANONICAL("cas.pipeline.canonical", CAS_PipeLine_url, 2), SOCOM_SGI_PIPELINE(
								"socom", CAS_PipeLine_url, 2), CAS_RENDERER("renderer-package", CAS_Renderer_url, 1);
		private String splitter;
		private String artifact_Url;
		private int arrayNumber;

		Artifacts(String split, String url, int number) {
			splitter = split;
			artifact_Url = url;
			arrayNumber = number;
		}

		private String getSplitter() {
			return splitter;
		}

		private String getEnvUrl() {
			return artifact_Url;
		}

		private int getArrayNumber() {
			return arrayNumber;
		}

	}

	public static void main(String[] str) {

		String[] env = { "dev", "int", "qa", "stage", "prod" };
		for (String environ : env) {
			System.out.println("===========MINDTAP_" + environ.toUpperCase() + "============\n");
			for (Artifacts artifacts : Artifacts.values()) {
				Response response = get(artifacts.getEnvUrl().replace("int", environ).replace("prod-mt", "mt"));

				System.out.println(artifacts + " = "
						+ response.asString().split(artifacts.getSplitter())[1].split("/")[artifacts.getArrayNumber()]);
			}
		}
	}
}