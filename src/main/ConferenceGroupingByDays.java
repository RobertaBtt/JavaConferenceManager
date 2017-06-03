package main;

import java.util.ArrayList;
import java.util.List;


public class ConferenceGroupingByDays implements ConferenceGrouping {
	
	private boolean toOrder = true;
	private List<SessionMorning> sessionsMorning = new ArrayList<SessionMorning>();
	
	private static final double DURATION_MORNING = 180;
	private static final String LUNCH = "Lunch";
	private int currentTotalMinutes = 0;
	private int initPosition = 0;
	private List<Integer> excludedIndexes = new ArrayList<Integer>();
	private SessionMorning sessionMorning = new SessionMorning();
	
	private List<Integer> acceptedProposalIndexes = new ArrayList<Integer>();
	
	public List<SessionDay> getDaysOfConference(List<String> proposals) {		
		createSessionsMorning(proposals);
		return null;
	}
	
	public List<SessionMorning> getSessionMorning(List<String> proposals) {
		if (sessionsMorning != null && sessionsMorning.size() !=0){
			return sessionsMorning;
		}
		else{
			createSessionsMorning(proposals);
			return sessionsMorning;
		}
	}


	public List<SessionAfternoon> getSessionAfternoon(List<String> proposals) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	private void createSessionsMorning(List<String> proposals){
		
		int numDays = InfoRetrieverFromProposalLines.getNumberOfDays(proposals);
		
		for (int i=initPosition; i<=proposals.size(); i++){
			if (daysToFillStillRemains(numDays)){
				
				if (InfoRetrieverFromProposalLines.isDivisibileForThree(proposals.get(i))){
					currentTotalMinutes += InfoRetrieverFromProposalLines.getMinutes(proposals.get(i));
					
					if (morningExactlyFilled(currentTotalMinutes)){
						updateInfoForMorningSession(proposals, i, sessionMorning);
						closeMorning(sessionMorning);
						
						sessionsMorning.add(sessionMorning);
						initPosition = i+1;
						sessionMorning = new SessionMorning();
						currentTotalMinutes = 0;
						createSessionsMorning(proposals);
					}
					else if(morningNotYetFilled(currentTotalMinutes))
						updateInfoForMorningSession(proposals, i, sessionMorning);
					
					else if (morningExcedeed(currentTotalMinutes)){
						adjustInfoForMorningSession(proposals.get(i), i);
						createSessionsMorning(proposals);
						
					}
				}
				
			}
		}
	}
	
	private boolean daysToFillStillRemains(int numDays){
		if (sessionsMorning.size() <= numDays -1 )
			return true;
		else
			return false;
		
	}
	
	private boolean morningExactlyFilled(int currentTotalMinutes){
		if (currentTotalMinutes == DURATION_MORNING)
			return true;
		else 
			return false;
		
	}
	
	private void updateInfoForMorningSession(List<String> proposals, 
			int indexAcceptedProposal,
			SessionMorning sessionMorning){
		
		acceptedProposalIndexes.add(indexAcceptedProposal);
		sessionMorning.addTalk(proposals.get(indexAcceptedProposal));
			
	}
	
	private void closeMorning(SessionMorning sessionMorning){
		sessionMorning.addTalk(LUNCH);	
	}
	
	private boolean morningNotYetFilled(int currentTotalMinutes){
		if (currentTotalMinutes < DURATION_MORNING)
			return true;
		else 
			return false;
		
	}
	
	private boolean morningExcedeed(int currentTotalMinutes){
		if (currentTotalMinutes > DURATION_MORNING)
			return true;
		else 
			return false;
		
	}
	
	private void adjustInfoForMorningSession(String proposal, int currentIndex){
		
		currentTotalMinutes = currentTotalMinutes - InfoRetrieverFromProposalLines.getMinutes(proposal);
		initPosition = currentIndex+1;
		excludedIndexes.add(currentIndex);
		
	}
	
	
	
	
}