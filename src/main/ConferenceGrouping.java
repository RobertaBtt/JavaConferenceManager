package main;

import java.util.List;

public interface ConferenceGrouping {
	
	public List<SessionDay> getDaysOfConference(List<String> proposals);
	public List<SessionMorning> getSessionMorning(List<String> proposals);
	public List<SessionAfternoon> getSessionAfternoon(List<String> proposals);

}
