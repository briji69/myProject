package com.capgemini.busschedulingjdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.capgemini.busschedulingjdbc.beans.Feedback;
import com.capgemini.busschedulingjdbc.beans.Ticket;
import com.capgemini.busschedulingjdbc.util.DBHelper;

public class CustomerDAOImplementation implements CustomerDAO {

	static Connection connection = DBHelper.getConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public Ticket bookTicket(int busId, int userId, int noOfSeats) {

		int seats = 0;
		Date journeyDate = null;
		String query = "SELECT availableSeats,journeyDate from bus_details WHERE busId=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, busId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				seats = resultSet.getInt("availableSeats");
				journeyDate = resultSet.getDate("journeyDate");
			}
			if (seats > 0 && seats >= noOfSeats) {
				String addQuery = "INSERT  INTO ticket_details VALUES(?,?,?,?,?,?)";
				String updateSeats = "UPDATE bus_details set availableSeats=? WHERE busId=?";
				try {
					Ticket ticket = new Ticket();
					Random random = new Random();
					int ticketId = random.nextInt(500);
					preparedStatement = connection.prepareStatement(addQuery);
					preparedStatement.setInt(1, ticketId);
					ticket.setTicketId(ticketId);
					preparedStatement.setInt(2, busId);
					ticket.setBusId(busId);
					preparedStatement.setInt(3, userId);
					ticket.setUserId(userId);
					preparedStatement.setDate(4, journeyDate);
					ticket.setJourneyDate(journeyDate);
					preparedStatement.setInt(5, noOfSeats);
					ticket.setNoOfSeats(noOfSeats);
					preparedStatement.setTimestamp(6, new java.sql.Timestamp(new java.util.Date().getTime()));
					ticket.setReservationDateTime(new java.sql.Timestamp(new java.util.Date().getTime()));
					preparedStatement.executeUpdate();
					preparedStatement = connection.prepareStatement(updateSeats);
					preparedStatement.setInt(1, seats - noOfSeats);
					preparedStatement.setInt(2, busId);
					preparedStatement.executeUpdate(); 
					return ticket;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Seats not available");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean cancelTicket(int ticketId, int userId, int noOfSeats) {
		int availableSeats = 0;
		int busIds = 0;
		String query = "DELETE FROM ticket_details WHERE ticketId=? and userId=?";
		String busId = "SELECT * from ticket_details WHERE ticketId=?";
		String seats = "SELECT * from bus_details where busId=?";
		String updateSeats = "UPDATE bus_details set availableSeats=? where busId=?";
		try {
			preparedStatement = connection.prepareStatement(busId);
			preparedStatement.setInt(1, ticketId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				busIds = resultSet.getInt("busId");
			}
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, ticketId);
			preparedStatement.setInt(2, userId);
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				preparedStatement = connection.prepareStatement(seats);
				preparedStatement.setInt(1, busIds);
				resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					availableSeats = resultSet.getInt("availableSeats");
				}
				preparedStatement = connection.prepareStatement(updateSeats);
				preparedStatement.setInt(1, availableSeats + noOfSeats);
				preparedStatement.setInt(2, busIds);
				preparedStatement.executeUpdate();
				return true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Ticket getTicketInfo(int ticketId) {
		Ticket ticket = new Ticket();
		String query = "SELECT * from ticket_details WHERE ticketId=?";
		try {
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, ticketId);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				ticket.setTicketId(resultSet.getInt("ticketId"));
				ticket.setBusId(resultSet.getInt("busId"));
				ticket.setUserId(resultSet.getInt("userId"));
				ticket.setJourneyDate(resultSet.getDate("journeyDate"));
				ticket.setNoOfSeats(resultSet.getInt("noOfSeats"));
				ticket.setReservationDateTime(resultSet.getTimestamp("reservationDateTime"));
				return ticket;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean giveFeedback(Feedback feedback) {
		String query = "INSERT  INTO feedback_details VALUES(?,?,?) ";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, feedback.getBusId());
			preparedStatement.setInt(2, feedback.getUserId());
			preparedStatement.setString(3, feedback.getFeedback());
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
