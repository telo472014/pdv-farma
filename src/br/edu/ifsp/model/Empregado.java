package br.edu.ifsp.model;

public class Empregado extends Pessoa implements IModel{
    private long idEmpregado;
    private long idPessoa;
    String matricula;
    String cargo;

    public long getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(long idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
