package it.unical.fbruno.springchat.businessLogic;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

public class UserHandler {

    @Autowired
    private MessageFactory messageFactory;
    private String username = "";

    public UserHandler() {
       
    }

    public void init() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLogged() {
        return !username.equals("");
    }

    public void writeMessage(String message) {
       messageFactory.storeMessage(username, message);
    }
    
    
    public ArrayList<String> getMessages(){
        return messageFactory.getMessages();
    }
    

}
