package it.unical.quizasde.logic;

import java.util.ArrayList;

public class Chat {
	
	private ArrayList<Message> messages;

	public Chat() {
		super();
	}
	
	public void init() {
		messages = new ArrayList<Message>();
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}
	
	public ArrayList<Message> getMessages() {
		return messages;
	}

}
