package test;

import static org.junit.Assert.*;

import main.SessionAfternoon;

import org.junit.Before;
import org.junit.Test;

public class SessionAfternoonTest {

	private SessionAfternoon sessionAfternoon;
	private  static final String PROPOSAL_1 = "Rails for Python Developers lightning";
	private  static final String PROPOSAL_1_TIMED = "01:00PM Rails for Python Developers lightning";


	@Before
	public void setUp() throws Exception {
		sessionAfternoon = new SessionAfternoon();		
	}

	@Test
	public void testGetTalkIsEmpty() {
		assertEquals(0,  sessionAfternoon.getTalks().size());
	}
	
	@Test
	public void testGetTalkNotEmpty() {
		sessionAfternoon.addTalk(PROPOSAL_1);
		assertEquals(1,  sessionAfternoon.getTalks().size());
	}
	
	@Test
	public void testGetTalksCheckFirst() {
		sessionAfternoon.addTalk(PROPOSAL_1);
		assertEquals(PROPOSAL_1_TIMED,  sessionAfternoon.getTalks().get(0));
	}

}
