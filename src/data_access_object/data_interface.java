package data_access_object;

import java.util.ArrayList;

public interface data_interface<T> {
	
	public int insert(T t);
	
	public int update(T t);
	
	public int delete(T t);
	
	public ArrayList<T> selectAll();
	
	public T selectById(T t);
	
}
