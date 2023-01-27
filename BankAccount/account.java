package banking;

public class account {

	public static void main(String[] args)
	{
		BankAccount account1 = new BankAccount("1234","Vignesh","9500752205");
		account1.deposit(250);
		account1.getBalance();
		account1.getHolderName();
	}
}
