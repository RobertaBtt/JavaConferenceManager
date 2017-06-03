package main;

import java.util.ArrayList;
import java.util.List;

public abstract class Conference {
	
	protected List<String> proposals;
	
	public final void fitProposalIntoTimeConstraintsTemplateMethod(){		
		
		obtainProposals();
		orderProposals();
		printOrderedProposals();
	}
	
	abstract void orderProposals();	
	private void obtainProposals(){
		proposals = new ArrayList<String>();
		proposals.add("Writing Fast Tests Against Enterprise Rails 60min");
		proposals.add("Overdoing it in Python 45min");
		proposals.add("Lua for the Masses 30min");
		proposals.add("Ruby Errors from Mismatched Gem Versions 45min");
	}	
	private void printOrderedProposals(){}

}
