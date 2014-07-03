package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryAccountActivation extends Request
{
	public CategoryAccountActivation()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver )
	{
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Account Activation")).click();
		return System.currentTimeMillis() - in;
	}
}
