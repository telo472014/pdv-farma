package br.edu.ifsp.controller;

import br.edu.ifsp.model.Medicamento;
import br.edu.ifsp.model.database.DAO.MedicamentoDAO;

import java.util.List;

public class ClienteController extends Controller<Medicamento>{

    public ClienteController(Medicamento medicamento) {
        super(new MedicamentoDAO(medicamento));
    }

    @Override
    public List<Medicamento> listAll() {
        return null;
    }

    @Override
    public void insert(Medicamento medicamento) {
        super.dao.insert(medicamento);
    }

    @Override
    public void update(Medicamento medicamento) {
        super.dao.update(medicamento);
    }

    @Override
    public void delete(Medicamento medicamento) {
        super.dao.delete(medicamento);
    }
}
