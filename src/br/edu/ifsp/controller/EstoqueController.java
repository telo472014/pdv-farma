package br.edu.ifsp.controller;

import br.edu.ifsp.model.Estoque;
import br.edu.ifsp.model.database.DAO.EstoqueDAO;

import java.util.List;

public class EstoqueController extends Controller<Estoque>{

    public EstoqueController(Estoque estoque) {
        super(new EstoqueDAO(estoque));
    }

    @Override
    public List<Estoque> listAll() {
        return null;
    }

    @Override
    public void insert(Estoque estoque) {
        super.dao.insert(estoque);
    }

    @Override
    public void update(Estoque estoque) {
        super.dao.update(estoque);
    }

    @Override
    public void delete(Estoque estoque) {
        super.dao.delete(estoque);
    }

    @Override
    public List<Estoque> find(Estoque estoque, String by, String value) {
        return super.dao.find(estoque,by,value);
    }
}
