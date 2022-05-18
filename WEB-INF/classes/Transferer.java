import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Transferer extends HttpServlet
{
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
			throws IOException,ServletException
	{
		HttpSession userInfo = request.getSession();
		User currentUser = (User) userInfo.getAttribute("currentUser");
		Vector<User> users = (Vector<User>) userInfo.getAttribute("allUsers");

		int from;
		int to;
		double amt;
		//in case user's entry couldn't be parsed
		try
		{
			 amt = Double.parseDouble(request.getParameter("TransferAmt"));
			 from = Integer.parseInt(request.getParameter("FromAcct"));
			 to = Integer.parseInt(request.getParameter("ToAcct"));
			 boolean trans = currentUser.transfer(from, to, amt);
			 //if transfer occurred, save it
			 if(trans)
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
