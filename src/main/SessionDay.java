package main;

import java.util.List;

public interface SessionDay {

	public List<String> getSessionMorning();
	public List<String> getSessionAfternoon();
	
	public void setSessionMorning(SessionMorning sessionMorning);
	public void setSessionAfternoon(SessionAfternoon sessionAfternoon);

}
