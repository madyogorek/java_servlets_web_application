
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Enumeration;

public class History extends HttpServlet
{


	public void doGet(HttpServletRequest request,
						HttpServletResponse response)
			throws IOException,ServletException
	{
		HttpSession userInfo = request.getSession();
		//ca.setAttribute("currentProd",currentProduct);

		response.setContentType("text/HTML");

		PrintWriter out = response.getWriter();
		User currentUser = (User) userInfo.getAttribute("currentUser");

		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>History</TITLE>");
		out.println("</HEAD>");

		out.println("<BODY>");

		out.println("<CENTER>");
		out.println("<H1><FONT COLOR=Red>Your History</FONT></H1>");
		out.println("<BR><BR><BR>");

		out.println("<FORM METHOD=POST ACTION='Historyer'");
		out.println("<TABLE>");


		out.println("</TABLE>");

		out.println("<BR><BR><BR>");

		out.println("<TABLE BGCOLOR=E3E3E3 BORDER=2 width = '400'>");
		out.println("<TR>");
		out.println("<TH>Date</FONT></TH>");
		out.println("<TH>Transaction Type</FONT></TH>");
		out.println("<TH>Account</FONT></TH>");
		out.println("</TR>");
		//printing out history log
		for(int i = 0; i < currentUser.getEvents().size(); i++)
		{
			out.println("<TR>");
			out.println("<TD>"+currentUser.getEvents().get(i).getDate()+"</FONT></TD>");
			if(currentUser.getEvents().get(i).getType() == 1)
				out.println("<TD>Added Account</FONT></TD>");
			else if(currentUser.getEvents().get(i).getType() == 2)
				out.println("<TD>Removed Account</FONT></TD>");
			else
				out.println("<TD>Transferred (from)</FONT></TD>");
			out.println("<TD>"+currentUser.getEvents().get(i).getAcct().getAcctNo()+"</FONT></TD>");
			out.println("</TR>");
		}
		out.println("</TABLE>");

		out.println("<BR><BR><BR>");

		out.println("<INPUT TYPE='Submit' VALUE='Back'>");

		out.println("</FORM>");
		out.println("</CENTER>");

		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
	}
}
