package mdload.userdefined.request;

import mdload.userdefined.UserDefs;
import mdload.userdefined.UserRandomStream;
import mdload.client.workload.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class QuickAddWidget extends Request
{
	public QuickAddWidget()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Quick Add")).click();
		new Select(driver.findElement(By.name("category_id"))).selectByVisibleText("Widget Quick Add");
		driver.findElement(By.linkText("Choose QuickAdd Category")).click();

		driver.findElement(By.name("quantity_WG-1111")).clear();
		driver.findElement(By.name("quantity_WG-1111")).sendKeys("" + UserRandomStream.random.nextInt( UserDefs.MAX_ITEM_QUANTITY  ));
		driver.findElement(By.name("quantity_WG-5569")).clear();
		driver.findElement(By.name("quantity_WG-5569")).sendKeys("" + UserRandomStream.random.nextInt( UserDefs.MAX_ITEM_QUANTITY  ));

		return System.currentTimeMillis() - in;
	}
}
