package mdload.userdefined.request;

import mdload.userdefined.UserLoginDetails;
import mdload.client.workload.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginDetails extends Request
{
	private UserLoginDetails user;
	
	public LoginDetails(UserLoginDetails u)
	{
		super();
		user = u;
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys(user.getUsername());
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(user.getPassword());
		driver.findElement(By.cssSelector("input.button")).click();
		return System.currentTimeMillis() - in ;
	}
}
