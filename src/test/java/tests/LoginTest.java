package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;


public class LoginTest extends BaseTest {
@Test
public void validLoginTest() 
{
LoginPage login = new LoginPage(driver);

login.login("admin", "admin123");
Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
}
@Test
public void invalidPasswordTest() 
{
LoginPage login = new LoginPage(driver);
login.login("admin", "wrong123");
Assert.assertEquals(login.getErrorMessage(), "Invalid Username or Password");

}
@Test
public void emptyPasswordTest() 
{
	LoginPage login = new LoginPage(driver);
	login.login("admin", "");
	Assert.assertEquals(login.getErrorMessage(), "Password is required");

}
@Test
public void verifyInvalidUsername() 
{
	LoginPage login = new LoginPage(driver);
	login.login("wronguser", "admin123");
	Assert.assertEquals(login.getErrorMessage(),"Invalid Username or Password");
}
@Test
public void verifyInvalidCredentials() 
{
	LoginPage login = new LoginPage(driver);
	login.login("wronguser", "wrong123");
	Assert.assertEquals(login.getErrorMessage(),"Invalid Username or Password");
}

@Test
public void verifyEmptyUsername() 
{
	LoginPage login = new LoginPage(driver);
	login.login("", "admin123");
	Assert.assertEquals(login.getErrorMessage(),"Username is required");
}
@Test
public void verifyPasswordWithSpaces() 
{
	LoginPage login = new LoginPage(driver);
	login.login("admin", "   ");
	Assert.assertEquals(login.getErrorMessage(),"Invalid Username or Password");}

@Test
public void verifyUpperCaseUsername() 
{
	LoginPage login = new LoginPage(driver);
	login.login("ADMIN", "admin123");
	Assert.assertEquals(login.getErrorMessage(),			"Invalid Username or Password");
}
@Test
public void verifyUpperCasePassword() 
{
	LoginPage login = new LoginPage(driver);
	login.login("admin", "ADMIN123");

	Assert.assertEquals(login.getErrorMessage(),"Invalid Username or Password");
}
@Test
public void verifyNumericCredentials() 
{
	LoginPage login = new LoginPage(driver);
	login.login("12345", "12345");
	Assert.assertEquals(login.getErrorMessage(),"Invalid Username or Password");
}


}
