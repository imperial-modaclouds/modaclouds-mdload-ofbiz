package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutReviewSubmit extends Request
{
	public CheckOutReviewSubmit()
	{
		super();
	}

	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.name("processButton")).click();
		return System.currentTimeMillis() - in;
	}
}
