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
	 
	
System.out.println(temp);
System.out.println(mintemp);
System.out.println(maxtemp);
System.out.println("========================================================");
System.out.println(temp.size());
System.out.println(mintemp.size());
System.out.println(maxtemp.size());


}
	
boolean eValue=true;
@Test
public void temperatureValidation() 
{
	int i,j,k;
	for(i=0;i<temp.size();i++) 
	{
		for(j=0;j<mintemp.size();j++) 
		{
				/*for(k=0;k<maxtemp.size();k++) 
				{
				if(temp.get(i)<mintemp.get(j)&&temp.get(i)>maxtemp.size())	
				{
					Assert.fail(temp.get(i)+"is gretaer than "+maxtemp.get(j)+" "+temp.get(i)+"is less than "+mintemp.get(j));
				}
				else {
					Assert.assertEquals(eValue,temp.get(i)==mintemp.get(j));
				}
		
				}*/
			double a[]=new double[temp.size()];
			double[] arr = temp.stream().mapToDouble(Double::doubleValue).toArray(); 
System.out.println("Converted value "+arr);
		//	Assert.assertEquals(eValue,temp1>=tempmin1);
		}
	}


}






}
