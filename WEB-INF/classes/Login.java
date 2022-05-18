import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Login extends HttpServlet
{
			//holds all users for the application
			private Vector<User> users;
			//will be used for setting new user ids
			private int idCounter;

			@SuppressWarnings("unchecked")
			public void init() throws ServletException
		    {

					 this.users = new Vector<>();
					 this.idCounter = 0;
					 Log objectIO = new Log();
					 //Load saved users from file
					 Vector<User> usersv = (Vector<User>) objectIO.ReadObjectFromFile();
					 this.users = usersv;
		    }

			public void doGet(HttpServletRequest request,
								HttpServletResponse response)
					throws IOException,ServletException
			{
				//skips the identification step
				HttpSession userInfo = request.getSession();
				User currentUser = (User) userInfo.getAttribute("currentUser");
				sendPage(response, currentUser);

			}
			public void doPost(HttpServletRequest request,
								HttpServletResponse response)
					throws IOException,ServletException
			{
				String username = "";
				User currentUser = new User(-1, "*** Invalid entry! ***");
				HttpSession userInfo = request.getSession();
				try
				{
						//checking the username
				    username = request.getParameter("username");
				}
				catch(NumberFormatException cnfEx)
				{

					sendPage(response, currentUser);
				}
				boolean isnew = true;
				for(Integer i = 0; i < users.size();i++)
				{
					//seeing if the entered username matches and saved users
					if(username.equals(users.get(i).getUsername()))
					{
								currentUser = users.get(i);
								isnew = false;
					}
				}
				//otherwise we need to add the new user to our system
				if(isnew)
				{
					//initialize new user and increment idCounter so new users have different ids
					User newuser = new User(idCounter,username);
					users.add(newuser);
					currentUser = newuser;
					idCounter++;
					//saving the new user
					Log objectIO = new Log();
					objectIO.WriteObjectToFile(users);
				}
				userInfo.setAttribute("currentUser", currentUser);
				userInfo.setAttribute("allUsers", this.users);
				sendPage(response, currentUser);
			}


			private void sendPage(HttpServletResponse reply, User user)
														throws IOException
			{
				reply.setContentType("text/HTML");

				PrintWriter out = reply.getWriter();
				out.println("<HTML>");
				out.println("<HEAD>");
				out.println("<TITLE>Accounts</TITLE>");
				out.println("</HEAD>");
				out.println("<BODY>");
				out.println("<CENTER>");
				out.println("<CENTER><H1>" + user.getUsername() + "</H1></CENTER>");
				out.println("<BR><BR><BR>");
				out.println("<CENTER>");

				out.println("<TABLE BGCOLOR=E3E3E3 BORDER=2 width = '400'>");
				out.println("<TR>");
				out.println("<TH>Account ID</FONT></TH>");
				out.println("<TH>Account Type</FONT></TH>");
				out.println("<TH>Balance</FONT></TH>");
				out.println("</TR>");
				Vector<Account> accts = user.getAccts();

				//printing out the bank accounts
				for(int i = 0; i < accts.size(); i++)
				{
					out.println("<TR>");
					out.println("<TD>"+accts.get(i).getAcctNo()+"</FONT></TD>");
					if(accts.get(i).getType() == 1)
						out.println("<TD>Checking</FONT></TD>");
					else if(accts.get(i).getType() == 2)
						out.println("<TD>Savings</FONT></TD>");
					else
						out.println("<TD>Retirement</FONT></TD>");
					out.println("<TD>"+accts.get(i).getBalance()+"</FONT></TD>");
					out.println("</TR>");
				}
				out.println("</TABLE>");
				//options.java has control and will redirect to different servlets
				out.println("<FORM  METHOD=POST  ACTION='Options'>");
				out.println("<TABLE>");

				out.println("<TR>");
				out.println(
					"	<TD><INPUT TYPE='Radio' NAME='Option' VALUE='Add' CHECKED>");
				out.println("	<FONT COLOR=blue>	Add Account</FONT></TD>");
				out.println("</TR>");

				out.println("<TR>");
				out.println(
					"	<TD><INPUT TYPE='Radio' NAME='Option' VALUE='Remove'>");
				out.println(
					"	<FONT COLOR=blue>	Remove Account</FONT></TD>");
				out.println("</TR>");

				out.println("<TR>");
				out.println(
					"	<TD><INPUT TYPE='Radio' NAME='Option' VALUE='Transfer'>");
				out.println(
					"	<FONT COLOR=blue>	Transfer Funds</FONT></TD>");
				out.println("</TR>");

				out.println("<TR>");
				out.println(
					"	<TD><INPUT TYPE='Radio' NAME='Option' VALUE='History'>");
				out.println("	<FONT COLOR=blue>	View Accounts History</FONT></TD>");
				out.println("</TR>");

				out.println("<TR>");
				out.println(
					"	<TD><INPUT TYPE='Radio' NAME='Option' VALUE='Sum' CHECKED>");
				out.println("	<FONT COLOR=blue>	Sum Balances</FONT></TD>");
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
