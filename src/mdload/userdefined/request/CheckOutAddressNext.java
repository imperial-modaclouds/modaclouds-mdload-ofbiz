package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutAddressNext extends Request
{
	public CheckOutAddressNext()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Next")).click();
		return System.currentTimeMillis() - in;
	}
}
