package it.unical.quizasde.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import it.unical.quizasde.logic.Chat;
import it.unical.quizasde.logic.Message;

@Controller
@SessionAttributes({"nickname","chat"})
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired
	private WebApplicationContext context;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("chat", context.getBean("chat", Chat.class));
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST, params="nickname")
	public String login(@RequestParam String nickname, Model model) {
		model.addAttribute("nickname", nickname);
		return "home";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, params="message")
	public String sendMessage(@ModelAttribute("chat") Chat chat, @ModelAttribute("nickname") String nickname, @RequestParam String message) {
		chat.addMessage(new Message(nickname, message));
		return "home";
	}
}
