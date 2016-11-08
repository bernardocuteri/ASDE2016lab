package it.unical.publicchat.logic;

import java.util.ArrayList;

public class Chat {

	private ArrayList<String> mess;

	public ArrayList<String> getMess() {
		return mess;
	}

	public void setMess(ArrayList<String> mess) {
		this.mess = mess;
	}

	public void init() {
		mess = new ArrayList<>();

	}

	public ArrayList<String> getLast20Mess() {
		if (mess.size() > 20) {
			ArrayList<String> last = new ArrayList<>();
			for (int i = mess.size() - 20; i < mess.size(); i++)
				last.add(mess.get(i));
			return last;
		} else {
			return mess;
		}
	}

	public void sendMess(String message) {
		mess.add(message);
	}
}
