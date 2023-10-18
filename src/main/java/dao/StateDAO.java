package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DatabaseConnection;
import utility.State;

public class StateDAO {

	static Connection connection = DatabaseConnection.getConnection();

	// getState by id
	public static State getState(int id) {
		String query = "SELECT id, name, country_id FROM states WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				State state = new State(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getInt("country_id"));
				return state;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
