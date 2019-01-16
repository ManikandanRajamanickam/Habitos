package com.altius.automation;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loginpage {
    WebDriver d;
	@BeforeTest()
   	public void browserlauching()
   	{
		PropertyConfigurator.configure("log4jproperties.txt");

	System.setProperty("webdriver.chrome.driver", "../Habitos/src/test/resources/chromedriver.exe");
	d = new ChromeDriver();
	
	d.get("http://192.168.1.73:3004/");

	d.manage().window().maximize();
	

   	}
	

	    Logger logger =Logger.getLogger(TestAutomation.class);
		String uname1 = "anand";
		String pwd1 = "anand";
		String uname2 = "anand";
		String pwd2 = "anand";

	@Test(priority =1)
   public void WithoutUNPW() 
	{
			try {

				d.findElement(By.name("commit")).click();
				String URL ="http://192.168.1.73:4000/normalmenu_sites/dashboard";
			   if(d.getCurrentUrl().equalsIgnoreCase(URL))
				{
				logger.error("User is able to login without UN and Pw");
				Thread.sleep(2000);
	           }
				System.out.println("The URL is :"+d.getCurrentUrl());
			    } 
			catch (Exception e)
			    {
				logger.error(e);
				logger.info("User is unable to login without data");

			    }
		}

		@Test(priority =2)
		public void wrongUN() {
			try {

				WebElement un = d.findElement(By.id("kitchen_user_user_name"));
				un.sendKeys(uname1);

				logger.info("Invalid data is successfully passed through the Username field");
			  
				d.findElement(By.name("commit")).click();
			} 
			 
			    catch (Exception e) {

				logger.error(e);
				logger.error("Invalid data is not successfully passed through the username field");

			}
			
			try {

				d.findElement(By.name("commit")).click();
				logger.info("Submit button is successfully cliked after invalid data is passed through the username field");
			} catch (Exception e) {

				logger.error(e);
				logger.error("Submit button is not clicked successfulluy after invalid data is passed to the username field");

			}
			d.findElement(By.id("kitchen_user_user_name")).clear();


		}

		@Test(priority =3)
		public void wrongPW() {
			// Password field
			logger.info("Wrong password                ");
			try {
				d.findElement(By.id("kitchen_user_password_digest")).sendKeys(pwd1);
				logger.info("Invalid password is entered through the password field");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Invalid password is not entered through the password field");
			}
			try {
				d.findElement(By.name("commit")).click();
				logger.info("User unable to login with wrong PW");
			} catch (Exception e) {
				logger.error("User able to login with wrong PW ");
			}

			d.findElement(By.id("kitchen_user_password_digest")).clear();
		}

		@Test(priority =4)
		public void wrongUNPW() {
			logger.info("Checking the wrong UN and PW                      ");
			try {
				d.findElement(By.id("kitchen_user_user_name")).sendKeys("annad");
				logger.info("Invalid Username is entered to the UN field");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Invalid username is not entered to the UN field");

			}
			try {
				d.findElement(By.id("kitchen_user_password_digest")).sendKeys("annad");
				logger.info("Invalid password is entered to the PW field");
			}

			catch (Exception e) {
				logger.error(e);
				logger.error("Invalid Pw is not entered to the PW field");

			}
			try {
				d.findElement(By.name("commit")).click();
				logger.info("Submit is clicked after Wrong UN and PW");
				logger.info("Validation is raised and User unable to login with wrong UN & PW");

			} catch (Exception e) {
				logger.error(e);
				logger.error("User is able to login and with wrong UN and PW and need validation alert ");
			}

		}

		@Test(priority =5)
		public void OnlyCorrectUN() {

			d.findElement(By.id("kitchen_user_user_name")).clear();
			d.findElement(By.id("kitchen_user_password_digest")).clear();
			try {
				d.findElement(By.id("kitchen_user_user_name")).sendKeys("altius");
				logger.info("Valid User name is passed to the UN field");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Valid user name is not passed to the UN field");
			}

			try {

				d.findElement(By.name("commit")).click();
				logger.info("Submit button is clicked after the valid UN is passed to the UN field");
				logger.info("User Unable to login with only correct UN");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Submit button is not clicked after the valid UN is passed to the UN field");
				logger.error("User able to login with only correct UN");
			}
		}

		@Test(priority =6)
		public void OnlycorrectPW() {
			d.findElement(By.id("kitchen_user_user_name")).clear();
			try {
				d.findElement(By.id("kitchen_user_password_digest")).sendKeys("altius");
				logger.info("Only valid password data is passed to the password field ");
			}
			catch (Exception e) {

				logger.error(e);
				logger.error("Valid password data is not passed to the password field");
			}
			d.findElement(By.name("commit")).click();
		}
		
		
		@Test(priority =7)
		public void rememberme()
		{
			WebElement rem =d.findElement(By.xpath("/html/body/div/div/div[2]/div/form/div/a"));
			rem.click();
			logger.info("");
			
			
		}

		@Test(priority =8)
		public void OnlyCorrectUNPW() {
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			d.findElement(By.id("kitchen_user_user_name")).clear();
			d.findElement(By.id("kitchen_user_password_digest")).clear();

			try {
				d.findElement(By.id("kitchen_user_user_name")).sendKeys("Vivek");
				logger.info("Valid UN is passed to the UN field");
			} catch (Exception e) {
				logger.error(e);
				logger.error("Valid data is not passed to the UN field");

			}
			try {
				d.findElement(By.id("kitchen_user_password_digest")).sendKeys("Vivek");
				logger.info("Valid password data is passed to the PW field");
			} catch (Exception e) {

				logger.error("Valid password is not passed to the PW field");

			}
			d.findElement(By.name("commit")).click();

			logger.info("User able to login with Correct UN  &PW");
		
		System.out.println("Login page is woriking fine........");
		
		}

		
	
	@AfterTest()
	public void aftertest()
	{
		d.quit();
		logger.info("Browser ");
	}
	
	
}
