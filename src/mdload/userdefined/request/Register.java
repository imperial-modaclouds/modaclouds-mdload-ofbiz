package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.*;

public class Register extends Request
{
	public Register()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Register")).click();
		return System.currentTimeMillis() - in;
	}
}
