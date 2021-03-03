package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import pageObject.loginpage;
import resources.base;



public class homePage extends base{
	public WebDriver driver;
		private static Logger Log= LogManager.getLogger(homePage.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		Log.debug("driver is initialized");
	}
	@Test(dataProvider="getData")
	public void basepageNavigation(String Username, String Password) throws IOException
	{
		
		driver.get(prop.getProperty("URL"));
		Log.debug("URL is opened");
		Landingpage l = new Landingpage(driver);
		l.getlogin().click();
		loginpage lp = new loginpage(driver);
		lp.getEmail().sendKeys(Username);
		Log.debug("username is entered");
		lp.getPassword().sendKeys(Password);
		Log.debug("password is entered");
		lp.getsignin().click();
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
		
		@DataProvider
		public Object getData()
		{
			Object[][] data = new Object[2][2];
			//0th row
			data[0][0] = "bunny";
			data[0][1]= "password1";
			//1st row
			data[1][0] = "balasharath";
			data[1][1] = "gajawada";
			
			
			return data;					
		}
		
		
		
	}
