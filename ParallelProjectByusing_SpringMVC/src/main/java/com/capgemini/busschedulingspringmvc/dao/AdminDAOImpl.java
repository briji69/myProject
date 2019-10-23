package com.capgemini.busschedulingspringmvc.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import com.capgemini.busschedulingspringmvc.beans.User;

public class AdminDAOImpl implements AdminDAO {
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("TestPersistence");
	@Override
	public User adminLogin(Integer adminId, String password)  {
		User admin = null;
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			Query query=entityManager.createQuery("FROM User WHERE id=:id and password=:password", User.class);
			query.setParameter("id", adminId);
			query.setParameter("password", password);
			admin=(User) query.getSingleResult();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return admin;		
	}
	@Override
	public User registerOwner(User owner)   {	
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(owner);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return owner;
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
	public Boolean deleteOwner(Integer ownerId)  {
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			User owner=entityManager.find(User.class, ownerId);
			if(owner.getType().equalsIgnoreCase("owner")) {
				entityTransaction.begin();
				entityManager.remove(owner);
				entityTransaction.commit();
				entityManager.close();
				return true;
			}
		} catch (Exception e) {
			return true;
		}
		return false;
	}	
}


