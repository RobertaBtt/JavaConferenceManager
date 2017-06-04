package test;

import static org.junit.Assert.*;

import main.SessionMorning;

import org.junit.Before;
import org.junit.Test;

public class SessionMorningTest {

	private SessionMorning sessionMorning;
	private  static final String PROPOSAL_1 = "Writing Fast Tests Against Enterprise Rails 60min";
	private  static final String PROPOSAL_1_TIMED = "09:00AM Writing Fast Tests Against Enterprise Rails 60min";


	@Before
	public void setUp() throws Exception {
		sessionMorning = new SessionMorning();		
	}

	@Test
	public void testGetTalkIsEmpty() {
		assertEquals(0,  sessionMorning.getTalks().size());
	}
	
	@Test
	public void testGetTalkNotEmpty() {
		sessionMorning.addTalk(PROPOSAL_1);
		assertEquals(1,  sessionMorning.getTalks().size());
	}
	
	@Test
	public void testGetTalksCheckFirst() {
		sessionMorning.addTalk(PROPOSAL_1);
		assertEquals(PROPOSAL_1_TIMED,  sessionMorning.getTalks().get(0));
	}

}
