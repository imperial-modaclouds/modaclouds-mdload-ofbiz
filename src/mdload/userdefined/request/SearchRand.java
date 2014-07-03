package mdload.userdefined.request;

import mdload.userdefined.UserRandomStream;
import mdload.client.workload.*;

import org.openqa.selenium.*;

public class SearchRand extends Request
{
	public SearchRand()
	{
		super();
	}
	
	@Override
	public long action( WebDriver driver ) {
		String searchtext[] = {"gizmo", "widget", "gift cards", "round", "small", "large"};
		
		long in = System.currentTimeMillis();
		driver.findElement(By.name("SEARCH_STRING")).clear();
		driver.findElement(By.name("SEARCH_STRING")).sendKeys(searchtext[UserRandomStream.random.nextInt( searchtext.length )]);
		driver.findElement(By.cssSelector("input.button")).click();
		return System.currentTimeMillis() - in;
	}
}
