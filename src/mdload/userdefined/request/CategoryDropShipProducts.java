package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CategoryDropShipProducts extends Request
{
	public CategoryDropShipProducts()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver )
	{
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("DropShip Products")).click();
		return System.currentTimeMillis() - in;
	}
}
