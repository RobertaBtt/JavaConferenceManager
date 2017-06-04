package main;


public class  SessionDayConference implements SessionDay{

	SessionMorning sessionMorning;
	SessionAfternoon sessionAfternoon;
	
	public SessionMorning getSessionMorning(){
		return sessionMorning;
	}
	public SessionAfternoon getSessionAfternoon(){
		return sessionAfternoon;
	}
	
	public void setSessionMorning(SessionMorning sessionMorning){
		this.sessionMorning = sessionMorning;
	}
	public void setSessionAfternoon(SessionAfternoon sessionAfternoon){
		this.sessionAfternoon = sessionAfternoon;
	}

}
