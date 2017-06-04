package main;

import java.util.List;

public class InfoRetrieverFromProposalLines {
	
	private  static final String LIGHTNING_STRING = "lightning";
	private  static final String LUNCH_STRING = "Lunch";
	private  static final String NETWORKING_EVENT_STRING = "Networking Event";
	
	private  static final int LIGHTNING = 5;
	private  static final int LUNCH = 60;
	private  static final int NETWORKING_EVENT = 60;
	
	private static final double MAX_DURATION_PER_DAY = 420.0;
	
	public static int getMinutes(String proposalLine){
		return getNumber(proposalLine);
		
	}
	
	
	private static int getNumber(String proposal){
		
		int number = 0;
		
		String[] split = proposal.split(" ");		
		String lastElement = split[split.length - 1];
				
		if (lastElement.equalsIgnoreCase(LIGHTNING_STRING))
			number = LIGHTNING;
		
		else if (lastElement.equalsIgnoreCase(LUNCH_STRING))
			number = LUNCH;
		
		else
			if (proposal.equals(NETWORKING_EVENT_STRING))
				number = NETWORKING_EVENT;			
			else
				number = Integer.valueOf(lastElement.substring(0,2));		
		
		return number;
		
	}
	
	public static int getTotalMinutes(List<String> proposals){
		
		int minutes = 0;
		for (int i = 0; i < proposals.size(); i++) {
			minutes += InfoRetrieverFromProposalLines.getMinutes(proposals.get(i));
		}
		return minutes;
	}
	
	
	public static int getNumberOfDays(List<String> proposals){
		
		double dividedResult = InfoRetrieverFromProposalLines.getTotalMinutes(proposals) / MAX_DURATION_PER_DAY;
		
		if (exceedToNexDay(dividedResult))
			return (int) (dividedResult + 1); //day after		
		else return (int)dividedResult;
		
	}
	
	private static boolean exceedToNexDay(double dividedResult){
		if(dividedResult - (int)(dividedResult) >0)
			return true;
		else
			return false;	
	}
	
	public static boolean isDivisibileForThree(String proposalLine){
		
		int minutes = InfoRetrieverFromProposalLines.getMinutes(proposalLine);
		if (minutes % 3 == 0)
			return true;
		else
			return false;		
	}
	
	
}
