package it.unical.fbruno.springchat.controllers;

import it.unical.fbruno.springchat.businessLogic.MessageFactory;
import it.unical.fbruno.springchat.businessLogic.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

@Controller
@SessionAttributes("userHandler")
public class HomeController {

    @Autowired
    private WebApplicationContext context;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        UserHandler ua = context.getBean("userHandler", UserHandler.class);
        if (!ua.isLogged()) {           
            return "login";
        }

        return "chat";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        UserHandler ua = context.getBean("userHandler", UserHandler.class);
       
        if(username.length() > 3 && password.length() > 3){
            ua.setUsername(username);
            return "redirect: chat";
        }

        return "login";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat(Model model) {
        
        UserHandler ua = context.getBean("userHandler", UserHandler.class);
       /*
        if (!ua.isLogged()) {           
            return "redirect: login";
        }
        */
        
        return "chat";
    }

    @RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
    public String sendMessage(@RequestParam String message, Model model) throws Exception {
        
        UserHandler ua = context.getBean("userHandler", UserHandler.class);
        MessageFactory mf = context.getBean("messageFactory", MessageFactory.class);
        mf.storeMessage(ua.getUsername(),message);
        for(String s: mf.getMessages()){
            System.out.println(s);
        }
        /*
        if (!ua.isLogged()) {           
            return "redirect: chat";
        }
        */
        
        model.addAttribute("user",ua);
        model.addAttribute("messagesList",mf.getMessages());
        
        return "chat";
    }

}
