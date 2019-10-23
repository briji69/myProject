package com.capgemini.busschedulingjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.busschedulingjdbc.beans.User;
import com.capgemini.busschedulingjdbc.util.DBHelper;

public class AdminDAOImplementation implements AdminDAO {

	Connection connection = DBHelper.getConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public User registerUser(User user) {
		String query = "INSERT  INTO user_information VALUES(?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getEmailId());
			preparedStatement.setLong(4, user.getContactNumber());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getType());
			preparedStatement.executeUpdate();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteUser(int userId) {
		String query = "DELETE from user_information WHERE userId=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
