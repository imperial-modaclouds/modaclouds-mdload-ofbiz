package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartView extends Request
{
	public CartView()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver )
	{
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("[View Cart]")).click();
		return System.currentTimeMillis() - in;
	}
}
