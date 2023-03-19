package com.springDemo.SpringDemo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.springDemo.SpringDemo.dao.TicketDaoImp;
import com.springDemo.SpringDemo.models.Ticket;
import com.springDemo.SpringDemo.models.Ticket.Category;
import com.springDemo.SpringDemo.models.TicketImp;

public class TicketServiceImpTest {

		private TicketServiceImp ticketService;
		private TicketDaoImp mockTicketDao;
		
		@Before
		public  void setup() {
			mockTicketDao = Mockito.mock(TicketDaoImp.class);
			ticketService = new TicketServiceImp();
			ticketService.setTicketDao(mockTicketDao);
			
		}
		
		@Test
		public void whenBookTicket_ThenTicketReturn() {
			Ticket ticket = new TicketImp(1,1,Ticket.Category.BAR,3);
			when(mockTicketDao.bookTicket(anyLong(),anyLong(),anyInt(),any(Category.class))).thenReturn(ticket);
			Ticket ticket2 = ticketService.bookTicket(1, 1, 3, Ticket.Category.BAR);
			assertEquals(ticket,ticket2);
		}

	}



