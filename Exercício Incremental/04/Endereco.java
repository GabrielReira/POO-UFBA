import java.util.ArrayList;

public class Endereco {
  private String rua;
  private int numero;
  private String cep;
  private String estado;
  private String cidade;
  // Siglas de estados permitidos
  private ArrayList<String> estadosPermitidos = new ArrayList<String>() {{
    add("AC"); add("AL"); add("AP"); add("AM"); add("BA"); add("CE"); add("DF");
    add("ES"); add("GO"); add("MA"); add("MT"); add("MS"); add("MG"); add("PA");
    add("PB"); add("PR"); add("PE"); add("PI"); add("RJ"); add("RN"); add("RS");
    add("RO"); add("RR"); add("SC"); add("SP"); add("SE"); add("TO");
  }};

  public Endereco(String rua, int numero, String cep, String estado, String cidade) {
    // Validar estado
    if(!(estadosPermitidos.contains(estado.toUpperCase()))) {
      throw new IllegalArgumentException("A sigla do estado informado é inválida.");
    }
    this.estado = estado.toUpperCase();
    this.rua = rua;
    this.numero = numero;
    this.cep = cep;
    this.cidade = cidade;
  }

  // Caso não seja informado estado e cidade
  public Endereco(String rua, int numero, String cep) {
    this(rua, numero, cep, "BA", "Salvador");
  }

  // GETs
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
