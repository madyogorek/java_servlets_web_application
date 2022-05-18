import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Historyer extends HttpServlet
{
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
			throws IOException,ServletException
	{
		//just for sending redirect after sumbit button is hit
		HttpSession userInfo = request.getSession();
		//String currentProduct = (String)cart.getAttribute("currentProd");
		User currentUser = (User) userInfo.getAttribute("currentUser");

		response.sendRedirect("Login");


	}


}
