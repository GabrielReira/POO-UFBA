public class Imovel {
  private String iptu;
  private String tipo;
  private String utilizacao;
  private Endereco endereco;

  public Imovel(String iptu, String rua, int numero, String cep, String estado, String cidade, String tipo, String utilizacao) {
    this.iptu = iptu;
    this.tipo = tipo;
    this.utilizacao = utilizacao;
    this.endereco = new Endereco(rua, numero, cep, estado, cidade);
  }

  // Caso não seja informado estado e cidade
  public Imovel(String iptu, String rua, int numero, String cep, String tipo, String utilizacao) {
    this.iptu = iptu;
    this.tipo = tipo;
    this.utilizacao = utilizacao;
    this.endereco = new Endereco(rua, numero, cep);
  }

  // GETs
  public String getIptu() {
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

  // SETs
  public void setIptu(String novoIptu) {
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
}
