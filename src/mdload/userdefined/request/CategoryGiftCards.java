package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryGiftCards extends Request
{
	public CategoryGiftCards()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver )
	{
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Gift Cards")).click();
		return System.currentTimeMillis() - in;
	}
}
