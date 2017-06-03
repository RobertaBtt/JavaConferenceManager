package test;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import main.FileScanner;
import main.ProposalOrdererDivideIntoSessions;


public class ProposalOrdererDivideIntoSessionsTest {
	
	private List<String> proposals = new ArrayList<String>();
	private ProposalOrdererDivideIntoSessions proposalOrderer;
	private  static final int NUMBER_OF_ELEMENTS = 19;
	
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
		
		
		proposalOrderer = new ProposalOrdererDivideIntoSessions();
		
	}
	
	@Test
	public final void testListOrdererImplementationObjectExists(){
		assertNotNull(proposalOrderer);		
	}

	
	
	@Test
	public final void testOrderList(){
		proposals = proposalOrderer.getReordererList(proposals);
		assertEquals("09:00AM Writing Fast Tests Against Enterprise Rails 60min", proposals.get(0));

	}
	
	
}
