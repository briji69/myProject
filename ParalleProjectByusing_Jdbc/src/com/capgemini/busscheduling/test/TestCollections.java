package com.capgemini.busscheduling.test;

import org.junit.jupiter.api.Test;

import com.capgemini.busschedulingjdbc.dao.AdminDAOImplementation;
import com.capgemini.busschedulingjdbc.dao.CustomerDAOImplementation;

import junit.framework.TestCase;

public class TestCollections extends TestCase {

	AdminDAOImplementation admin = new AdminDAOImplementation();
	CustomerDAOImplementation customer = new CustomerDAOImplementation();

	@Test
	public void testdeletePass() {

		boolean result = admin.deleteUser(901);
		assertEquals(true, result);
	}

	@Test
	public void testdeleteFail() {

		boolean result = admin.deleteUser(301);
		assertEquals(false, result);
	}


	@Test
	public void testloginPass() {

		boolean result = customer.cancelTicket(245, 901, 1); 
		assertEquals(true,result);
	}

	@Test public void testloginFail() {

		boolean result = customer.cancelTicket(456, 901, 2);
		assertEquals(false	,result); 
	}
}
