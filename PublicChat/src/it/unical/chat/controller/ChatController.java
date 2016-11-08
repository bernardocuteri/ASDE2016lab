package it.unical.chat.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {
	
	@Autowired
	private Messages messages;
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) { 
		
		return "chat";
		
	}
	
	@RequestMapping(value = "/chat", method = RequestMethod.POST)
	public String messageRequest(@RequestParam String message) {
		
		System.out.println("message "+message);
		
		//chi invia il messaggio al file?
		try(FileWriter fw = new FileWriter(messages.getFile(), true); 
				BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(message);
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
		return "chat";
		
	}

}