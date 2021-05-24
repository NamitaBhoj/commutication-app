package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Model.RegisterUser;
import Model.User;
import Model.post;


public class UserDBUtil {
private DataSource ds;
	
	public UserDBUtil(DataSource ds) {
		this.ds = ds;
	}

public int authenticateUser(User loginBean)
{
		
		String userEmail = loginBean.getEmail(); //Assign user entered values to temporary variables.
		String userpassword = loginBean.getPassword();

		Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
		int userIDDB = 0;
		
        try {      	
			conn = this.ds.getConnection();
			
			String sql = "select userID, Email,Password from user where Email=?";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, userEmail);
			
			res = psmt.executeQuery();
			
				if(res.next())
				{
				
				  userIDDB = res.getInt("userID");
				  
				  loginBean.setUserID(userIDDB);
				  
				  String  userEmailDB = res.getString("Email").toString();
				  String passwordDB = res.getString("Password").toString(); 
						
						
			           if(userEmail.equals(userEmailDB) && userpassword.equals(passwordDB))
		               {
			        	   System.out.println("hi");
		                  return 1; //If the user entered values are already present in the database, which means user has already registered so return a SUCCESS message.
		                 
		               }
				}
	        }catch(Exception e) {
	        	 e.printStackTrace();
	        }
        
        return 0;		
 }

//here function for register user
public String registerUser(RegisterUser registerBean)
{
    String fName = registerBean.getFirstName();
    String lname=registerBean.getLastName();
    String regemail = registerBean.getEmail();
    String regpassword = registerBean.getPassword();
    String regPostContent = registerBean.getPostContent();
    
    
    Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "insert into user(Fname,Lname,Email,Password, Bio) values (?,?,?,?,?)"; //Insert user details into the table 'USER'
        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
        preparedStatement.setString(1, fName);
        preparedStatement.setString(2, lname);
        preparedStatement.setString(3, regemail);
        preparedStatement.setString(4, regpassword);
        preparedStatement.setString(5, regPostContent);
        
        int i= preparedStatement.executeUpdate();
        
        if (i!=0)  //Just to ensure data has been inserted into the database
        return "SUCCESS"; 
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }       
    return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
}

public User getUser(int userid) throws Exception{
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
		
	User user = null;
	try {
		conn = this.ds.getConnection();
		
		String sql = "SELECT * FROM user where userID = " + userid;
		
		smt = conn.createStatement();
		res = smt.executeQuery(sql);
		
		while(res.next()) {
			String Fname = res.getString("Fname").toString();
			String Lname = res.getString("Lname").toString();
			String Email = res.getString("Email").toString();
			String Bio = res.getString("Bio").toString();
			
			user = new User(Fname,Lname, Email, Bio);
			user.setUserID(userid);
		}
		
	}finally {
		close(conn,smt,psmt,res);
	}

	return user;
}

public String createPost(post postbean)
{
	
	 String content = postbean.getPost();
	 int userID = postbean.getUserid();
	 
	 	Connection conn = null;
		Statement smt = null;
		PreparedStatement psmt = null;
		ResultSet res = null;
	    PreparedStatement preparedStatement = null;         
	    try
	    {
	    	conn = this.ds.getConnection();
	        String query = "insert into post(userID,post) values (?,?)"; //Insert user details into the table 'USER'
	        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	        preparedStatement.setInt(1, userID);
	        preparedStatement.setString(2, content);
	        
	        int i= preparedStatement.executeUpdate();
	        
	        if (i!=0)  //Just to ensure data has been inserted into the database
	        return "SUCCESS"; 
	    }
	    catch(SQLException e)
	    {
	       e.printStackTrace();
	    }       
	    return "Oops.. Something went wrong there..!";
}

public boolean likes(String like, int userID) throws SQLException
{
	int likes = 1;
	
	int likePost = Integer.parseInt(like);
	
	Connection conn = null;
	Statement smt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    
    try
    {
    	conn = this.ds.getConnection();
        String query = "insert into likes(postID,userID,likes) values (?,?,?)"; //Insert user details into the table 'USER'
        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
        preparedStatement.setInt(1, likePost);
        preparedStatement.setInt(2, userID); 
        preparedStatement.setInt(3, likes); 
        
        int i= preparedStatement.executeUpdate();
		
        if(i!=0)
        return true;
        	
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }   
    return false;
}

