package mdload.userdefined.request;


import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAddFirst extends Request
{
	public CartAddFirst()
	{
		super();
	}

	@Override
	public long action( WebDriver driver )
	{
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Add to Cart")).click();
		return System.currentTimeMillis() - in;
	}
}
