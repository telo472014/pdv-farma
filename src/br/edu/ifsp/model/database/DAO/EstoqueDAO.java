package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.Estoque;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class EstoqueDAO extends DAO<Estoque>{

    private long idEstoque;
    private long idMedicamento;
    private long quantidadeAtual;
    private Date validade;

    public EstoqueDAO(Estoque estoque) {
        super(estoque);
    }

    @Override
    protected void getAttributes(Estoque estoque) {
        idEstoque = estoque.getIdEstoque();
        idMedicamento = estoque.getIdMedicamento();
        quantidadeAtual = estoque.getQtdeAtual();
        validade = estoque.getValidade();
    }

    @Override
    public boolean insert(Estoque estoque) {
        ResultSet resultado;
        String sql;

        super.database.connect();

        sql = "INSERT INTO Estoque(" +
                "idMedicamento, quantidadeAtual, validade) " +
                "VALUES ('" +
                idMedicamento + "', '" +
                quantidadeAtual + "', '" +
                validade + "')";

        super.database.executeSQL(sql);

        try{
            resultado = super.database.query("SELECT MAX(idEstoque) as lastID FROM Estoque");
            resultado.next();
            idEstoque = resultado.getLong("lastID");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        super.database.disconnect();
        return true;
    }

    @Override
    public boolean update(Estoque estoque) {
        return false;//TODO
    }

    @Override
    public boolean delete(Estoque estoque) {
        return false;//TODO
    }

    @Override
    public List<Estoque> find(Estoque estoque, String by, String value) {
        return null;//TODO
    }

    @Override
    protected List<Estoque> listAll() {
        return null;//TODO
    }
}
