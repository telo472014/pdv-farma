package br.edu.ifsp.controller;

import br.edu.ifsp.model.Fabricante;
import br.edu.ifsp.model.database.DAO.FabricanteDAO;

import java.util.List;

public class FabricanteController extends Controller<Fabricante>{

    public FabricanteController(Fabricante fabricante) {
        super(new FabricanteDAO(fabricante));
    }

    @Override
    public List<Fabricante> listAll() {
        return null;
    }

    @Override
    public void insert(Fabricante fabricante) {
        super.dao.insert(fabricante);
    }

    @Override
    public void update(Fabricante fabricante) {
        super.dao.update(fabricante);
    }

    @Override
    public void delete(Fabricante fabricante) {
        super.dao.delete(fabricante);
    }

    @Override
    public List<Fabricante> find(Fabricante fabricante, String by, String value) {
        return super.dao.find(fabricante,by,value);
    }
}
