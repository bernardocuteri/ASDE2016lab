package it.unical.publicchat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/")
@SessionAttributes("username")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println("Get home");
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleLoginAction(@RequestParam String username, Model model) {
		model.addAttribute("username", username);
		System.out.println(username);
		return "redirect:chat";
	}
}
