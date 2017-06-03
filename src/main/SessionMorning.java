package main;

import java.util.ArrayList;
import java.util.List;


public class SessionMorning extends Session{
	
	private List<String> talks = new ArrayList<String>();
	
	public void addTalk(String proposalTalk){
		talks.add(proposalTalk);
		
	}
	
	public List<String> getTalks() {
		return talks;
	}
}
