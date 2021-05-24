package Model;

public class RegisterUser {
	private int userID;
	private String firstName;
	private String LastName;
	private String Email;
	private String Password;
	private String PostContent;
	
	public RegisterUser(String firstName, String lastName, String email, String password, String PostContent)
	{
		super();
		this.firstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.Password = password;
		this.PostContent = PostContent;
	}
	
	
	public String getPostContent() {
		return PostContent;
	}

	public void setPostContent(String PostContent) {
		this.PostContent = PostContent;
	}



	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		this.Password = password;
	}
	@Override
	public String toString() {
		return "firstName=" + firstName + ", LastName=" + LastName + ", Email=" + Email + ", Password="
				+ Password;
	}

}
