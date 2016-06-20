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
    	String sql = "UPDATE Cliente SET idCliente = ?, nome = ? WHERE idCliente = ?";
		
		sql = sql.replaceFirst("\\?", cliente.getIdCliente().toString());
		sql = sql.replaceFirst("\\?", "\"" + cliente.getEndereco().toString + "\"");
		sql = sql.replaceFirst("\\?", cliente.getIdCliente().toString());

		return database.update(sql);
	}

	@Override
	public boolean delete(Cliente cliente) {
		String sql = "DELETE Cliente WHERE idCliente = ?";
		
		sql = sql.replaceFirst("\\?", cliente.getIdCliente().toString());

		return database.delete(sql);
	}

	@Override
	public List<Cliente> listAll() {
		// Falta implementar query...
		return null;
	}

}
