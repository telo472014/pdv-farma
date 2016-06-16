package br.edu.ifsp.model.database;

import java.sql.ResultSet;

public interface Database {

	boolean connect();

	ResultSet query(String sql);

	boolean insert(String sql);

	boolean update(String sql);

	boolean delete(String sql);

	boolean disconnect();

}
