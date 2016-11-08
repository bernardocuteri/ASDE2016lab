package it.unical.assignment;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import it.unical.assignment.logic.ChatLogic;
import it.unical.assignment.logic.Message;

@Controller
@SessionAttributes("chatLogic")
@RequestMapping("/")
public class ChatController {

	@Autowired
	private WebApplicationContext context;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("chatLogic", context.getBean("chatLogic", ChatLogic.class));
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(@ModelAttribute("chatLogic") ChatLogic cl, @RequestParam String nick, Model model) {
		if(nick != null && !nick.isEmpty())
			cl.setNickname(nick);
		
		return "home";
	}
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public String handleLoginAction(@ModelAttribute("chatLogic") ChatLogic cl, @RequestParam String message, Model model) {
		if(cl.getIsLoggedIn()) {
			cl.addMesssage(new Message(cl.getNickname(), message, new Date()));
		}
		
		return "home";
	}
}
