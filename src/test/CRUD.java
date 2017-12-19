package test;

import java.util.List;

public interface CRUD <T extends Lib>{
	
	List<T> GetAll();
	T GetOne(int id);
	boolean Add(T obj);
	boolean Update(T obj);
	boolean Delete(int id);
}
