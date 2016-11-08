package it.unical.quizasde.logic;

public class Message {
	
	private String user;
	private String text;
	public Message(String user, String text) {
		super();
		this.user = user;
		this.text = text;
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
	
}
