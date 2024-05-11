package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdatePoints {
	public static void updateWinPoints(int playerId) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String sql = "UPDATE SCORE SET win_points = win_points + 1 WHERE player_id = " + playerId;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
