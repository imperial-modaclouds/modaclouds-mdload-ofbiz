package mdload.userdefined.request;

import mdload.client.workload.*;
import org.openqa.selenium.*;

public class Main extends Request
{
	String status;
	public Main()
	{
		super();
		status = "";
	}
	public Main(String mystatus)
	{
		super();
		status = mystatus;
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		driver.findElement(By.linkText("Main")).click();
		return System.currentTimeMillis() - in;
	}
	
	
}
