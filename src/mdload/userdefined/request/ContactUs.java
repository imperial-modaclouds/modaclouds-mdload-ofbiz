package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUs extends Request
{
	public ContactUs()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Contact Us")).click();
		return System.currentTimeMillis() - in;
	}
}
