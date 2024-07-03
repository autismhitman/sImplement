/*

package com.neopane.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;


public final class ELKUtils {
	
	
   private ELKUtils() {}
	
	public static void getElkDocs(String testCaseName, String status) {
		
		Map<String, String> hmap = new HashMap<>();
		hmap.put("TestCaseName", testCaseName);
		hmap.put("Status", status);
		hmap.put("ExecutionTime", LocalDateTime.now().toString());
		
		 given()
		.header("Content-Type","application/json") 
		.body(hmap)
		.post("http://localhost:9200/regression/results")
		.then()
		.statusCode(201);
		
	}
	
	

}
*/