package mdload.userdefined.session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;

import mdload.client.workload.EndAtomic;
import mdload.client.workload.EndSession;
import mdload.client.workload.Request;
import mdload.client.workload.Session;
import mdload.client.workload.StartSession;
import mdload.userdefined.UserDefs;
import mdload.userdefined.UserLoginDetails;
import mdload.userdefined.request.*;


public class TestMatlab extends Session {

	private UserLoginDetails user;
	
	// sockets, readers, server, and port
	Socket lineSocket;
    PrintWriter out;
    BufferedReader in;
    //final String server = "localhost";
    final String server = UserDefs.LQN_SERVER;
    final int port = UserDefs.LQN_PORT;
    // connection status
    boolean connected;
    final int numAttempts = 3;
    final int timeout = 60000;
    
    //LQN model file path
    //String LQNpath = "/data/line_test/ofbiz_prob.xml";
    //String LQNpath = "/data/line_test/ofbizBranch.xml";
    //String LQNpath = "D://line_test//ofbizBranch.xml";
    String LQNpath = UserDefs.LQN_FILE;

    
    public TestMatlab(long userid) {
		super(userid);
		this.setUser(new UserLoginDetails(getUserID()));
		
		//Establish connection with MDL service
	    connected = connect();
        //request server to load LQN model
        if (connected){
	        String command;
	        //Load model
	        command = "LOAD "+LQNpath;
	        System.out.println("Command: "+command); 
        	out.println(command);
            out.flush();
            try{
		        //Thread.sleep(2000);
		    	String resp = in.readLine();
	        	System.out.println(resp);
	        	
		        //Close connection
		        command = "CLOSE";
		        System.out.println("Command: "+command); 
	        	out.println(command);
	            out.flush();
	        	out.close();
	            in.close();
	            lineSocket.close();
	            
            }catch(IOException e){
            	System.err.println("An I/O exception occurred:"+e.getStackTrace());
                System.exit(1);
                
            }/*catch(InterruptedException e){
            	System.err.println("An Interrupted Exception occurred:"+e.getStackTrace());
                System.exit(1);
            }*/
        }
        
        
		
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
		connected = connect();
		if (connected){
			try {
				//request list from MDL service
			    String command;
		        //request next request
		        command = "NEXT";
		        System.out.println("Command: "+command); 
	        	out.println(command);
	            out.flush();
	            //response
	            String resp = in.readLine();
	        	System.out.println(resp);
	        	// tokenize response
	        	String[] parts = resp.split(":");
	        	// fill session linkedlist with response
	        	for(int i = 0; i < parts.length; i++){
	        		//System.out.println((i+1)+": "+parts[i]);
	        		session.add(injectNewRequest(parts[i]));
	        	}
	        		        	
	        	//close connection
	        	command = "CLOSE";
		        System.out.println("Command: "+command); 
	        	out.println(command);
	        	out.flush();
	        	out.close();
	            in.close();
	            lineSocket.close();
            }catch(IOException e){
            	System.err.println("An I/O exception occurred:"+e.getStackTrace());
                System.exit(1);
            }
        }
		return session;
	}

	public UserLoginDetails getUser() {
		return user;
	}

	public void setUser(UserLoginDetails user) {
		this.user = user;
	}
	
