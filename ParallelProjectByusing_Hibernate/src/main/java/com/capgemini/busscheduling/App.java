 package com.capgemini.busscheduling;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Scanner;

import com.capgemini.busscheduling.dto.User;
import com.capgemini.busscheduling.dto.Availability;
import com.capgemini.busscheduling.dto.Bus;
import com.capgemini.busscheduling.dto.Feedback;
import com.capgemini.busscheduling.dto.Ticket;
import com.capgemini.busscheduling.exception.BusNotFoundException;
import com.capgemini.busscheduling.exception.DeletionFailedException;
import com.capgemini.busscheduling.exception.LoginFailedException;
import com.capgemini.busscheduling.exception.RegsitrationFailedException;
import com.capgemini.busscheduling.exception.TicketBookingFailedException;
import com.capgemini.busscheduling.exception.UpdationFailedException;
import com.capgemini.busscheduling.services.AdminService;
import com.capgemini.busscheduling.services.AdminServiceImpl;
import com.capgemini.busscheduling.services.BusBookingService;
import com.capgemini.busscheduling.services.BusBookingServiceImpl;
import com.capgemini.busscheduling.services.CustomerService;
import com.capgemini.busscheduling.services.CustomerServicesImpl;
import com.capgemini.busscheduling.services.OwnerService;
import com.capgemini.busscheduling.services.OwnerServiceImpl;
import com.capgemini.busscheduling.util.Validator;

import java.util.List;

public class App 
{
	static Scanner scanner = new Scanner(System.in);

