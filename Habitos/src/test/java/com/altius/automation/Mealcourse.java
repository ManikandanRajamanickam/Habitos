package com.altius.automation;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mealcourse {

	WebDriver d;
    Logger logger =Logger.getLogger(Mealcourse.class);

	@BeforeTest()
  	public void browserlauching()
  	{
		PropertyConfigurator.configure("log4jproperties.txt");

	System.setProperty("webdriver.chrome.driver", "../Habitos/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://192.168.1.18:85/");

	d.manage().window().maximize();
	
	
    try
    {
    	
    	d.findElement(By.id("kitchen_user_user_name")).clear();
		d.findElement(By.id("kitchen_user_user_name")).sendKeys("vivek");
		logger.info("Valid UN is passed to the UN field");
    }
    catch(Exception e)
    {
    	
    	logger.error("Valid UN data is not passed");
    }
    try
    {
    	d.findElement(By.id("kitchen_user_password_digest")).clear();
     
		d.findElement(By.id("kitchen_user_password_digest")).sendKeys("vivek");
    }
    catch(Exception e)
    {
		logger.error("Valid password is not passed to the PW field");
    }
	d.findElement(By.name("commit")).click();

  	}
	
	
	@Test(priority =1)
	public void mealcoursesinsert() throws InterruptedException
	{
	d.findElement(By.xpath("/html/body/div/div/header/nav/div/ul/li[1]/a/i")).click();
	// master module
	try
	{
		WebElement master=d.findElement(By.xpath("/html/body/div/nav/div[2]/a[6]"));
		master.click();
		logger.info("Meal course bar is clicked successfully");
	}
	catch(Exception e)
	{
		logger.error("Meal course bar is not get clicked");
	}
	Thread.sleep(2000);
	// Meal type module button
	try
	{
		WebElement master=d.findElement(By.linkText("Meal Course"));
		master.click();
		logger.info("Meal type - side bar is clicked successfully");
	}
	catch(Exception e)
	{
		
		logger.error("Meal type- side bar is not get clicked");
	}
	Thread.sleep(2000);
	

	    //New Meal type button
	try
	{                                              
		WebElement master=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3/span/a"));
		master.click();
		logger.info("New meal course button is clicked successfully");
	}
	catch(Exception e)
	{
		logger.error("New Meal course button is not get clicked");
		
	}
	// Back button
	try
	{
		WebElement allergy=d.findElement(By.linkText("Back"));
		allergy.click();
		logger.info("Back button is clicked successfully");
	}
	catch(Exception e)
	{
		
		logger.error("Back button is not clicked");
		
	}
	
	// Again clicking the new meal type button
	try {
		WebElement master = d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3/span/a"));
		master.click();
		logger.info("New Meal course  button is again clicked successfully");
	}
	catch (Exception e)
	{

		logger.error("New Meal course button is not again clicked");

	}
	// Validating the Meal type screen
	System.out.println("The page title 1 is :"+d.getTitle());
	try {
		WebElement allergy = d.findElement(By.name("commit"));
		allergy.click();
		logger.info("Submit button is clicked successfully - to check validation");
	}
	catch (Exception e) {

		logger.error("Submit button is not clicked successfully - to check validation");
	}
	// Numeric values  passing to allergy field
	try {
		WebElement allergy = d.findElement(By.id("meal_course_meal_course_name"));
		allergy.sendKeys("12345");
		logger.error("Numeric value is accepting in category field");
	}
	catch (Exception e)
	{

		logger.info("Numeric value is not accepting");
	}

	// Allergy name restricting upto 20 characters
	try {
		WebElement allergy = d.findElement(By.id("meal_course_meal_course_name"));
		allergy.clear();

		allergy.sendKeys("adnhufherfuljikdhfnduk");

		logger.error("Meal course field is accepting more than 20 characters");
	}
	catch(Exception e)
	{
		
		logger.info("Meal course field is not accepting more than 20 characters");
		
	}
	
	
	// Inserting the allergy field
	Thread.sleep(2000);
	

	 WebElement allergynew = d.findElement(By.id("meal_course_meal_course_name"));
		allergynew.clear();
	   allergynew.sendKeys("Mealcourse");
		WebElement submit = d.findElement(By.name("commit"));
		submit.click();
		submit.click();
		String alert = "has already been taken";
		WebElement alert1 = d.findElement( By.xpath("/html/body/div/div/div[2]/div[4]/div/form/article/div[2]/div/div/div/div/label"));

		if (alert.equals(alert1.getText())) 
		{
			for (int i = 0; i <= 100; i++) 
			{
				String a = "Mealcourse";
				WebElement allergy = d.findElement(By.id("meal_course_meal_course_name"));
				// String b =allergy.getAttribute("Value");
				// int i=1;
				String c = a + i;
				allergy.clear();
				allergy.sendKeys(c);
				WebElement submit1 = d.findElement(By.name("commit"));
				submit1.click();
				submit1.click();
			    String content ="MEAL COURSESNEW MEAL COURSE";
			    WebElement title =d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3"));
			    if(content.equals(title.getText()))
					{
			    		
			    	Thread.sleep(2000);
			   	 List  <WebElement> rows =d.findElements(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[1]"));  
			   	 
			   	   logger.info(" The number of row is "+rows.size());
			   	   
			   	for(int j=1;j<=rows.size();j++)
			   	{
			   		
			   		WebElement row1 =d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/table/tbody/tr["+(j)+"]/td[1]"));
			   		if(c.equals(row1.getText()))
			   		{
			   			logger.info("Meal courses is inserted successfully");
			   			i=101;
			   		}
			   		
			   	}
					
				}
	
			}
			}
		}
		   

	@Test(priority =2)
	public void mealcourseupdate() throws InterruptedException
	{
			d.get("http://192.168.1.18:85/meal_courses");

     // clicking the edit option
			WebElement data =d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[1]"));
			String a=data.getText();
			WebElement edit =d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/table/tbody/tr[1]/td[6]/a"));
		  
			edit.click();
		// Deleting the existing value and passing the new value
		   WebElement allergynew = d.findElement(By.id("meal_course_meal_course_name"));
			allergynew.clear();

			String e=a+1;
			
			WebElement allergy = d.findElement(By.id("meal_course_meal_course_name"));
			allergy.sendKeys(e);
			WebElement submit1 = d.findElement(By.name("commit"));
			submit1.click();
			submit1.click();
			 String content ="MEAL COURSESNEW MEAL COURSE";
			    WebElement title =d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3"));
			    if(content.equals(title.getText()))
					{
			    		
			    	Thread.sleep(2000);
			   	 List  <WebElement> rows =d.findElements(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/table/tbody/tr/td[1]"));  
			   	 
			   	   logger.info(" The number of row is "+rows.size());
			   	   
			   	for(int j=1;j<=rows.size();j++)
			   	{
			   		
			   		WebElement row1 =d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/table/tbody/tr["+(j)+"]/td[1]"));
			   		if(e.equals(row1.getText()))
			   		{
			   			logger.info("Meal courses is updated successfully");
			   		}
			   		
			   	}
				}

	} 
	
	
		
	@AfterTest()
	public void aftertest()
	{
		d.quit();
		logger.info("Browser is closed successfully ");
	}


}
