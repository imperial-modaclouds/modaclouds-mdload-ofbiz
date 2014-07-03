package mdload.userdefined;

import java.util.*;

import mdload.userdefined.UserDefs;

// import automation.request.SearchAddMicroWidgetToCart;

public class UserRandomStream {

	public static final Random random = new Random(UserDefs.RANDOM_SEED);
	
	public UserRandomStream() {

	}

	public Random getRandom() {
		return random;
	}

}
