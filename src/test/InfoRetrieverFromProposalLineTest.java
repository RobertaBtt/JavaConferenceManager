package test;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import main.FileScanner;
import main.InfoRetrieverFromProposalLines;
import main.ProposalOrdererDivideIntoSessions;


public class InfoRetrieverFromProposalLineTest {
	
	private List<String> proposals = new ArrayList<String>();
	
	private  static final String PROPOSAL_1 = "Writing Fast Tests Against Enterprise Rails 60min";
	private  static final String PROPOSAL_2 = "Rails for Python Developers lightning";
	private  static final int MIN_60 = 60;
	private  static final int LIGHTNING = 5;
	private  static final int LUNCH = 60;
	private  static final int NETWORKING_EVENT = 60;
	private  static final int TOTAL_MINUTES = 785;
	private  static final int NUMBER_OF_DAYS = 2;
	
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
				
	}
	
	@Test
	public final void testProposal1(){
		assertEquals(MIN_60, InfoRetrieverFromProposalLines.getMinutes(PROPOSAL_1));		
	}
	
	@Test
	public final void testProposal2(){
		assertEquals(LIGHTNING, InfoRetrieverFromProposalLines.getMinutes(PROPOSAL_2));		
	}

	@Test
	public final void testTotalMinutes(){
		assertEquals(TOTAL_MINUTES, InfoRetrieverFromProposalLines.getTotalMinutes(proposals));		
	}
	
	@Test
	public final void testNumberOfDays(){
		assertEquals(NUMBER_OF_DAYS, InfoRetrieverFromProposalLines.getNumberOfDays(proposals));		
	} 
	
	
	
	
}
