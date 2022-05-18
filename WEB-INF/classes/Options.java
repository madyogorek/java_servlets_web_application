import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Options extends HttpServlet
{
		public void doPost(HttpServletRequest request,
							HttpServletResponse response)
				throws IOException,ServletException
		{
				HttpSession userInfo = request.getSession();
				String option =
							request.getParameter("Option");
				

				if (option.equals("Add"))
					response.sendRedirect("Add");
				else if(option.equals("Remove"))
					response.sendRedirect("Remove");
				else if(option.equals("Transfer"))
					response.sendRedirect("Transfer");
				else if(option.equals("History"))
					response.sendRedirect("History");
				else
					response.sendRedirect("Sum");

		}
