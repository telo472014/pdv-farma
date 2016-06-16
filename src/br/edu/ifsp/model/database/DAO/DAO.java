package br.edu.ifsp.model.database.DAO;

import java.util.List;

import br.edu.ifsp.model.database.Database;

public abstract class DAO<E> {

	protected Database database;

	public DAO(Database database) {
		this.database = database;
	}

	public abstract boolean insert(E objeto);

	public abstract boolean update(E objeto);

	public abstract boolean delete(E objeto);

	public abstract List<E> listAll();
}
