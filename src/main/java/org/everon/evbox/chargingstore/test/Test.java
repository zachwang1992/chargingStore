package org.everon.evbox.chargingstore.test;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;

/**
 * This class implements some HTTP requests (GET, POST, PUT) to test the designed web service.
 * @author Wang Long
 *
 */

public class Test {

	public static void main(String[] args) {
		
		final String URL = "http://localhost:8080/chargingstore/webapi/chargingSessions";
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		Scanner scanner = new Scanner(System.in); 
		while(true) {
			System.out.println("Please input command:");
			System.out.println("eg. POST /chargingSessions, PUT /chargingSessions, "
					+ "GET /chargingSessions, GET /chargingSessions/summary, quit");
	
			String command = scanner.nextLine();
			if(command.equals("GET /chargingSessions")) {
				HttpResponse<JsonNode> response = Unirest.get(URL)
						.header("Accept", "application/json")
						.asJson();

				String responseBody = response.getBody().toString();
				JsonElement je = jp.parse(responseBody);
				String formattedBody = gson.toJson(je);
				System.out.println(formattedBody);
				System.out.println();
				
			}else if(command.equals("POST /chargingSessions")) {
				System.out.println("Please input the stationId:");
				String stationId = scanner.nextLine();
				JSONObject body = new JSONObject();
				body.put("stationId", stationId);
				HttpResponse<JsonNode> response = Unirest.post(URL)
						.header("Accept", "application/json")
						.header("Content-Type", "application/json")
						.body(body)
						.asJson();
				
				String responseBody = response.getBody().toString();
				JsonElement je = jp.parse(responseBody);
				String formattedBody = gson.toJson(je);
				System.out.println(formattedBody);
				System.out.println();
				
			}else if(command.equals("PUT /chargingSessions")) {
				System.out.println("Please input the charging session id:");
				String id = scanner.nextLine();
				HttpResponse<JsonNode> response = Unirest.put(URL + "/{id}")
						.routeParam("id", id)
						.header("accept", "application/json")
						.asJson();
				
				String responseBody = response.getBody().toString();
				JsonElement je = jp.parse(responseBody);
				String formattedBody = gson.toJson(je);
				System.out.println(formattedBody);
				System.out.println();
				
			}else if(command.equals("GET /chargingSessions/summary")) {
				HttpResponse<JsonNode> response = Unirest.get(URL + "/summary")
						.header("Accept", "application/json")
						.asJson();
				
				String responseBody = response.getBody().toString();
				JsonElement je = jp.parse(responseBody);
				String formattedBody = gson.toJson(je);
				System.out.println(formattedBody);
				System.out.println();
				
			}else if(command.equals("quit")) {
				break;
				
			}else {
				System.out.println("Invalid command!");
				continue;
			}
			
		}
		
		scanner.close();
		
	}

}
