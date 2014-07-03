package mdload.userdefined.request;

import mdload.userdefined.UserDefs;
import mdload.userdefined.UserRandomStream;
import mdload.client.workload.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickAddMain extends Request
{
	public QuickAddMain()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Quick Add")).click();
	
		driver.findElement(By.name("quantity_GZ-2644")).clear();
		driver.findElement(By.name("quantity_GZ-2644")).sendKeys("" + UserRandomStream.random.nextInt( UserDefs.MAX_ITEM_QUANTITY ));
		driver.findElement(By.name("quantity_GZ-8544")).clear();
		driver.findElement(By.name("quantity_GZ-8544")).sendKeys("" + UserRandomStream.random.nextInt( UserDefs.MAX_ITEM_QUANTITY  ));
		driver.findElement(By.name("quantity_WG-1111")).clear();
		driver.findElement(By.name("quantity_WG-1111")).sendKeys("" + UserRandomStream.random.nextInt( UserDefs.MAX_ITEM_QUANTITY  ));
		driver.findElement(By.name("quantity_WG-5569")).clear();
		driver.findElement(By.name("quantity_WG-5569")).sendKeys("" + UserRandomStream.random.nextInt( UserDefs.MAX_ITEM_QUANTITY  ));
		
		driver.findElement(By.linkText("Add All to Cart")).click();

		return System.currentTimeMillis() - in;
	}
}
