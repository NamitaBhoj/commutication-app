package Model;

import java.util.ArrayList;

public class User 
{
	private int userID;
	private String firstName;
	private String LastName;
	private String Email;
	private String Password;
	private String Bio;
	
	private ArrayList<post> posts  = new ArrayList<>();

	public User(int userID, String firstName, String lastName, String email, String Bio) {
		this.userID = userID;
		this.firstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.Bio = Bio;
	}

	public ArrayList<post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<post> posts) {
		this.posts = posts;
	}

	public User(String firstName, String lastName, String email, String Bio) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		Email = email;
		this.Bio = Bio;
	}

	public User(String Email, String Password) {
		super();
		this.Email = Email;
		this.Password = Password;
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
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getBio() {
		return Bio;
	}

	public void setBio(String bio) {
		Bio = bio;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", LastName=" + LastName + ", Email=" + Email + ", Password=" + Password
				+ "]";
	}

	

}
