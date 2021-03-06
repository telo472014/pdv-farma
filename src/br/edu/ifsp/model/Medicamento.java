package br.edu.ifsp.model;

public class Medicamento implements IModel{
    private long idMedicamento;
    private String tarja;
    private String nome;
    private float valor;
    private boolean retemReceita;
    private long quantidadeMin;
    private long idFabricante;

    public long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public long getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(long idFabricante) {
        this.idFabricante = idFabricante;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean getRetemReceita() {
        return retemReceita;
    }

    public void setRetemReceita(boolean retemReceita) {
        this.retemReceita = retemReceita;
    }

    public long getQuantidadeMin() {
        return quantidadeMin;
    }

    public void setQuantidadeMin(long quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }
}
