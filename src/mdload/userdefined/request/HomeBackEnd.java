package mdload.userdefined.request;

import mdload.userdefined.UserDefs;
import mdload.client.workload.*;

import org.openqa.selenium.WebDriver;

/**
 * HomeBackEnd is request to the Home page of OFBiz, 
 * located in a specific BackEnd (IP address)
 * @author Juan
 *
 */
public class HomeBackEnd extends Request
{
	private String BackEndIP;
	String status;
	
	public HomeBackEnd(String BackEndIP)
	{
		super();
		this.BackEndIP = BackEndIP;
		status = "";
	}
	
	public HomeBackEnd(String BackEndIP, String mystatus)
	{
		super();
		this.BackEndIP = BackEndIP;
		status = mystatus;
	}
	
	@Override
	public long action( WebDriver driver)
	{
		long in = System.currentTimeMillis();
		driver.get("http://"+this.BackEndIP + ":" + UserDefs.BASE_PORT + "/ecommerce/");
		return System.currentTimeMillis() - in;
	}
	
	@Override
	public String toString()
	{
		return "HomeBackEnd(" + status + ")";
	
	}
}
