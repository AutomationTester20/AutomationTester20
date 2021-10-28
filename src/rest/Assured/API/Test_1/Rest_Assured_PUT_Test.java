package rest.Assured.API.Test_1;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import rest.Payload.Payloads;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Rest_Assured_PUT_Test {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json").body(Payloads.PUT_Payload()).
		when().put("maps/api/place/update/json").
		then().log().all().
		assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
	}

}
