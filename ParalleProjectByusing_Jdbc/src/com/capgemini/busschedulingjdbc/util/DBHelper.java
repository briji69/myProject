package com.capgemini.busschedulingjdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.capgemini.busschedulingjdbc.common.BusSchedulingSystemDB;

public class DBHelper {
	static Connection connection = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(BusSchedulingSystemDB.DB_URL,BusSchedulingSystemDB.DB_USERNAME, BusSchedulingSystemDB.DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			   
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}	
}