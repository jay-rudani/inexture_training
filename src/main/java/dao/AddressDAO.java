package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DatabaseConnection;
import utility.Address;
import utility.City;
import utility.Country;
import utility.State;

public class AddressDAO {

	static Connection connection = DatabaseConnection.getConnection();

	// method to delete saved address(s) of user
	public static void deleteSavedAddress(List<String> savedAddressId, String uuid) {
		String idList = String.join("','", savedAddressId.stream().map(String::valueOf).toArray(String[]::new));
		String tempSql = "delete from addresses where user_uuid = ? and address_id not in ('" + idList + "')";

		try {
			PreparedStatement statement = connection.prepareStatement(tempSql);
			statement.setString(1, uuid);
			statement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	// get List of addresses for particular user
	public static List<Address> getAddresses(String user_uuid) {
		String query = "SELECT * FROM addresses WHERE user_uuid = ?";
		List<Address> addresses = new ArrayList<Address>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user_uuid);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Country country = CountryDAO.getCountry(resultSet.getInt("address_country"));
				State state = StateDAO.getState(resultSet.getInt("address_state"));
				City city = CityDAO.getCity(resultSet.getInt("address_city"));
				Address address = new Address(resultSet.getInt("address_id"), resultSet.getString("address_line_1"),
						resultSet.getString("address_line_2"), city, state, country,
						String.valueOf(resultSet.getInt("address_pincode")));
				addresses.add(address);
			}
			return addresses;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
