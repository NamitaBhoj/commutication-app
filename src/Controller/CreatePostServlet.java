package Controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DB.UserDBUtil;
import Model.post;

/**
 * Servlet implementation class CreatePostServlet
 */
@WebServlet("/CreatePostServlet")
public class CreatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePostServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String content = request.getParameter("postContent");
		
		HttpSession session  =request.getSession();
		
		int userID = (int)session.getAttribute("user");
		
		System.out.println(userID);
		
		post postbean = new post(userID, content);
		
		postbean.setPost(content);
		postbean.setUserid(userID);
		
		UserDBUtil userdbutil = new UserDBUtil(ds);
        
        String userPost = userdbutil.createPost(postbean);
        
        if(userPost.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
        	 RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
             rd.forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
           System.out.println("error");
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
