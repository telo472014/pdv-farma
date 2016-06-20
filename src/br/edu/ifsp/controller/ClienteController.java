package br.edu.ifsp.controller;

import br.edu.ifsp.model.Cliente;
import br.edu.ifsp.model.Medicamento;
import br.edu.ifsp.model.database.DAO.ClienteDAO;
import br.edu.ifsp.model.database.DAO.MedicamentoDAO;

import java.util.List;

public class ClienteController extends Controller<Cliente>{

    public ClienteController(Cliente cliente) {
        super(new ClienteDAO(cliente));
    }

    @Override
    public List<Cliente> listAll() {
        return super.dao.listAll();
    }

    @Override
    public void insert(Cliente cliente) {
        super.dao.insert(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        super.dao.update(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        super.dao.delete(cliente);
    }

    @Override
    public List<Cliente> find(Cliente cliente, String by, String value) {
        return super.dao.find(cliente, by, value);
    }
}
