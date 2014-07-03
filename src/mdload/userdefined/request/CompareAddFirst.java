package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompareAddFirst extends Request
{
	public CompareAddFirst() 
	{
		super();
	}
	

	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Add To Compare")).click();
		return System.currentTimeMillis() - in;
	}
}
