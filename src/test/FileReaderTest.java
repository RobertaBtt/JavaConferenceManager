package test;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.List;

import main.FileScanner;


public class FileReaderTest {
	protected FileScanner fileReader;
	private  static final String FILE_EMPTY = "EmptyTestInput.txt";
	private  static final String FILE = "TestInput.txt";
	private  static final int NUMBER_OF_LINES = 19;

	@Before
	public void setUp() throws Exception {
		fileReader = new FileScanner();
		
	}
	
	@Test
	public final void testFileScannerObjectExists(){
		assertNotNull(fileReader);		
	}

	@Test
	public final void testSetSource(){
		fileReader.setSource("");
	}
	
	@Test
	public final void testgetLinesFromSource(){

		fileReader.setSource(FILE_EMPTY);
		List<String> linesFromSource = fileReader.getLinesFromSource();
		assert(linesFromSource.size() == 0);
	}
	
	@Test
	public final void testfillListLinesFromSource(){
		fileReader.setSource(FILE);
		List<String> linesFromSource = fileReader.getLinesFromSource();
		assertFalse(linesFromSource.size() == 0);
		assertEquals(NUMBER_OF_LINES, linesFromSource.size());
	}
	
	
	
}
