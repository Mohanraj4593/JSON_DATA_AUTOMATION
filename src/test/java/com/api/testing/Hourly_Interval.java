package com.api.testing;

import static io.restassured.RestAssured.get;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class Hourly_Interval {


@Test
public void hourlyInterval() 
{
	
	List<String> date; 
	 date=get("\r\n" + 
	"https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22")
   .then().extract().jsonPath()
   .getList("list.dt_txt");	
	 String[] s=new String[date.size()];
	 int t=0;
	
	for(int i=0;i<date.size();i++) 
	{s[i]=date.get(i);}
	
	
	
	int contineous=0;
	int eContineous=0;
	
	for(int k=0;k<s.length;k++) {
		for(int l=1;l<s.length;l++) {
	/*System.out.println("First");
	year1=Integer.valueOf(s[k].substring(0,4));
	System.out.println(year1);
	month1=Integer.valueOf(s[k].substring(5,7));
	System.out.println(month1);
	dates1=Integer.valueOf(s[k].substring(8,10));
	System.out.println(dates1);
	hour1=Integer.valueOf(s[k].substring(11,13));
	System.out.println(hour1);
	
	System.out.println("Second");
	year2=Integer.valueOf(s[l].substring(0,4));
	System.out.println(year2);
	month2=Integer.valueOf(s[l].substring(5,7));
	System.out.println(month2);
	dates2=Integer.valueOf(s[l].substring(8,10));
	System.out.println(dates2);
	hour2=Integer.valueOf(s[l].substring(11,13));
	System.out.println(hour2);
	
	
	
	if (((year1-year2)==0 || (year1-year2)==1 )&& ((month1-month2)==0 || (month1-month2)==1)
			&& ((dates1-dates2)==0 || (dates1-dates2)==1)&& ((hour1-hour2)==1)) {
		count++;
	}*/
	
if((s[k].substring(8, 10).compareTo(s[l].substring(8,10))==0))
{
	if((s[l].substring(11, 13).compareTo(s[k].substring(11,13))==1))
			{
		contineous++;
			}

	else if((s[k].substring(8, 10).compareTo(s[l].substring(8,10))==1)
			&&(s[l].substring(11, 13).compareTo(s[k].substring(11,13))==23))
			{
		contineous=0;
			}
}}}
	if(contineous==24)
	{Assert.assertEquals(eContineous,contineous);}
	else {org.testng.Assert.fail("Not Contineous Interval");}

}
}