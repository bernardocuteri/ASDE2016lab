package org.spring.chat;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("personObj")
public class PersonController {
	private List<Chat> chats;
	
	
	
	@RequestMapping(value = "/addChat", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")Chat chat, ModelMap model) {
		    model.addAttribute("chats", chats);
	
		    return "chat";
	   }
	
	@RequestMapping(value="/person-form")
	public String personPage(ModelMap model) {
		model.addAttribute("person-entity", new Person());
	      return "person-page";
	}
	
	@RequestMapping(value="/process-person")
	public String addStudent(@ModelAttribute Person person, ModelMap model) {
		
		model.addAttribute("personObj", person);
		model.addAttribute("name", person.getName());
	    model.addAttribute("age", person.getAge());
		
		return "person-result-page";
	}
	
}
