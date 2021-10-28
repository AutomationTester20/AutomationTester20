package rest.Assured.API.Test_1;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import rest.Payload.Payloads;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Rest_Assured_POST_Test1 {

	public static void main(String[] args) {
		
	RestAssured.baseURI="https://rahulshettyacademy.com/";
	String Response =given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
	.body(Payloads.payload())
	.when().post("maps/api/place/add/json")
	.then().assertThat().statusCode(200)
	.body("scope",equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();
	System.out.println(Response);
	
	JsonPath js=new JsonPath(Response); // This is for parsing JsonResponse 

	String PlaceID=js.getString("place_id");
	System.out.println(PlaceID);
			
	
	}

	

}
