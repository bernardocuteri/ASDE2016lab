package test.asde.model;

import java.util.ArrayList;

public class ChatBean {
	
	private ArrayList<String> users;
	private ArrayList<PairS> messages;
	
	public ChatBean() {	}
	
	public void init()
	{
		setUsers(new ArrayList<String>());
		setMessages(new ArrayList<PairS>());
	}

	public ArrayList<String> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<String> users) {
		this.users = users;
	}
	
	public ArrayList<PairS> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<PairS> messages) {
		this.messages = messages;
	}

	public void addSingleUser(String user)
	{
		this.users.add(user);
	}
	
	public void addMessage(String user, String message)
	{
		if(this.getMessages().size() >= 20)
		{
			this.getMessages().remove(0);
		}
		
		this.messages.add(new PairS(user, message));
	}
}
