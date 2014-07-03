package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAddTinyChromeWidget extends Request
{
	public CartAddTinyChromeWidget()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver )
	{
		// add round gizmo to cart
		long in = System.currentTimeMillis();
		driver.findElement(By.cssSelector("form[name=\"the7form\"] > a.buttontext")).click();
		driver.findElement(By.linkText("Add to Cart")).click();
			return System.currentTimeMillis() - in;
	}
}
