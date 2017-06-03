package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.*;

import main.ConferenceGroupingByDays;
import main.SessionDay;
import main.SessionMorning;

import org.junit.Before;
import org.junit.Test;


public class ConferenceGroupingByDaysTest {
	
	private List<String> proposals = new ArrayList<String>();
	private ConferenceGroupingByDays conferenceGroupingByDays;
	private  static final int NUMBER_OF_DAYS = 2;
	private static final String FIRST_PROPOSAL = "09:00AM Writing Fast Tests Against Enterprise Rails 60min";

	@Before
	public void setUp() throws Exception {
		
		proposals.add("Writing Fast Tests Against Enterprise Rails 60min");
		proposals.add("Overdoing it in Python 45min");
		proposals.add("Lua for the Masses 30min");
		proposals.add("Ruby Errors from Mismatched Gem Versions 45min");
		proposals.add("Common Ruby Errors 45min");
		proposals.add("Rails for Python Developers lightning");
		proposals.add("Communicating Over Distance 60min");
		proposals.add("Accounting-Driven Development 45min");
		proposals.add("Woah 30min");
		proposals.add("Sit Down and Write 30min");
		proposals.add("Pair Programming vs Noise 45min");
		proposals.add("Rails Magic 60min");
		proposals.add("Ruby on Rails: Why We Should Move On 60min");
		proposals.add("Clojure Ate Scala (on my project) 45min");
		proposals.add("Programming in the Boondocks of Seattle 30min");
		proposals.add("Ruby vs. Clojure for Back-End Development 30min");
		proposals.add("Ruby on Rails Legacy App Maintenance 60min");
		proposals.add("A World Without HackerNews 30min");
		proposals.add("User Interface CSS in Rails Apps 30min");
		
		
		conferenceGroupingByDays = new ConferenceGroupingByDays();
		
	}

	@Test
	public final void testListOrdererImplementationObjectExists(){
		assertNotNull(conferenceGroupingByDays);		
	}
	
	@Test
	public final void testGetDaysOfConferenceTest(){
		List<SessionDay> sessionDays = conferenceGroupingByDays.getDaysOfConference(proposals);
		assertEquals(null, sessionDays);		
	}
	
	@Test
	public final void testFirstProposalFromSessionDay(){
		List<SessionMorning> sessionMorning = conferenceGroupingByDays.getSessionMorning(proposals);		
		assertEquals(FIRST_PROPOSAL, sessionMorning.get(0));
	}
	
	
	
}
