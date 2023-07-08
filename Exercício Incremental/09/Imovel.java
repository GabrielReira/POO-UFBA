import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Imovel {
  private double iptu;
  private String tipo;
  private String utilizacao;
  private Endereco endereco;
  private Agenda agenda;

  public Imovel(double iptu, String tipo, String utilizacao, Endereco endereco) {
    this.iptu = iptu;
    this.tipo = tipo;
    this.utilizacao = utilizacao;
    this.endereco = endereco;
    this.agenda = new Agenda();
  }
  
  // Método abstrato para o cálculo de valor de referência do aluguel
  public abstract double valorReferenciaAluguel();
  
  // Sobrescrevendo o método toString
  @Override
  public String toString() {
      return 
        "IPTU: " + this.getIptu() + "\n" +
        "Tipo: " + this.getTipo() + "\n" +
        "Utilização: " + this.getUtilizacao() + "\n" +
        "Endereço:" + "\n" + this.endereco.toString();
  }

  // GETs
  public double getIptu() {
    return this.iptu;
  }

  public String getRua() {
    return this.endereco.getRua();
  }

  public int getNumero() {
    return this.endereco.getNumero();
  }

  public String getCep() {
    return this.endereco.getCep();
  }

  public String getEstado() {
    return this.endereco.getEstado();
  }

  public String getCidade() {
    return this.endereco.getCidade();
  }

  public String getTipo() {
    return this.tipo;
  }

  public String getUtilizacao() {
    return this.utilizacao;
  }
  
  public ArrayList<LocalDate> getDatasAlugado() {
    return this.agenda.getDatasAlugado();
  }
  
  public ArrayList<LocalDate> getDatasBloqueado() {
    return this.agenda.getDatasBloqueado();
  }

  // SETs
  public void setIptu(double novoIptu) {
    this.iptu = novoIptu;
  }

  public void setRua(String novaRua) {
    this.endereco.setRua(novaRua);
  }

  public void setNumero(int novoNumero) {
    this.endereco.setNumero(novoNumero);
  }

  public void setCep(String novoCep) {
    this.endereco.setCep(novoCep);
  }

  public void setEstado(String novoEstado) {
    this.setEstado(novoEstado);
  }

  public void setCidade(String novaCidade) {
    this.setCidade(novaCidade);
  }

  public void setTipo(String novoTipo) {
    this.tipo = novoTipo;
  }

  public void setUtilizacao(String novaUtilizacao) {
    this.utilizacao = novaUtilizacao;
  }
  
  public void adicionaDataAlugado(LocalDate data) {
      this.agenda.adicionaDataAlugado(data);  
  }
  
  public void removeDataAlugado(LocalDate data) {
      this.agenda.removeDataAlugado(data);  
  }
  
  public void adicionaDataBloqueado(LocalDate data) {
      this.agenda.adicionaDataBloqueado(data);
  }
  
  public void removeDataBloqueado(LocalDate data) {
      this.agenda.removeDataBloqueado(data);  
  }
}
