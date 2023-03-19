package com.springDemo.SpringDemo.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class EventImp implements Event{
	  private static final AtomicInteger count = new AtomicInteger(0); 
	;
	@Override
	public String toString() {
		return "EventImp [event_id=" + event_id + ", title=" + title + ", date=" + date + "]";
	}
	private long event_id;
	private String title;
	private Date date;
	
	



	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return event_id;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		this.event_id=id;
				
		
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	@Override
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
		
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		
	}
	public EventImp(String title, Date date) {
		super();
		this.event_id = count.incrementAndGet();
		this.title = title;
		this.date = date;
	
	}


}
