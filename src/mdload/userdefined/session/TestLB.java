package mdload.userdefined.session;

import java.util.LinkedList;
import java.util.ArrayList;

import mdload.userdefined.UserDefs;
import mdload.userdefined.UserLoginDetails;
import mdload.userdefined.request.*;
import mdload.client.workload.*;

public class TestLB extends Session {

	private UserLoginDetails user;

	public TestLB(long userid) {
		super(userid);
		this.setUser(new UserLoginDetails(getUserID()));
	}

	@Override
	public LinkedList<Request> getWarmup() {
		System.out.println("getWarmUp");
		LinkedList<Request> session = new LinkedList<Request>();
		session.add( new StartSession());
		String[] backEndList = UserDefs.BACKEND_LIST.split(";");
		// create a permutation of the backend indexes 
		int n = backEndList.length;
		System.out.println("back end list size: "+n);
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		for(int i = 0; i < n; i++){
			indexList.add(i, new Integer(i));
		}
		java.util.Collections.shuffle(indexList);
		
		// register on every backend
		for(int i = 0; i < n; i++){
			session.add( new HomeBackEnd(backEndList[indexList.get(i)]) );
			session.add( new Register() );
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
			System.out.println("Registering on backend " + backEndList[indexList.get(i)] );
			session.add( new RegisterDetails(user) );
			session.add( new Logout() );

		}
		session.add( new EndSession());
		return session;
	}

	@Override
	public LinkedList<Request> getNext() {
		System.out.println("getNext");
		LinkedList<Request> session = new LinkedList<Request>();
		session.add( new StartSession());
		session.add( new Home() );
		session.add( new Login() );
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
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
