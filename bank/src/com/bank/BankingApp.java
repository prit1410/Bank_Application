package com.bank;

import java.util.Scanner;

public class BankingApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AccountDAO dao = new AccountDAO();
		BankService service = new BankService();

		while (true) {
			
			System.out.println("\n===== Banking Menu =====");
			System.out.println("1. Create Account");
			System.out.println("2. View Account");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Delete Account");
			System.out.println("6. View All Accounts");
			System.out.println("7. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter ID: ");
				int id = sc.nextInt();
				System.out.print("Enter Name: ");
				String name = sc.next();
				System.out.print("Enter Initial Balance: ");
				double bal = sc.nextDouble();
				dao.createAccount(new Account(id, name, bal));
				break;
			case 2:
				System.out.print("Enter ID: ");
				id = sc.nextInt();
				Account acc = dao.getAccount(id);
				if (acc != null) {
					System.out.println("ID: " + acc.getId() + ", Name: " + acc.getName() + ", Balance: " + acc.getBalance());
				} else {
					System.out.println(" Account not found!");
				}
				break;
			case 3:
				System.out.print("Enter ID: ");
				id = sc.nextInt();
				System.out.print("Enter Amount: ");
				double dep = sc.nextDouble();
				service.deposit(id, dep);
				break;
			case 4:
				System.out.print("Enter ID: ");
				id = sc.nextInt();
				System.out.print("Enter Amount: ");
				double wd = sc.nextDouble();
				service.withdraw(id, wd);
				break;
			case 5:
				System.out.print("Enter ID: ");
				id = sc.nextInt();
				dao.deleteAccount(id);
				break;
			case 6:
				for (Account a : dao.getAllAccounts()) {
					System.out.println("ID: " + a.getId() + ", Name: " + a.getName() + ", Balance: " + a.getBalance());
				}
				break;
			case 7:
				System.out.println(" Exiting...");
				System.exit(0);
			default:
				System.out.println(" Invalid Choice!");
			}
		}
	}
}