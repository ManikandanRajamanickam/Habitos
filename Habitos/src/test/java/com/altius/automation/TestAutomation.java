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
		// hb.menuplaner(); ( hav to write script)
		// hb.menucycle(); ( hav to write script)
		// hb.individual credentials ( hav to write script )
		// hb.mealtypeinsert();
	    //hb.mealtypeupdate();
  //        hb.mealcoursesinsert();
	      hb.mealcourseupdate();*/
	}
       
 


