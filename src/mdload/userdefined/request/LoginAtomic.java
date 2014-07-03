package mdload.userdefined.request;

import mdload.userdefined.UserLoginDetails;
import mdload.client.workload.*;

import org.openqa.selenium.WebDriver;

public class LoginAtomic extends Request {
	Request login;
	Request loginDetails;

	public LoginAtomic(UserLoginDetails u) {
		super();
		login = new Login();
		loginDetails = new LoginDetails(u);
	}

	@Override
	public long action( WebDriver driver ) {
		long t1 = login.action(driver);
		long t2 = loginDetails.action(driver);
		return t1+t2;
	}
}