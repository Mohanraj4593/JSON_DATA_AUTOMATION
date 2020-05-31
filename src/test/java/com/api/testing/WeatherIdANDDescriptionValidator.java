package com.api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import java.util.List;


public class WeatherIdANDDescriptionValidator{

	@Test
	public void idDescrptionVerify() 
{
	List<String> id; 
				 id=get("\r\n" + 
				"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
			    .then().extract().jsonPath()
			    .getList("list.weather.id");
						  
		List<String> description =new ArrayList<String>(); 
				 description=get("\r\n" + 
				"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
			    .then().extract().jsonPath()
			    .getList("list.weather.description");
				 
      					 
				 
				 
				

				 
		
		int eID=800;
		String eDescription="clear sky";
		int eID1=500;
		String eDescription1="light rain";
	
		/*	while(i!=id.size()&&j!=description.size()) {
			System.out.println(id.get(i));
			get("\r\n" + 
"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22").then().assertThat()
.body("list["+i+"].weather[0].id", equalTo(eID)).body("list["+i+"].weather[0].description",equalTo(eDescription)); 

			get("\r\n" + 
					"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22").then().assertThat()
					.body("list["+i+"].weather[0].id", equalTo(eID1)).body("list["+i+"].weather[0].description",equalTo(eDescription1)); 

i++;
j++;
}*/
		
		//Second Logic
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("\r\n" + 
					"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22");
		 
		 io.restassured.response.ResponseBody body =response.getBody();
		 
		String bodyAsString = body.asString();
		 int l=0;
		while(l!=id.size())
		 {	Assert.assertEquals(eID,id.get(l));
		 	Assert.assertEquals(eDescription,description.get(l));
		 	System.out.println("-------------------------------------");
		 	Assert.assertEquals(eID1,id.get(l));
		 	Assert.assertEquals(eDescription1,description.get(l));

		 }
		
}}