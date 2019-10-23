package com.capgemini.busbookingsystem.app;

import java.util.List;
import java.util.Scanner;

import com.capgemini.busbookingsystem.beans.Booking;
import com.capgemini.busbookingsystem.beans.Bus;
import com.capgemini.busbookingsystem.beans.User;
import com.capgemini.busbookingsystem.services.AdminServices;
import com.capgemini.busbookingsystem.services.AdminServicesImplementation;
import com.capgemini.busbookingsystem.services.OwnerServiceImplementation;
import com.capgemini.busbookingsystem.services.UserServices;
import com.capgemini.busbookingsystem.services.UserServicesImplementation;

public class App {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		UserServices ser = new UserServicesImplementation();
		OwnerServiceImplementation owner = new OwnerServiceImplementation();
		AdminServices admin = new AdminServicesImplementation();

		int admin_id;
		String adminpassword;

		int ownerId;
		String ownerPassword;
		String ownerName;

		int user_id;
		String username;
		String password;
		String email;
		String mobile;
		boolean result;

		int bus_id;
		String busname;
		String source;
		String destination;
		String bus_type;
		int total_seats;
		double price;

		int ticket_id;
		int numofseats;
		System.out.println("***************************");
		System.out.println("Bus Booking System \n(using Collection) ");

