package com.capgemini.busbookingsystem.services;

import java.util.List;

import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.common.SearchBus;
import com.capgemini.busbookingsystem.dao.OwnerDAO;
import com.capgemini.busbookingsystem.dao.OwnerDAOImplementation;
import com.capgemini.busbookingsystem.utils.ValidationsRegEx;
import com.capgemini.busbookingsystem.utils.ValidationsRegExImplementation;

public class OwnerServiceImplementation implements OwnerService {
	ValidationsRegEx validation = new ValidationsRegExImplementation();
	OwnerDAO dao=new OwnerDAOImplementation();
	SearchBus search = new SearchBus();
	
	
	@Override
	public Boolean ownerLogin(int ownerId, String ownerPassword) {
		return dao.ownerLogin(ownerId, ownerPassword);
	}
	
	@Override
	public Boolean createBus(Bus bus) {
		return dao.createBus(bus);
				}

	@Override
	public Boolean updateBus(Bus bus) {
		return dao.updateBus(bus);
	}

	@Override
	public Boolean deleteBus(int bus_id) {
		return dao.deleteBus(bus_id);
		}

	
	@Override
	public Bus getBus(int bus_id) {
		return search.getBus(bus_id);
	}
	
	@Override
	public List<Integer> showAllBusInfo() {
		return dao.showAllBusInfo();
	}
	
	@Override
	public boolean updateAvailability(int bus_id, int seats) {
		return dao.updateAvailability(bus_id, seats);
	}
	
	@Override
	public Integer regex(String id) {
		return validation.regex(id);
	}

	@Override
	public String regexemail(String email) {
		return validation.regexemail(email);
	}

	@Override
	public String regexcontact(String contact) {
		return validation.regexcontact(contact);
	}
}