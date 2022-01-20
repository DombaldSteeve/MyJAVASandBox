package myapp.services;

import java.sql.SQLException;
import java.util.List;


public interface ICrud<Object> {
	
	void add(Object o);
	
	void update(Object o);
	
	void delete(Object o);
	
	List<Object> selectAll();
	
	Object selectOne(int id);


}
