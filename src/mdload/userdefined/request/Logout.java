package mdload.userdefined.request;

import mdload.client.workload.*;
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
		return System.currentTimeMillis() - in;
	}
}
