package com.capgemini.busscheduling.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.busscheduling.dto.User;
import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Bus;
import com.capgemini.busscheduling.dto.Ticket;

public class OwnerDAOImpl implements OwnerDAO {
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");

	public User loginOwner(Integer ownerId, String password)  {
		User owner = null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery("FROM User WHERE id=:id and password=:password and type='owner'", User.class);
			query.setParameter("id", ownerId);
			query.setParameter("password", password);
			owner=(User) query.getSingleResult();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return owner;
	}

	public Bus addBus(Bus bus)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bus);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bus;
	}

	public Boolean updateBus(Bus bus)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Bus bus1=entityManager.find(Bus.class, bus.getBusId());
			if(bus1!=null) {
				entityTransaction.begin();
				bus1.setBusName(bus.getBusName());	
				bus1.setBusType(bus.getBusType());
				bus1.setCost(bus.getCost());
				bus1.setStartingPoint(bus.getStartingPoint());
				bus1.setEndingPoint(bus.getEndingPoint());
				bus1.setTotalSeats(bus.getTotalSeats());
				entityTransaction.commit();
				entityManager.close();
				return true;
			}		
		} catch (Exception e) {
			e.printStackTrace();	
		}
		return false;
	}

	public Boolean deleteBus(Integer busId)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			Bus bus=entityManager.find(Bus.class, busId);		
			entityTransaction.begin();
			entityManager.remove(bus);
			entityTransaction.commit();
			entityManager.close();
			return true;		
		} catch (Exception e) {
			return false;
		}
	}

	public List<Ticket> getAllTicket(Integer id) {
		List<Ticket> tickets=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Ticket> query=entityManager.createQuery("FROM Ticket WHERE customerId=:id", Ticket.class);
			query.setParameter("id", id);
			tickets=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tickets;
	}

	public List<Ticket> getTicketByBus(Integer busId, Date date) {
		List<Ticket> tickets=null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			TypedQuery<Ticket> query=entityManager.createQuery("FROM Ticket WHERE busId=:id and journeyDate=:date", Ticket.class);
			query.setParameter("id",busId);
			query.setParameter("date", date);
			tickets=query.getResultList();
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tickets;
	}

	public Boolean setBusAvailability(Availability availability)  {
		Boolean status=false;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(availability);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}
}