	static AdminService adminService = new AdminServiceImpl	();
	static OwnerService ownerService = new OwnerServiceImpl();
	static CustomerService customerService = new CustomerServicesImpl();
	static BusBookingService bookingService = new BusBookingServiceImpl();
	static Validator validator = new Validator();
	static int ownerId;
	static int customerId;
	public static void main(String[] args) {



		System.out.println("Bus Booking System");
		System.out.println("###############################");

		while(true) {
			System.out.println("Select an option: ");
			System.out.println("1) Login Admin");
			System.out.println("2) Login Owner");
			System.out.println("3) Login Customer");
			System.out.println("4) Register Customer");
			System.out.println("0) Close The Application");
			System.out.println("#################################");

			int choice = Integer.parseInt(scanner.next());
			if(choice == 1) {
				User admin = null;
				//Admin Login  
				try {
					admin = adminLogin();
				} catch (LoginFailedException e) {
					e.printStackTrace();
				}
				if(admin!=null) {
					System.out.println("Login Successfull");
					System.out.println("Hii "+admin.getName());
					boolean b = true;
					while(b) {
						System.out.println("#######################");
						System.out.println("Enter a choice");
						System.out.println("1) Add Owner");
						System.out.println("2) Remove Owner");
						System.out.println("3) Remove Customer");
						System.out.println("0) signout");

						int ch = Integer.parseInt(scanner.next());
						switch(ch) {
						case 1:

							try {
								registerOwner();
							} catch (RegsitrationFailedException e1) {
								e1.printStackTrace();
							}

							break;
						case 2:
							try {
								deleteOwner();
							} catch (DeletionFailedException e) {
								e.printStackTrace();
							}
							break;
						case 3:
							try {
								deleteCustomer();
							} catch (DeletionFailedException e) {
								e.printStackTrace();
							}
							break;
						case 0:
							b = false;
							break;
						default:
							System.out.println("Please enter correct option");
						}
					}
				}else {
					System.out.println("Login Failed");
				}
			}
			else if(choice == 2) {
				User owner = null;
				// Owner login
				try {
					owner = loginOwner();
				} catch (LoginFailedException e) {
					e.printStackTrace();
				}
				if(owner!=null) {
					System.out.println("Login Successfull");
					System.out.println("Hello "+ owner.getName());
					boolean b = true;
					while(b) {
						System.out.println("###############################");
						System.out.println("Enter a choice");
						System.out.println("1) Add Bus");
						System.out.println("2) Delete Bus");
						System.out.println("3) Update Bus");
						System.out.println("4) Get all the tickets");
						System.out.println("5) Set bus availability");
						System.out.println("0) Logout");

						int option = Integer.parseInt(scanner.next());
						switch(option) {
						case 1:
							try {
								addBus();
							} catch (RegsitrationFailedException e) {
								e.printStackTrace();
							}
							break;
						case 2:
							try {
								deletebus();
							} catch (DeletionFailedException e) {
								e.printStackTrace();
							}
							break;
						case 3:
							try {
								updateBus();
							} catch (UpdationFailedException e) {
								e.printStackTrace();
							}
							break;
						case 4:
							getTicketInfo();
							break;
						case 5:
							try {
								setBusAvailability();
							} catch (BusNotFoundException e) {
								e.printStackTrace();
							}
							break;
						case 0:
							b = false;
							break;
						default:
							System.out.println("Please enter correct option");
						}
					}
				}else {
					System.out.println("Login Failed");
				}
			}
			else if(choice == 3) {
				User customer = null;
				//Customer Login
				try {
					customer = loginCustomer();
				} catch (LoginFailedException e) {
					e.printStackTrace();
				}
				if(customer!=null) {
					System.out.println("Login Successfull");
					System.out.println("Hello "+customer.getName());
					boolean b = true;
					while(b) {
						System.out.println("###############################");
						System.out.println("Enter a choice");
						System.out.println("1) Update Customer");
						System.out.println("2) Delete Customer");
						System.out.println("3) Book ticket");
						System.out.println("4) Cancel ticket");
						System.out.println("5) Print Ticket");
						System.out.println("6) Check Availability");
						System.out.println("7) Give one word Feedback");
						System.out.println("0) SignOut");

						int option = Integer.parseInt(scanner.next());
						switch(option) {
						case 1:
							try {
								updateCustomer();
							} catch (UpdationFailedException e1) {
								e1.printStackTrace();
							}
							break;
						case 2:
							try {
								deleteCustomer();
								b=false;
							} catch (DeletionFailedException e) {
								e.printStackTrace();
							}
							break;
						case 3:
							try {
								bookTicket();
							} catch (TicketBookingFailedException e) {
								e.printStackTrace();
							}
							break;
						case 4:
							cancelTicket();
							break;
						case 5:
							getTicketInfo();
							break;
						case 6:
							checkAvailability();
							break;
						case 7:
							writeFeedback();
							break;
						case 0:
							b = false;
							break;
						}
					}
				}else {
					System.out.println("Login Failed");
				}
			}
			else if(choice == 4) {
				try {
					registerCustomer();
				} catch (RegsitrationFailedException e) {
					e.printStackTrace();
				}
			}
			else if(choice == 0) {
				break;
			}else {
				System.out.println("Please select Correct Option");
			}
		}
	}
	public static User adminLogin() throws LoginFailedException {
		int adminId=0;
		while(true){
			System.out.println("Enter the userId");
			Integer aId=validator.validateId(scanner.next());
			if(aId!=null){
				adminId=aId;
				break;
			}else{
				System.out.println("Id should be Integer");
			}
		}
		System.out.println("Enter user password");
		String password = scanner.next();
		User admin=adminService.adminLogin(adminId, password);
		if (admin!=null) {
			return admin;
		} else {
			throw new LoginFailedException("user login Failed");
		}
	}
	public static void registerOwner() throws RegsitrationFailedException {
		User owner = new User();
		while(true){
			System.out.println("Enter the userId");
			Integer  oId=validator.validateId(scanner.next());
			if(oId!=null){
				owner.setId(oId);
				break;
			}else{
				System.out.println("Id should be number");
			}
		}
		System.out.println("Enter the userName");
		owner.setName(scanner.next());
		while(true){
			System.out.println("Enter the email id");
			String  sEmail=validator.validateEmail(scanner.next());
			if(sEmail!=null){
				owner.setEmail(sEmail);
				break;
			}else{
				System.out.println("Please enter valid email id");
			}
		}
		System.out.println("Enter the password");
		owner.setPassword(scanner.next());
		while(true){
			System.out.println("Enter the contact no.");
			Long mobile=validator.validateContact(scanner.next());
			if(mobile!=null){
				owner.setMobile(mobile);
				break;
			}else{
				System.out.println("mobile should be of 10 digits!!");
			}
		}
		owner=adminService. registerOwner(owner);
		if (owner != null) {
			System.out.println("Registration sucessful");
		} else {
			throw new RegsitrationFailedException("Owner Registration Failed (Duplicate id is not allowed!)");
		}
	}
	private static void deleteOwner() throws DeletionFailedException {
		System.out.println("Enter the userId to be deleted");
		Integer ownerId = scanner.nextInt();

		if (adminService.deleteOwner(ownerId)) {
			System.out.println("User sucessfully Deleted");
		} else {
			throw new DeletionFailedException("User Profile deletion Failed");
		}
	}
	private static void deleteCustomer() throws DeletionFailedException {
		System.out.println("Enter the userId to be deleted");
		Integer customerId = scanner.nextInt();

		if (adminService.deleteCustomer(customerId)) {
			System.out.println("User sucessfully Deleted");
		} else {
			throw new DeletionFailedException("User Profile deletion Failed");
		}
	}
	public static User loginOwner() throws LoginFailedException {
		int ownerId=0;
		while(true){
			System.out.println("Enter the userId");
			Integer oId=validator.validateId(scanner.next());
			if(oId!=null){
				ownerId=oId;
				break;
			}else{
				System.out.println("Id should be Integer");
			}
		}
		System.out.println("Enter user password");
		String password = scanner.next();
		User user=ownerService.loginOwner(ownerId, password);
		if (user!=null) {
			return user;
		} else {
			throw new LoginFailedException("User login Failed");
		}
	}
	public static void addBus() throws RegsitrationFailedException {
		Bus bus = new Bus();
		int busId=0;
		while(true){
			System.out.println("Enter the busId");
			Integer bId=validator.validateId(scanner.next());
			if(bId!=null){
				bus.setBusId(bId);
				break;
			}else{
				System.out.println("Id should be Integer");
			}
		}
		System.out.println("Enter Bus name");
		bus.setBusName(scanner.next());
		System.out.println("Enter starting point");
		bus.setStartingPoint(scanner.next());
		System.out.println("Enter ending point");
		bus.setEndingPoint(scanner.next());
		System.out.println("Enter Bus type");
		bus.setBusType(scanner.next());
		System.out.println("Enter Total seats");
		bus.setTotalSeats(Integer.parseInt(scanner.next()));
		System.out.println("Enter fare charge");
		bus.setCost(scanner.nextDouble());

		if (ownerService.addBus(bus) != null) {
			System.out.println("Bus added Successfully");
		} else {
			throw new RegsitrationFailedException("Failed to add Bus");
		}
	}	
	public static void updateBus() throws UpdationFailedException {
		Bus bus = new Bus();
		while(true){
			System.out.println("Enter the busId");
			Integer bId=validator.validateId(scanner.next());
			if(bId!=null){
				bus.setBusId(bId);
				break;
			}else{
				System.out.println("Id should be Integer");
			}
		}	
		System.out.println("Enter new Bus name");
		bus.setBusName(scanner.next());
		System.out.println("Enter new starting point");
		bus.setStartingPoint(scanner.next());
		System.out.println("Enter new ending point");
		bus.setEndingPoint(scanner.next());
		System.out.println("Enter new Bus type");
		bus.setBusType(scanner.next());
		System.out.println("Enter new Total seats");
		bus.setTotalSeats(Integer.parseInt(scanner.next()));
		System.out.println("Enter new fare charge");
		bus.setCost(scanner.nextDouble());

		if (ownerService.updateBus(bus)) {
			System.out.println("Bus updated Successfully");
		} else {
			throw new UpdationFailedException("Failed to Update Bus");
		}

	}	
	public static void deletebus() throws DeletionFailedException {
		int busId=0;
		while(true){
			System.out.println("Enter the busId");
			Integer bId=validator.validateId(scanner.next());
			if(bId!=null){
				busId=bId;
				break;
			}else{
				System.out.println("Id should be Integer");
			}
		}
		System.out.println("Are you sure you want to delete\n1. Yes");
		if (Integer.parseInt(scanner.next()) == 1) {
			if (ownerService.deleteBus(busId)) {
				System.out.println("Sucessfylly Deleted Bus data");
			} else {
				throw new DeletionFailedException("Bus deletion failed");
			}
		}
	}
	private static void getTicketInfo() {
		int busId=0;
		while(true){
			System.out.println("Enter the busId");
			Integer bId=validator.validateId(scanner.next());
			if(bId!=null){
				busId=bId;
				break;
			}else{
				System.out.println("Id should be Integer");
			}
		}
		System.out.println("Enter the date(yyyy-mm-dd)");
		String tempDate = scanner.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date =  dateFormat.parse(tempDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.util.List<Ticket> ticketAL=ownerService.getTicketByBus(busId, date);
		if(ticketAL.size()>0){
			System.out.println("Tickets are:");
			for (Ticket ticket : ticketAL) {
				System.out.println("####################################");
				System.out.println(ticket);
			}
		}else{
			System.out.println("No Ticket found");
		}
	}	
	private static void setBusAvailability() throws BusNotFoundException {
		Availability availability=new Availability();
		int busId=0;
		while(true){
			System.out.println("Enter the busId");
			Integer bId=validator.validateId(scanner.next());
			if(bId!=null){
				busId=bId;
				break;
			}else{
				System.out.println("Id should be Integer");
			}
		}
		Bus bus=bookingService.searchBus(busId);
		if(bus!=null){
			System.out.println(bus);
			availability.setBusId(busId);
			System.out.println("Enter the Available seats");
			availability.setAvailableSeat(Integer.parseInt(scanner.next()));
			System.out.println("Enter the date(yyyy-mm-dd)");
			String tempDate = scanner.next();


			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
			Date date=null;
			try {
				date = dateFormat.parse(tempDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			availability.setAvailableDate(date);

			if(ownerService.setBusAvailability(availability)){
				System.out.println("Successfully Set the availability");
			}
		}else{
			System.out.println("Failed to Set the availability");
			throw new BusNotFoundException("No Bus found");
		}
	}
	public static void registerCustomer() throws RegsitrationFailedException {
		User customer = new User();
		while(true){
			System.out.println("Enter the UserId");
			Integer  sId=validator.validateId(scanner.next());
			if(sId!=null){
				customer.setId(sId);
				break;
			}else{
				System.out.println("Id should be number");
			}
		}
		System.out.println("Enter the UserName");
		customer.setName(scanner.next());
		while(true){
			System.out.println("Enter the email id");
			String  cEmail=validator.validateEmail(scanner.next());
			if(cEmail!=null){
				customer.setEmail(cEmail);
				break;
			}else{
				System.out.println("Please enter valid email id");
			}
		}
		System.out.println("Enter the password");
		customer.setPassword(scanner.next());
		while(true){
			System.out.println("Enter the contact no.");
			Long mobile=validator.validateContact(scanner.next());
			if(mobile!=null){
				customer.setMobile(mobile);
				break;
			}else{
				System.out.println("Contact should be of 10 digits!!");
			}
		}
		customer=customerService. registerCustomer(customer);
		if (customer != null) {
			System.out.println("Registration sucessful");
		} else {
			throw new RegsitrationFailedException("User Registration Failed (Duplicate id is not allowed!)");
		}
	}
	public static User loginCustomer() throws LoginFailedException {

		while(true){
			System.out.println("Enter the UserId");
			Integer cId=validator.validateId(scanner.next());
			if(cId!=null){
				customerId=cId;
				break;
			}else{
				System.out.println("Id should be a number");
			}
		}
		System.out.println("Enter the password");
		String password = scanner.next();
		User customer=customerService.loginCustomer(customerId, password);
		if (customer != null) {
			return customer;
		} else {
			throw new LoginFailedException("User Login Failed");
		}
	}	
	private static void updateCustomer() throws UpdationFailedException {
		User customer = new User();
		customer.setId(customerId);
		System.out.println("Enter new password");
		customer.setPassword(scanner.next());
		System.out.println("Enter New CustomerName");
		customer.setName(scanner.next());
		while(true){
			System.out.println("Enter the email id");
			String  sEmail=validator.validateEmail(scanner.next());
			if(sEmail!=null){
				customer.setEmail(sEmail);
				break;
			}else{
				System.out.println("Please enter valid email");
			}
		}
		while(true){
			System.out.println("Enter the contact no.");
			Long mobile=validator.validateContact(scanner.next());
			if(mobile!=null){
				customer.setMobile(mobile);
				break;
			}else{
				System.out.println("Contact should be of 10 digits!!");
			}
		}
		if (customerService.updateCustomer(customer)) {
			System.out.println("Profile sucessfully Updated");
		} else {
			throw new UpdationFailedException("User profile Updation Failed");
		}
	}
	private static void bookTicket() throws TicketBookingFailedException {
		Ticket ticket = new Ticket();
		System.out.println("Enter source point");
		String source = scanner.next();
		System.out.println("Enter Destination point");
		String destination = scanner.next();
		System.out.println("Enter the date(yyyy-mm-dd)");
		String tempDate = scanner.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date=null;
		try {
			date = dateFormat.parse(tempDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// set Date
		ticket.setJourneyDate(date);
		// get current Date
		long millis = System.currentTimeMillis();
		java.sql.Date currentDate = new java.sql.Date(millis);
		java.util.List<Availability> buslist = bookingService.checkAvailability(source, destination, date);
		if (buslist.size() > 0) {
			for(Availability avail :buslist) {
				System.out.println(avail);
				Bus bus  = bookingService.searchBus(avail.getBusId());
				int availSeats = avail.getAvailableSeat();
				System.out.println(bus);
				System.out.println("Available seats : " + availSeats);
				System.out.println("#################################");
			}
			Integer busId=0;
			boolean idState=true;
			while(idState){
				System.out.println("Enter the busId");
				String bId=scanner.next();
				busId=validator.validateId(bId);
				if(busId!=null){
					ticket.setBusId(busId);
					idState=false;
				}else{
					System.out.println("Id should be number");
				}
				// get the global userId
				ticket.setCustomerId(customerId);

				Integer availSeats = bookingService.checkAvailability(busId, date);
				if (availSeats>0) {
					System.out.println("Total available seats are: " + availSeats);
				}
				System.out.println("Enter number of seats to book");
				int numOfSeats=Integer.parseInt(scanner.next());
				if(numOfSeats>0){
					ticket.setNumOfSeats(numOfSeats);
				}else{
					throw new TicketBookingFailedException("Ticket Booking Failed");
				}
				Random random=new Random();
				int bookingId = random.nextInt(100000);
				ticket.setBookingId(bookingId);
				Ticket bookedTicket = customerService.bookTicket(ticket);
				if (bookedTicket != null) {
					System.out.println("Ticket sucessfully Booked");
					System.out.println(bookedTicket);
				} else {
					throw new TicketBookingFailedException("Ticket Booking Failed");
				}

			}
		}
	}	
	private static void cancelTicket() {
		java.util.List<Ticket> ticketList = ownerService.getAllTicket(customerId);

		if (ticketList.size() > 0) {
			for (Ticket tickets : ticketList) {
				System.out.println(tickets);
				System.out.println("####################################");
			}
			int bookingId=0;
			while(true){
				System.out.println("Enter the bookingId");
				Integer bookId=validator.validateId(scanner.next());
				if(bookId!=null){
					bookingId=bookId;
					break;
				}else{
					System.out.println("Id should be Integer");
				}
			}
			if (customerService.cancelTicket(bookingId, customerId)) {
				System.out.println("Ticket cancelled");
			} else {
				System.out.println("Ticket cancelation Failed");
			}
		} else {
			System.out.println("No tickets found to cancel");
		}
	}
	private static void checkAvailability() {
		System.out.println("Enter starting point");
		String source = scanner.next();
		System.out.println("Enter ending point");
		String destination = scanner.next();
		System.out.println("Enter the date(yyyy-mm-dd)");
		String tempDate = scanner.next();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {
			date = dateFormat.parse(tempDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<Availability> busList = bookingService.checkAvailability(source, destination, date);
		for (Availability abus : busList) {
			System.out.println(abus);
			int availSeats = bookingService.checkAvailability(abus.getBusId(), date);

			System.out.println("Available seats : " + availSeats);
			System.out.println("########################################");
		}
	}	
	private static void writeFeedback() {
		Feedback feed = new Feedback();
		feed.setCustomerId(customerId);
		System.out.println("Write the feedback");
		String feedback = scanner.next();
		feed.setFeedback(feedback);
		if (!feedback.equals("")) {
			if (customerService.writeFeedback(feed)) {
				System.out.println("Successfully done");
			} else {
				System.out.println("Failed");
			}
		}
	}
}
