package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.Pessoa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PessoaDAO extends DAO<Pessoa> {
    private long    idPessoa;
    private String  nome;
    private Date nascimento;

    public PessoaDAO(Pessoa pessoa) {
        super(pessoa);
    }

    @Override
    protected void getAttributes(Pessoa pessoa) {
        idPessoa = pessoa.getIdPessoa();
        nome = pessoa.getNome();
        nascimento = pessoa.getNascimento();
    }

    @Override
    public boolean insert(Pessoa pessoa) {
        ResultSet resultado;
        String sql;

        super.database.connect();

        try{
            if(idPessoa == 0) {
                sql = "INSERT INTO Pessoa(nome, nascimento) " +
                        "VALUES(" + nome + "," + nascimento + ")";
                super.database.executeSQL(sql);

                resultado = super.database.query("SELECT MAX(idPessoa) as lastID FROM Pessoa");
                resultado.next();
                idPessoa = resultado.getLong("lastID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean update(Pessoa pessoa) {
        String sql = "UPDATE Pessoa idPessoa = ?, nome = ?, nascimento = ?  WHERE idPessoa = ?";
        
        sql = sql.replaceFirst("\\?", pessoa.getidPessoa().toString());
        sql = sql.replaceFirst("\\?","\""+ pessoa.getnome()+"\"");
        sql = sql.replaceFirst("\\?", pessoa.getnascimento().toString());
        
        return database.update(sql);
    }

    @Override
    public boolean delete(Pessoa pessoa) {
        String sql = "DELETE Pessoa WHERE idPessoa = ?";
        
        sql = sql.replaceFirst("\\?", pessoa.getidPessoa().toString());
        
        return database.delete(sql);
    }

    @Override
    public List<Pessoa> find(Pessoa pessoa, String by, String value) {
//        super.database.connect();
//
//        String sql = "SELECT * FROM Pessoa WHERE "+by+" = "+value;
//
//        ResultSet rs = super.database.query(sql);


        return null;
    }

    @Override
    public List<Pessoa> listAll() {
        return null;
    }
}
