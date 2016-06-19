package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.IModel;
import br.edu.ifsp.model.database.Database;
import br.edu.ifsp.model.database.MariaDatabase;

import java.util.List;

public abstract class DAO<E extends IModel> {

	protected Database database;

	public DAO() {
		this.database = new MariaDatabase("root", "", "Farmacia");
	}

	public abstract boolean insert(E objeto);

	public abstract boolean update(E objeto);

	public abstract boolean delete(E objeto);

	public abstract List<E> listAll();
}
