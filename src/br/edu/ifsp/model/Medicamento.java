package br.edu.ifsp.model;

public class Medicamento implements IModel{
  int idMedicamento;
  enum tarja;
  String nome;
  float valor;
  boolean retemReceita;
  
  public int getidMedicamento(){
    return this.idMedicamento;
  }
  public void setidMedicamento(int idMedicamento){
    this.idMedicamento = idMedicamento;
  }
  
  //Como vamos implementar esse método 
  public enum gettarja(){
    return this.tarja;
  }
  public void settarja(enum tarja){
    this.tarja = tarja;
  }
  
  public String getnome(){
    return this.nome;
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
