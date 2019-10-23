package com.capgemini.busschedulingjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.busschedulingjdbc.beans.Bus;
import com.capgemini.busschedulingjdbc.beans.Ticket;
import com.capgemini.busschedulingjdbc.beans.User;
import com.capgemini.busschedulingjdbc.exceptions.BusNotFoundException;
import com.capgemini.busschedulingjdbc.util.DBHelper;

public class OwnerDAOImplementation implements OwnerDAO{

	static Connection connection = DBHelper.getConnection();
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	@Override
	public Bus addBus(Bus bus) {
		String query = "INSERT  INTO bus_details VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, bus.getBusId());
			preparedStatement.setString(2, bus.getBusName());
			preparedStatement.setString(3, bus.getBusType());
			preparedStatement.setString(4, bus.getSource());
			preparedStatement.setString(5, bus.getDestination());
			preparedStatement.setInt(6, bus.getCapacity());
			preparedStatement.setInt(7, bus.getAvailableSeats());
			preparedStatement.setDouble(8, bus.getFare());
			preparedStatement.setDate(9, bus.getJourneyDate());
			preparedStatement.executeUpdate();
			return bus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateBus(Bus bus) {
		int id = 0;
		String busId = "SELECT * from bus_details WHERE busId=?";
		String query = "UPDATE bus_details SET busName=?, busType=?, source=?, destination=?, fare=?, capacity=?, availableSeats=? WHERE busId=?";

		try {
			preparedStatement = connection.prepareStatement(busId);
			preparedStatement.setInt(1, bus.getBusId());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id = resultSet.getInt("busId");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(id > 0) {
			try {
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, bus.getBusName());
				preparedStatement.setString(2, bus.getBusType());
				preparedStatement.setString(3, bus.getSource());
				preparedStatement.setString(4, bus.getDestination());
				preparedStatement.setDouble(5, bus.getFare());
				preparedStatement.setInt(6, bus.getCapacity());
				preparedStatement.setInt(7, bus.getAvailableSeats());
				//			preparedStatement.setDate(8, bus.getJourneyDate());
				preparedStatement.setInt(8, bus.getBusId());
				preparedStatement.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			throw new BusNotFoundException();
		}
		return false;
	}

	@Override
	public boolean deleteBus(int busId) {
		String query = "DELETE from bus_details WHERE busId=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, busId);
			int count = preparedStatement.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public List<Ticket> getTicketByBusId(int busId, java.util.Date journeyDate) {
		java.sql.Date date = new java.sql.Date(journeyDate.getTime());
		String query = "SELECT * from ticket_details WHERE busId=? AND journeyDate=?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, busId);
			preparedStatement.setDate(2, date);
			resultSet = preparedStatement.executeQuery();
			List<Ticket> ticketList = new ArrayList();
			while(resultSet.next()) {
				Ticket ticket = new Ticket();
				ticket.setBusId(resultSet.getInt("busId"));
				ticket.setUserId(resultSet.getInt("userId"));
				ticket.setTicketId(resultSet.getInt("ticketId"));
				ticket.setJourneyDate(resultSet.getDate("journeyDate"));
				ticket.setNoOfSeats(resultSet.getInt("noOfSeats"));
				ticket.setReservationDateTime(resultSet.getTimestamp("reservationDateTime"));

				ticketList.add(ticket);	
			}
			return ticketList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}



}
