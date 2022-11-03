package it.prova.gestionetv.dao;

import java.sql.Connection;
import java.util.List;

public interface IBaseDAO<T> {
	
	public List<T> list() throws Exception;

	public T get(Long id) throws Exception;

	public int update(T input) throws Exception;

	public int insert(T input) throws Exception;

	public int delete(Long input) throws Exception;

	// questo mi serve per la injection della connection
	public void setConnection(Connection connection);

}
