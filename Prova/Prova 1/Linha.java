import java.util.ArrayList;

public class Linha {
  private int codigo;
  private String cidadePartida;
  private String cidadeDestino;
  private String horarioSaida;
  private int distancia;
  private ArrayList<Onibus> onibus;

  // QUESTÃO 1 - A
  public Linha(int codigo, String cidadePartida, String cidadeDestino, String horarioSaida, int distancia) {
    this.codigo = codigo;
    this.cidadePartida = cidadePartida;
    this.cidadeDestino = cidadeDestino;
    this.horarioSaida = horarioSaida;
    this.distancia = distancia;
    this.onibus = new ArrayList<Onibus>();
  }

  public Linha(int codigo, String cidadePartida, String cidadeDestino) {
    this.codigo = codigo;
    this.cidadePartida = cidadePartida;
    this.cidadeDestino = cidadeDestino;
    this.onibus = new ArrayList<Onibus>();
  }

  // QUESTÃO 2 - A
  public boolean adicionaOnibus(Onibus novoOnibus) {
    // Verificar se o ônibus já faz parte da linha
    for (Onibus o : onibus) {
      if (novoOnibus.getPlaca().equals(o.getPlaca())) {
        return false;
      }
    }
    this.onibus.add(novoOnibus);
    return true;
  }

  // QUESTÃO 2 - B
  public boolean removeOnibus(Onibus referenciaOnibus) {
    // Verificar se a lista contém o ônibus informado
    if (!(onibus.contains(referenciaOnibus))) {
      return false;
    }
    this.onibus.remove(referenciaOnibus);
    return true;
  }

  public boolean removeOnibus(String placa) {
    for (Onibus o : onibus) {
      if (o.getPlaca().equals(placa)) {
        this.onibus.remove(o);
        return true;
      }
    }
    return false;
  }

  // QUESTÃO 3 - A
  public void imprimeDadosLinha() {
    int qtdOnibus = onibus.size();
    System.out.println(
      "Código da prefeitura: " + getCodigo() + ", Cidade de partida: " + getCidadePartida() +
      ", Cidade de destino: " + getCidadeDestino() + ", Horário de saída: " + getHorarioSaida() +
      ", Distância: " + getDistancia() + ", Quantidade de ônibus: " + qtdOnibus
      );
  }

  // QUESTÃO 3 - B
  // Caso não receba parâmetro
  public void imprimeDadosOnibus() {
    for (Onibus o : onibus) {
      System.out.println(
        "Placa: " + o.getPlaca() + ", Capacidade: " + o.getCapacidade() +
        ", Data da última revisão: " + o.getDataRevisao() + ", Nome do motorista: " + o.getNomeMotorista() +
        ", Horário de saída: " + o.getHorarioSaida() + ", Status: " + o.getStatus()
      );
    }
  }

  // Caso receba parâmetro
  public void imprimeDadosOnibus(boolean parametro) {
    // Se o parâmetro for true
    if (parametro) {
      for (Onibus o : onibus) {
        if (o.getStatus().equals("ativo")) {
          System.out.println(
            "Placa: " + o.getPlaca() + ", Capacidade: " + o.getCapacidade() +
            ", Data da última revisão: " + o.getDataRevisao() + ", Nome do motorista: " + o.getNomeMotorista() +
            ", Horário de saída: " + o.getHorarioSaida() + ", Status: " + o.getStatus()
          );
        }
      }
    }
    // Se o parâmetro for false
    else {
      for (Onibus o : onibus) {
        if (o.getStatus().equals("inativo")) {
          System.out.println(
            "Placa: " + o.getPlaca() + ", Capacidade: " + o.getCapacidade() +
            ", Data da última revisão: " + o.getDataRevisao() + ", Nome do motorista: " + o.getNomeMotorista() +
            ", Horário de saída: " + o.getHorarioSaida() + ", Status: " + o.getStatus()
          );
        }
      }
    }
  }

  // GETs
  public int getCodigo() {
    return this.codigo;
  }

  public String getCidadePartida() {
    return this.cidadePartida;
  }

  public String getCidadeDestino() {
    return this.cidadeDestino;
  }

  public String getHorarioSaida() {
    return this.horarioSaida;
  }

  public int getDistancia() {
    return this.distancia;
  }

  // SETs
  public void setCodigo(int novoCodigo) {
    this.codigo = novoCodigo;
  }

  public void setCidadePartida(String novaCidadePartida) {
    this.cidadePartida = novaCidadePartida;
  }

  public void setCidadeDestino(String novaCidadeDestino) {
    this.cidadeDestino = novaCidadeDestino;
  }

  public void setHorarioSaida(String novoHorarioSaida) {
    this.horarioSaida = novoHorarioSaida;
  }

  public void setDistancia(int novaDistancia) {
    this.distancia = novaDistancia;
  }
}
