package it.unical.chat.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Messages {

	private File file;
	private List<String> mess = new ArrayList<>();
	
	public Messages() {
		super();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public List<String> init () {
		
		//file...
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    System.out.println("sono nel try");
		    while ((line = br.readLine()) != null) {
		    	System.out.println("e ora nel while");
		    	mess.add(line);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mess;
	}

}
