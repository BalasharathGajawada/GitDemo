package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import sun.net.ftp.FtpDirEntry.Type;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis=new FileInputStream("D:\\E2Eproject\\src\\main\\java\\resources\\browser.properties");
		prop.load(fis);
		String Browsername = prop.getProperty("browser");
		
		if(Browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(Browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\IEDriver.exe");
			driver = new InternetExplorerDriver();
		}
		

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
	}
	
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		FileUtils.copyFile(source, new File(destinationfile));
		return destinationfile;
		
				
	}
	
}
				
				
				