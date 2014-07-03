package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistory extends Request
{
	public OrderHistory()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Order History")).click();
		return System.currentTimeMillis() - in;
	}
}
