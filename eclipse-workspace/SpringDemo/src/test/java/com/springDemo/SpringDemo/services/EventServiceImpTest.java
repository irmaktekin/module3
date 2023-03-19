package com.springDemo.SpringDemo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.springDemo.SpringDemo.dao.EventDAO;
import com.springDemo.SpringDemo.dao.EventDaoImp;
import com.springDemo.SpringDemo.dao.UserDAO;
import com.springDemo.SpringDemo.dao.UserDaoImp;
import com.springDemo.SpringDemo.models.Event;
import com.springDemo.SpringDemo.models.EventImp;
import com.springDemo.SpringDemo.models.User;
import com.springDemo.SpringDemo.models.UserImp;

public class EventServiceImpTest {
	private EventServiceImp eventService;
	private EventDAO mockEventDao;
	
	@Before
	public  void setup() {
		mockEventDao = Mockito.mock(EventDaoImp.class);
		eventService = new EventServiceImp();
		eventService.setEventDao(mockEventDao);
		
	}
	
	@Test
	public void whenEventId_ThenEventReturn() {
		Event event = new EventImp("event22",new Date());
		when(mockEventDao.getEventById(anyLong())).thenReturn(event);
		Event event_returned = eventService.getEventById(1);
		assertEquals(event,event_returned);
	}
	@Test
	public void whenCreatEvent_ThenReturnCreatedEvent() {
		Event event = new EventImp("event45",new Date());
		when(mockEventDao.createEvent(any(Event.class))).thenReturn(event);
		Event event_created = eventService.createEvent(event);
		assertEquals(event,event_created);
	
		
	
	}
}
