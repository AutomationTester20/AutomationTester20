package rest.Assured.API.Test_1;

import io.restassured.path.json.JsonPath;
import rest.Payload.ComplexJasonPayload;

public class Rest_Assured_ComplexJsonParse {

	public static void main(String[] args) {
		JsonPath js=new JsonPath(ComplexJasonPayload.complexJason());
		
		// Print No of courses returned by API
		int course =js.getInt("courses.size()");
		System.out.println("Total Course in Json file :" +course);
		
		//Print Purchase Amount
		int purchase =js.getInt("dashboard.purchaseAmount");
		System.out.println("The Purchase amount is : " +purchase);
		
		//Print Title of the first course
		String firstcourse=js.getString("courses[0].title");
		System.out.println("The First Course is : " +firstcourse);
		
		//Print first course price
		int firstcourseprice =js.getInt("courses[0].price");
		System.out.println("The first course pric: "+firstcourseprice);
		
		
		//Print All course titles and their respective Prices
		for(int i=0; i<course;i++) {
			String coursetitles=js.getString("courses["+i+"].title");
			System.out.println(coursetitles);
			System.out.println(js.get("courses["+i+"].price").toString()); //(When we don't what will be the return type then use toString Method)
		}
		
			//Print no of copies sold by RPA Course
			for(int i=0; i<course;i++) 
			{
				String coursetitle=js.get("courses["+i+"].title");
				
				if(coursetitle.equalsIgnoreCase("RPA")) 
				{
					
					int copies=js.get("courses["+i+"].copies");
					System.out.println("Number of copies sold by RPA Course :"+copies);
				}
				
			}
			
		}
		
	}



