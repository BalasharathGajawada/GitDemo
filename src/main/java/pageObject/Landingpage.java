package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	
	public WebDriver driver;
	
	By Signin = By.xpath("//a[contains(@href,'sign_in')]");
	By title = By.xpath("//div[@class='text-center']");
	By navigationBar = By.xpath("//nav[@class='navbar-collapse collapse']");
	
	
	
	
	public Landingpage(WebDriver driver) 
	{
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}



	public WebElement getlogin()
	{
		return driver.findElement(Signin);
		
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getnavigationBar()
	{
		return driver.findElement(navigationBar);
	}
	
	

}
