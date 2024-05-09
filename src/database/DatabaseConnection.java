package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://DESKTOP-M57B9H4:1433;databaseName=QLPoints; encrypt = true;trustServerCertificate = true";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "anh270504";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    public static void main(String[] args) throws SQLException {
		getConnection();
		System.out.println("OK!!!");
	}
}
