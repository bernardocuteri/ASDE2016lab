package it.unical.assignment.logic;

import java.util.Date;

public class Message {
	private String user;
	private String text;
	private Date time;
	
	public Message(String user, String text, Date time) {
		this.user = user;
		this.text = text;
		this.time = time;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}
	
	
}
