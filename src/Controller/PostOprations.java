package Controller;

import java.io.IOException;
import java.sql.SQLException;

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
 * Servlet implementation class PostOprations
 */
@WebServlet("/PostOprations")
public class PostOprations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostOprations() {
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
		int userID = (int)session.getAttribute("user");
		
		boolean done = false;
		boolean confirm = false;
		
		String like =  (request.getParameter("like"));
		System.out.println(like);
		
		String dislike =  (request.getParameter("dislike"));
		System.out.println(dislike);
		
		String save =  (request.getParameter("save"));
		System.out.println(save);
		
		String delete =  (request.getParameter("delete"));
		System.out.println(delete);
		
		String editText = request.getParameter("editText");
		System.out.println(editText);
		
		String edit = request.getParameter("edit");
		System.out.println(edit);
		
			
		if(like != null)
		{
			try {
				done = userdb.likes(like ,userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(dislike != null)
		{
			try {
				done = userdb.dislikes(dislike ,userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(save !=null) 
		{
			try {
				done = userdb.savePost(save, userID);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(delete !=null) 
		{
			try {
				confirm = userdb.deletePost(delete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(edit != null)
		{
			confirm = userdb.editPost(edit,userID, editText);
		}
		
		if(done) 
		{
			response.sendRedirect("feed.jsp");
		}
		if(confirm)
		{
			response.sendRedirect("ProfileServlet");
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
