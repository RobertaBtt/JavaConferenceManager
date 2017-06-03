package main;

import java.util.List;

public abstract class Conference {
	
	protected List<String> proposals;
	
	public final void fitProposalIntoTimeConstraintsTemplateMethod(){		
		obtainProposals();
		orderProposals();
		printOrderedProposal();
	}
	
	abstract void orderProposals();
	
	private void obtainProposals(){
		
	}	
	
	private void printOrderedProposal(){
		
	}

}
