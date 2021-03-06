package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.ItemVenda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ItemVendaDAO extends DAO<ItemVenda>{

    private long  idItemVenda;
    private long  idVenda;
    private long  idMedicamento;
    private long  quantidade;
    private Float valorUnitario;


    public ItemVendaDAO(ItemVenda itemVenda) {
        super(itemVenda);
    }

    @Override
    protected void getAttributes(ItemVenda itemVenda) {
        idItemVenda = itemVenda.getIdItemVenda();
        idVenda = itemVenda.getIdVenda();
        idMedicamento = itemVenda.getIdMedicamento();
        quantidade = itemVenda.getQuantidade();
        valorUnitario = itemVenda.getValorUnitario();
    }

    @Override
    public boolean insert(ItemVenda itemVenda) {
        ResultSet resultado;
        String sql;

        super.database.connect();

        sql = "INSERT INTO ItemVenda(" +
                "idVenda, idMedicamento, valorUnitario, quantidade) " +
                "VALUES ('" +
                idVenda + "', '" +
                idMedicamento + "', '" +
                valorUnitario + "', '" +
                quantidade + "')";

        super.database.executeSQL(sql);

        try{
            resultado = super.database.query("SELECT MAX(idItemVenda) as lastID FROM ItemVenda");
            resultado.next()

            itemVenda.setIdItemVenda(resultado.getLong("lastID"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        super.database.disconnect();
        return true;
    }

    @Override
    public boolean update(ItemVenda itemVenda) {
    	String sql = "UPDATE ItemVenda SET idItemVenda = ?, idVenda = ?, idMedicamento = ?, quantidade = ?, "
    			+ " valorunitario = ? WHERE idEstoque = ?";
		
		sql = sql.replaceFirst("\\?", itemVenda.getidVenda().toString());
		sql = sql.replaceFirst("\\?", "\"" + itemVenda.getidVenda().toString()+ "\"");
		sql = sql.replaceFirst("\\?", "\"" + itemVenda.getidMedicamento().toString()+ "\"");
		sql = sql.replaceFirst("\\?", "\"" + itemVenda.getquantidade().toString()+ "\"");
		sql = sql.replaceFirst("\\?", cliente.CNPJ());

		return database.update(sql);
    }

    @Override
    public boolean delete(ItemVenda itemVenda) {
    	String sql = "DELETE ItenVenda WHERE idItemVenda = ?";
		
		sql = sql.replaceFirst("\\?", itemVenda.getidVenda().toString());

		return database.delete(sql);
    }

    @Override
    public List<ItemVenda> find(ItemVenda itemVenda, String by, String value) {
        return null;
    }

    @Override
    public List<ItemVenda> listAll() {
        return null;
    }
}
