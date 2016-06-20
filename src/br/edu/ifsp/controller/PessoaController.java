package br.edu.ifsp.controller;

import br.edu.ifsp.model.Pessoa;
import br.edu.ifsp.model.database.DAO.PessoaDAO;

import java.util.List;

public class PessoaController extends Controller<Pessoa>{

    public PessoaController(Pessoa pessoa) {
        super(new PessoaDAO(pessoa));
    }

    @Override
    public List<Pessoa> listAll() {
        return null;
    }

    @Override
    public void insert(Pessoa pessoa) {
        super.dao.insert(pessoa);
    }

    @Override
    public void update(Pessoa pessoa) {
        super.dao.update(pessoa);
    }

    @Override
    public void delete(Pessoa pessoa) {
        super.dao.delete(pessoa);
    }

    @Override
    public List<Pessoa> find(Pessoa pessoa, String by, String value) {
        return super.dao.find(pessoa,by,value);
    }
}
