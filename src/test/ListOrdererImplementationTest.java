package test;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import main.FileScanner;
import main.ListOrdererImplementation;


public class ListOrdererImplementationTest {
	
	private List<String> list = new ArrayList<String>();
	private ListOrdererImplementation listOrdererImplementation;
	private  static final int NUMBER_OF_ELEMENTS = 19;
	
	@Before
	public void setUp() throws Exception {
		
		list.add("Writing Fast Tests Against Enterprise Rails 60min");
		list.add("Overdoing it in Python 45min");
		list.add("Lua for the Masses 30min");
		list.add("Ruby Errors from Mismatched Gem Versions 45min");
		list.add("Common Ruby Errors 45min");
		list.add("Rails for Python Developers lightning");
		list.add("Communicating Over Distance 60min");
		list.add("Accounting-Driven Development 45min");
		list.add("Woah 30min");
		list.add("Sit Down and Write 30min");
		list.add("Pair Programming vs Noise 45min");
		list.add("Rails Magic 60min");
		list.add("Ruby on Rails: Why We Should Move On 60min");
		list.add("Clojure Ate Scala (on my project) 45min");
		list.add("Programming in the Boondocks of Seattle 30min");
		list.add("Ruby vs. Clojure for Back-End Development 30min");
		list.add("Ruby on Rails Legacy App Maintenance 60min");
		list.add("A World Without HackerNews 30min");
		list.add("User Interface CSS in Rails Apps 30min");
		
		
		listOrdererImplementation = new ListOrdererImplementation();
		
	}
	
	@Test
	public final void testListOrdererImplementationObjectExists(){
		assertNotNull(listOrdererImplementation);		
	}

	@Test
	public final void testListOrdererImplementationSetList(){
		listOrdererImplementation.setList(list);
		assertNotNull(listOrdererImplementation.getList());
		assertEquals(NUMBER_OF_ELEMENTS, listOrdererImplementation.getList().size());
	}
	
	@Test
	public final void testOrderListWithoutSetList(){
		listOrdererImplementation.orderList();
		assertNotNull(listOrdererImplementation.getList());
		assertEquals(0, listOrdererImplementation.getList().size());
	}
	
	@Test
	public final void testOrderList(){
		listOrdererImplementation.setList(list);
		listOrdererImplementation.orderList();
		assertEquals("09:00AM Writing Fast Tests Against Enterprise Rails 60min", listOrdererImplementation.getList().get(0));

	}
	
	
}
