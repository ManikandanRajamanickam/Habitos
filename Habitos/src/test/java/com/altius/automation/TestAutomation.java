package com.altius.automation;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAutomation {

WebDriver d;
Logger logger =Logger.getLogger(TestAutomation.class);

	@BeforeTest()
  	public void browserlauching()
  	{
		PropertyConfigurator.configure("log4jproperties.txt");

	System.setProperty("webdriver.chrome.driver", "../Habitos/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://192.168.1.73:3004/");

	d.manage().window().maximize();
	
  	}

	
	/*@Test
	public void SCMreport()
	{  
		try {
		//collapse button
		WebElement collapse =d.findElement(By.xpath("/html/body/div/div/header/nav/div/ul/li[1]/a/i"));
		collapse.click();
		logger.info("Collapse button is clicked successfully");
		}
		
		catch(Exception e)
		{
			logger.error(e);
            logger.error("Collapse button is not clicked");			
			
		}
		try
		{
	// SCM module button 
		WebElement scm =d.findElement(By.xpath("/html/body/div/nav/div[2]/a[3]/span"));
		scm.click();
		logger.info("SCM module button is clicked successfully");
		}
		catch(Exception e)
		{
			logger.error("SCM module button is not clicked");
			
		}
		
		// od summary
		try {
		WebElement od = d.findElement(By.xpath("/html/body/div/nav/div[2]/div[2]/a[1]"));

		od.click();
        logger.info("order summary button is clicked successfully");
		
		}
		catch(Exception e)
		{
			logger.error("Order summary button is not clicked ");
			
		}
		// drop down
		try
		{

		Select dropdrown = new Select(d.findElement(By.id("e1")));
		dropdrown.selectByIndex(1);
		logger.info("drop down option is selected");
		}
		catch(Exception e)
		{
			
			logger.error("Drop down is notselcted");
		}
		// From date
		try
		{
		WebElement frm = d.findElement(By.id("txtFrom"));
		frm.sendKeys("2018-12-01");
		frm.sendKeys(Keys.TAB);
        logger.info("From date is passed successfully");
		}
		catch(Exception e)
		{
			logger.error("From date is not passed ");
			
		}
		// To date
		try
		{

		WebElement to = d.findElement(By.id("txtTo"));
		to.sendKeys("2018-12-01");
        logger.info("To date is selcted successfully");
		}
		catch(Exception e)
		{
			logger.error("To date is not selected");
		}
	
	    // Get report
		try
		{
		WebElement report =d.findElement(By.id("report"));
		report.click();
		logger.info("Report is downloaded successfully");
		}
		catch(Exception e)
		{
			logger.error("Repory is not downloaded");
		}
	
		// Entries dropdown
		try
		{
		Select show =new Select(d.findElement(By.name("tenant_detail_length")));
		show.selectByIndex(2);;
		logger.info("option 50 in list box is selected successfully");
		}
		catch(Exception e)
		{
			logger.error("Option 50 is not get selected");
		}
		// scroll down
		 JavascriptExecutor js = (JavascriptExecutor) d;
	        js.executeScript("window.scrollBy(0,10000)");
	        
	        // scroll up
	        JavascriptExecutor js1 = (JavascriptExecutor) d;
	        js1.executeScript("window.scrollBy(10000,0)");
		//Search option
		try
		{
	    WebElement show =d.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/div[2]/div/div/div[1]/div[2]/label/input"));
		show.sendKeys("PSG");
		logger.info("PSG is passed successfully");
		}
		catch(Exception e)
		{
			logger.error("PSG is not passed");
		}
	}
		@Test
		public void individualorder()
	      	{
			try
	      	{
			WebElement scm =d.findElement(By.xpath("/html/body/div/nav/div[2]/a[3]/span"));
			scm.click();
			logger.info("SCM module button is clicked successfully");
			}
			catch(Exception e)
			{
				logger.error("SCM module button is not clicked");
				
			}
			// OD Summary
			try
			{
			WebElement scm =d.findElement(By.linkText("Individual Orders"));
			scm.click();
			logger.info("SCM module button is clicked successfully");
			}
			catch(Exception e)
			{
				logger.error("SCM module button is not clicked");
				
			}	
			
			
		}
		
	@Test
	pu	
	blic void allergyinsert() throws InterruptedException
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
		//Allergy module button
		try
		{
			WebElement master=d.findElement(By.linkText("Allergy"));
			master.click();
			logger.info("Allergy button - side bar is clicked successfully");
		}
		catch(Exception e)
		{
			
			logger.error("Allergy button - side bar is not get clicked");
			
			
		}
		Thread.sleep(2000);
		
//  New allergy button
		try
		{                                              
			WebElement master=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[1]/h3/span/a"));
			master.click();
			logger.info("New Allergy button is clicked successfully");
		}
		catch(Exception e)
		{
			
			logger.error("New allergy button is not get clicked");
			
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
			logger.info("New Allergy button is again clicked successfully");
		} catch (Exception e) {

			logger.error("New allergy button is not again clicked");

		}
		// Validating the allergy screen
		try {
			WebElement allergy = d.findElement(By.name("commit"));
			allergy.click();
			logger.info("Submit button is clicked successfully - to check validation");
		} catch (Exception e) {

			logger.error("Submit button is not clicked successfully - to check validation");

		}
		// Numeric values  passing to allergy field
		try {
			WebElement allergy = d.findElement(By.id("allery_name"));
			allergy.sendKeys("12345");
			logger.error("Numeric value is accepting in allergy name field");
		} catch (Exception e) {

			logger.info("Numeric value is not accepting");

		}

		// Allergy name restricting upto 20 characters
		try {
			WebElement allergy = d.findElement(By.id("allery_name"));
			allergy.clear();

			allergy.sendKeys("adnhufherfuljikdhfnduk");

			logger.error("Allergy field is accepting more than 20 characters");
		}
		catch(Exception e)
		{
			
			logger.info("Allergy field is not accepting more than 20 characters");
			
		}
		
		
		// Inserting the allergy field
		Thread.sleep(2000);
		

		WebElement allergynew = d.findElement(By.id("allery_name"));
		allergynew.clear();

		allergynew.sendKeys("Brinjal cutt");
		WebElement submit = d.findElement(By.name("commit"));
		submit.click();
		submit.click();

		String alert = "has already been taken";
		WebElement alert1 = d.findElement( By.xpath("/html/body/div/div/div[2]/div[4]/div/form/article/div[2]/div/div/div/div/label"));

		if (alert.equals(alert1.getText())) 
		{
			for (int i = 0; i <= 100; i++) 
			{
				String a = "Egg";
				WebElement allergy = d.findElement(By.id("allery_name"));
				// String b =allergy.getAttribute("Value");
				// int i=1;
				String c = a + i;
				allergy.clear();
				allergy.sendKeys(c);
				WebElement submit1 = d.findElement(By.name("commit"));
				submit1.click();
				submit1.click();
			    String url ="http://192.168.1.18:85/alleries?notice=Allery+was+successfully+created.";
			    if(url.equals(d.getCurrentUrl()))
					{
                       i =100;				
           //  search box 
                WebElement search=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/div[2]/label/input"));       
				search.sendKeys(c);
                WebElement row1=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]"));
				if(c.equals(row1.getText()))
				{
					
					logger.info("Allergy is inserted successfully");
					
				}
				else
				{
					logger.info("Allergy is not inserted successfully");
					
				}
					}
			}
			
		}
	}
		
	
	@Test 
	public void allergyupdate()
	{
	// 	
		d.get("http://192.168.1.18:85/alleries");

		//  Choosing the drop drown option
	 try {
		Select dropdown =new Select (d.findElement(By.name("allery_length")));
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
	 WebElement search=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/div[2]/label/input"));       
		search.sendKeys("egg");
       WebElement update=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[5]/a"));
       update.click();
	    logger.info("Value is searched and edit button is clicked successfully");
	}
	   catch(Exception e)
	   {
		  logger.error("Value is not searched and edit button is not clicked"); 
		   
	   }
	// Deleting the existing value and passing the new value
	   WebElement allergynew = d.findElement(By.id("allery_name"));
		allergynew.clear();
	   allergynew.sendKeys("shell fish");
		WebElement submit = d.findElement(By.name("commit"));
		submit.click();

		String alert = "has already been taken";
		WebElement alert1 = d.findElement( By.xpath("/html/body/div/div/div[2]/div[4]/div/form/article/div[2]/div/div/div/div/label"));

		if (alert.equals(alert1.getText())) 
		{
			for (int i = 0; i <= 100; i++) 
			{
				String a = "Shell fish";
				WebElement allergy = d.findElement(By.id("allery_name"));
				// String b =allergy.getAttribute("Value");
				// int i=1;
				String c = a + i;
				allergy.clear();
				allergy.sendKeys(c);
				WebElement submit1 = d.findElement(By.name("commit"));
				submit1.click();
			    String url ="http://192.168.1.18:85/alleries?notice=Allery+was+successfully+updated.";
			    if(url.equals(d.getCurrentUrl()))
					{
                      i =100;				
          //  search box 
               WebElement search=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/div[2]/label/input"));       
				search.sendKeys(c);
               WebElement row1=d.findElement(By.xpath("/html/body/div/div/div[2]/div[4]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[1]/td[1]"));
				if(c.equals(row1.getText()))
				{
					
					logger.info("Allergy is updated successfully");
					
				}
				else
				{
					logger.info("Allergy is not updated ");
					
				}
					}
			}
			
		}
	}	
	@Test
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
	@Test 
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
	
	@Test
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
		    String url ="http://192.168.1.73:4000/food_categories?notice=Food+category+was+successfully+created.";
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
				d.navigate().to("http://192.168.1.73:4000/normalmenu_sites/menu_planner");
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
		 
}
	@Test
	public void mealtypeupdate() throws InterruptedException
	{
		// 	
			d.get("http://192.168.1.73:4000/food_categories");

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
				    String url ="http://192.168.1.73:4000/food_categories?notice=Food+category+was+successfully+updated.";
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
						d.navigate().to("http://192.168.1.73:4000/normalmenu_sites/menu_planner");
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
				
			}
		}	
	
	@Test
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
                logger.error("Meal course is not inserted");
					
				}
					}
			}
		}
		   

	@Test
	public void mealcourseupdate() throws InterruptedException
	{
			d.get("http://192.168.1.73:4000/meal_courses");

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
			   			logger.info("Meal courses is inserted successfully");
			   		}
			   		
			   	}
             logger.error("Meal course is not inserted");
				}
	} */
			
		
	

	
	
	@AfterTest()
	public void browserclose()
	{
		
		d.quit();
		
	}

/*	public static void main(String args[]) throws InterruptedException
	{
		TestAutomation hb = new TestAutomation();
		hb.browserlauching();
		/*
		 * hb.WithoutUNPW(); hb.OnlyCorrectUN(); hb.OnlycorrectPW(); hb.wrongUN();
		 * hb.wrongPW(); hb.wrongUNPW();
		  hb.OnlyCorrectUNPW("vivek", "vivek");
		// hb.SCMreport();
		// hb.individualorder();
		// hb.browserclose();
		// hb.allergyinsert();
		// hb.allergyupdate();
		// hb.itemcategoryinsert();
		// hb.Itemcategoryupdate();
		// hb.menuplaner(); ( hav to write script)
		// hb.menucycle(); ( hav to write script)
		// hb.individual credentials ( hav to write script )
		// hb.mealtypeinsert();
	    //hb.mealtypeupdate();
  //        hb.mealcoursesinsert();
	      hb.mealcourseupdate();*/
	}
       
 


