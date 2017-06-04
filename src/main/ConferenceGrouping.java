package main;

import java.util.List;

public interface ConferenceGrouping {
	
	public List<SessionDay> getDaysOfConference(List<String> proposals);
	public List<SessionMorning> getSessionsMorning(List<String> proposals);
	public List<SessionAfternoon> getSessionsAfternoon(List<String> proposals);

}
