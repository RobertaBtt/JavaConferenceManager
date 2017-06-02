package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  FileScanner implements SourceScanner{
	
	private String stringSource = null;
	private List<String> linesFromSource = null;
	private  static final String MESSAGE_FILE_NOT_FOUND = "Sorry, you have to check the path for the source: ";

	
	
	public void setSource(String source) {
		this.stringSource = source;
	}
	
	public List<String> getLinesFromSource() {		
		
		try{
			fillListLinesFromSource();
		}
		catch(FileNotFoundException e){
			System.out.println (MESSAGE_FILE_NOT_FOUND + stringSource);			
		}
		
		return linesFromSource;
	}
	
	private void fillListLinesFromSource() throws FileNotFoundException{
		
		this.linesFromSource = new ArrayList<String>();
		Scanner fileScanner;
		try{
			fileScanner = new Scanner(new File(stringSource));
			while (fileScanner.hasNextLine()){
				linesFromSource.add(fileScanner.nextLine());				
			}
			fileScanner.close();
		}
		catch (FileNotFoundException e) {
			this.linesFromSource = new ArrayList<String>();
			throw e;
		}
		
	}

}
