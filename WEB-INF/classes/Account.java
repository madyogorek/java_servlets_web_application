//Class from which objects will be created
//and then passed as arguments.

import java.io.Serializable;

public class Account implements Serializable
{
	private int type;
	private int acctNo;
	private double balance;

	public Account(int acctNo, int type, double amt)
	{
		this.acctNo = acctNo;
		this.type = type;
		this.balance = amt;
	}

	public int getAcctNo()
	{
		return acctNo;
	}

	public int getType()
	{
		return type;
	}

	public double getBalance()
	{
		return balance;
	}

	public double withdraw(double amount)
	{
		//ensure account has sufficient balance
		if (amount <= balance)
		{
			balance = balance - amount;
			return amount;
		}
		else
			return 0;
	}

	public void deposit(double amount)
	{
		//can't deposit a negative
		if (amount > 0)
			balance += amount;
	}
}
