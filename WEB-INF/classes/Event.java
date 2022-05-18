//Class from which objects will be created
//and then passed as arguments.


import java.io.Serializable;

public class Event implements Serializable
{
	private int transType;
	private Account acct;
	private String date;


	public Event(int type, Account ac, String dat)
	{
		this.transType = type;
		this.acct = ac;
		this.date = dat;
	}

	public int getType()
	{
		//either 1,2,or 3 1=add account 2= remove 3= transferred
		return transType;
	}

	public Account getAcct()
	{
		return acct;
	}

	public String getDate()
	{
		return date;
	}

}
