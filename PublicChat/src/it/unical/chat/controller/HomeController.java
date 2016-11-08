package it.unical.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

@Controller
@SessionAttributes
@RequestMapping("/") //url vuota, è la root page
public class HomeController {
	
	@Autowired
	private WebApplicationContext context;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) { 
		
		model.addAttribute("chat", context.getBean("chat", Chat.class));
		return "home";
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginRequest(@RequestParam String nickname, Model model) {
		
		System.out.println("login request");
		
		if(nickname.equals("ciccio") || nickname.equals("utente2")) {
			
			model.addAttribute("utenteOk", nickname);
			System.out.println("utente: "+nickname);
			return "redirect:chat";
//			return "chat";//devo restituire la view della chat
		}
		
		System.out.println("utente non loggato: "+nickname);
		return "home";
	}
	
}
