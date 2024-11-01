package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/gymmanagementsystem";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	public static Connection getConnection() throws Exception {
		try {
			// Chargement du driver jdbc mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Ouverture de la connexion
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Driver Class not found : '" + e.getMessage() + "'");
		} catch (SQLException e) {
			throw new SQLException("Error : Unable to open connection with database !");
		}
	}
}
