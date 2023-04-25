public class Proprietario {
  private String nome;
  private String cpf;
  private String identidade;
  private String rua;
  private int numero;
  private String cep;
  private String estado;
  private String cidade;

  public Proprietario(String nome, String cpf, String identidade, String rua, int numero, String cep, String estado, String cidade) {
    this.nome = nome;
    this.cpf = cpf;
    this.identidade = identidade;
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.estado = estado;
    this.cidade = cidade;
  }

  // GETs
  public String getNome() {
    return this.nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getIdentidade() {
    return this.identidade;
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

  // SETs
  public void setNome(String novoNome) {
    this.nome = novoNome;
  }

  public void setCpf(String novoCpf) {
    this.cpf = novoCpf;
  }

  public void setIdentidade(String novaIdentidade) {
    this.identidade = novaIdentidade;
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
}
