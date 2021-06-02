package bankApp;

import java.util.*;

public class Account {
	String userName;
	int accountNumber;
	double balance;
	final double balanceLimit = 5000;
	final double rateOfinterest = 10;

	public Account(String name, int accountNumber) {
		this.userName = name;
		this.accountNumber = accountNumber;
		this.balance = 0.0;

	}

	public void showMenu() {
		System.out.println("Welcome " + userName);
		System.out.println("Id number: " + accountNumber);
		System.out.println("What would you like to do: ");
		System.out.println("A: Check Balance");
		System.out.println("B: Make a deposit ");
		System.out.println("C: Withdraw");
		System.out.println("D: View previous transaction");
		System.out.println("E: Calculate interest");
		System.out.println("F: Exit");
		System.out.print("Enter an option: ");
		Scanner sc = new Scanner(System.in);

		String userInput = sc.nextLine();
		while (userInput.equalsIgnoreCase("F") == false) {
			directToOperation(userInput);
			System.out.print("Enter an option: ");
			userInput = sc.nextLine();
		}

	}

	public void directToOperation(String operation) {
		double userBalance;
		int i = 0;
		ArrayList<String> listOfTransactions = new ArrayList<String>();
		Scanner inp = new Scanner(System.in);
		if (operation.equalsIgnoreCase("A")) {
			listOfTransactions.add(i, operation);
			balance = getBalance();
			System.out.println(balance);
		} else if (operation.equalsIgnoreCase("B")) {
			listOfTransactions.add(i, operation);
			System.out.println("Enter amount: NB not more than 5000");
			userBalance = inp.nextDouble();
			setBalance(userBalance);
			
		} else if (operation.equalsIgnoreCase("C")) {
			listOfTransactions.add(i, operation);
			System.out.println("Enter amount to withdraw");
			userBalance = inp.nextDouble();
			withdrawBalance(userBalance);
		} else if (operation.equalsIgnoreCase("D")) {
			previousTransaction(listOfTransactions);
		}
		else if (operation.equalsIgnoreCase("E")) {
			listOfTransactions.add(i, operation);
			System.out.println("Enter year");
			int year  = inp.nextInt();
			double calculatedInteres;
			
			calculatedInteres = interest(year);
			System.out.println(calculatedInteres);
			

			
		}
		i++;
		

	}
	public void previousTransaction(ArrayList<String> listOfTransactions) {
		int size = listOfTransactions.size() -2;
		System.out.println(listOfTransactions.size());
		String transaction = listOfTransactions.get(0);
		if(transaction.equalsIgnoreCase("A")) {
			System.out.println("You previously checked your balance");
		}
		else if (transaction.equalsIgnoreCase("B")) {
			System.out.println("You previously made a deposit");
		}
		else if (transaction.equalsIgnoreCase("C")) {
			System.out.println("You previously withdraw");
		}
		else if (transaction.equalsIgnoreCase("E")) {
			System.out.println("You previosly calcuated your interest");
		}
		else {
			System.out.println(transaction);
		}
		
		
	}
	public double interest(int year) {
		return (balance)*(rateOfinterest/balance)*(year);
		
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double newbalance) {
		if (newbalance > balanceLimit || newbalance <= 0) {
			System.out.println("Invalid operation");

		} else {
			balance += newbalance;

		}

	}

	public void withdrawBalance(double balanceToWithdraw) {

		if (balanceToWithdraw > balance) {
			System.out.println("Invalid operation");
		} else {
			balance -= balanceToWithdraw;
		}

	}

}
