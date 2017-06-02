package main;

import java.util.List;

public interface SourceScanner {
	
	public void setSource(String source);
	public List<String> getLinesFromSource();

}
