package com.capgemini.busscheduling.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Bus;
import com.capgemini.busscheduling.dto.Feedback;

public class BusBookingDAOImpl implements BusBookingDAO{

	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");

	public Bus searchBus(Integer busId) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Bus bus=entityManager.find(Bus.class, busId);
		entityManager.getTransaction().commit();
		entityManager.close();
		return bus;
	}

	public Integer checkAvailability(Integer busId, Date date) {
		Integer availSeats=null;
		Availability availability=null;
		List<Availability> availList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Availability> query=entityManager.createQuery("FROM Availability WHERE busId=:bid and availableDate=:aDate", Availability.class);
			query.setParameter("bid", busId);
			query.setParameter("aDate", date);
			availList=query.getResultList();
			if (availList.size()>0) {
				availability=availList.get(0);
				availSeats=availability.getAvailableSeat();
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return availSeats;
	}

	public List<Availability> checkAvailability(String source, String destination, Date date) {
		List<Availability> availList=new ArrayList<Availability>();
		List<Availability> resultList=null;
		List<Bus> busList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Bus> query=entityManager.createQuery("FROM Bus WHERE startingPoint=:sp and endingPoint=:ep", Bus.class);
			query.setParameter("sp", source);
			query.setParameter("ep", destination);
			TypedQuery<Availability> availQuery=entityManager.createQuery("FROM Availability WHERE busId=:bid and availableDate=:aDate", Availability.class);
			busList=query.getResultList();
			if (busList.size()>0) {
				for (Bus bus : busList) {
					availQuery.setParameter("bid", bus.getBusId());
					availQuery.setParameter("aDate", date);

					//getting result from taable
					resultList=availQuery.getResultList();

					//storing in array list
					availList.addAll(resultList);					
				}
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return availList;
	}

	public List<Feedback> viewFeedback() {
		List<Feedback> feedbacks=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Feedback> query=entityManager.createQuery("FROM Feedback", Feedback.class);
			feedbacks=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}

