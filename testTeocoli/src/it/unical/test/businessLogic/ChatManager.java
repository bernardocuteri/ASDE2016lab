package it.unical.test.businessLogic;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatManager {
	
	
	private ArrayList<String> users;
	
	private HashMap<String, String> messages;
	
		
	public ChatManager() {
		super();
	}

	public void init() {
		users = new ArrayList<String>();
		messages = new HashMap<String, String>();
	}
	
	public void putMessage(String user, String message)
	{
		messages.put(user, message);		  
	}

	public ArrayList<String> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}

	public HashMap<String, String> getMessages() {
		return messages;
	}

	public void setMessages(HashMap<String, String> messages) {
		this.messages = messages;
	}
	

	
	

}
