public class Proprietario {
  private String nome;
  private String cpf;
  private String identidade;
  private Endereco endereco;

  public Proprietario(String nome, String cpf, String identidade, String rua, int numero, String cep, String estado, String cidade) {
    this.nome = nome;
    this.cpf = cpf;
    this.identidade = identidade;
    this.endereco = new Endereco(rua, numero, cep, estado, cidade);
  }

  // Caso não seja informado estado e cidade
  public Proprietario(String nome, String cpf, String identidade, String rua, int numero, String cep) {
    this.nome = nome;
    this.cpf = cpf;
    this.identidade = identidade;
    this.endereco = new Endereco(rua, numero, cep);
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

  // Atualizar endereço
  public void atualizaEndereco(String novaRua, int novoNumero, String novoCep, String novoEstado, String novaCidade) {
    this.setRua(novaRua);
    this.setNumero(novoNumero);
    this.setCep(novoCep);
    this.setEstado(novoEstado);
    this.setCidade(novaCidade);
  }

  public void atualizaEndereco(String novaRua, int novoNumero, String novoCep) {
    this.setRua(novaRua);
    this.setNumero(novoNumero);
    this.setCep(novoCep);
  }
}
