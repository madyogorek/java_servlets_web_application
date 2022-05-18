import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Summer extends HttpServlet
{
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request,
						HttpServletResponse response)
			throws IOException,ServletException
	{
		HttpSession userInfo = request.getSession();
		User currentUser = (User) userInfo.getAttribute("currentUser");

		response.sendRedirect("Login");


	}


}
