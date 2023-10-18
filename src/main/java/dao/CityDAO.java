package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DatabaseConnection;
import utility.City;

public class CityDAO {

	static Connection connection = DatabaseConnection.getConnection();

	// getCity by id
	public static City getCity(int id) {
		String query = "SELECT id, name, state_id FROM cities WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				City city = new City(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("state_id"));
				return city;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