		int i=9;
		while(i!=0) {
			System.out.println("***************************");
			System.out.println("Select an option: ");
			System.out.println("1) Create User Profile");
			System.out.println("2) User Login");
			System.out.println("3) Admin Login");
			System.out.println("4) Owner Login");
			System.out.println("0) Close The Application");
			System.out.println("***************************");

			i=sc.nextInt();
			switch(i) {
			case 1:
				//Create User profile
				User user=new User();
				boolean check = true;
				while(check)
				{
					System.out.println("Enter userid:");
					Integer tempId=ser.regex(sc.next());
					if(tempId!=null) {
						user_id = tempId;
						user.setUser_id(user_id);
						check = false;
					}else {
						System.out.println("User id should be number !");
					}
				}
				System.out.println("Enter The UserName:");
				username = sc.next();
				user.setUsername(username);

				boolean checkEmail = true;
				while(checkEmail) {
					System.out.println("Enter Email:");
					String temp=ser.regexemail(sc.next());
					if(temp !=null) {
						user.setEmail(temp);
						checkEmail = false;
					}else {
						System.out.println("Wrong Email Format!! e.g(example@email.com)");
					}
				}
				System.out.println("Enter The User Password:");
				password = sc.next();
				user.setPassword(password);

				boolean checkContact = true;
				while(checkContact) {
					System.out.println("Enter Contact No.:");
					String temp=ser.regexcontact(sc.next());
					if(temp !=null) {
						user.setMobile(temp);
						checkContact = false;
					}else {
						System.out.println("Contact should be of 10 digits!!");
					}
				}

				ser=new UserServicesImplementation();
				result = ser.createUser(user);
				if(result) {
					System.out.println("User Data Added");
				}
				else {
					System.out.println("Something went Wrong");
				}
				break;

			case 2:
				//User Login

				System.out.println("Enter User Id");
				user_id = sc.nextInt();

				System.out.println("Enter the Password");
				password = sc.next();

				final int userID = user_id;

				boolean b = ser.loginUser(user_id, password);
				if(b)
				{
					System.out.println("User Login Succesfull");

					int u=15;
					while(u!=0) {
						System.out.println("10) Get User Profile Details");
						System.out.println("11) Update User Profile");
						System.out.println("12) Delete User");
						System.out.println("13) Book tickets");
						System.out.println("0) Close The Application");

						u=sc.nextInt();
						switch(u) {
						case 10:
							//Search User Profile
							user = ser.searchUser(userID);
							if(user!=null) {
								System.out.println(user);
							}
							else {
								System.out.println("No such user with id: "+user_id);
							}
							break;

						case 11:
							//Update User Profile
							System.out.println("Enter The User Name:");
							username=sc.next();
							System.out.println("Enter The User Email:");
							email=sc.next();
							System.out.println("Enter The User Password:");
							password=sc.next();
							System.out.println("Enter The Contact Number:");
							mobile=sc.next();

							user=new User();
							user.setUser_id(userID);
							user.setUsername(username);
							user.setEmail(email);
							user.setPassword(password);
							user.setMobile(mobile);

							result = ser.updateUser(user);

							if(result)
							{
								System.out.println("User Data Successfully Updated");
							}
							else
							{
								System.out.println("Updation Failed");
							}
							break;

						case 12:
							//Delete User Profile
							result = ser.deleteUser(userID);
							if(result)
							{
								System.out.println("User Successfully Deleted");
							}
							else
							{
								System.out.println("There is no User with ID:"+user_id);
							}
							break;

						case 13:
							//Book?

							List<Integer> busList=(ser.showAllBusInfo());
							for(Integer busId : busList) {
								System.out.println(ser.getBus(busId));
							}


							int t=9;
							while(t!=0) {
								System.out.println("20) Get Bus");
								System.out.println("21) Show Tickets");
								System.out.println("22) Delete Ticket");
								System.out.println("0) Close The Application");

								t=sc.nextInt();
								switch(t) {

								case 20:
									//Search A Bus  

									Bus bus = new Bus();

									System.out.println("Enter Bus Id");
									bus_id = sc.nextInt();
									bus = ser.getBus(bus_id);
									if(bus!=null)
									{
										System.out.println(bus);
										//Check availablity
										System.out.println("Enter total no. of seats to be booked");
										int seats = sc.nextInt();

										int availableSeats = bus.getAvailable_seats();
										if(availableSeats>0)
										{
											if(seats<=availableSeats)
											{
												System.out.println("B o o k i n g . . .");	

												Booking ticket = new Booking();

												ticket.setBus_id(bus.getBus_id());
												ticket.setUser_id(userID);
												ticket.setNumofseats(seats);;
												try {

													result = ser.bookTicket(ticket);
													if(result) {
														if((ser).updateAvailability(bus.getBus_id(), seats)) 
														{
															System.out.println("Ticket Booked. Happy Journey!");
															System.out.println(result);
														}
													}
													else {
														System.out.println("Something went Wrong");
													}
												}catch(ClassCastException e) {
													e.printStackTrace();
												}
												break;

											}else
												System.out.println("Opps! Only "+availableSeats+" seats available.");
										}
										else
											System.out.println("Opps! There are no seats available.");
										break;
										//Check availabilty ends
									}else
									{
										System.out.println("No Bus Found");
									}
									break;

								case 21:
									//Show booked ticket
									System.out.println(ser.searchUser(userID));

									List<Booking> showUserBookedTicket = ser.showUserBookedTicket(userID);
									if(showUserBookedTicket != null)
									{
										System.out.println(showUserBookedTicket);
									}else {
										System.out.println("You haven't booked a ticket");
									}

									break;

								case 22:
									//Delete Booked ticket
									System.out.println("Enter Ticket ID");
									ticket_id = sc.nextInt();
									result = ser.cancelTicket(ticket_id);
									if(result)
									{
										System.out.println("Ticket Successfully Deleted");
									}
									else
									{
										System.out.println("There is no Ticket with ID:"+ticket_id);
									}
									break;


								case 0:
									//Close App

									t=0;
									break;

								default:
									System.out.println("Choose The Correct Option");




								} //Swtich Case of booking a ticket closes
							}
						case 0:
							//Close App

							u=0;
							break;

						default:
							System.out.println("Choose The Correct Option");
						} //Switch Case of User closes
					}
				}else
				{
					System.out.println("Login Failed");
				}
				break;

			case 3:
				//Admin Login  
				System.out.println("Enter Admin Id");
				admin_id = sc.nextInt();
				System.out.println("Enter the Admin Password");
				adminpassword = sc.next();

				boolean a = (admin).adminlogin(admin_id, adminpassword);
				if(a)
				{
					System.out.println("Login Succesfull");

					int l=9;
					while(l!=0) {
						System.out.println("31) Delete User");
						System.out.println("32) Delete Owner");
						System.out.println("0) Close The Application");

						l=sc.nextInt();

						switch(l) {
						case 31:
							user_id = sc.nextInt();
							result = admin.deleteUser(user_id);

							if(result)
							{
								System.out.println("User Successfully Deleted");
							}
							else
							{
								System.out.println("There is no User with ID:"+user_id);
							}
							break;

						case 32 :
							ownerId = sc.nextInt();
							result = admin.deleteOwner(ownerId);
							if(result) {
								System.out.println("Owner Successfully deleted");
							}else {
								System.out.println("Thier is no Owner Id:"+ownerId);
							}

							break;



						case 0:
							//Close App

							l=0;
							break;

						default:
							System.out.println("Choose The Correct Option");
						} //Switch Case Closed
					}

				}else
				{
					System.out.println("User Login Failed");
				}
				break;

			case 0:
				//Close App

				i=0;
				break;	

			case 4:
				//Owner Login  
				System.out.println("Enter Owner Id");
				ownerId = sc.nextInt();
				System.out.println("Enter the Owner Password");
				ownerPassword = sc.next();

				boolean c = owner.ownerLogin(ownerId, ownerPassword);
				if(c)
				{
					System.out.println("Login Succesfull");

					int j=9;
					while(j!=0) {
						System.out.println("41) Create Bus");
						System.out.println("42) Show All Bus Info");
						System.out.println("43) Get Bus");
						System.out.println("44) Update Bus Info");
						System.out.println("45) Delete Bus");
						System.out.println("0) Close The Application");

						j=sc.nextInt();
						switch(j) {
						case 41:
							//Create Bus
							Bus bus = new Bus();

							boolean checkBus = true;
							while(checkBus)
							{
								System.out.println("Enter Bus id:");
								Integer tempId=owner.regex(sc.next());
								if(tempId!=null) {
									bus_id = tempId;
									bus.setBus_id(bus_id);
									checkBus = false;
								}else {
									System.out.println("Bus id should be number !");
								}
							}

							System.out.println("Enter The Bus Name:");
							busname=sc.next();
							bus.setBusname(busname);
							System.out.println("Enter The source:");
							source=sc.next();
							bus.setSource(source);
							System.out.println("Enter The Destination:");
							destination=sc.next();
							bus.setDestination(destination);
							System.out.println("Enter The Bus type:");
							bus_type=sc.next();
							bus.setBus_type(bus_type);
							System.out.println("Enter The total seats:");
							total_seats = sc.nextInt();
							bus.setTotal_seats(total_seats);
							System.out.println("Enter The price:");
							price=sc.nextDouble();
							bus.setPrice(price);

							result = owner.createBus(bus);
							if(result) {
								System.out.println("Bus Data Added");

							}
							else {
								System.out.println("Something is Wrong");
							}
							break;

						case 42 :
							List<Integer> busList=(owner.showAllBusInfo());
							for(Integer busId : busList) {
								System.out.println(owner.getBus(busId));
							}

							break;

						case 43 :

							System.out.println("Enter Bus ID");
							bus_id = sc.nextInt();
							bus = owner.getBus(bus_id);
							if(bus!=null)
							{
								System.out.println(bus);
							}else
							{
								System.out.println("Bus Not Found");
							}
							break;



						case 44:
							//Update Bus Info
							System.out.println("Enter The bus Id:");
							bus_id=sc.nextInt();
							System.out.println("Enter The bus name:");
							busname=sc.next();
							System.out.println("Enter The bus source:");
							source=sc.next();
							System.out.println("Enter The bus destination:");
							destination=sc.next();
							System.out.println("Enter The bus type:");
							bus_type=sc.next();
							System.out.println("Enter Total seats:");
							total_seats=sc.nextInt();
							System.out.println("Enter The Price:");
							price=sc.nextDouble();

							bus=new Bus();
							bus.setBus_id(bus_id);
							bus.setBusname(busname);
							bus.setSource(source);
							bus.setDestination(destination);
							bus.setBus_type(bus_type);
							bus.setTotal_seats(total_seats);
							bus.setPrice(price);

							result = owner.updateBus(bus);

							if(result)
							{
								System.out.println("Bus Data Successfully Updated");
							}
							else
							{
								System.out.println("Updation Failed. Please check the Bus Id");
							}
							break;

						case 45:
							//Delete Bus
							System.out.println("Enter Bus ID");
							bus_id = sc.nextInt();

							result = owner.deleteBus(bus_id);
							if(result)
							{
								System.out.println("Bus Successfully Deleted");
							}
							else
							{
								System.out.println("There is no Bus with ID:"+bus_id);
							}
							break;

						case 0:
							//Close App

							j=0;
							break;

						default:
							System.out.println("Choose The Correct Option");
						} //Switch Case Closed
					}
				}else {
					System.out.println("Owner Login Failed");
				}
				break;


			case 5:
				//Close App

				i=0;
				break;

			default:
				System.out.println("Choose The Correct Option");

			} 
		}
	}
}
