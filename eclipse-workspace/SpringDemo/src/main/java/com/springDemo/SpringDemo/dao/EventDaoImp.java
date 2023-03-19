package com.springDemo.SpringDemo.dao;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.apache.log4j.Logger;

import com.springDemo.SpringDemo.models.Event;
import com.springDemo.SpringDemo.models.User;
import com.springDemo.SpringDemo.storage.Storage;



public class EventDaoImp implements EventDAO {
	public static final String EVENT = "event";
   // private static final Logger logger = Logger.getLogger(EventDaoImp.class);

	private Storage storage;
	public void setStorage(Storage storage) {
		this.storage = storage;
	}


	@Override
	public Event getEventById(long eventId) {
		// TODO Auto-generated method stub
		Event event = storage.getById(EVENT+eventId);
		return event;
	}

	@Override
	public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		Predicate <Event> predicate = e -> e.getTitle().equals(title);
		List <Event> events = storage.getElementsByValue(predicate,EVENT);
		return events;
	}

	@Override
	public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		Predicate <Event> predicate = e -> e.getDate().equals(day);
		List <Event> events = storage.getElementsByValue(predicate, EVENT);
		return events;
	}

	@Override
	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		
		Event eventCreated = storage.addPair(EVENT+event.getId(),event);

		return eventCreated;
	}

	@Override
	public Event updateEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEvent(long eventId) {
		// TODO Auto-generated method stub
		return storage.delete(EVENT+eventId);
	}

}
