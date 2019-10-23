package com.capgemini.busschedulingspringmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.busschedulingspringmvc.beans.Availability;
import com.capgemini.busschedulingspringmvc.beans.Bus;
import com.capgemini.busschedulingspringmvc.beans.Feedback;
import com.capgemini.busschedulingspringmvc.beans.Ticket;
import com.capgemini.busschedulingspringmvc.beans.User;
import com.capgemini.busschedulingspringmvc.service.AdminService;
import com.capgemini.busschedulingspringmvc.service.AdminServiceImpl;
import com.capgemini.busschedulingspringmvc.service.BusBookingService;
import com.capgemini.busschedulingspringmvc.service.BusBookingServiceImpl;
import com.capgemini.busschedulingspringmvc.service.CustomerService;
import com.capgemini.busschedulingspringmvc.service.CustomerServicesImpl;
import com.capgemini.busschedulingspringmvc.service.OwnerService;
import com.capgemini.busschedulingspringmvc.service.OwnerServiceImpl;



@Controller
public class AppController {
	
	AdminService adminService=new AdminServiceImpl();
	CustomerService customerService=new CustomerServicesImpl();
	OwnerService ownerService=new OwnerServiceImpl();
	BusBookingService busBookingService=new BusBookingServiceImpl();
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor=new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@GetMapping("/app")
	public ModelAndView getApp(ModelAndView modelAndView) {
		modelAndView.setViewName("app");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView getadminLoginForm(ModelAndView modelAndView) {

		modelAndView.setViewName("loginForm");
		return modelAndView;
	}

	@GetMapping("/addOwner")
	public String getAddOwnerForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "registerForm";
		}
	}
	@GetMapping("/removeOwner")
	public String getRemoveOwnerForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "removeOwnerForm";
		}
	}
	@GetMapping("/updateOwner")
	public String getUpdateOwnerForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "updateOwnerForm";
		}
	}
	@GetMapping("/register")
	public String getAddAdminForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "registerForm";
		}
	}
	@GetMapping("/addCustomer")
	public String getAddCustomerForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "registerForm";
		}
	}
	@GetMapping("/updateCustomer")
	public String getUpdateCustomerForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "updateCustomerForm";
		}
	}
	@GetMapping("/removeCustomer")
	public String getRemoveCustomerForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "removeCustomerForm";
		}
	}

	@GetMapping("/updateBus")
	public String getUpdateBusForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "updateBusForm";
		}
	}
	@GetMapping("/addBus")
	public String getAddBusForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "addBusForm";
		}
	}
	@GetMapping("/removeBus")
	public String getRemoveBusForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "removeBusForm";
		}
	}
	@GetMapping("/setBusAvail")
	public String getSetBusAvailForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "setBusAvailForm";
		}
	}
	@GetMapping("/checkAvail")
	public String getCheckAvailForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "bookTicketForm";
		}
	}
	@GetMapping("/cancelTicket")
	public String getCancelTicketForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "cancelTicketForm";
		}
	}
	@GetMapping("/writeFeedback")
	public String getwriteFeedbackForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "writeFeedbackForm";
		}
	}
	@GetMapping("/bookTicket")
	public String getBookTicketForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "bookTicketForm";
		}
	}
	@GetMapping("/writeFeeedback")
	public String getWriteFeedbackForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "writeFeeedbackForm";
		}else {
			return "writeFeeedbackForm";
		}
	}
	@GetMapping("/printTicket")
	public String getPrintTicketForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "printTicketForm";
		}
	}
	@GetMapping("/searchBus")
	public String getSearchBusForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			return "searchBusForm";
		}
	}

	@GetMapping("/getAllTicketsForm")
	public String getgetAllTicketsForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			List<Ticket> tickets=ownerService.getAllTicket();
			if(tickets.size()>0) {
				modelMap.addAttribute("ticket", tickets);
				return "getAllTicketsForm";
			}
			modelMap.addAttribute("msg", "No tickets Found");
			return "getAllTicketsForm";
		}
	}
	@GetMapping("/viewFeedbackForm")
	public String getviewFeedbackForm(HttpSession session,ModelMap modelMap ) {
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("msg", "please login first");
			return "loginForm";
		}else {
			List<Feedback> feedbacks=busBookingService.viewFeedback();
			if(feedbacks.size()>0) {
				modelMap.addAttribute("feedback", feedbacks);
				return "viewFeedbackForm";
			}
			modelMap.addAttribute("msg", "No Feedbacks Found");
			return "viewFeedbackForm";
		}
	}
	@PostMapping("/login")
	public String adminLogin( int userId, String userPassword,ModelMap map,HttpServletRequest request) {
		User user=adminService.adminLogin(userId,userPassword); 
		if(user!=null) {
			if(user.getType().equalsIgnoreCase("admin")) {		
				HttpSession session=request.getSession(true);
				session.setMaxInactiveInterval(25);
				map.addAttribute("user", user);
				return "adminHomeForm";
			}
			else if (user.getType().equalsIgnoreCase("owner")) {

				HttpSession session=request.getSession(true);
				session.setMaxInactiveInterval(25);
				map.addAttribute("user", user);
				return "ownerHomeForm";	
			}		
			else if (user.getType().equalsIgnoreCase("enjoyer")) {	
				HttpSession session=request.getSession(true);
				session.setMaxInactiveInterval(25);
				map.addAttribute("user", user);
				return "customerHomeForm";	
			}
		}
		map.addAttribute("msg", "invalid credentials");
		return "app";

	}

	@PostMapping("/register")
	public String addUser(User user,ModelMap modelMap) {
		User user1=adminService.registerOwner(user);
		if (user1!=null ) {
			modelMap.addAttribute("msg", "User Details Added Successfully...");
			return "registerForm"; 	
		} else {
			modelMap.addAttribute("msg", "Failed to Add User!!! User ID Already Exist.");
			return "registerForm";
		}
	}
	@PostMapping("/removeCustomer")
	public String removeCustomer( int userId,ModelMap modelMap) {
		if (adminService.deleteCustomer(userId)) {
			modelMap.addAttribute("msg", "Customer Details Deleted Successfully...");
			return "loginForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Delete Customer!!! Customer ID Does not Exist.");
			return "removeCustomerForm";
		}
	}
	@PostMapping("/removeOwner")
	public String removeOwner( int userId,ModelMap modelMap) {
		if (adminService.deleteOwner(userId)) {
			modelMap.addAttribute("msg", "Owner Details Deleted Successfully...");
			return "loginForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Delete Owner!!! Owner ID Does not Exist.");
			return "removeOwnerForm";
		}
	}
	@PostMapping("/removeBus")
	public String removeBus( @RequestParam(name = "busId") int id,ModelMap modelMap) {
		if (ownerService.deleteBus(id)) {
			modelMap.addAttribute("msg", "Bus Details Deleted Successfully...");
			return "removeBusForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Delete Bus!!! Bus ID Does not Exist.");
			return "removeBusForm";
		}
	}
	@PostMapping("/updateBus")
	public String updateBus( Bus bus,ModelMap modelMap) {
		if (ownerService.updateBus(bus)) {
			modelMap.addAttribute("msg", "Bus Details Updated Successfully...");
			return "updateBusForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Update Bus!!! Bus ID Does not Exist.");
			return "updateBusForm";
		}
	}
	@PostMapping("/addBus")
	public String addBus( Bus bus,ModelMap modelMap) {
		Bus bus1=ownerService.addBus(bus);
		if (bus1!=null) {
			modelMap.addAttribute("msg", "Bus Details added Successfully...");
			return "addBusForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to add Bus!!! Bus ID allready Exist.");
			return "addBusForm";
		}
	}
	@PostMapping("/setBusAvail")
	public String setBusAvail( Availability availability,ModelMap modelMap) {
		if (ownerService.setBusAvailability(availability)) {
			modelMap.addAttribute("msg", "Bus Details Set Successfully...");
			return "setBusAvailForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Set Bus Details!!! Bus ID Does not Exist.");
			return "setBusAvailForm";
		}
	}
	@PostMapping("/updateCustomer")
	public String updateCustomer( User user,ModelMap modelMap) {
		if (customerService.updateCustomer(user)) {
			modelMap.addAttribute("msg", "Customer Details Updated Successfully...");
			return "updateCustomerForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Update Customer!!! Customer ID Does not Exist.");
			return "updateCustomerForm";
		}
	}
	@PostMapping("/checkAvail")
	public String checkAvail( Date journeyDate,String startingPoint,String endingPoint, ModelMap modelMap) {
	List<Availability> availability=busBookingService.checkAvailability(startingPoint, endingPoint,journeyDate);
		if (availability!=null) {
			modelMap.addAttribute("availList", availability);
			return "bookTicketForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Retrieve Buses!!! Buses Does not Exist.");
			return "bookTicketForm";
		}
	}
	@PostMapping("/bookTicket")
	public String bookTicket( Ticket ticket,ModelMap modelMap) {
	Ticket ticket2=customerService.bookTicket(ticket);
		if (ticket2!=null) {
			modelMap.addAttribute("ticket", ticket2);
			return "bookTicketForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Book Ticket!!! Tickets Does not Exist.");
			return "bookTicketForm";
		}
	}
	@PostMapping("/cancelTicket")
	public String cancelTicket(int bookingId,int userId,ModelMap modelMap) {
	
		if (customerService.cancelTicket(bookingId, userId)) {
			modelMap.addAttribute("msg", "Ticket Cancelled");
			return "cancelTicketForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Cancel Ticket!!! Tickets Does not Exist.");
			return "cancelTicketForm";
		}
	}
	@PostMapping("/printTicket")
	public String printTicket( int bookingId,ModelMap modelMap) {
		Ticket ticket=customerService.getTicketInfo(bookingId);
		if (ticket!=null) {
			modelMap.addAttribute("msg", "Ticket Details are:");
			modelMap.addAttribute("ticket", ticket);
			return "printTicketForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to Print Ticket!!! Tickets Does not Exist.");
			return "printTicketForm";
		}
	}
	@PostMapping("/writeFeedback")
	public String writeFeedback(Feedback feed,ModelMap modelMap) {
		
		if (customerService.writeFeedback(feed)) {
			modelMap.addAttribute("msg", "Feedback Details added Successfully");
			return "writeFeedbackForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to add Feedback!!! User Does not Exist.");
			return "writeFeedbackForm";
		}
	}
	@PostMapping("/searchBus")
	public String searchBus(int busId,ModelMap modelMap) {
		Bus bus=ownerService.searchBus(busId);
		if (bus!=null) {
			modelMap.addAttribute("msg", "Bus Details are:");
			modelMap.addAttribute("bus", bus);
			return "searchBusForm"; 
		} else {
			modelMap.addAttribute("msg", "Failed to get Bus Details!!! Bus Does not Exist.");
			return "searchBusForm";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("msg", "Logged Out Successfully");
		return "forward:/login";
	}
}