package mdload.userdefined.request;

import mdload.userdefined.UserDefs;
import mdload.client.workload.*;

import org.openqa.selenium.WebDriver;

public class Home extends Request
{
	String status;
	public Home()
	{
		super();
		status = "";
	}
	public Home(String mystatus)
	{
		super();
		status = mystatus;
	}
	
	@Override
	public long action( WebDriver driver)
	{
		long in = System.currentTimeMillis();
		driver.get(UserDefs.BASE_URL + ":" + UserDefs.BASE_PORT + "/ecommerce/");
		return System.currentTimeMillis() - in;
	}
	
	@Override
	public String toString()
	{
		return "Home(" + status + ")";
	
	}
}
