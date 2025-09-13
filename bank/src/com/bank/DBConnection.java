package com.bank;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
	private static final String USER = "root"; // apna MySQL username
	private static final String PASS = "Zxc123!@#"; // apna MySQL password

	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}