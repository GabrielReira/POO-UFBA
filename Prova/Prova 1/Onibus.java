public class Onibus {
  private String placa;
  private int capacidade;
  private String dataRevisao;
  private String nomeMotorista;
  private String horarioSaida;
  private String status;

  // QUESTÃO 1 - B
  public Onibus(String placa, int capacidade, String dataRevisao, String nomeMotorista, String horarioSaida, String status) {
    this.placa = placa;
    this.capacidade = capacidade;
    this.dataRevisao = dataRevisao;
    this.nomeMotorista = nomeMotorista;
    this.horarioSaida = horarioSaida;
    this.status = status;
  }

  public Onibus(String placa, int capacidade, String dataRevisao, String horarioSaida) {
    this.placa = placa;
    this.capacidade = capacidade;
    this.dataRevisao = dataRevisao;
    this.horarioSaida = horarioSaida;
    this.status = "inativo";
  }

  // GETs
  public String getPlaca() {
    return this.placa;
  }

  public int getCapacidade() {
    return this.capacidade;
  }

  public String getDataRevisao() {
    return this.dataRevisao;
  }

  public String getNomeMotorista() {
    return this.nomeMotorista;
  }

  public String getHorarioSaida() {
    return this.horarioSaida;
  }

  public String getStatus() {
    return this.status;
  }

  // SETs
  public void setPlaca(String novaPlaca) {
    this.placa = novaPlaca;
  }

  public void setCapacidade(int novaCapacidade) {
    this.capacidade = novaCapacidade;
  }

  public void setDataRevisao(String novaDataRevisao) {
    this.dataRevisao = novaDataRevisao;
  }

  public void setNomeMotorista(String novoNomeMotorista) {
    this.nomeMotorista = novoNomeMotorista;
  }

  public void setHorarioSaida(String novoHorarioSaida) {
    this.horarioSaida = novoHorarioSaida;
  }

  public void setStatus(String novoStatus) {
    this.status = novoStatus;
  }
}
