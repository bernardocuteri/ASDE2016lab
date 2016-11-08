package it.unical.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;


import it.unical.test.businessLogic.ChatManager;


@Controller
@RequestMapping(value="/")
public class MainController {
	
	@RequestMapping(method = RequestMethod.POST, params = {"user", "message"})
	public String postMessage(@ModelAttribute("chatManager") ChatManager cm, @RequestParam String user,  @RequestParam String message, Model model) {
		model.addAttribute("userName",user);
		cm.putMessage(user, message);
		return "userHomePage";
	}
	
	
	
}
