package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DB.UserDBUtil;
import Model.RegisterUser;
import Model.User;
import Model.post;



/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Resource(name="jdbc/social_db")
    private DataSource ds;
    private UserDBUtil userdb;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			userdb = new UserDBUtil(ds);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
			
		int userID = (int)session.getAttribute("user");
		
		User users = (User)session.getAttribute("userObj");
		
		try {
			
			ArrayList<post> allPosts = new ArrayList<>();
			
			User user = userdb.getUser(userID);//for user details
			
			allPosts = userdb.getPost(userID,user);//for user posts
									
			users.setPosts(allPosts);
						
			request.setAttribute("details", user);
			
			request.setAttribute("allPosts", allPosts);
			
			request.getRequestDispatcher("profile.jsp").forward(request, response);		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
}
