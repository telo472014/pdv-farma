package br.edu.ifsp.model.database.DAO;

import br.edu.ifsp.model.Cliente;
import br.edu.ifsp.model.Empregado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpregadoDAO extends DAO<Empregado>{
    private long    idEmpregado;
    private long    idPessoa;
    private String  cargo;
    private String  matricula;

    public EmpregadoDAO(Empregado empregado) {
        super(empregado);
    }

    @Override
    protected void getAttributes(Empregado empregado) {
        idEmpregado = empregado.getIdEmpregado();
        idPessoa = empregado.getIdPessoa();
        cargo = empregado.getCargo();
        matricula = empregado.getMatricula();
    }

    @Override
    public boolean insert(Empregado empregado) {
        ResultSet resultado;
        String sql;
        super.database.connect();

        sql = "INSERT INTO Empregado(" +
                "idpessoa, cargo, matricula) " +
                "VALUES ('" + idPessoa + "', '" + cargo + "','" + matricula + ")";

        super.database.executeSQL(sql);

        try{
            resultado = super.database.query("SELECT MAX(idEmpregado) as lastID FROM Empregado");
            resultado.next();

            empregado.setIdEmpregado(resultado.getLong("lastID"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        super.database.disconnect();
        return true;
    }

    @Override
    public boolean update(Empregado empregado) {
    	String sql = "UPDATE Empregado SET idEmpregado = ?, Matricula = ?, Cargo = ? WHERE idEmpregado = ?";
		
		sql = sql.replaceFirst("\\?", empregado.getidEmpregado().toString());
		sql = sql.replaceFirst("\\?", "\"" + empregado.getMatricula()+ "\"");
		sql = sql.replaceFirst("\\?", empregado.getCargo());

		return database.update(sql);
    }

    @Override
    public boolean delete(Empregado empregado) {
		
    	String sql = "DELETE Empregado WHERE idEmpregado = ?";
		
		sql = sql.replaceFirst("\\?", empregado.getidEmpregado().toString());

		return database.delete(sql);
    }
    
    @Override
    public List<Estoque> find(Empregado empregado, String by, String value) {
        return null;//TODO
    }

   
    @Override
    public List<Empregado> listAll() {
        return null;
    }
}
