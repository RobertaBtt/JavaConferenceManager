package main;

public class TwoSessionConference extends Conference{

	private ConferenceGroupingByDays conferenceGrouping;
	
	@Override
	protected void fitProposalIntoDays() {		
		conferenceGrouping = new ConferenceGroupingByDays();
		sessionsDay = conferenceGrouping.getDaysOfConference(proposals);		
		
	}

}
