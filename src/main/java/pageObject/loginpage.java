package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {
	
	
	public WebDriver driver;
	
	By EmailAddress = By.xpath("//input[@id='user_email']");
	By Password = By.xpath("//input[@id='user_password']");
	By login = By.xpath("//input[@value='Log In']");
	
	public loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public WebElement getEmail() 
	{
		return driver.findElement(EmailAddress);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(Password);
		
	}
	public WebElement getsignin()
	{
		return driver.findElement(login);
	}

}
