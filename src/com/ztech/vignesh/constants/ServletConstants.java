package com.ztech.vignesh.constants;

public class ServletConstants {
	public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/names";
	public static final String USER_NAME = "root";
	public static final String INSERT_USER_DETAILS = "insert into users values(?,?,?,?,?)";
	public static final String RESPONSE = "<h3> successfully added</h3><br><a href = 'http://localhost:8080/MYFirstServlet/index.html'>go back</a>";
	public static final String INVALID_DETAILS = "enter the input values properly";
	public static final String PASSWORD = "zilkeradmin";
}
