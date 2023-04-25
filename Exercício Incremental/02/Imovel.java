public class Imovel {
  private String iptu;
  private String rua;
  private int numero;
  private String cep;
  private String estado;
  private String cidade;
  private String tipo;
  private String utilizacao;

  public Imovel(String iptu, String rua, int numero, String cep, String estado, String cidade, String tipo, String utilizacao) {
    this.iptu = iptu;
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.estado = estado;
    this.cidade = cidade;
    this.tipo = tipo;
    this.utilizacao = utilizacao;
  }

  public Imovel(String iptu, String rua, int numero, String cep, String tipo, String utilizacao) {
    this.iptu = iptu;
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.estado = "Bahia";
    this.cidade = "Salvador";
    this.tipo = tipo;
    this.utilizacao = utilizacao;
  }

  // GETs
  public String getIptu() {
    return this.iptu;
  }

  public String getRua() {
    return this.rua;
  }

  public int getNumero() {
    return this.numero;
  }

  public String getCep() {
    return this.cep;
  }

  public String getEstado() {
    return this.estado;
  }

  public String getCidade() {
    return this.cidade;
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
    this.rua = novaRua;
  }

  public void setNumero(int novoNumero) {
    this.numero = novoNumero;
  }

  public void setCep(String novoCep) {
    this.cep = novoCep;
  }

  public void setEstado(String novoEstado) {
    this.estado = novoEstado;
  }

  public void setCidade(String novaCidade) {
    this.cidade = novaCidade;
  }

  public void setTipo(String novoTipo) {
    this.tipo = novoTipo;
  }

  public void setUtilizacao(String novaUtilizacao) {
    this.utilizacao = novaUtilizacao;
  }
}
