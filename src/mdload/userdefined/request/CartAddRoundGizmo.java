package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAddRoundGizmo extends Request
{
	public CartAddRoundGizmo()
	{
		super();
	}

	@Override
	public long action( WebDriver driver )
	{
		// add round gizmo to cart
		long in = System.currentTimeMillis();
		//driver.findElement(By.xpath("//div[@id='div3']/h1[2]")).click();
		driver.findElement(By.cssSelector("form[name=\"the4form\"] > a.buttontext")).click();
		driver.findElement(By.linkText("Add to Cart")).click();
			return System.currentTimeMillis() - in;
	}
}
