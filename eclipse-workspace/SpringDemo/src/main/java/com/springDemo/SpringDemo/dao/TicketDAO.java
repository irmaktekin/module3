package com.springDemo.SpringDemo.dao;

import java.util.List;

import com.springDemo.SpringDemo.models.Event;
import com.springDemo.SpringDemo.models.Ticket;
import com.springDemo.SpringDemo.models.User;


public interface TicketDAO {
	Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category);
    List<Ticket> getBookedTickets(User user, int pageSize, int pageNum);
    List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum);
    boolean cancelTicket(long ticketId);
}
