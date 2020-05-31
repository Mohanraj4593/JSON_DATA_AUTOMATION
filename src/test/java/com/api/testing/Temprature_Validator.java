package com.api.testing;

import static io.restassured.RestAssured.get;
import static org.junit.Assert.fail;

import java.util.List;

import org.testng.annotations.Test;

import com.sun.tools.javac.util.ArrayUtils;

import junit.framework.Assert;

public class Temprature_Validator {
	List<Double> temp;
	List<Double> mintemp; 
	List<Double> maxtemp; 
	
	@Test
	public void getData() 
	{
		 
		 temp=get("\r\n" + 
		"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
	  .then().extract().jsonPath()
	  .getList("list.main.temp");
		

		
		 mintemp=get("\r\n" + 
		"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
	  .then().extract().jsonPath()
	  .getList("list.main.temp_min");
		 

		
		 maxtemp=get("\r\n" + 
		"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
	  .then().extract().jsonPath()
	  .getList("list.main.temp_max");
	 }
	
	

	
	
boolean eVal=true;
boolean aVal;



@Test
public void tempAndminTempValidation() 
{
	for(int i=0;i<temp.size();i++) 
	{
		for(int j=0;j<mintemp.size();j++) 
		{
			if(temp.get(i).doubleValue()>=mintemp.get(j).doubleValue()) 
			{	aVal=true;
				Assert.assertEquals(eVal, aVal);
			}
			
			
			else {
				Assert.fail("Temperature is minimum");
			}
			
			Object[] a=temp.toArray();
			for (Object o :a) {
				System.out.println(o);
			}
		}
	}
}			
			
	@Test
	public void tempAndmaxTempValidation() 
	{
		for(int i=0;i<temp.size();i++) 
		{
			for(int j=0;j<maxtemp.size();j++) 
			{
				if(temp.get(i).doubleValue()<=maxtemp.get(j).doubleValue()) 
				{	aVal=true;
					Assert.assertEquals(eVal, aVal);
				}
				else {
					Assert.fail("Temperature is exceeding the max limit");
				}
				
			}
		}
	

			
	}
	

}
