package main;

import java.util.ArrayList;
import java.util.List;


public  class SessionAfternoon extends Session{
	
	private List<String> talks = new ArrayList<String>();
	private  static final String AFTERNOON_START = "01:00pM";
	private  static final String AM = "AM";
	private  static final String PM = "PM";
	
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
	

	private String getNextTime(String currentTime, int currentMinutesDuration){
	
	String[] timeSplitted = currentTime.split(":");

	String timeHour = timeSplitted[0];	
	String timeMinutes = timeSplitted[1].substring(0,2);
	
	int minutes = Integer.valueOf(timeMinutes);
	int hours = Integer.valueOf(timeHour);
	int newHour = -1;

	int newMinutes = minutes + currentMinutesDuration;
	
	if (newMinutes >= 60){
		newHour = hours + 1;
		newMinutes = newMinutes - 60;			
	}
	else
		newHour = hours;		
	
	
	String newHourString = String.valueOf(newHour);
	String newMinutesString = String.valueOf(newMinutes);
	
	if (newHourString.length() == 1)
		 newHourString = "0"+newHourString;
		
	if (newMinutesString.length() == 1)
		newMinutesString =  "0" +newMinutesString;
		
	if (newHour >= 9  && newHour <=11)
		newMinutesString =  newMinutesString+AM;
	
	else
		newMinutesString =  newMinutesString+PM;
		
	return newHourString+ ":"+ newMinutesString;
	
	}

}
