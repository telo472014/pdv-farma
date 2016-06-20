package br.edu.ifsp.model.database;

import java.sql.ResultSet;

public interface Database {

	boolean connect();

	ResultSet query(String sql);

	boolean executeSQL(String sql);

	boolean disconnect();

}
