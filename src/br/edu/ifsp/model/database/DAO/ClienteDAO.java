package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO extends DAO<Cliente>{
    private long    idCliente;
    private long    idPessoa;
    private String  endereco;

    public ClienteDAO(Cliente cliente) {
        super(cliente);
    }

    @Override
    protected void getAttributes(Cliente cliente) {
        idCliente = cliente.getIdCliente();
        idPessoa = cliente.getIdPessoa();
        endereco = cliente.getEndereco();
    }

    @Override
    public boolean insert(Cliente cliente) {
        ResultSet resultado;
        String sql;
        super.database.connect();

        sql = "INSERT INTO Cliente(" +
                "idpessoa, endereco) " +
                "VALUES ('" + idPessoa + "', '" + endereco + "')";

        super.database.executeSQL(sql);

        try{
            resultado = super.database.query("SELECT MAX(idCliente) as lastID FROM Cliente");
            resultado.next();
            idCliente = resultado.getLong("lastID");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        super.database.disconnect();
        return true;
    }

    @Override
    public boolean update(Cliente cliente) {
        return false;
    }

    @Override
    public boolean delete(Cliente cliente) {
        return false;
    }

    @Override
    public List<Cliente> find(Cliente objeto, String by, String value) {
        return null;
    }

    @Override
    protected List<Cliente> listAll() {
        return null;
    }
}
