package mdload.userdefined.session;

import java.util.LinkedList;

import mdload.userdefined.UserLoginDetails;
import mdload.userdefined.request.*;
import mdload.client.workload.*;

public class Test extends Session {

	private UserLoginDetails user;

	public Test(long userid) {
		super(userid);
		this.setUser(new UserLoginDetails(getUserID()));
	}

	@Override
	public LinkedList<Request> getWarmup() {
		LinkedList<Request> session = new LinkedList<Request>();
		session.add( new StartSession());
		session.add( new Home() );
		session.add( new Register() );
		session.add( new RegisterDetails(user) );
		return session;
	}

	@Override
	public LinkedList<Request> getNext() {
		LinkedList<Request> session = new LinkedList<Request>();
		session.add( new StartSession());
		session.add( new Home() );
		session.add( new Login() );
		session.add( new LoginDetails(user) );
		session.add( new QuickAddMain() );
		session.add( new Main() );
		session.add( new Logout() );
		session.add( new EndSession());
		return session;
	}

	public UserLoginDetails getUser() {
		return user;
	}

	public void setUser(UserLoginDetails user) {
		this.user = user;
	}
}
