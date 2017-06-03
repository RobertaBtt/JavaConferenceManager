package main;

import java.util.ArrayList;
import java.util.List;


public class TwoSessionConference extends Conference{

	private ProposalOrderer proposalOrder;
	
	@Override
	public void orderProposals() {
		proposalOrder = new ProposalOrdererDivideIntoSessions();
		proposals = proposalOrder.getReordererList(proposals);
		
		List<String> orderedList = new ArrayList<String>();
		proposals = orderedList;
		
	}

}
