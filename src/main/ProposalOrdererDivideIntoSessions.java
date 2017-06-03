package main;

import java.util.ArrayList;
import java.util.List;

public class ProposalOrdererDivideIntoSessions implements ProposalOrderer {
	
	private boolean toOrder = true;
	

	public List<String> getReordererList(List<String> proposals) {
		
		if (toOrder){
			
			//TODO process to order list
			toOrder = false;
		}
		
		
		return proposals;
	}
}
