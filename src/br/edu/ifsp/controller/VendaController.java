package br.edu.ifsp.controller;

import br.edu.ifsp.model.Venda;
import br.edu.ifsp.model.database.DAO.VendaDAO;

import java.util.List;

public class VendaController extends Controller<Venda>{

    public VendaController(Venda venda) {
        super(new VendaDAO(venda));
    }

    @Override
    public List<Venda> listAll() {
        return null;
    }

    @Override
    public void insert(Venda venda) {
        super.dao.insert(venda);
    }

    @Override
    public void update(Venda venda) {
        super.dao.update(venda);
    }

    @Override
    public void delete(Venda venda) {
        super.dao.delete(venda);
    }

    @Override
    public List<Venda> find(Venda venda, String by, String value) {
        return super.dao.find(venda,by,value);
    }
}
