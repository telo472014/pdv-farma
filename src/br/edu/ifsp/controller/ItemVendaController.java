package br.edu.ifsp.controller;

import br.edu.ifsp.model.ItemVenda;
import br.edu.ifsp.model.database.DAO.ItemVendaDAO;

import java.util.List;

public class ItemVendaController extends Controller<ItemVenda>{

    public ItemVendaController(ItemVenda itemVenda) {
        super(new ItemVendaDAO(itemVenda));
    }

    @Override
    public List<ItemVenda> listAll() {
        return null;
    }

    @Override
    public void insert(ItemVenda itemVenda) {
        super.dao.insert(itemVenda);
    }

    @Override
    public void update(ItemVenda itemVenda) {
        super.dao.update(itemVenda);
    }

    @Override
    public void delete(ItemVenda itemVenda) {
        super.dao.delete(itemVenda);
    }

    @Override
    public List<ItemVenda> find(ItemVenda itemVenda, String by, String value) {
        return super.dao.find(itemVenda,by,value);
    }
}
