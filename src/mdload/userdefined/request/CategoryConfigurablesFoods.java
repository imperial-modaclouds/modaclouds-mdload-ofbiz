package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryConfigurablesFoods extends Request
{
	public CategoryConfigurablesFoods()
	{
		super();
	}

	@Override
	public long action( WebDriver driver )
	{
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Configurables Foods")).click();
		return System.currentTimeMillis() - in;
	}
}
