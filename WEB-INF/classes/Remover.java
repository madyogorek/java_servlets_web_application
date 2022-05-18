import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Remover extends HttpServlet
{
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
			throws IOException,ServletException
	{
			HttpSession userInfo = request.getSession();

			User currentUser = (User) userInfo.getAttribute("currentUser");
			Vector<User> users = (Vector<User>) userInfo.getAttribute("allUsers");
			int id = -1;
			try
			{
				//incase user entered nonint
				 id = Integer.parseInt(request.getParameter("AcctID"));
				 if(currentUser.removeAccount(id))
				 {
					 Log objectIO = new Log();
		 	 		objectIO.WriteObjectToFile(users);
				 }
			 }
			catch (Exception e)
			 {
				 System.out.println("User is bad at typing");
			 }

			response.sendRedirect("Login");

	}


}
