package main;

import java.util.ArrayList;
import java.util.List;


public  class SessionAfternoon extends Session{
	
	private List<String> talks = new ArrayList<String>();
	private  static final String AFTERNOON_START = "01:00PM";
	
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
				currentTime = AFTERNOON_START;
			else
				currentTime = getNextTime(currentTime, minutes);
			
			minutes = InfoRetrieverFromProposalLines.getMinutes(talks.get(i));
			talksWithHourBegin.add(currentTime + " " + talks.get(i));	
		}
		return talksWithHourBegin;
	}
	

	

}
