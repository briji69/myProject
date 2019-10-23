package com.capgemini.busschedulingjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capgemini.busschedulingjdbc.beans.Bus;
import com.capgemini.busschedulingjdbc.beans.Feedback;
import com.capgemini.busschedulingjdbc.beans.User;
import com.capgemini.busschedulingjdbc.util.DBHelper;

public class CommonDAOImplementation implements CommonDAO {

	static Connection connection = DBHelper.getConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public List<Bus> exploreBus(String source, String destination) {
		String query = "SELECT * from bus_details WHERE source=? AND destination=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, source);
			preparedStatement.setString(2, destination);
			resultSet = preparedStatement.executeQuery();
			List<Bus> buses = new ArrayList<>();
			while(resultSet.next()) {
				Bus bus = new Bus();
				bus.setBusId(resultSet.getInt("busId"));
				bus.setBusName(resultSet.getString("busName"));
				bus.setBusType(resultSet.getString("busType"));
				bus.setSource(resultSet.getString("source"));
				bus.setDestination(resultSet.getString("destination"));
				bus.setAvailableSeats(resultSet.getInt("availableSeats"));
				bus.setCapacity(resultSet.getInt("capacity"));
				bus.setFare(resultSet.getDouble("fare"));
				buses.add(bus);	
			}
			return buses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Feedback> viewFeedback() {
		String query = "SELECT * from feedback_details";
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			List<Feedback> feedbackList = new ArrayList<Feedback>();
			while(resultSet.next()) {
				Feedback feedback = new Feedback();
				feedback.setUserId(resultSet.getInt("userId"));
				feedback.setBusId(resultSet.getInt("busId"));
				feedback.setFeedback(resultSet.getString("feedback"));
				feedbackList.add(feedback);	
			}
			return feedbackList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User login(int userId, String password) {
		String query = "SELECT * from user_information where userId=? AND password=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("userId"));
				user.setUserName(resultSet.getString("userName"));
				user.setPassword(resultSet.getString("password"));
				user.setEmailId(resultSet.getString("emailId"));
				user.setContactNumber(resultSet.getLong("contactNumber"));
				user.setType(resultSet.getString("type"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		String query = "UPDATE user_information SET userName=?, emailId=?, contactNumber=?, password=? WHERE userId=?";
		try {
			User users = new User();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getEmailId());
			preparedStatement.setLong(3, user.getContactNumber());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setInt(5, user.getUserId());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
