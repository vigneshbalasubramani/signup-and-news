package com.ztech.vignesh.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ztech.vignesh.constants.ServletConstants;

public class Connectivity {
	public Connection connection;
	public PreparedStatement statement;
	
	public int connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(ServletConstants.CONNECTION_STRING, ServletConstants.USER_NAME, ServletConstants.PASSWORD);
		statement = connection.prepareStatement(ServletConstants.INSERT_USER_DETAILS);
		return 0;
	}
	
	public int close() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		return 0;
	}
}
