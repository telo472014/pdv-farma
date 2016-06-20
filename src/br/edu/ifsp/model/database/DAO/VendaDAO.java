package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.ItemVenda;
import br.edu.ifsp.model.Venda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class VendaDAO extends DAO<Venda>{

    private long idVenda;
    private String idReceita;
    private Date data;
    private Date hora;
    private List<ItemVenda> itens;

    public VendaDAO(Venda venda) {
        super(venda);
    }

    @Override
    protected void getAttributes(Venda venda) {
        idVenda = venda.getIdVenda();

        idReceita = ""+venda.getIdReceita();
        if (idReceita.equals("-1")) {
            idReceita="";
        }

        data = venda.getData();
        hora = venda.getHora();
        itens = venda.getItens();
    }

    @Override
    public boolean insert(Venda venda) {
        ResultSet resultado;
        String sql;

        super.database.connect();

        sql = "INSERT INTO Venda(" +
                "data, hora, idReceita) " +
                "VALUES ('" +
                data + "', '" +
                hora + "', '" +
                idReceita + "')";

        super.database.executeSQL(sql);

        try{
            resultado = super.database.query("SELECT MAX(idVenda) as lastID FROM Venda");
            resultado.next();
            idVenda = resultado.getLong("lastID");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        super.database.disconnect();
        return true;
    }

    @Override
    public boolean update(Venda venda) {
        String sql = "UPDATE Venda idVenda = ?, data = ?, hora = ?, receita = ? WHERE idVenda = ?";
        
        sql = sql.replaceFirst("\\?", venda.getidVenda().toString());
        sql = sql.replaceFirst("\\?","\""+ venda.getdata().toString()+"\"");
        sql = sql.replaceFirst("\\?", "\""+venda.gethora().toString()+"\"");
        sql = sql.replaceFirst("\\?", venda.getreceita().toString());
        
    }

    @Override
    public boolean delete(Venda venda) {
        String sql = "DELETE Venda WHERE idVenda = ?";
        
        sql = sql.replaceFirst("\\?", venda.idVenda().toString());
        
        return database.delete(sql);
    }

    @Override
    public List<Venda> find(Venda venda, String by, String value) {
        return null;//TODO:
    }

    @Override
    public List<Venda> listAll() {
        return null;//TODO:
    }
}
