package com.springDemo.SpringDemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springDemo.SpringDemo.dao.TicketDAO;
import com.springDemo.SpringDemo.models.Event;
import com.springDemo.SpringDemo.models.Ticket;
import com.springDemo.SpringDemo.models.Ticket.Category;
import com.springDemo.SpringDemo.models.User;


public class TicketServiceImp implements TicketService{
	@Autowired
	public void setTicketDao(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}

	private TicketDAO ticketDao;

	@Override
	public Ticket bookTicket(long userId, long eventId, int place, Category category) {
		// TODO Auto-generated method stub
		Ticket ticket = ticketDao.bookTicket(userId, eventId, place, category);
		return ticket;
	}

	@Override
	public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List <Ticket> tickets = ticketDao.getBookedTickets(user, pageSize, pageNum);
		return tickets;
	} 

	@Override
	public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List <Ticket> tickets = ticketDao.getBookedTickets(event, pageSize, pageNum);
		return tickets;
	}

	@Override
	public boolean cancelTicket(long ticketId) {
		// TODO Auto-generated method stub
		if(ticketDao.cancelTicket(ticketId)) {
			return true;

		}
		else {
			return false;
		}
	}

}
