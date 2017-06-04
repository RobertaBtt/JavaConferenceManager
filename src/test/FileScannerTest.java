package test;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.List;

import main.FileScanner;


public class FileScannerTest {
	
	private FileScanner fileScanner;
	private  static final String FILE_EMPTY = "EmptyTestInput.txt";
	private  static final String FILE = "TestInput.txt";

	private  static final int NUMBER_OF_LINES = 19;

	@Before
	public void setUp() throws Exception {
		fileScanner = new FileScanner();		
	}
	
	@Test
	public final void testFileScannerObjectExists(){
		assertNotNull(fileScanner);		
	}

	@Test
	public final void testSetSource(){
		fileScanner.setSource("");
	}
	
	@Test
	public final void testGetLinesFromSource(){

		fileScanner.setSource(FILE_EMPTY);
		List<String> linesFromSource = fileScanner.getLinesFromSource();
		assertEquals(0, linesFromSource.size());
	}
		
	@Test
	public final void testFillListLinesFromSource(){
		
		fileScanner.setSource(FILE);
		List<String> linesFromSource = fileScanner.getLinesFromSource();
		assertNotEquals(0, linesFromSource.size());
		assertEquals(NUMBER_OF_LINES, linesFromSource.size());
	}
	
}
