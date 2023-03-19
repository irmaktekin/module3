package com.springDemo.SpringDemo.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springDemo.SpringDemo.models.Event;
import com.springDemo.SpringDemo.models.Ticket;
import com.springDemo.SpringDemo.models.Ticket.Category;
import com.springDemo.SpringDemo.models.User;
import com.springDemo.SpringDemo.services.EventService;
import com.springDemo.SpringDemo.services.TicketService;
import com.springDemo.SpringDemo.services.UserService;



public class FacadeImp implements BookingFacade{

	private UserService userService;
	private EventService eventService;
	private TicketService ticketService;
	@Override
	public Event getEventById(long eventId) {
		// TODO Auto-generated method stub
		Event event = eventService.getEventById(eventId);
		return event;
	}
	@Override
	public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List <Event> events = eventService.getEventsByTitle(title, pageSize, pageNum);
		return events;
	}
	@Override
	public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List <Event> events = eventService.getEventsForDay(day, pageSize, pageNum);
		return events;
	}
	@Override
	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		Event createdEvent = eventService.createEvent(event);
		return createdEvent;
	}
	@Override
	public Event updateEvent(Event event) {
		// TODO Auto-generated method stub
		Event updatedEvent = eventService.updateEvent(event);
		return updatedEvent;
	}
	@Override
	public boolean deleteEvent(long eventId) {
		// TODO Auto-generated method stub
		return eventService.deleteEvent(eventId);
	}
	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		User user = userService.getUserById(userId);
		return user;
	}
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userService.getUserByEmail(email);
		return user;
	}
	@Override
	public List<User> getUsersByName(String name, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List<User> users = userService.getUsersByName(name, pageSize, pageNum);
		return users;
	}
	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User newUser = userService.createUser(user);
		return newUser;
	}
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User updatedUser = userService.updateUser(user);
		return updatedUser;
	}
	@Override
	public boolean deleteUser(long userId) {
		// TODO Auto-generated method stub
		return userService.deleteUser(userId);
	}
	@Override
	public Ticket bookTicket(long userId, long eventId, int place, Category category) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketService.bookTicket(userId, eventId, place, category);
		return ticket;
	}
	@Override
	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List <Ticket> bookedTickets = ticketService.getBookedTickets(user, pageSize, pageNum);
		return bookedTickets;
	}
	@Override
	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List <Ticket> bookedTickets = ticketService.getBookedTickets(event, pageSize, pageNum);
		return bookedTickets;
	}
	@Override
	public boolean cancelTicket(long ticketId) {
		// TODO Auto-generated method stub
		return ticketService.cancelTicket(ticketId);
	}
	

	public FacadeImp(UserService userService, EventService eventService, TicketService ticketService) {
		super();
		this.userService = userService;
		this.eventService = eventService;
		this.ticketService = ticketService;
	}

	

}
