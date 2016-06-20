package br.edu.ifsp.controller;

import br.edu.ifsp.model.Empregado;
import br.edu.ifsp.model.database.DAO.EmpregadoDAO;

import java.util.List;

public class EmpregadoController extends Controller<Empregado>{

    public EmpregadoController(Empregado empregado) {
        super(new EmpregadoDAO(empregado));
    }

    @Override
    public List<Empregado> listAll() {
        return null;
    }

    @Override
    public void insert(Empregado empregado) {
        super.dao.insert(empregado);
    }

    @Override
    public void update(Empregado empregado) {
        super.dao.update(empregado);
    }

    @Override
    public void delete(Empregado empregado) {
        super.dao.delete(empregado);
    }

    @Override
    public List<Empregado> find(Empregado empregado, String by, String value) {
        return super.dao.find(empregado,by,value);
    }
}
