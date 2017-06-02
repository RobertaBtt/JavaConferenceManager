package main;

public abstract class Conference {
	
	public final void fitProposalIntoTimeConstraintsTemplateMethod(){		
		obtainProposalsFromFile();
		orderProposalIntoList();
		printOrderedProposal();
	}
	
	abstract void orderProposalIntoList();
	
	void obtainProposalsFromFile(){}	
	void printOrderedProposal(){}

}
