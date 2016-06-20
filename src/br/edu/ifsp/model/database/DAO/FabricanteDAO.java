package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.Cliente;
import br.edu.ifsp.model.Fabricante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FabricanteDAO extends DAO<Fabricante>{
    private long    idFabricante;
    private String  nome;
    private String  endereco;
    private String  cnpj;

    public FabricanteDAO(Fabricante fabricante) {
        super(fabricante);
    }

    @Override
    protected void getAttributes(Fabricante fabricante) {
        idFabricante = fabricante.getIdFabricante();
        idPessoa = fabricante.getIdPessoa();
        cargo = fabricante.getCargo();
        matricula = fabricante.getMatricula();
    }

    @Override
    public boolean insert(Fabricante fabricante) {
        ResultSet resultado;
        String sql;
        super.database.connect();

        sql = "INSERT INTO Fabricante(" +
                "nome, endereco, CNPJ) " +
                "VALUES ('" + nome + "', '" + endereco + "','" + cnpj + ")";

        super.database.executeSQL(sql);

        try{
            resultado = super.database.query("SELECT MAX(idFabricante) as lastID FROM Fabricante");
            resultado.next();

            fabricante.setIdFabricante(resultado.getLong("lastID"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        super.database.disconnect();
        return true;
    }

    @Override
    public boolean update(Fabricante fabricante) {
        return false;
    }

    @Override
    public boolean delete(Fabricante fabricante) {
        return false;
    }

    @Override
    public List<Fabricante> find(Fabricante fabricante, String by, String value) {
        return null;
    }

    @Override
    public List<Fabricante> listAll() {
        return null;
    }
}
