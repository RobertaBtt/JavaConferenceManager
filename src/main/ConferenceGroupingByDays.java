package main;

import java.util.ArrayList;
import java.util.List;


public class ConferenceGroupingByDays implements ConferenceGrouping {
	
	private List<SessionMorning> sessionsMorning = new ArrayList<SessionMorning>();
	private List<SessionAfternoon> sessionsAfternoon= new ArrayList<SessionAfternoon>();

	private static final double DURATION_MORNING = 180;
	private static final double DURATION_ATERNOON = 240;
	private static final String LUNCH = "Lunch";
	private static final String NETWORKING_EVENT = "Networking Event";
	
	private int currentTotalMinutes = 0;
	private int initPosition = 0;
	private List<Integer> excludedProposalIndexes = new ArrayList<Integer>();
	private List<Integer> acceptedProposalIndexes = new ArrayList<Integer>();
	
	private SessionMorning sessionMorning = new SessionMorning();
	private SessionAfternoon sessionAfternoon = new SessionAfternoon();	
	
	private List<SessionDay> sessionsDay = new ArrayList<SessionDay>();
	
	public List<SessionDay> getDaysOfConference(List<String> proposals) {	
		
		if (sessionsDayBuilt())
			return sessionsDay;
		else{
			createSessionsDay(proposals);
			return sessionsDay;
		}			
	}
	
	private boolean sessionsDayBuilt(){
		if (sessionsDay != null && sessionsDay.size() !=0)
			return true;
		else
			return false;
	}
	
	private void createSessionsDay(List<String> proposals){
		SessionDayConference sessionDayConference;
		
		List<SessionAfternoon> sessionsAfternoon = getSessionsAfternoon(proposals);
		for(int i=0; i<sessionsMorning.size(); i++)
			for (int j=0; j<sessionsAfternoon.size(); j++)
				if (i==j){
					 sessionDayConference = new SessionDayConference();
					 sessionDayConference.setSessionMorning(sessionsMorning.get(i));
					 sessionDayConference.setSessionAfternoon(sessionsAfternoon.get(j));
					 sessionsDay.add(sessionDayConference);
				}										
	}
	
	public List<SessionMorning> getSessionsMorning(List<String> proposals) {
		
		if (morningSessionsBuilt())
			return sessionsMorning;
		
		else{
			createSessionsMorning(proposals);
			return sessionsMorning;
		}
	}


	public List<SessionAfternoon> getSessionsAfternoon(List<String> proposals) {
		
		if (morningSessionsBuilt())
			if (afternoonSessionsBuilt())
				return sessionsAfternoon;
			else{
				initPosition = 0;
				createSessionsAfternoon(proposals);
				return sessionsAfternoon;
			}
		
		else{
			createSessionsMorning(proposals);
			initPosition = 0;
			createSessionsAfternoon(proposals);
			return sessionsAfternoon;
		}
	}
	
	private boolean morningSessionsBuilt(){
		if (sessionsMorning != null && sessionsMorning.size() !=0)
			return true;
		else
			return false;
	}
	
	private boolean afternoonSessionsBuilt(){
		if (sessionAfternoon != null && sessionsAfternoon.size() !=0)
			return true;
		else
			return false;
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
		excludedProposalIndexes.add(currentIndex);
		
	}
	
	private void createSessionsAfternoon(List<String> proposals){
		
		for (int i=initPosition; i<=proposals.size(); i++){
			if (remainsProposals(proposals)){
				if (currentIndexNotInTheMorning(i)){
					currentTotalMinutes += InfoRetrieverFromProposalLines.getMinutes(proposals.get(i));
					if(excludedIndexesNotEmpty()){
						currentTotalMinutes += InfoRetrieverFromProposalLines.getMinutes(proposals.get(i));
						excludedProposalIndexes.clear();
					}
					if (afternoonNotYetFill()){
						initPosition = i+1;
						updateInfoForAfternoonSession(proposals, i);
						if (elementsToCheckAreFinished(proposals)){
							closeAfternoon(sessionAfternoon);
							sessionsAfternoon.add(sessionAfternoon);
						}
					}
					else{
						currentTotalMinutes = currentTotalMinutes - InfoRetrieverFromProposalLines.getMinutes(proposals.get(i));
						if (afternoonNotYetFill()){
							closeAfternoon(sessionAfternoon);
							sessionsAfternoon.add(sessionAfternoon);
							sessionAfternoon = new SessionAfternoon();
							currentTotalMinutes = 0;
							createSessionsAfternoon(proposals);
						}
					}
				}
			}
				
		}
	
	}
	
	private boolean remainsProposals(List<String> proposals){
		if( acceptedProposalIndexes.size() <= proposals.size() -1)
			return true;
			else
				return false;
		
	}
	private boolean currentIndexNotInTheMorning(int proposalIndex){
		if(! acceptedProposalIndexes.contains(proposalIndex))
			return true;
		else
			return false;
	}
	private boolean excludedIndexesNotEmpty(){
		if (excludedProposalIndexes.size() != 0)
			return true;
		else 
			return false;
	}
	private boolean afternoonNotYetFill(){
		if(currentTotalMinutes <= DURATION_ATERNOON)
			return true;
		else
			return false;
	}
	private void updateInfoForAfternoonSession(List<String> proposals,
			int indexAcceptedProposal){
		acceptedProposalIndexes.add(indexAcceptedProposal);
		sessionAfternoon.addTalk(proposals.get(indexAcceptedProposal));
	}
	private boolean elementsToCheckAreFinished(List<String> proposals){
		if(acceptedProposalIndexes.size() == proposals.size())
			return true;
		else
			return false;
					
	}
	private void closeAfternoon(SessionAfternoon sessionAfternoon){
		sessionAfternoon.addTalk(NETWORKING_EVENT);	
	}
}