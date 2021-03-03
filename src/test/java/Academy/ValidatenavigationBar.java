package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObject.Landingpage;
import resources.base;

public class ValidatenavigationBar extends base {
	
	public WebDriver driver;
	private static Logger Log= LogManager.getLogger(ValidatenavigationBar.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		Log.debug("driver is initialized");
		driver.get(prop.getProperty("URL"));
		Log.info("URL is opened");
	}
	
	@Test
	public void navigation() throws IOException
	{
		
		Landingpage l = new Landingpage(driver);
		l.getnavigationBar();
		Log.info("validate navigation bar");
		Assert.assertTrue(l.getnavigationBar().isDisplayed());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
