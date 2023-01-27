package banking;

public class BankAccount {
	private String accountNumber;
	private String holderName;
	private double balance = 0.0;
	private String number;
	
	
	public BankAccount(String accountNumber,String holdername,String number)
	{
		this.accountNumber=accountNumber;
		this.holderName=holdername;
		this.number=number;
		
	}
	public void withdarw(double amount)
	{
		if(balance-amount < 0.0)
		{
			System.out.println("WithDraw Unsucessful! Your balance is less than required "+this.balance);
		}else {
			balance-=amount;
			System.out.println("Withdraw of amount "+ amount +" Sucessful!.." );
		}
	}
	public void deposit(double amount)
	{
		balance+=amount;
		System.out.println("Your new balance "+this.balance);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		System.out.println(this.holderName);
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public double getBalance() {
		System.out.println(this.balance);
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getNumber() {
		System.out.println(this.number);
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	

}
