package liberary.API.liberary.API;


import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import rest.Payload.AddBookLiberary;

import static io.restassured.RestAssured.*;



public class RestAssured_LiberaryTest {
  
	@Test
  public void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
	String addbook=  given().log().all().header("Content-Type", "application/json").body(AddBookLiberary.AddBookLib())
			.when().post("Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
	JsonPath js=new JsonPath(addbook);
	String id=js.get("ID");
	System.out.println(id);
  }
}
