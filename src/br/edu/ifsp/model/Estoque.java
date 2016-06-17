package br.edu.ifsp.model;

import java.util.*;

public class Estoque implements IModel{
  long idEstoque;
  int qtdeAtual;
  int qtdeMin;
  Date validade; //Utilizei esse tipo, mas se achar melhor podemos mudar para outro.
  
  public long getidEstoque(){
    return idEstoque;
  }
  
  public void setidEstoque(long idEstoque){
    this.idEstoque = idEstoque;
  }
  
  public int getqtdeAtual(){
    return qtdeAtual;
  }
  
  public void setqtdeAtual(int qtdeAtual){
    this.qtdeAtual = qtdeAtual;
  }
  
  public int getqtdeMin(){
    return qtdeMin;
  }
  
  public void setqtdeMin(int qtdeMin){
    this.qtdeMin = qtdeMin;
  }
  
  public Date getvalidade(){
    return validade;
  }
  
  public void setvalidade(Date validade){
    this.validade = validade;
  }
  
  
}
