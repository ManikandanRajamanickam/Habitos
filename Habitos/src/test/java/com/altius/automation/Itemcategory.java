package com.altius.automation;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Itemcategory {
	WebDriver d;
    Logger logger =Logger.getLogger(Itemcategory.class);

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
	public void itemcategoryinsert() throws InterruptedException
	{

		d.findElement(By.xpath("/html/body/div/div/header/nav/div/ul/li[1]/a/i")).click();
		// master module
		try
		{
			WebElement master=d.findElement(By.xpath("/html/body/div/nav/div[2]/a[6]"));
			master.click();
			logger.info("Master side bar is clicked successfully");
		}
		catch(Exception e)
		{
			logger.error("Master side bar is not get clicked");
		}
		Thread.sleep(2000);
		//Item category module button
		try
		{
			WebElement master=d.findElement(By.linkText("Item Category"));
			master.click();
			logger.info("Item category - side bar is clicked successfully");
		}
		catch(Exception e)
		{
			
			logger.error("Item category - side bar is not get clicked");
		}
		Thread.sleep(2000);
		
//  New Item category button
		try
		{                                              
			WebElement master=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3/span/a"));
			master.click();
			logger.info("New Item category button is clicked successfully");
		}
		catch(Exception e)
		{
			logger.error("New Item catgeory button is not get clicked");
			
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
		
		// Again clicking the new allergy button
		try {
			WebElement master = d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3/span/a"));
			master.click();
			logger.info("New Item category button is again clicked successfully");
		}
		catch (Exception e)
		{

			logger.error("New Item category button is not again clicked");

		}
		// Validating the allergy screen
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
			WebElement allergy = d.findElement(By.id("category_category_name"));
			allergy.sendKeys("12345");
			logger.error("Numeric value is accepting in category field");
		}
		catch (Exception e)
		{

			logger.info("Numeric value is not accepting");
		}

		// Allergy name restricting upto 20 characters
		try {
			WebElement allergy = d.findElement(By.id("category_category_name"));
			allergy.clear();

			allergy.sendKeys("adnhufherfuljikdhfnduk");

			logger.error("Category field is accepting more than 20 characters");
		}
		catch(Exception e)
		{
			
			logger.info("Category field is not accepting more than 20 characters");
			
		}
		
		
		// Inserting the allergy field
		Thread.sleep(2000);
		

		WebElement allergynew = d.findElement(By.id("category_category_name"));
		allergynew.clear();

		allergynew.sendKeys("Lunch");
		WebElement submit = d.findElement(By.name("commit"));
		submit.click();
		submit.click();

		String alert = "has already been taken";
		WebElement alert1 = d.findElement( By.xpath("/html/body/div/div/div[2]/div[4]/div/form/article/div[2]/div/div/div/div/label"));

		if (alert.equals(alert1.getText())) 
		{
			for (int i = 0; i <= 100; i++) 
			{
				String a = "Lunch";
				WebElement allergy = d.findElement(By.id("category_category_name"));
				String c = a + i;
				allergy.clear();
				allergy.sendKeys(c);
				WebElement submit1 = d.findElement(By.name("commit"));
				submit1.click();
				submit1.click();
			    String url ="http://192.168.1.18:85/categories?notice=Category+was+successfully+created.";
			    if(url.equals(d.getCurrentUrl()))
					{
                       i =100;				
           //  search box 
                WebElement search=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/div[2]/label/input"));       
				search.sendKeys(c);
                WebElement row1=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]"));
				if(c.equals(row1.getText()))
				{
					
					logger.info("New Item category is inserted successfully");
					
				}
				else
				{
					logger.info("New Item category is not inserted successfully");
					
				}
					}
			}
			
		}
	}
	@Test(priority=2)
	public void Itemcategoryupdate()
	{
	// 	
		d.get("http://192.168.1.18:85/categories");

		//  Choosing the drop drown option
	 try {
		Select dropdown =new Select (d.findElement(By.name("category_length")));
		dropdown.selectByValue("100");
		logger.info("Drop down option of 100 is selected successfully");
	     }
	 
	 catch(Exception e)
	 {
		 
		 logger.error("Drop down option of 100 is not get selected ");
		 
	 }
	   // Fetching the no of rows                    
	 
	 List  <WebElement> rows =d.findElements(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr/td[1]"));  
	 
	   logger.info("Drop down option is selected to list 100 entries and the number of entry is "+rows.size());
	   
	
	// Searching and finding an option
	   try  
	   {                                       
	 WebElement search=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]/div[2]/label/input"));       
		search.sendKeys("Lunch");
       WebElement update=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]/table/tbody/tr[1]/td[1]"));
       update.click();
	    logger.info("Value is searched and edit button is clicked successfully");
	   }
	   catch(Exception e)
	   {
		  logger.error("Value is not searched and edit button is not clicked"); 
		   
	   }
	   // Viewing the item categroy information
	
	   try
	   {
		WebElement view =d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]/ul/li[1]/a/i"));   
		   
		view.click();
		logger.info("View button is clicked successfully");
	   }
	   catch(Exception e)
	   {
		   
		   logger.error("View button is not clicked");
		   
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
			
			// Update
			
				
			WebElement update=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[1]/table/tbody/tr[1]/td[1]"));
		       update.click();
		    d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div[2]/ul/li[2]/a/i")).click();   
	   
	// Deleting the existing value and passing the new value
	   WebElement allergynew = d.findElement(By.id("category_category_name"));
		allergynew.clear();
	   allergynew.sendKeys("Tea - Break");
		WebElement submit = d.findElement(By.name("commit"));
		submit.click();
		submit.click();

		String alert = "has already been taken";
		WebElement alert1 = d.findElement( By.xpath("/html/body/div/div/div[2]/div[4]/div/form/article/div[2]/div/div/div/div/label"));

		if (alert.equals(alert1.getText())) 
		{
			for (int i = 0; i <= 100; i++) 
			{
				String a = "Tea - Break";
				WebElement allergy = d.findElement(By.id("category_category_name"));
				// String b =allergy.getAttribute("Value");
				// int i=1;
				String c = a + i;
				allergy.clear();
				allergy.sendKeys(c);
				WebElement submit1 = d.findElement(By.name("commit"));
				submit1.click();
				submit1.click();
			    String url ="http://192.168.1.18:85/categories?notice=Category+was+successfully+updated.";
			    if(url.equals(d.getCurrentUrl()))
					{
                      i =100;				
          //  search box 
               WebElement search=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/div[2]/label/input"));       
				search.sendKeys(c);
               WebElement row1=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]"));
				if(c.equals(row1.getText()))
				{
					logger.info("Item category is updated successfully");
					
				}
				else
				{
					logger.info("Item category is not updated ");
					
				}
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
