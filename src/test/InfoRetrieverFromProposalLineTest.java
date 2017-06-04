package test;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

import main.InfoRetrieverFromProposalLines;

public class InfoRetrieverFromProposalLineTest {
	
	private List<String> proposals = new ArrayList<String>();
	private List<String> oneDayProposals = new ArrayList<String>();

	
	private  static final String PROPOSAL_1 = "Writing Fast Tests Against Enterprise Rails 60min";
	private  static final String PROPOSAL_2 = "Rails for Python Developers lightning";
	private  static final int MIN_60 = 60;
	private  static final int LIGHTNING = 5;
	private  static final int TOTAL_MINUTES = 785;
	private  static final int NUMBER_OF_DAYS_TWO = 2;
	private  static final int NUMBER_OF_DAYS_ONE = 1;

	
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
				
		oneDayProposals.add("Writing Fast Tests Against Enterprise Rails 60min");
		oneDayProposals.add("Overdoing it in Python 45min");
		oneDayProposals.add("Lua for the Masses 30min");
		oneDayProposals.add("Ruby Errors from Mismatched Gem Versions 45min");
		oneDayProposals.add("Common Ruby Errors 45min");
		oneDayProposals.add("Rails for Python Developers lightning");
		oneDayProposals.add("Communicating Over Distance 60min");
		oneDayProposals.add("Accounting-Driven Development 45min");
		oneDayProposals.add("Woah 30min");
		oneDayProposals.add("Sit Down and Write 30min");

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
	public final void testNumberOfDaysTwo(){
		assertEquals(NUMBER_OF_DAYS_TWO, InfoRetrieverFromProposalLines.getNumberOfDays(proposals));		
	}
	
	@Test
	public final void testNumberOfDaysOne(){
		assertEquals(NUMBER_OF_DAYS_ONE, InfoRetrieverFromProposalLines.getNumberOfDays(oneDayProposals));		
	}
	
	
	@Test
	public final void testProposalDivisibleForThreeTrue(){
		assertTrue( InfoRetrieverFromProposalLines.isDivisibileForThree(PROPOSAL_1));		
	}
	
	@Test
	public final void testProposalDivisibleForThreeFalse(){
		assertFalse( InfoRetrieverFromProposalLines.isDivisibileForThree(PROPOSAL_2));		
	}
	
	
}
