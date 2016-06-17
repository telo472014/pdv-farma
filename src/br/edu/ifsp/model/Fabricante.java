package br.edu.ifsp.model;

public class Fabricante implements IModel{
  int idFabricante;
  String nome;
  String endereco;
  String CNPJ;
  
  public int getidFabricante(){
    return idFabricante;
  }
  
  public void setidFabricante(int idFabricante){
    this.idFabricante = idFabricante;
  }
  
  public String getnome(){
    return nome;
  }
  
  public void setnome(String nome){
    this.nome = nome;
  }
  
  public String getenderco(){
    return endereco;
  }
  
  public void setendereco(String endereco){
    this.endereco = endereco;
  }
  
    public String getCNPJ(){
    return CNPJ;
  }
  
  public void setCNPJ(String CNPJ){
    this.CNPJ = CNPJ;
  }
  
  
  
  
  
}
