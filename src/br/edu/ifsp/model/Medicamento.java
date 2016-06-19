package br.edu.ifsp.model;

public class Medicamento implements IModel{
  int idMedicamento;
  enum tarja;
  String nome;
  float valor;
  boolean retemReceita;
  
  public int getIdMedicamento(){
    return this.idMedicamento;
  }
  public void setIdMedicamento(int idMedicamento){
    this.idMedicamento = idMedicamento;
  }
  
  //Como vamos implementar esse mÃ©todo 
  public enum getTarja(){
    return this.tarja;
  }
  public void setTarja(enum tarja){
    this.tarja = tarja;
  }
  
  public String getNome(){
    return this.nome;
  }
  public void setNome(String nome){
    this.nome = nome;
  }
  
  public float getValor(){
    return valor;
  }
  public void setValor(float valor){
    this.valor = valor;
  }
  
  public boolean getRetemReceita(){
    return this.retemReceita;
  }
  
}

  public void setnome(String nome){
    this.nome = nome;
  }
  
  public float getvalor(){
    return valor;
  }
  public void setvalor(float valor){
    this.valor = valor;
  }
  
  public boolean getretemReceita(){
    return this.retemReceita;
  }
  
}