	public Request injectNewRequest(String toInject) {
		//System.out.println("toInject: "+toInject);
	    Request req = null;
	    switch (toInject) {
	    	case "Start":
	    		req = new StartSession();
	    		break;
	    	case "Stop":
	    		req = new EndSession();
	    		break;
	        case "CartAddAll":
	            req = new CartAddAll();
	            break;
	        case "CartAddFirst":
	            req = new CartAddFirst();
	            break;
	        case "CartAddRoundGizmo":
	            req = new CartAddRoundGizmo();
	            break;
	        case "CartAddTinyChromeWidget":
	            req = new CartAddTinyChromeWidget();
	            break;
	        case "CartView":
	            req = new CartView();
	            break;
	        case "Compare":
	            req = new Compare();
	            break;
	        case "CompareAddFirst":
	            req = new CompareAddFirst();
	            break;
	        case "CategoryAccountActivation":
	            req = new CategoryAccountActivation();
	            break;
	        case "CategoryConfigurablesFoods":
	            req = new CategoryConfigurablesFoods();
	            break;
	        case "CategoryConfigurablesPCs":
	            req = new CategoryConfigurablesPCs();
	            break;
	        case "CategoryDropShipProducts":
	            req = new CategoryDropShipProducts();
	            break;
	        case "CategoryGiftCards":
	            req = new CategoryGiftCards();
	            break;
	        case "CategoryGizmos":
	            req = new CategoryGizmos();
	            break;
	        case "CategoryServices":
	            req = new CategoryServices();
	            break;
	        case "CategoryWidgets":
	            req = new CategoryWidgets();
	            break;
	        case "QuickAddMain":
	            req = new QuickAddMain();
	            break;
	        case "QuickAddWidget":
	            req = new QuickAddWidget();
	            break;
	        case "SearchRand":
	            req = new SearchRand();
	            break;
	        case "CheckOut":
	            req = new CheckOut();
	            break;
	        case "CheckOutAddressNext":
	            req = new CheckOutAddressNext();
	            break;
	        case "CheckOutPaymentNext":
	            req = new CheckOutPaymentNext();
	            break;
	        case "CheckOutReviewSubmit":
	            req = new CheckOutReviewSubmit();
	            break;
	        case "CheckOutShippingNext":
	            req = new CheckOutShippingNext();
	            break;
	        case "OrderHistory":
	            req = new OrderHistory();
	            break;
	        case "OrderHistoryView":
	            req = new OrderHistoryView();
	            break;
	        case "ContactUs":
	            req = new ContactUs();
	            break;
	        case "ContactUsDetails":
	            req = new ContactUsDetails();
	            break;
	        case "Home":
	            req = new Home();
	            break;
	        case "Login":
	            req = new Login();
	            break;
	        case "LoginDetails":
	            req = new LoginDetails(user);
	            break;
	        case "LoginGetPasswordHint":
	            req = new LoginGetPasswordHint(user);
	            break;
	        case "Logout":
	            req = new Logout();
	            break;
	        case "Main":
	            req = new Main();
	            break;
	        case "Register":
	            req = new Register();
	            break;
	        case "RegisterDetails":
	            req = new RegisterDetails(user);
	            break;
	        /*case "RegisterAtomic":
	            req = new RegisterAtomic();
	            break;*/
	        case "LoginAtomic":
	            req = new LoginAtomic(user);
	            break;
	        case "EndAtomic":
	            req = new EndAtomic();
	            break;
	        case "CategoryGizmosTinyGizmos":
	            req = new CategoryGizmosTinyGizmos();
	            break;
	    }
	    if (req == null)
	    	System.out.println("Request name "+toInject+" not found");
	    return req;
	}
	
    private  boolean connect(){
		lineSocket = null;
	    out = null;
	    in = null;
    	boolean connected = false;
        int attempt = 0;
        while (attempt<=numAttempts && !connected){
        	attempt = attempt + 1; 
	        try {
	            lineSocket = new Socket(server, port);//open socket in machine server, (remote) port 5463
	            //writer to the socket
	            //out = new PrintWriter(kkSocket.getOutputStream(), true);
	            out = new PrintWriter(lineSocket.getOutputStream());
	            //input from socket
	            in = new BufferedReader(new InputStreamReader(lineSocket.getInputStream()));
	            
	            String resp = in.readLine();
	            if(resp.equals("MDL READY") ){
	            	System.out.println(resp); 
	            	connected = true;
	            }
	            
	        } catch (UnknownHostException e) {
	            System.err.println("Don't know about host:"+server+".");
	            if(attempt<=numAttempts){
	            	System.err.println("Connection will be retried in "+timeout/1000+" seconds.");
	            	System.err.println("Attempt "+attempt+" of "+numAttempts+".");
	            }else{
	            	System.err.println("Maximum number of attempts ("+numAttempts+") reached. Terminating.");
	            	System.exit(1);
	            }
	        } catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to: "+server+".");
	            if(attempt<=numAttempts){
	            	System.err.println("Connection will be retried in "+timeout/1000+" seconds.");
	            	System.err.println("Attempt "+attempt+" of "+numAttempts+".");
	            }else{
	            	System.err.println("Maximum number of attempts ("+numAttempts+") reached. Terminating.");
	            	System.exit(1);
	            }
	        }
	        if (!connected){
	        	try{
	        		Thread.sleep(timeout);
	        	}catch (InterruptedException e){
	        		System.err.print(e.getStackTrace());
	            	System.exit(1);
	        	}
	        }
        }
        return connected;
    }
    



	
}
