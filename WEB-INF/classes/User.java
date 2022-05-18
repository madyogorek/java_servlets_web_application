//Class from which objects will be created
//and then passed as arguments.
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.util.*;

public class User implements Serializable
{
	//for history log
	private Vector<Event> events;
	private Vector<Account> accts;
	private int id;
	private String username;
	private int idCounter;

	public User(int id, String username)
	{
		this.id = id;
		this.username = username;
		this.accts = new Vector<>();
		this.events = new Vector<>();
		this.idCounter = 0;
	}
	public String getUsername()
	{
		return username;
	}
	public Vector<Account> getAccts()
	{
		return accts;
	}
	public Vector<Event> getEvents()
	{
		return events;
	}
	public void addAccount(int type, double amt)
	{
		Integer accId = this.idCounter;
		this.idCounter++;
		Account newacct = new Account(accId, type, amt);
		accts.add(newacct);
		addEvent(1,newacct);

	}
	public void addEvent(int type, Account acct)
	{
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
		Event newevent = new Event(type, acct, formattedDate);

		this.events.add(newevent);
	}
	public boolean removeAccount(int id)
	{
		boolean removed = false;
		for(int i = 0; i < accts.size(); i++)
		{
				int thisid = accts.get(i).getAcctNo();
				if(thisid == id)
				{
					if(accts.get(i).getBalance() == 0)
					{
						//only log if removal was able to happen
						addEvent(2, accts.get(i));
						accts.remove(i);
						removed = true;

					}

					break;
				}
		}
		return removed;
	}
	public double sumBalances()
	{
		double total = 0;
		for(int i = 0; i < accts.size(); i++)
		{
			double bal = accts.get(i).getBalance();
			total += bal;
		}
		return total;
	}
	public boolean transfer(int fromid, int toid, double amt)
	{
		Account from = new Account(-1,-1,-1);
		Account to = new Account(-1,-1,-1);
		boolean fromset = false;
		boolean toset = false;
		for(Integer i = 0; i < accts.size();i++)
		{
			if(fromid == accts.get(i).getAcctNo())
			{
						from = accts.get(i);
						fromset = true;
			}
			if(toid == accts.get(i).getAcctNo())
			{
						to = accts.get(i);
						toset = true;
			}
		}
		boolean withdrew = false;
		if(toset && fromset)
		{

			if(from.getBalance() >= amt)
			{
				from.withdraw(amt);
				addEvent(3,from);
				withdrew = true;
				to.deposit(amt);
			}
		}
		//so calling file (Transferer.java) knows whether to save the transfer to file
		return withdrew;
	}

}
