package mdload.userdefined;

public class UserLoginDetails {
	private String title;
	private String firstName;
	private String lastName;
	private String address1;
	private String city;
	private String postCode;
	private String email;
	private String username;
	private String password;
	private String passwordHint;
	private long id;

	public UserLoginDetails(long uid) {
		this.id = uid;
		generateDetailsDefault();
	}

	private void generateDetailsDefault() {
		setTitle("Mr.");
		setFirstName("first" + id);
		setLastName("last" + id);
		setAddress1("address" + id);
		setCity("city" + id);
		setPostCode("postcode" + id);
		setEmail("email" + id + "@domain.com");
		setUsername("user-" + id);
		//long t0 = System.currentTimeMillis();
		//setUsername("user-" + t0);
		setPassword("pwd-" + id);
		setPasswordHint("this is my password hint");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordHint() {
		return passwordHint;
	}

	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}

}
