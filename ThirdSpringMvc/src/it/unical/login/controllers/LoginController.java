package it.unical.login.controllers;

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;

	@Controller
	public class LoginController {
		
		@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String handleLoginPage() {
			
			return "login";
		}
		
		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String handleLoginAction(@RequestParam String username, @RequestParam String password, Model model) {
			
			if(username == "tom") {
				model.addAttribute("loggedUser", "tom");
				return "userHomePage";
			}
			return "login";
			
			 
		}

	}


