package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection connection;

	private DatabaseConnection() {

	}

	public static Connection getConnection() {

		if (connection == null) {
			try {
				String url = "jdbc:mysql://localhost:3306/user_management_system";
				String username = "root";
				String password = "Sql@4321";
				connection = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return connection;
	}
}
