import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Adder extends HttpServlet
{
	//warning is thrown because of writeObjecttoFile()
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
			throws IOException,ServletException
	{
		HttpSession userInfo = request.getSession();
		User currentUser = (User) userInfo.getAttribute("currentUser");
		Vector<User> users = (Vector<User>) userInfo.getAttribute("allUsers");

		String choice = request.getParameter("AcctType");

		double amt;
		try
		{
			 amt = Double.parseDouble(request.getParameter("DepAmt"));
			 if (choice.equals("Checking"))
	 		{
	 			currentUser.addAccount(1,amt);

	 		}

	 		if (choice.equals("Savings"))
	 		{
	 			currentUser.addAccount(2,amt);

	 		}

	 		if (choice.equals("Retirement"))
	 		{
	 			currentUser.addAccount(3,amt);

	 		}
			//saving new account
	 		Log objectIO = new Log();
	 		objectIO.WriteObjectToFile(users);
		 }
		catch (Exception e)
		 {
			 //parsing error
			 System.out.println("User is bad at typing");
		 }

		response.sendRedirect("Login");


	}


}
