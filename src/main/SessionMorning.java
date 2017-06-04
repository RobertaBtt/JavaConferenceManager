package main;

import java.util.*;

public class SessionMorning extends Session{
	
	private List<String> talks = new ArrayList<String>();
	
	private  static final String MORNING_START = "09:00AM";

	public void addTalk(String proposalTalk){
		talks.add(proposalTalk);
		
	}
	
	public List<String> getTalks() {
		return getTalksWithStartTime(talks);
	}
	
	private List<String> getTalksWithStartTime(List<String> talks){
		List<String> talksWithHourBegin = new ArrayList<String>();

		int minutes = -1;
		String currentTime = null;
		
		for (int i = 0; i< talks.size(); i++){
			if (i==0)
				currentTime = MORNING_START;
			else
				currentTime = getNextTime(currentTime, minutes);
			
			minutes = InfoRetrieverFromProposalLines.getMinutes(talks.get(i));
			talksWithHourBegin.add(currentTime + " " + talks.get(i));	
		}
		return talksWithHourBegin;
	}
	
	
}
