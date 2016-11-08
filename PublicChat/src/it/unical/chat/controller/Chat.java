package it.unical.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class Chat {
	
	@Autowired
	private Messages messages;
	private List<String> inText;
	private String outText;
	
	public Chat() {
		super();
	}
	
	public void init() {
		inText=messages.init(); //dovresti leggere il file con le chat precedenti...
	}
	
	public List<String> getInText() {
		return inText;
	}

	public String getOutText() {
		return outText;
	}

	public void setOutText(String t) {
		outText = t;
	}
	
}
