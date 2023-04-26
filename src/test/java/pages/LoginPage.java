package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	
	
	@FindBy(name="user-name")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(id="login-button")
	WebElement loginbutton;
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginFunction(String uname, String pwd)
	{
		
		username.sendKeys(uname);	
		password.sendKeys(pwd);			
		loginbutton.click();
		
		
		

	}

	
	
	
	
	
	
	
	
}
