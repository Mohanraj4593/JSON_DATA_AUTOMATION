package com.api.testing;

import static io.restassured.RestAssured.get;

import java.util.List;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class Count_Daysof_Data {


@Test
public void countNumberOfDaysData() 
{
	
	List<String> days; 
	 days=get("\r\n" + 
	"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
  .then().extract().jsonPath()
  .getList("list.dt_txt");	
	 String[] s=new String[days.size()];
	 int countdays=0;
	 int actualDays=0;
	 int expectedDyas=0;
	 for(int i=0;i<days.size();i++) 
	{s[i]=days.get(i);}

for(int i=1;i<s.length;i++) 
{
	int fd=Integer.valueOf(s[i].substring(8, 10));
	int sd=Integer.valueOf(s[i-1].substring(8, 10));

if(Math.abs(fd-sd)==1)	
{countdays++;}
}

actualDays=countdays;
expectedDyas=4; 
Assert.assertEquals(expectedDyas, actualDays);



}}
