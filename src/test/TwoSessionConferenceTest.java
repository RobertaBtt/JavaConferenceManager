package test;

import junit.framework.TestCase;
import main.TwoSessionConference;

import org.junit.Test;

public class TwoSessionConferenceTest extends TestCase{
	
	private TwoSessionConference twoSessionConference;

	protected void setUp() throws Exception {
		twoSessionConference = new TwoSessionConference();
		super.setUp();
	}

	
	
	@Test
	public final void testTwoSessionConferenceObjectExists(){
		assertNotNull(twoSessionConference);		
	}
	
	
	@Test 
	public final void testFitProposalIntoTimeConstraintsTemplateMethod(){
		twoSessionConference.fitProposalIntoTimeConstraintsTemplateMethod();	
		
	}
	
	@Test
	public final void testOrderProposalIntoList(){
		twoSessionConference.orderProposalIntoList();
	}

}
