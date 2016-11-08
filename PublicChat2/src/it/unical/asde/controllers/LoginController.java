package it.unical.asde.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.asde.businessLogic.ChatMessages;
import it.unical.asde.businessLogic.Message;
import it.unical.asde.businessLogic.User;

@Controller

public class LoginController {

	@Autowired
	User user;
	@Autowired
	ChatMessages cmsg;

	@RequestMapping("/")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam String nickName, Model model) {
		user.setName(nickName);
		model.addAttribute("user", user);
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String nickName, @RequestParam Message comment, Model model) {
		cmsg.msgs.add(comment);
		model.addAttribute("chat", cmsg);
		return "home";
	}
}
