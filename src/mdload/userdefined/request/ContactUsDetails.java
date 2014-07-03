package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsDetails extends Request
{
	public ContactUsDetails()
	{
		super();
	}

	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.name("subject")).clear();
		driver.findElement(By.name("subject")).sendKeys("error title");
		driver.findElement(By.name("content")).clear();
		driver.findElement(By.name("content")).sendKeys("error msg");
		driver.findElement(By.cssSelector("input.smallSubmit")).click();		return System.currentTimeMillis() - in;
	}
}
