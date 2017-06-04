package main;

import java.util.List;

public abstract class Conference {
	
	private  static final String FILE = "TestInput.txt";

	protected List<String> proposals;
	protected List<SessionDay> sessionsDay;
	
	public final void fitProposalIntoTimeConstraintsTemplateMethod(){		
		
		obtainProposals();
		fitProposalIntoDays();
		printOrderedProposals();
	}
	
	private void obtainProposals(){
		FileScanner fileReader = new FileScanner();
		fileReader.setSource(FILE);
		proposals = fileReader.getLinesFromSource();		
	}	
	
	protected abstract void fitProposalIntoDays();	
	
	private void printOrderedProposals(){
		SessionMorning sessionMorning;
		SessionAfternoon sessionAfternoon;
		for (int i=0; i<sessionsDay.size(); i++){
			System.out.println("Track " +Integer.valueOf(i+1) + ":");
			sessionMorning = sessionsDay.get(i).getSessionMorning();
			sessionAfternoon = sessionsDay.get(i).getSessionAfternoon();
			
			for (int m=0; m<sessionMorning.getTalks().size(); m++)
				System.out.println(sessionMorning.getTalks().get(m));
			for (int a=0; a<sessionAfternoon.getTalks().size(); a++)
				System.out.println(sessionAfternoon.getTalks().get(a));
			
		}
			
	}

}
