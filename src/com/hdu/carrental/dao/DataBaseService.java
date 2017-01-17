package com.hdu.carrental.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseService {
	static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=test";
	static final String USERNAME = "sa";
	static final String PASSWORD = "zxc,412412412";
	private static Connection conn;
	private static Statement statement;

	/* �������ݿ⺯�� */
	public static void connectDataBase() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("���ݿ����ӳɹ�");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			statement = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*ִ��insert,delete,update���*/
	public static void executeUpdate(String sql) {
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*ִ��select���*/
	public static ResultSet executeQurey(String sql) {
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static void close() {
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
