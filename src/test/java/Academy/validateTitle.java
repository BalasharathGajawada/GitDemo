package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.Landingpage;
import resources.base;

public class validateTitle extends base
{
	
	public WebDriver driver;
	private static Logger Log= LogManager.getLogger(validateTitle.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		Log.info("driver is initialized");
		driver.get(prop.getProperty("URL"));
		Log.info("URL is opened");
		
	}
	
	@Test
	public void basepageNavigation() throws IOException
	{
		
		
		Landingpage l = new Landingpage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COUR3SES");
		System.out.println(l.getTitle().getText());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
