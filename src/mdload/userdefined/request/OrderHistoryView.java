package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderHistoryView extends Request
{
	public OrderHistoryView()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		// view first order from order history
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("View")).click();
		return System.currentTimeMillis() - in;
	}
}
