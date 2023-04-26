package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test

	public void ValidLogin() throws FilloException {

		Recordset recordset = connection.executeQuery("select * from data where TestName='ValidLogin'");
		recordset.next();

		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");

		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);

		String ActPageURL = driver.getCurrentUrl();
		String ExpPageURL = "https://www.saucedemo.com/inventory.html";

		AssertJUnit.assertEquals(ActPageURL, ExpPageURL);
	}

	@Test
	public void InValidLogin() throws FilloException {

		Recordset recordset = connection.executeQuery("select * from data where TestName='InValidLogin'");
		recordset.next();

		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.LoginFunction(UserName, Password);
		WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));

		String ActError = error.getText();
		String ExpError = "Epic, sadface: Username and password do not match any user in this service";

		AssertJUnit.assertEquals(ActError, ExpError);
	}

}
