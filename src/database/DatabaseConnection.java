package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:sqlserver://89P13:1433;databaseName=PLAYER_POINT; encrypt = true;trustServerCertificate = true";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "123456";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public static void main(String[] args) throws SQLException {
		getConnection();
		System.out.println("OK!!!");
	}
}
