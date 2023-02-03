package atm;

import java.util.Scanner;

public class ATM {
	private float balance;
	private final int pin = 1234;
	
	public ATM(float balance) {
		
		this.balance = balance;
		login();
	}
	
	public void login()
	{
		System.out.println("Enter Pin");
		int input = input();
		if(this.pin == input)
		{
			menu();
		}
		else {
			System.out.println("Invalid pin");
			return;
		}	
	}

	private void menu() {

		System.out.println("1. Balance");
		System.out.println("2. Withdraw money");
		System.out.println("3. Deposit money");
		System.out.println("4. Cancel");
		int n = input();
		if(n <= 0 || n>4)
		{
			System.out.println("Invalid Entry");
			return;
		}
		else {
			switch(n)
			{
			case 1:
				balance();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				deposit();
				break;
			case 4:
				cancel();
				break;
			}
		}
		
	}

	private void cancel() {

		System.out.println("Requested Cancelation");
		return;
		
	}

	private void deposit() {

		System.out.println("Enter Amount");
		
		int amount = input();
		this.balance += amount;
		System.out.println("Deposit Successful "+ amount);
		System.out.println();
		Minimenu();
		return;
	}

	private int input() {
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}

	private void withdraw() {
		System.out.println("Enter Amount");
		
		int amount = input();
		if(this.balance - amount < 0)
		{
			System.out.println("Invalid Entry");
			System.out.println("Your balance is "+this.balance);
			Minimenu();
			return;
		}
		this.balance -= amount;
		System.out.println("Withdraw Successful "+ amount);
		Minimenu();
		return;
		
	}

	private void balance() {
		System.out.println(this.balance);
		System.out.println();
		Minimenu();
		return;
	}
	
	private void Minimenu() {
		System.out.println("1.Back");
		System.out.println("2.Cancel");
		switch(input())
		{
			case 1:
				menu();
				break;
			case 2:
				cancel();
				break;
			default:
				cancel();
				break;	
		}
		
	}
}
