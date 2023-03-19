package com.springDemo.SpringDemo.dao;

import java.util.List;
import java.util.function.Predicate;

import org.apache.log4j.Logger;

import com.springDemo.SpringDemo.models.Event;
import com.springDemo.SpringDemo.models.Ticket;
import com.springDemo.SpringDemo.models.Ticket.Category;
import com.springDemo.SpringDemo.models.TicketImp;
import com.springDemo.SpringDemo.models.User;
import com.springDemo.SpringDemo.storage.Storage;



public class TicketDaoImp implements TicketDAO{
	public static final String TICKET = "ticket";
	private static final Logger logger = Logger.getLogger(EventDaoImp.class);
	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	private Storage storage;

	@Override
	public Ticket bookTicket(long userId, long eventId, int place, Category category) {
		// TODO Auto-generated method stub
		logger.debug("Bookingticket is working");
		Ticket ticket = new TicketImp(userId,eventId,category,place);
		return storage.addPair(TICKET+ticket.getId(),ticket);
	
	}

	@Override
	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Predicate <Ticket> predicate = e -> e.getUserId()==user.getId();
		List<Ticket> tickets = storage.getElementsByValue(predicate, TICKET);
		
		return tickets;
	}

	@Override
	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		Predicate <Ticket> predicate = e -> e.getEventId()==event.getId();
		List<Ticket> tickets = storage.getElementsByValue(predicate, TICKET);
		
		return tickets;
	}

	@Override
	public boolean cancelTicket(long ticketId) {
		// TODO Auto-generated method stub
		return storage.delete(TICKET+ticketId);
	}

}
