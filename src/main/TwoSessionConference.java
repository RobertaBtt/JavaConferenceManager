package main;

import java.util.ArrayList;
import java.util.List;


public class TwoSessionConference extends Conference{

	private ConferenceGroupingByDays conferenceGrouping;
	
	@Override
	public void orderProposals() {
		
		conferenceGrouping = new ConferenceGroupingByDays();
		 
		List<SessionDay> sessionDays;
		if (proposals != null)
			sessionDays = conferenceGrouping.getDaysOfConference(proposals);
		
		List<String> orderedList = new ArrayList<String>();
		proposals = orderedList;
		
	}

}
