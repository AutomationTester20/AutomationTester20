package rest.Assured.API.Test_1;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Rest_Assured_Get_Test {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String ResponseAddress=given().log().all().queryParam("key","qaclick123").
		queryParam("place_id","2f81b9cb325aa12b5b02765eec35f360").
		when().get("maps/api/place/get/json").
		then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(ResponseAddress);
		String actualAddress=js.getString("address");
		System.out.println(actualAddress);
	}

}
