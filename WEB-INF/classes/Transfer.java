
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class Transfer extends HttpServlet
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
			out.println("<TITLE>Transfer</TITLE>");
			out.println("</HEAD>");

			out.println("<BODY>");

			out.println("<CENTER>");
			out.println("<H1><FONT COLOR=Red>Transfer Funds</FONT></H1>");
			out.println("<BR><BR><BR>");


			out.println("<FORM METHOD=POST ACTION='Transferer'");
			out.println("<TABLE>");

			out.println("<TR>");
			out.println("<TD>Enter Amount to Transfer</TD>");
			out.println(
				"	<TD><INPUT TYPE='Text' NAME='TransferAmt' VALUE='' CHECKED>");


			out.println("</TR>");

			out.println("</TABLE>");

			out.println("<BR><BR><BR>");
			out.println("<TABLE>");

			out.println("<TR>");
			out.println("<TD>Enter the Account ID (to withdraw from)</TD>");
			out.println(
				"	<TD><INPUT TYPE='Text' NAME='FromAcct' VALUE='' CHECKED>");
			out.println("<TD>Enter the Account ID (to deposit into)</TD>");
			out.println(
					"	<TD><INPUT TYPE='Text' NAME='ToAcct' VALUE='' CHECKED>");


			out.println("</TR>");

			out.println("</TABLE>");

			out.println("<TD>Ensure first account has sufficient balance</TD>");

			out.println("<BR><BR><BR>");

			out.println("<INPUT TYPE='Submit' VALUE='Submit'>");

			out.println("</FORM>");
			out.println("</CENTER>");

			out.println("</BODY>");
			out.println("</HTML>");
			out.flush();
		}
}
