package com.capgemini.busschedulingjdbc.service;

import java.util.List;

import com.capgemini.busschedulingjdbc.beans.Bus;
import com.capgemini.busschedulingjdbc.beans.Feedback;
import com.capgemini.busschedulingjdbc.beans.User;
import com.capgemini.busschedulingjdbc.dao.CommonDAO;
import com.capgemini.busschedulingjdbc.dao.CommonDAOImplementation;
import com.capgemini.busschedulingjdbc.dao.CustomerDAO;

public class CommonServicesImplementation implements CommonServices {

	CommonDAO commonDAO = new CommonDAOImplementation();
	@Override
	public List<Bus> exploreBus(String source, String destination) {
		return commonDAO.exploreBus(source, destination);
		}

	@Override
	public List<Feedback> viewFeedback() {
		return commonDAO.viewFeedback();
	}

	@Override
	public User login(int userId, String password) {
		return commonDAO.login(userId, password);
	}

	@Override
	public boolean updateUser(User user) {
		return commonDAO.updateUser(user);
	}

}
