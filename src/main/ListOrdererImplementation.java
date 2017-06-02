package main;

import java.util.ArrayList;
import java.util.List;

public class ListOrdererImplementation implements ListOrderer {
	
	private List<String> list = null;
	private boolean toOrder = true;
	
	public void setList(List<String> list) {
		this.list = list;		
	}
	
	public void orderList() {
		
		if (toOrder){
			//TODO process to order list
			toOrder = false;
		}
		
				
	}
	public List<String> getList() {	
		if (list != null) return list;
		else return new ArrayList<String>();
	}
	
	

}
