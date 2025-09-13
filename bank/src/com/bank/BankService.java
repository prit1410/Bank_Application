package com.bank;

public class BankService {
	private AccountDAO dao = new AccountDAO();

	public void deposit(int id, double amount) {
		Account acc = dao.getAccount(id);
		if (acc != null) {
			acc.setBalance(acc.getBalance() + amount);
			dao.updateAccount(acc);
			System.out.println(" Deposited " + amount);
		} else {
			System.out.println(" Account not found!");
		}
	}

	public void withdraw(int id, double amount) {
		Account acc = dao.getAccount(id);
		if (acc != null && acc.getBalance() >= amount) {
			acc.setBalance(acc.getBalance() - amount);
			dao.updateAccount(acc);
			System.out.println(" Withdrawn " + amount);
		} else {
			System.out.println(" Insufficient balance or Account not found!");
		}
	}
}
