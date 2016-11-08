package it.unical.assignment.logic;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

public class ChatLogic {

	private String nickname;
	
	@Autowired
	ServletContext servletContext;
	
	public void init() {
	}
	
	public void addMesssage(Message message) {
		Object listObject = servletContext.getAttribute("chatHistory");
		if(listObject == null) {
			listObject = new ArrayList<Message>();
		}
		
		((List<Message>)listObject).add(message);
		servletContext.setAttribute("chatHistory", listObject);
	}
	
	public List<Message> getMessages() {
		Object listObject = servletContext.getAttribute("chatHistory");
		if(listObject == null) {
			listObject = new ArrayList<Message>();
		}
		return (List<Message>) listObject;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return this.nickname;
	}
	
	public boolean getIsLoggedIn() {
		return nickname != null && !nickname.isEmpty();
	}
}
