package Controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import DB.UserDBUtil;
import Model.RegisterUser;

/**
 * Servlet implementation class RegisterUserServlet
 */
@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String regfname = request.getParameter("regfirstname");
		 String reglname = request.getParameter("reglastname");
         String regemail = request.getParameter("regemail");
         String regpassword = request.getParameter("regpassword");
         String regPostContent = request.getParameter("regPostContent");
         
        
         RegisterUser registerBean = new RegisterUser(regfname,reglname, regemail, regpassword, regPostContent);
        
          registerBean.setFirstName(regfname);
          registerBean.setLastName(reglname);
          registerBean.setEmail(regemail);
          registerBean.setPassword(regpassword); 
          registerBean.setPostContent(regPostContent);
          
          UserDBUtil userdbutil = new UserDBUtil(ds);
          
          String userRegistered = userdbutil.registerUser(registerBean);
          
          if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
          {
        	 request.setAttribute("message", "Account Created");
             request.getRequestDispatcher("/form-login.jsp").forward(request, response);
          }
          else   //On Failure, display a meaningful message to the User.
          {
             request.setAttribute("errMessage", userRegistered);
             request.getRequestDispatcher("/form-register.jsp").forward(request, response);
          }
          
	}

}
