package it.unical.test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")
public class LoginController {

	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String handleLoginPage() {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginAction(@RequestParam String username, Model model) {
		
		if(username != null) {
			model.addAttribute("loggedUser", username);
			return "userHomePage";
		}
		
		return "login";
		
	}
	
	

}
