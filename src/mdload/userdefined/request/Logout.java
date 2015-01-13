package mdload.userdefined.request;

import mdload.client.workload.*;
import mdload.userdefined.UserDefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout extends Request
{
	public Logout()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Logout")).click();
		driver.get(UserDefs.BASE_URL + ":" + UserDefs.BASE_PORT + "/ecommerce/");
		return System.currentTimeMillis() - in;
	}
}
