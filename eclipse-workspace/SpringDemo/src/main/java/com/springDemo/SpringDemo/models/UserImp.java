package com.springDemo.SpringDemo.models;

import java.util.concurrent.atomic.AtomicInteger;

public class UserImp implements User{
	  private static final AtomicInteger count = new AtomicInteger(0); 

	public UserImp(String name, String email) {
		super();
		this.id=count.incrementAndGet();
		this.name = name;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserImp [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public UserImp() {
		super();
	}

	private long id;
	private String name;
	private String email;

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id= id;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
		
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email=email;
		
	}

}
