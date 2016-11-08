package test.asde.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import test.asde.model.ChatBean;

@Controller
@SessionAttributes({"chatBean","username"})
@RequestMapping("/")
public class IndexController {

	@Autowired
	private WebApplicationContext context;
	
	@RequestMapping(method = RequestMethod.GET)
	public String helloIndex(Model model)
	{
		model.addAttribute("chatBean", context.getBean("chatBean", ChatBean.class));
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "username")
	public String loginUser(@ModelAttribute("chatBean") ChatBean chat, Model model, @RequestParam String username)
	{				
		chat.addSingleUser(username);
		model.addAttribute("username", username);
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST, params = "message")
	public String sendMessage(@ModelAttribute("chatBean") ChatBean chat, @ModelAttribute("username") String username,
			Model model, @RequestParam String message)
	{					
		chat.addMessage(username, message);
		return "index";
	}
}
