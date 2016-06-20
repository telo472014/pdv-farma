package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.Medicamento;

import java.util.List;

public class MedicamentoDAO extends DAO<Medicamento> {
    private long    idMedicamento;
    private String  nome;
    private String  tarja;
    private float   valor;
    private boolean retemReceita;
    private long    quantidadeMin;
    private long    idFabricante;

    public MedicamentoDAO(Medicamento objeto) {
        super(objeto);
    }

    @Override
    public boolean insert(Medicamento medicamento) {
        super.database.connect();
        String sql =
                "INSERT INTO Medicamento(" +
                        "nome, tarja, valor, retemReceita, quantidadeMin, idFabricante) " +
                        "values ('"+
                        medicamento.getNome()+"','"+
                        medicamento.getTarja()+"',"+
                        medicamento.getValor()+","+
                        medicamento.getRetemReceita()+","+
                        medicamento.getQuantidadeMin()+","+
                        medicamento.getIdFabricante()+")";

        super.database.executeSQL(sql);
        super.database.disconnect();
        return true;
    }

    @Override
    public boolean update(Medicamento medicamento) {
        super.database.connect();

        String sql = "UPDATE `medicamento` SET " +
                "`nome`          = '" + nome+"', " +
                "`tarja`         = '" + tarja+"', " +
                "`valor`         = '" + valor+"', " +
                "`retemReceita`  = "  + retemReceita+", " +
                "`quantidadeMin` = '" + quantidadeMin+"', " +
                "`idFabricante`  = '" + idFabricante+"'" +
                "WHERE `medicamento`.`idMedicamento` = "+ idMedicamento;

        super.database.executeSQL(sql);
        super.database.disconnect();
        return true;
    }

    @Override
    public boolean delete(Medicamento medicamento) {
        String sql = "DELETE FROM `medicamento` WHERE `medicamento`.`idMedicamento` = "+
                medicamento.getIdMedicamento();

        super.database.executeSQL(sql);
        super.database.disconnect();
        return true;
    }

    @Override
    public List<Medicamento> find(Medicamento objeto, String by, String value) {
        return null;
    }

    @Override
    public List<Medicamento> listAll() {
        return null;
    }

    @Override
    protected void getAttributes(Medicamento medicamento){
        idMedicamento   = medicamento.getIdMedicamento();
        nome            = medicamento.getNome();
        tarja           = medicamento.getTarja();
        valor           = medicamento.getValor();
        retemReceita    = medicamento.getRetemReceita();
        quantidadeMin   = medicamento.getQuantidadeMin();
        idFabricante    = medicamento.getIdFabricante();
    }
}
