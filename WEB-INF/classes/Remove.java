
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class Remove extends HttpServlet
{


	public void doGet(HttpServletRequest request,
						HttpServletResponse response)
			throws IOException,ServletException
	{
			HttpSession userInfo = request.getSession();

			response.setContentType("text/HTML");

			PrintWriter out = response.getWriter();

			out.println("<HTML>");
			out.println("<HEAD>");
			out.println("<TITLE>Remove</TITLE>");
			out.println("</HEAD>");

			out.println("<BODY>");

			out.println("<CENTER>");
			out.println("<H1><FONT COLOR=Red>Close Account</FONT></H1>");
			out.println("<BR><BR><BR>");

			out.println("<TD>Account must be empty</TD>");
			out.println("<BR><BR><BR>");

			out.println("<FORM METHOD=POST ACTION='Remover'");


			out.println("<TABLE>");

			out.println("<TR>");
			out.println("<TD>Enter Account ID</TD>");
			out.println(
				"	<TD><INPUT TYPE='Text' NAME='AcctID' VALUE='' CHECKED>");


			out.println("</TR>");

			out.println("</TABLE>");

			out.println("<BR><BR><BR>");

			out.println("<INPUT TYPE='Submit' VALUE='Submit'>");

			out.println("</FORM>");
			out.println("</CENTER>");

			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
		}
}
