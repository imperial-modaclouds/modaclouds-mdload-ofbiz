package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPaymentNext extends Request
{
	public CheckOutPaymentNext()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.id("checkOutPaymentId_COD")).click();
		driver.findElement(By.id("checkOutPaymentId_OFFLINE")).click();
		driver.findElement(By.linkText("Continue to Final Order Review")).click();
		return System.currentTimeMillis() - in;
	}
}
