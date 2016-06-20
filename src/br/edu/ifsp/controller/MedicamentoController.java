package br.edu.ifsp.controller;

import br.edu.ifsp.model.Medicamento;
import br.edu.ifsp.model.database.DAO.MedicamentoDAO;

import java.util.List;

public class MedicamentoController extends Controller<Medicamento>{

    public MedicamentoController(Medicamento medicamento) {
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

    @Override
    public List<Medicamento> find(Medicamento medicamento, String by, String value) {
        return super.dao.find(medicamento,by,value);
    }
}
