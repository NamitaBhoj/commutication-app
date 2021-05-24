package Model;

public class post 
{
private String fname;
private String lname;
private int userid;
private int postid;
private String post;
private int likes;

public post(int userid, String post) {
	super();
	this.userid = userid;
	this.post = post;
}

public post(int userid, int postid, String post) {
	this.userid = userid;
	this.postid = postid;
	this.post = post;
}

public post(String Fname,String Lname,int userid, int postid, String post) {
	this.fname = Fname;
	this.lname = Lname;
	this.userid = userid;
	this.postid = postid;
	this.post = post;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public int getLikes() {
	return likes;
}


public void setLikes(int likes) {
	this.likes = likes;
}


public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}


public int getPostid() {
	return postid;
}

public void setPostid(int postid) {
	this.postid = postid;
}

public String getPost() {
	return post;
}

public void setPost(String post) {
	this.post = post;
}

}
