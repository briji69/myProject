package com.capgemini.busschedulingspringmvc.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.capgemini.busschedulingspringmvc.beans.Availability;
import com.capgemini.busschedulingspringmvc.beans.Feedback;
import com.capgemini.busschedulingspringmvc.beans.Ticket;
import com.capgemini.busschedulingspringmvc.beans.User;

public class CustomerDAOImpl implements CustomerDAO{
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");

	@Override
	public Boolean updateCustomer(User customer)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			User customer2=entityManager.find(User.class, customer.getUserId());
			if(customer2!=null) {
				entityTransaction.begin();
				customer2.setUserName(customer.getUserName());
				customer2.setUserEmail(customer.getUserEmail());
				customer2.setUserMobile(customer.getUserMobile());
				customer2.setUserPassword(customer.getUserPassword());	
				customer2.setType("enjoyer");		
				entityTransaction.commit();
				entityManager.close();
				return true;
			}		
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}
	@Override
	public Boolean deleteCustomer(Integer customerId)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			User customer=entityManager.find(User.class, customerId);		
			if(customer.getType().equalsIgnoreCase("enjoyer")) {
				entityTransaction.begin();
				entityManager.remove(customer);
				entityTransaction.commit();
				entityManager.close();
				return true;
			}		
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	@Override
	public Ticket bookTicket(Ticket ticket)  {
		Availability availability=null;
		ticket.setBookingDateTime(new java.util.Date());
		Ticket bookedTicket=null;
		List<Availability> availList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			Random random=new Random();
			int bookingId = random.nextInt(100000);
			ticket.setBookingId(bookingId);
			entityManager.persist(ticket);

			//to update booked seats in availiable info
			Query availQuery=entityManager.createQuery("FROM Availability WHERE busId=:bId and availableDate=:aDate", Availability.class);
			availQuery.setParameter("bId", ticket.getBusId());
			availQuery.setParameter("aDate", ticket.getJourneyDate());
			availList=availQuery.getResultList();
			availability=availList.get(0);
			availability.setAvailableSeat(availability.getAvailableSeat()-ticket.getNumOfSeats());
			entityManager.getTransaction().commit();
			entityManager.close();
			return ticket;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookedTicket;
	}
	@Override
	public Boolean cancelTicket(Integer bookingId, Integer id) {
		Boolean status=false;
		Ticket ticket=null;
		Availability availability=null;
		List<Ticket> tickets=null;
		List<Availability> availList=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Ticket> query=entityManager.createQuery("FROM Ticket WHERE customerId=:id and bookingId=:bId", Ticket.class);
			TypedQuery<Availability> availQuery=entityManager.createQuery("FROM Availability WHERE availableDate=:aDate and busId=:bid", Availability.class);
			query.setParameter("id", id);
			query.setParameter("bId", bookingId);
			tickets=query.getResultList();
			if (tickets.size()>0) {
				ticket=tickets.get(0);
				entityManager.remove(ticket);
				//to increment cancelled ticket 
				availQuery.setParameter("aDate",ticket.getJourneyDate());
				availQuery.setParameter("bid", ticket.getBusId());
				availList=availQuery.getResultList();
				availability=availList.get(0);
				availability.setAvailableSeat(availability.getAvailableSeat()+ticket.getNumOfSeats());
				status=true;
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean writeFeedback(Feedback feed) {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(feed);
			entityTransaction.commit();
			entityManager.close();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Ticket getTicketInfo(Integer bookingId) {
		Ticket ticket=null;
		List<Ticket> tickets=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Ticket> query=entityManager.createQuery("FROM Ticket where bookingId=:id", Ticket.class);
			query.setParameter("id", bookingId);
			tickets=query.getResultList();
			if(tickets.size()>0) {
				ticket=tickets.get(0);
			}
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ticket;
	}


}
