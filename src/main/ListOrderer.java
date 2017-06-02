package main;

import java.util.List;

public interface ListOrderer {
	
	public void setList(List<String> list);
	public void orderList();
	public List<String> getList();

}
