import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class Sum extends HttpServlet
{


	public void doGet(HttpServletRequest request,
						HttpServletResponse response)
			throws IOException,ServletException
	{
		HttpSession userInfo = request.getSession();
		User currentUser = (User) userInfo.getAttribute("currentUser");
		response.setContentType("text/HTML");

		PrintWriter out = response.getWriter();

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>Sum</TITLE>");
		out.println("</HEAD>");
		out.println("<FORM METHOD=POST ACTION='Summer'");

		out.println("<BODY>");

		out.println("<CENTER>");
		out.println("<H1><FONT COLOR=Red>Sum of all Balances</FONT></H1>");
		out.println("<BR><BR><BR>");


		out.println("<TABLE>");

		out.println("<TR>");

		out.println("<TD>"+currentUser.sumBalances()+"</FONT></TD>");
		out.println("</TR>");

		out.println("</TABLE>");

		out.println("<BR><BR><BR>");





		out.println("<BR><BR><BR>");

		out.println("<INPUT TYPE='Submit' NAME='Butt' VALUE='Back'>");

		out.println("</FORM>");
		out.println("</CENTER>");

		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
	}
}
