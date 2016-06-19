package br.edu.ifsp.model;

public class Medicamento implements IModel{
    private int idMedicamento;
    private String tarja;
    private String nome;
    private float valor;
    private boolean retemReceita;
    private long quantidadeMin;

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(int idMedicamento) {
        this.idMedicamento = idMedicamento;
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

    public boolean isRetemReceita() {
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