public boolean dislikes(String dislike, int userID) throws SQLException
{
	int likes = 1;
	
	int dislikePost = Integer.parseInt(dislike);
	
	Connection conn = null;
	Statement smt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    
    try
    {
    	conn = this.ds.getConnection();
    	String query = "delete from likes where postID = ? and userID = ?"; 
        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
        preparedStatement.setInt(1, dislikePost);
        preparedStatement.setInt(2, userID);

        
        int i= preparedStatement.executeUpdate();
		
        if(i!=0)
        return true;
		
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }   
    return false;
}

public ArrayList<post> getPost(int id,User user) 
		throws Exception{
	
	//int userid = user.getUserID();
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
	
	ArrayList<post> tempPosts = new ArrayList<>();
		
	try {
		conn = this.ds.getConnection();
		
		String sql = "SELECT * FROM post where userID = " + id;
		
		smt = conn.createStatement();
		res = smt.executeQuery(sql);
		
		//System.out.println(res.first());
		System.out.println( "user db get post" + id);
		
		while(res.next()) {
			int postidPost = res.getInt("postID");
			int useridPost = res.getInt("userID");
			String postDetails = res.getString("post").toString();
						
			post postObj = new post(useridPost,postidPost,postDetails);
			
			postObj.setPostid(postidPost);
			
			tempPosts.add(new post(useridPost,postidPost, postDetails));
		}
		
		user.setPosts(tempPosts);
		
	}finally {
		close(conn,smt,psmt,res);
	}

	return tempPosts;
}

public boolean deletePost(String postID) throws SQLException
{
	Connection conn = null;
	Statement smt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "delete from post where postID = ?"; 
        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
        preparedStatement.setString(1, postID);
        int i= preparedStatement.executeUpdate();
        
        if (i!=0) 
        {
        	return true;
        }
    }
    finally {
		close(conn,smt,preparedStatement,res);
	}
    
    return false;
}

public boolean savePost(String save, int userID) throws SQLException
{
	int postID = Integer.parseInt(save);
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "insert into save_posts(postID, userID) values (?,?)"; //Insert user details into the table 'USER'
        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
        preparedStatement.setInt(1, postID);
        preparedStatement.setInt(2, userID);

        int i= preparedStatement.executeUpdate();
        
        if (i!=0)  //Just to ensure data has been inserted into the database
        return true; 
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }    
	return false;
}

public ArrayList<post> getAllPost() 
		throws Exception{
	
	//int userid = user.getUserID();
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
	
	ArrayList<post> tempPosts = new ArrayList<>();
		
	try {
		conn = this.ds.getConnection();
		
		String sql = "SELECT Fname, Lname, post.postID, post.userID, post.post FROM post join user where user.userID = post.userID";
		
		smt = conn.createStatement();
		res = smt.executeQuery(sql);
		
		//System.out.println(res.first());
		int i = 0;
		while(res.next()) {
			String Fname = res.getString("Fname");
			String Lname = res.getString("Lname");
			int postidPost = res.getInt("postID");
			int useridPost = res.getInt("userID");
			String postDetails = res.getString("post").toString();
					
			tempPosts.add(new post(Fname,Lname,useridPost, postidPost,postDetails));
		}
				
	}finally {
		close(conn,smt,psmt,res);
	}

	return tempPosts;
}
public String addFriend(int userID, int friendID)
{
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "insert into friend(userID,friendID) values (?,?)";
        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
        preparedStatement.setInt(1, userID);
        preparedStatement.setInt(2, friendID);
           
        int i= preparedStatement.executeUpdate();
        
        if (i!=0)  //Just to ensure data has been inserted into the database
        return "SUCCESS"; 
    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }       
    return "Oops.. Something went wrong there..!";

}

