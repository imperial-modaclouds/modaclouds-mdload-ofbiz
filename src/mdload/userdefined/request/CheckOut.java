package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut extends Request
{
	public CheckOut()
	{
		super();
	}

	@Override
	public long action( WebDriver driver ) {
		// long checkout
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Check out")).click();
			return System.currentTimeMillis() - in;
	}
}
