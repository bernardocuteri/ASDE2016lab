package it.unical.asde.businessLogic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;

@Scope("session")
public class ChatMessages {
	public List<Message> msgs = new ArrayList<>();
	public List<User> users = new ArrayList<>();

	public List<Message> getMsgs() {
		return msgs;
	}

	public void setMsgs(List<Message> msgs) {
		this.msgs = msgs;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
