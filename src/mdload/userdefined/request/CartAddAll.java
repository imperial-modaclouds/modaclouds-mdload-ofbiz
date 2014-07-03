package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAddAll extends Request
{
	public CartAddAll()
	{
		super();
	}

	@Override
	public long action( WebDriver driver )
	{
		// changing from the widget category
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Add All to Cart")).click();
		return System.currentTimeMillis() - in;
	}
}
