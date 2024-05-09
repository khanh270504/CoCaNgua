package database;

import java.sql.Connection;
import java.util.*;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Leaderboard {
    
    public static int GetPlayerWinPoint(int PlayerID) {
    	int winPoints = 0;
    	String sql = "SELECT win_points FROM win_points WHERE player_id = " + PlayerID;
    	try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            
            if (resultSet.next()) {
                winPoints = resultSet.getInt("win_points");
            }
            resultSet.close();            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    	return winPoints;
    }
}