public ArrayList<User> getAllUser() throws Exception{
	
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
		
	ArrayList<User> tempUser = new ArrayList<>();
	
	User user = null;
	try {
		conn = this.ds.getConnection();
		
		String sql = "SELECT * FROM user";
		
		smt = conn.createStatement();
		res = smt.executeQuery(sql);
		
		while(res.next()) {
			int userID = res.getInt("userID");

			String Fname = res.getString("Fname").toString();
			String Lname = res.getString("Lname").toString();
			String Email = res.getString("Email").toString();
			String Bio = res.getString("Bio").toString();
			
			
			tempUser.add(new User(userID, Fname,Lname, Email, Bio));
		}
		
	}finally {
		close(conn,smt,psmt,res);
	}

	return tempUser;
}

public ArrayList<post> getAllSavedPost(int userID) 
		throws Exception{
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
	
	ArrayList<post> tempPosts = new ArrayList<>();
		
	try {
		conn = this.ds.getConnection();
		
		String sql = "\r\n" + 
				"select post.PostID, save_posts.userID, user.Fname, user.Lname, post.post from save_posts \r\n" + 
				"				left join post\r\n" + 
				"				on save_posts.postID = post.postID\r\n" + 
				"                join user \r\n" + 
				"                on post.userID = user.userID\r\n" + 
				"                where  save_posts.userID =" + userID;
		
		smt = conn.createStatement();
		res = smt.executeQuery(sql);
		
		while(res.next()) {
			String Fname = res.getString("Fname");
			String Lname = res.getString("Lname");
			int postidPost = res.getInt("postID");
			int useridPost = res.getInt("userID");
			String postDetails = res.getString("post").toString();
			
			tempPosts.add(new post(Fname,Lname,useridPost,postidPost,postDetails));
		}
				
	}finally {
		close(conn,smt,psmt,res);
	}

	return tempPosts;
}

public ArrayList<User> FriendList(int userID) 
		throws Exception{
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
	
	ArrayList<User> tempUser = new ArrayList<>();
		
	try {
		conn = this.ds.getConnection();
		
		String sql = "select * from user join friend where user.userID = friend.friendID and friend.userID =" + userID;
		
		smt = conn.createStatement();
		res = smt.executeQuery(sql);
		
		while(res.next()) {
			int userid = res.getInt("userID");
			String Fname = res.getString("Fname");
			String Lname = res.getString("Lname");
			String Email = res.getString("Email");
			String Bio = res.getString("Bio");

			tempUser.add(new User(userid, Fname, Lname, Email, Bio));
		}
				
	}finally {
		close(conn,smt,psmt,res);
	}

	return tempUser;
}

public boolean editPost(String postID,int userID, String editText)
{
	int postIDEdit = Integer.parseInt(postID);
	
	Connection conn = null;
	Statement smt = null;
	PreparedStatement psmt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "update post \r\n" + 
        		"set post=\"\r\n" + editText + "\" \r\n" + 
        		"where postID ="+ postIDEdit; //Insert user details into the table 'USER'
        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
//        preparedStatement.setInt(1, postIDEdit);
//        preparedStatement.setInt(2, userID);
//        preparedStatement.setString(3, editText);
        
        int i= preparedStatement.executeUpdate();
        
        if (i!=0)  //Just to ensure data has been inserted into the database
        return true; 

    }
    catch(SQLException e)
    {
       e.printStackTrace();
    }   
    return false;
}

public void removeFriend(int userID, int friendID) throws SQLException
{
	Connection conn = null;
	Statement smt = null;
	ResultSet res = null;
    PreparedStatement preparedStatement = null;         
    try
    {
    	conn = this.ds.getConnection();
        String query = "delete from friend where userID = ? and friendID = ?"; 
        preparedStatement = conn.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
        preparedStatement.setInt(1, userID);
        preparedStatement.setInt(2, friendID);
        
        preparedStatement.executeUpdate();
    }
    finally {
		close(conn,smt,preparedStatement,res);
	}
    
}

private void close(Connection conn, Statement smt, PreparedStatement psmt, ResultSet res) {
		// TODO Auto-generated method stub
		try {
			if(conn != null)	
				conn.close();
			
			if(smt != null)
				smt.close();
			
			if(psmt != null)
				psmt.close();
			
			if(res != null)
				res.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


//get all user  fun -> array list of function -> return -> servel




