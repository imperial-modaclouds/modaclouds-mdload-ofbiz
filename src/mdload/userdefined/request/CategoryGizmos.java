package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryGizmos extends Request
{
	public CategoryGizmos()
	{
		super();
	}

	@Override
	public long action( WebDriver driver )
	{
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Gizmos")).click();
		return System.currentTimeMillis() - in;
	}
}
