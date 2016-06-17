package br.edu.ifsp.model;

public class Cliente extends Pessoa implements IModel{
    String endereco;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
