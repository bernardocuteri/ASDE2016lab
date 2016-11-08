package it.unical.publicchat.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.unical.publicchat.logic.Chat;

@Controller
@RequestMapping("chat")
@SessionAttributes("username")
public class ChatController {

	@Autowired
	private Chat chat;

	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model) {
		ArrayList<String> last20Mess = chat.getLast20Mess();
		String toPrint = new String();
		for (int i = 0; i < last20Mess.size(); i++)
			toPrint += last20Mess.get(i) + "<br>";
		model.addAttribute("messages", toPrint);
		System.out.println("Get Chat");
		return "chat";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String sendMessage(@RequestParam String message, Model model) {
		chat.sendMess(model.asMap().get("username") + ": " + message);
		System.out.println(message);
		return "redirect:chat";
	}

}
