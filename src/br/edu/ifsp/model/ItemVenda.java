package br.edu.ifsp.model;

public class ItemVenda implements IModel{

    private long idItemVenda;
    private long idVenda;
    private long idMedicamento;
    private long quantidade;
    private Float valorUnitario;

    public long getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(long idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(long quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
