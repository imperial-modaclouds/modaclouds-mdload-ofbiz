package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutShippingNext extends Request
{
	public CheckOutShippingNext()
	{
		super();
	}

	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.xpath("(//input[@name='shipping_method'])[" + 2 +"]")).click();
		driver.findElement(By.linkText("Next")).click();
		return System.currentTimeMillis() - in;
	}
}
