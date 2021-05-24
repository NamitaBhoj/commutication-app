package Controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import DB.UserDBUtil;

/**
 * Servlet implementation class AddFriend
 */
@WebServlet("/AddFriend")
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriend() {
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

		HttpSession session = request.getSession();
		int friendID = Integer.parseInt(request.getParameter("addFriend"));
		
		int userID = (int) session.getAttribute("user");
		
		 UserDBUtil userdbutil = new UserDBUtil(ds);
         
         String addFriend = userdbutil.addFriend(userID, friendID);
		
		
		if(addFriend.equals("SUCCESS"))   //On success, you can display a message to user on Home page
        {
			System.out.println("SUCCESS");
            request.getRequestDispatcher("/ProfileServlet").forward(request, response);
        }
        else   //On Failure, display a meaningful message to the User.
        {
        	System.out.println("error");
           //request.setAttribute("errMessage", userRegistered);
          // request.getRequestDispatcher("/form-register.jsp").forward(request, response);
        }
		System.out.println(friendID);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
