package br.edu.ifsp.controller;

import br.edu.ifsp.model.IModel;
import br.edu.ifsp.model.database.DAO.DAO;
import br.edu.ifsp.model.database.DAO.MedicamentoDAO;

import java.util.List;

public abstract class Controller<E extends IModel> {

    protected DAO<E> dao;

    public Controller(DAO<E> dao) {
        this.dao = dao;
    }

    public abstract List<E> listAll();

    public abstract void insert(E objeto);

    public abstract void update(E objeto);

    public abstract void delete(E objeto);

}
