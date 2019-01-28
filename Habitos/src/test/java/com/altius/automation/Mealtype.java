package com.altius.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class Mealtype {
	WebDriver d;
    Logger logger =Logger.getLogger(Mealtype.class);

	@BeforeTest()
  	public void browserlauching()
  	{
		PropertyConfigurator.configure("log4jproperties.txt");

	System.setProperty("webdriver.chrome.driver", "../Habitos/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://192.168.1.18:85/");

	d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	WebElement un=d.findElement(By.id("kitchen_user_user_name"));
	WebElement pw=d.findElement(By.id("kitchen_user_password_digest"));
	un.clear();
	pw.clear();


	try {
    un.sendKeys("vivek");
	logger.info("Valid UN is passed to the UN field");
	}
	catch (Exception e) {
		logger.error(e);
		logger.error("Valid data is not passed to the UN field");

	}
	
	try {	
		
		pw.sendKeys("vivek");
		logger.info("Valid password data is passed to the PW field");
	} 
	catch (Exception e) {

		logger.error("Valid password is not passed to the PW field");

	}
    WebElement click=d.findElement(By.name("commit"));
     click.click();
		logger.info("User able to login with Correct UN  &PW");


}
	@Test(priority =1)
	public void mealtypeinsert() throws InterruptedException
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
	// Meal type module button
	try
	{
		WebElement master=d.findElement(By.linkText("Meal Type"));
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
		logger.info("New meal type button is clicked successfully");
	}
	catch(Exception e)
	{
		logger.error("New Meal type button is not get clicked");
		
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
		logger.info("New Meal type  button is again clicked successfully");
	}
	catch (Exception e)
	{

		logger.error("New Meal type button is not again clicked");

	}
	// Validating the Meal type screen
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
		WebElement allergy = d.findElement(By.id("food_category_name"));
		allergy.sendKeys("12345");
		logger.error("Numeric value is accepting in category field");
	}
	catch (Exception e)
	{

		logger.info("Numeric value is not accepting");
	}

	// Allergy name restricting upto 20 characters
	try {
		WebElement allergy = d.findElement(By.id("food_category_name"));
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
	

	WebElement allergynew = d.findElement(By.id("food_category_name"));
	allergynew.clear();

	allergynew.sendKeys("Mealtype");
	WebElement submit = d.findElement(By.name("commit"));
	submit.click();
	submit.click();
     Thread.sleep(2000);
     
	String alert = "has already been taken";         
	WebElement alert1 = d.findElement(By.className("message"));

	if (alert.equals(alert1.getText())) 
	{
		for (int i = 0; i <= 100; i++) 
		{
			String a = "Mealtype";
			WebElement allergy = d.findElement(By.id("food_category_name"));

			String c = a + i;
			allergy.clear();
			allergy.sendKeys(c);
			WebElement submit1 = d.findElement(By.name("commit"));
			submit1.click();
			submit1.click(); 
		    String url ="http://192.168.1.18:85/food_categories?notice=Food+category+was+successfully+created.";
		    if(url.equals(d.getCurrentUrl()))
				{
                   i =100;				
       //  search box  
            WebElement search=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/div[2]/label/input"));       
			search.sendKeys(c);
            WebElement row1=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]"));
				
            
            if(c.equals(row1.getText()))
			{
				
				logger.info("New meal type is inserted successfully");
			}}}}
				/*	d.navigate().to("http://192.168.1.73:4000/normalmenu_sites/menu_planner");
				Thread.sleep(4000);
				for(int j=0;j<=1000;j++)
				{
				WebElement e =d.findElement(By.xpath("html/body/div/div/div[2]/div[4]/div[3]/div[2]/div[3]/div["+(j+1)+"]"));
				
				if(c.equals(e.getText()))
				   {
					logger.info("Created new meal type is fetched successfully from new meal type master");
					j=1001;
				   }
				}
                logger.error("Created new meal type is not fetched from new meal type master");    

			}	}
			else
			{
				logger.error("New meal type is not inserted successfully");
				
			}
				}
		}
		 */
}
	@Test(priority =2)
	public void mealtypeupdate() throws InterruptedException
	{
		// 	
			d.get("http://192.168.1.18:85/food_categories");

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
			search.sendKeys("Mealtype");
	       WebElement update=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[5]/a"));
	       update.click();
		    logger.info("Value is searched and edit button is clicked successfully");
		   }
		   catch(Exception e)
		   {
			  logger.error("Value is not searched and edit button is not clicked"); 
			   
		   }
		
		   
				
			Thread.sleep(2000);	
		   
		// Deleting the existing value and passing the new value
		   WebElement allergynew = d.findElement(By.id("food_category_name"));
			allergynew.clear();
		   allergynew.sendKeys("Meal");
			WebElement submit = d.findElement(By.name("commit"));
			submit.click();
			submit.click();

			String alert = "has already been taken";
			WebElement alert1 = d.findElement( By.xpath("/html/body/div/div/div[2]/div[4]/div/form/article/div[2]/div/div/div/div/label"));

			if (alert.equals(alert1.getText())) 
			{
				for (int i = 0; i <= 100; i++) 
				{
					String a = "Meal";
					WebElement allergy = d.findElement(By.id("food_category_name"));
					// String b =allergy.getAttribute("Value");
					// int i=1;
					String c = a + i;
					allergy.clear();
					allergy.sendKeys(c);
					WebElement submit1 = d.findElement(By.name("commit"));
					submit1.click();
					submit1.click();
				    String url ="http://192.168.1.18:85/food_categories?notice=Food+category+was+successfully+updated.";
				    if(url.equals(d.getCurrentUrl()))
						{
	                      i =100;				
	          //  search box 
	               WebElement search=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/div[2]/label/input"));       
					search.sendKeys(c);
	               WebElement row1=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]"));
					if(c.equals(row1.getText()))
					{
						/*logger.info("Item category is updated successfully");
						d.navigate().to("http://192.168.1.18:85/normalmenu_sites/menu_planner");
						Thread.sleep(4000);
						for(int j=0;j<=1000;j++)
						{
						WebElement e =d.findElement(By.xpath("html/body/div/div/div[2]/div[4]/div[3]/div[2]/div[3]/div["+(j+1)+"]"));
						
						if(c.equals(e.getText()))
						   {
							logger.info("Created new meal type is fetched successfully from new meal type master");
							j=1001;
						   }
						}
		                logger.error("Created new meal type is not fetched from new meal type master");    

						
					}
						}
				}
				
			}*/
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
