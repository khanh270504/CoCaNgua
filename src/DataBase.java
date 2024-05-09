
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
	private static String DB_SeverName = "89P13";
	private static String login = "sa";
	private static String password = "123456";
	private static String DB_databaseName = "QLSV";

	public static Connection getConnection() {
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String DB_URL = "jdbc:sqlserver://" + DB_SeverName + ":1433;databaseName=" + DB_databaseName
					+ "; encrypt = true;trustServerCertificate = true";
			return DriverManager.getConnection(DB_URL, login, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		getConnection();
		System.out.println("OK!!!!");

	}
}
