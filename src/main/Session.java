package main;

import java.util.List;


public abstract class Session {
	
	protected List<String> proposals;
	
	private  static final String AM = "AM";
	private  static final String PM = "PM";
	
	protected String getNextTime(String currentTime, int currentMinutesDuration){
		
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
