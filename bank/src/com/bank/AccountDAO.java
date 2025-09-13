package com.bank;
import java.sql.*;
import java.util.*;

public class AccountDAO {

	public void createAccount(Account acc) {
		try (Connection conn = DBConnection.getConnection()) {
			String sql = "INSERT INTO accounts (id, name, balance) VALUES (?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acc.getId());
			ps.setString(2, acc.getName());
			ps.setDouble(3, acc.getBalance());
			ps.executeUpdate();
			System.out.println(" Account Created!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}public Account getAccount(int id) {
		try (Connection conn = DBConnection.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
		
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new Account(rs.getInt("id"), rs.getString("name"), rs.getDouble("balance"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateAccount(Account acc) {
		try (Connection conn = DBConnection.getConnection()) {
			String sql = "UPDATE accounts SET balance=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, acc.getBalance());
			ps.setInt(2, acc.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteAccount(int id) {
		try (Connection conn = DBConnection.getConnection()) {
			String sql = "DELETE FROM accounts WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("🗑 Account Deleted!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<Account> getAllAccounts() {
		List<Account> list = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection()) {
			String sql = "SELECT * FROM accounts";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new Account(rs.getInt("id"), rs.getString("name"),
						rs.getDouble("balance")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
