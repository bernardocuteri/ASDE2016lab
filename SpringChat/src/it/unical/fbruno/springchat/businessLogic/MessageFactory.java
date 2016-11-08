package it.unical.fbruno.springchat.businessLogic;

import java.util.ArrayList;

public class MessageFactory {

    private static final ArrayList<String> MESSAGES_LIST = new ArrayList<>();

    public MessageFactory() {
        super();
    }

    public void init() {

    }

    public void storeMessage(String username, String message) {
        MESSAGES_LIST.add(username + ": " + message);
    }

    public ArrayList<String> getMessageFromIndex(int index) {

        ArrayList<String> messagesToReturn = new ArrayList<>();

        for (int i = index - 1; i < MESSAGES_LIST.size(); i++) {
            messagesToReturn.add(MESSAGES_LIST.get(i));
        }

        return messagesToReturn;
    }

    public ArrayList<String> getMessages() {
        return MESSAGES_LIST;
    }

}
