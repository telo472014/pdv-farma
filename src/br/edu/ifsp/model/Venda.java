package br.edu.ifsp.model;

import java.util.Date;
import java.util.List;

public class Venda implements IModel{
    private Date data;
    private Date hora;
    private List<Transacao> itens;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public List<Transacao> getItens() {
        return itens;
    }

    public void setItens(List<Transacao> itens) {
        this.itens = itens;
    }
}

