package mdload.userdefined.request;

import mdload.userdefined.UserLoginDetails;
import mdload.client.workload.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginGetPasswordHint extends Request
{
	private UserLoginDetails user;
	
	public LoginGetPasswordHint(UserLoginDetails u)
	{
		super();
		user = u;
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.id("forgotpassword_userName")).clear();
		driver.findElement(By.id("forgotpassword_userName")).sendKeys(user.getUsername());
		driver.findElement(By.name("GET_PASSWORD_HINT")).click();
		return System.currentTimeMillis() - in ;
	}
}
