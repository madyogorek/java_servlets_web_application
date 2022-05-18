
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class Add extends HttpServlet
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
		out.println("<TITLE>Add</TITLE>");
		out.println("</HEAD>");

		out.println("<BODY>");

		out.println("<CENTER>");
		out.println("<H1><FONT COLOR=Red>Select Type of Account</FONT></H1>");
		out.println("<BR><BR><BR>");

		out.println("<FORM METHOD=POST ACTION='Adder'");
		out.println("<TABLE>");

		out.println("<TR>");
		out.println("<TD>Enter Amount to Deposit</TD>");
		out.println(
			"	<TD><INPUT TYPE='Text' NAME='DepAmt' VALUE='' CHECKED>");


		out.println("</TR>");

		out.println("</TABLE>");

		out.println("<BR><BR><BR>");


		out.println("<TABLE>");
		//type of account selection
		out.println("<TR>");
		out.println(
			"	<TD><INPUT TYPE='Radio' NAME='AcctType' VALUE='Checking' CHECKED>");
		out.println("	<FONT COLOR=blue>	Checking</FONT></TD>");
		out.println("</TR>");

		out.println("<TR>");
		out.println(
			"	<TD><INPUT TYPE='Radio' NAME='AcctType' VALUE='Savings'>");
		out.println(
			"	<FONT COLOR=blue>	Savings</FONT></TD>");
		out.println("</TR>");

		out.println("<TR>");
		out.println(
			"	<TD><INPUT TYPE='Radio' NAME='AcctType' VALUE='Retirement'>");
		out.println(
			"	<FONT COLOR=blue>	Retirement</FONT></TD>");
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
