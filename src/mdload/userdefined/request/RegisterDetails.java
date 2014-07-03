package mdload.userdefined.request;

import mdload.userdefined.UserLoginDetails;
import mdload.client.workload.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class RegisterDetails extends Request
{
	private UserLoginDetails user;
	
	public RegisterDetails(UserLoginDetails u)
	{
		super();
		user = u;
	}
	
	@Override
	public long action( WebDriver driver ) {
		long in = System.currentTimeMillis();
		
		driver.findElement(By.id("USER_FIRST_NAME")).clear();
		driver.findElement(By.id("USER_FIRST_NAME")).sendKeys(user.getFirstName());
		driver.findElement(By.id("USER_LAST_NAME")).clear();
		driver.findElement(By.id("USER_LAST_NAME")).sendKeys(user.getLastName());
		driver.findElement(By.id("CUSTOMER_ADDRESS1")).clear();
		driver.findElement(By.id("CUSTOMER_ADDRESS1")).sendKeys(user.getAddress1());
		driver.findElement(By.id("CUSTOMER_CITY")).clear();
		driver.findElement(By.id("CUSTOMER_CITY")).sendKeys(user.getCity());
		driver.findElement(By.id("CUSTOMER_POSTAL_CODE")).clear();
		driver.findElement(By.id("CUSTOMER_POSTAL_CODE")).sendKeys(user.getPostCode());
		new Select(driver.findElement(By.id("newuserform_countryGeoId"))).selectByVisibleText("United States");
		new Select(driver.findElement(By.id("newuserform_stateProvinceGeoId"))).selectByVisibleText("Virginia");
		driver.findElement(By.id("CUSTOMER_EMAIL")).clear();
		driver.findElement(By.id("CUSTOMER_EMAIL")).sendKeys(user.getEmail());
		driver.findElement(By.id("USERNAME")).clear();
		driver.findElement(By.id("USERNAME")).sendKeys(user.getUsername());
		driver.findElement(By.id("PASSWORD")).clear();
		driver.findElement(By.id("PASSWORD")).sendKeys(user.getPassword());
		driver.findElement(By.id("CONFIRM_PASSWORD")).clear();
		driver.findElement(By.id("CONFIRM_PASSWORD")).sendKeys(user.getPassword());
		driver.findElement(By.id("PASSWORD_HINT")).clear();
		driver.findElement(By.id("PASSWORD_HINT")).sendKeys(user.getPasswordHint());
		driver.findElement(By.xpath("(//a[contains(text(),'Save')])[2]")).click();		
		return System.currentTimeMillis() - in;
	}
}
