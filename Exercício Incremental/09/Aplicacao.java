import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Aplicacao implements IAplicacao {
  // Variáveis para armazenar a lista de imóveis e proprietários criados
  private ArrayList<Imovel> db_imoveis;
  private ArrayList<Proprietario> db_proprietarios;
  
  public static void main() {
    Aplicacao app = new Aplicacao();
    app.db_proprietarios = new ArrayList<Proprietario>();
    app.db_imoveis = new ArrayList<Imovel>();
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Seja bem-vindo ao nosso sistema!");
    int opc = -1;
    while (opc != 0) {
      System.out.println("Digite 0 para sair.");
      System.out.println("Digite 1 para cadastrar um imóvel.");
      System.out.println("Digite 2 para cadastrar um proprietário.");
      System.out.println("Digite 3 para visualizar o valor de referência do aluguel de um imóvel.");
      System.out.println("Digite 4 para verificar a disponibilidade de um imóvel.");
      System.out.println("Digite 5 para verificar o preço do aluguel de um imóvel.");
      opc = sc.nextInt();

      switch (opc) {
        case 0:
          System.out.println("Até mais.");
          break;
        case 1:
          app.menuCadastroImovel(sc);
          break;
        case 2:
          app.menuCadastroProprietario(sc);
          break;
        case 3:
          app.menuValorReferenciaAluguel(sc);
          break;
        case 4:
          app.menuDisponibilidadeImovel(sc);
          break;
        case 5:
          app.menuPrecoAluguel(sc);
          break;
        default:
          System.out.println("Opção inválida.\n");
      }
    }
  }

  public void menuCadastroImovel(Scanner sc) {
    System.out.println("\t-------------- CADASTRO DE IMÓVEL --------------");
    System.out.println("Informe o valor do IPTU:");
    double iptu = sc.nextDouble();
    sc.nextLine();
    System.out.println("Informe o tipo de imóvel:");
    String tipo = sc.nextLine();
    System.out.println("Informe a sua utilização:");
    String utilizacao = sc.nextLine();
    Endereco enderecoImovel = menuCadastroEndereco(sc);

    // Perguntar ao usuário o tipo do imóvel
    System.out.println("O imóvel é uma unidade autônoma ou compartilhada? (A/C)");
    char tipoImovel = sc.next().charAt(0);
    Imovel imovelCriado = (Character.toUpperCase(tipoImovel) == 'A') ?
      menuCadastroUnidadeAutonoma(sc, iptu, tipo, utilizacao, enderecoImovel) :
      menuCadastroUnidadeCompartilhada(sc, iptu, tipo, utilizacao, enderecoImovel);

    // Perguntar ao usuário se ele gostaria de atribuir o imóvel a um Proprietário
    System.out.println("Você gostaria de atribuir este imóvel a um proprietário? (S/N)");
    char atribuirProprietario = sc.next().charAt(0);
    if (Character.toUpperCase(atribuirProprietario) == 'S')
      menuCadastroProprietario(sc, imovelCriado);

    // Perguntar ao usuário se ele gostaria de agendar o bloqueio desse imóvel
    System.out.println("Você gostaria de agendar o bloqueio deste imóvel? (S/N)");
    char agendarBloqueio = sc.next().charAt(0);
    if (Character.toUpperCase(agendarBloqueio) == 'S') {
      System.out.println("Por quantos dias você gostaria de agendar o bloqueio deste imóvel?");
      int numeroDias = sc.nextInt();
      menuBloqueioImovel(sc, imovelCriado, numeroDias);
    }

    // Perguntar ao usuário se ele gostaria de visualizar o valor de referência para o imóvel
    System.out.println("Você gostaria de visualizar o valor de referência para o imóvel? (S/N)");
    char visualizarValorReferencia = sc.next().charAt(0);
    if (Character.toUpperCase(visualizarValorReferencia) == 'S')
      valorReferenciaAluguel(sc, imovelCriado);
  }

  public UnidadeAutonoma menuCadastroUnidadeAutonoma(
    Scanner sc, double iptu, String tipo,
    String utilizacao, Endereco endereco
  ) {
    sc.nextLine();
    System.out.println("Informe a área útil do imóvel:");
    double areaUtil = sc.nextDouble();
    System.out.println("Informe a área construída do imóvel:");
    double areaConstruida = sc.nextDouble();
    UnidadeAutonoma novoImovel = new UnidadeAutonoma(iptu, tipo, utilizacao, endereco, areaUtil, areaConstruida);
    this.db_imoveis.add(novoImovel);
    System.out.println("Unidade autônoma cadastrada com sucesso.\n");
    return novoImovel;
  }

  public UnidadeCompartilhada menuCadastroUnidadeCompartilhada(
    Scanner sc, double iptu, String tipo,
    String utilizacao, Endereco endereco
  ) {
    System.out.println("Para realizar o cadastro de uma unidade compartilhada é necessário o condomínio.");
    Condominio condominio = menuCadastroCondominio(sc);
    System.out.println("Informe uma identificação para a unidade compartilhada:");
    String identificacao = sc.nextLine();
    UnidadeCompartilhada novoImovel = new UnidadeCompartilhada(iptu, tipo, utilizacao, endereco, identificacao, condominio);
    this.db_imoveis.add(novoImovel);
    System.out.println("Unidade compartilhada cadastrada com sucesso.\n");
    return novoImovel;
  }

  public Condominio menuCadastroCondominio(Scanner sc) {
    System.out.println("\t-------------- CADASTRO DE CONDOMÍNIO --------------");
    sc.nextLine();
    Endereco enderecoCondominio = menuCadastroEndereco(sc);
    Condominio novoCondominio = new Condominio(enderecoCondominio);

    System.out.println("Quantos itens de lazer o condomínio possui?");
    int qtdItensLazer = sc.nextInt();
    if (qtdItensLazer > 0) {
      sc.nextLine();
      for (int i = 0; i < qtdItensLazer; i++){
        System.out.println("Informe o " + (i+1) + "º item: ");
        String item = sc.nextLine();
        novoCondominio.adicionaItemLazer(item);
      }
    }
    System.out.println("Condomínio cadastrado com sucesso.\n");
    return novoCondominio;
  }

  public void menuCadastroProprietario(Scanner sc) {
    System.out.println("\t-------------- CADASTRO DE PROPRIETÁRIO --------------");
    sc.nextLine();
    System.out.println("Informe o nome do proprietário:");
    String nome = sc.nextLine();
    System.out.println("Informe o CPF:");
    String cpf = sc.nextLine();
    System.out.println("Informe a identidade:");
    String identidade = sc.nextLine();
    Endereco enderecoProprietario = menuCadastroEndereco(sc);
    try {
      for (Proprietario proprietario : db_proprietarios) {
        if ((proprietario.getCpf().equals(cpf)) || (proprietario.getIdentidade().equals(identidade))){
          throw new UsuarioExistenteException();
        }
      }
      // Criar novo proprietário no sistema
      Proprietario novoProprietario = new Proprietario(nome, cpf, identidade, enderecoProprietario);
      this.db_proprietarios.add(novoProprietario);
      System.out.println("Proprietário cadastrado com sucesso.\n");      
    }
    catch (UsuarioExistenteException ex) {
      System.out.println("ERRO: " + ex.getMessage() + "\n");
    }
  }

  // Cadastro de proprietário com imóvel
  public void menuCadastroProprietario(Scanner sc, Imovel imovel) {
    System.out.println("\t-------------- CADASTRO DE PROPRIETÁRIO --------------");
    sc.nextLine();
    System.out.println("Informe o nome do proprietário:");
    String nome = sc.nextLine();
    System.out.println("Informe o CPF:");
    String cpf = sc.nextLine();
    System.out.println("Informe a identidade:");
    String identidade = sc.nextLine();
    Endereco enderecoProprietario = menuCadastroEndereco(sc);
    try {
      for (Proprietario proprietario : db_proprietarios) {
        if ((proprietario.getCpf().equals(cpf)) || (proprietario.getIdentidade().equals(identidade))){
          throw new UsuarioExistenteException();
        }
      }
      // Criar novo proprietário no sistema
      Proprietario novoProprietario = new Proprietario(nome, cpf, identidade, enderecoProprietario);
      this.db_proprietarios.add(novoProprietario);
      novoProprietario.adicionaImovel(imovel);  // cadastrar imóvel ao proprietário
      System.out.println("Proprietário com imóvel cadastrado com sucesso.\n");
    }
    catch (UsuarioExistenteException ex) {
      System.out.println("ERRO: " + ex.getMessage() + "\n");
    }
  }

  // Cadastro de endereço
  public Endereco menuCadastroEndereco(Scanner sc) {
    System.out.println("Informe o nome da rua:");
    String rua = sc.nextLine();
    System.out.println("Informe o número da casa/prédio:");
    int numero = sc.nextInt();
    sc.nextLine();
    System.out.println("Informe o CEP:");
    String cep = sc.nextLine();
    System.out.println("Informe o nome do estado (sigla):");
    String estado = sc.nextLine();
    System.out.println("Informe a cidade:");
    String cidade = sc.nextLine();
    Endereco endereco = new Endereco(rua, numero, cep, estado, cidade);

    return endereco;
  }
  
  // Visualizar valor de referência do aluguel
  public void menuValorReferenciaAluguel(Scanner sc) {
    System.out.println("\t-------------- VALOR DE REFERÊNCIA DO ALUGUEL --------------");
    sc.nextLine();
    if (db_imoveis.size() == 0) {
      System.out.print("Ainda não existem imóveis cadastrados na aplicação.");
      System.out.println("Cadastre ao menos um antes de acessar essa funcionalidade.");
    }
    else {
      Imovel imovelSelecionado = selecionarImovel(sc);
      valorReferenciaAluguel(sc, imovelSelecionado);
    }
    System.out.println("Consulta finalizada com sucesso.\n");
  }
  
  // Visualizar a disponibilidade para alocação de imóvel
  public void menuDisponibilidadeImovel(Scanner sc) {
    System.out.println("\t-------------- DISPONIBILIDADE DE IMÓVEL --------------");
    
    if (db_imoveis.size() == 0) {
      System.out.print("Ainda não existem imóveis cadastrados na aplicação.");
      System.out.println("Cadastre ao menos um antes de acessar essa funcionalidade.");
    }
    else {
      Imovel imovelSelecionado = selecionarImovel(sc);
      sc.nextLine();
      System.out.println("Informe a data de início (dd/mm/yy):");
      String dataInicio = sc.nextLine();
      System.out.println("Informe a data de fim (dd/mm/yy):");
      String dataFim = sc.nextLine();
      boolean imovelEstaDisponivel = disponibilidadeImovel(imovelSelecionado, dataInicio, dataFim);    
    
      if (imovelEstaDisponivel)
        System.out.println("O imóvel está disponível na data especificada!");
      else
        System.out.println("O imóvel NÃO está disponível na data especificada...");
    }
    System.out.println("Consulta finalizada com sucesso.\n");
  }
  
  // Visualizar o preço do aluguel de um imóvel dado um dia ou período
  public void menuPrecoAluguel(Scanner sc) {
    System.out.println("\t-------------- PREÇO DO ALUGUEL DE IMÓVEL --------------");
    sc.nextLine();
    if (db_imoveis.size() == 0) {
      System.out.print("Ainda não existem imóveis cadastrados na aplicação.");
      System.out.println("Cadastre ao menos um antes de acessar essa funcionalidade.");
    }
    else {
      Imovel imovelSelecionado = selecionarImovel(sc);    
      double precoAluguel = 0;
      System.out.println("Você gostaria de visualizar o aluguel para um dia ou período? (D/P)");
      char visualizarAluguel = sc.next().charAt(0);
      
      if (Character.toUpperCase(visualizarAluguel) == 'D') {
        System.out.println("Informe a data (dd/mm/yy):");
        String data = sc.nextLine();
        precoAluguel = consultarPrecoAluguel(imovelSelecionado, data);
      }
      else if (Character.toUpperCase(visualizarAluguel) == 'P') {
        sc.nextLine();
        System.out.println("Informe a data de início (dd/mm/yy):");
        String dataInicio = sc.nextLine();
        System.out.println("Informe a data de fim (dd/mm/yy):");
        String dataFim = sc.nextLine();
        precoAluguel = consultarPrecoAluguel(imovelSelecionado, dataInicio, dataFim);
      }
      System.out.println("O preço TOTAL do aluguel para o dia/período especificado é R$" + precoAluguel);
    }
    System.out.println("Consulta finalizada com sucesso.\n");
  }
  
  // Método para exibir ao usuário lista de imóveis cadastrados e selecionar um deles
  public Imovel selecionarImovel (Scanner sc) {    
    for (int i = 0; i < db_imoveis.size(); i++) {
      System.out.print((i+1) + "º imóvel:\n");
      System.out.println(db_imoveis.get(i) + "\n");
    }
    System.out.print("Qual dos imóveis você gostaria de selecionar? ");
    System.out.println("Digite o índice correspondente ao imóvel.");
    int indiceImovel = sc.nextInt();
    
    return db_imoveis.get(indiceImovel - 1);
  }

  // Método para agendar o bloqueio de um determinado imóvel
  public void menuBloqueioImovel(Scanner sc, Imovel imovel, int qtdDiasBloqueado) {
    for (int i = 1; i <= qtdDiasBloqueado; i++) {
      System.out.println("Informe a data do " + i + "º dia de bloqueio (dd/mm/yy):");
      String dataUsuario = sc.next();
      // Converter a String informada pelo usuário para LocalDate
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
      LocalDate data = LocalDate.parse(dataUsuario, dateFormat);
      imovel.adicionaDataBloqueado(data);
    }
    System.out.println("Imóvel bloqueado com sucesso para a(s) data(s) informada(s).");
  }

  // Método para retornar para o usuário o valor de referência de aluguel do imóvel
  public double valorReferenciaAluguel(Scanner sc, Imovel imovel) {
    System.out.println("Qual índice de sazonalidade você gostaria de aplicar?");
    System.out.println(
      " 1 - Réveillon \n 2 - Carnaval \n 3 - Feriado alta estação \n 4 - Feriado baixa estação \n 0 - Comum (sem índice)"
    );
    int indice = sc.nextInt();
    int indiceSazonalidade = retornaIndiceSazonalidade(indice);
    double valorReferencia = imovel.valorReferenciaAluguel();
    
    System.out.print("O valor de referência para o aluguel deste imóvel é R$");

    // Se o imóvel for uma unidade compartilhada sem itens de lazer, 
    // reduzir 10% no valor de referência
    if ((imovel instanceof UnidadeCompartilhada)) {
      UnidadeCompartilhada uc = (UnidadeCompartilhada) imovel;
      if (uc.getQtdItensLazer() == 0)
        valorReferencia = valorReferencia * 0.9;
    }
    // Exibir para o usuário o valor de referência do aluguel
    double valorReferenciaAluguel = valorReferencia + valorReferencia * indiceSazonalidade;
    System.out.println(valorReferenciaAluguel);
    System.out.println();
    return valorReferenciaAluguel;
  }
  
  public int retornaIndiceSazonalidade(int indice) {
    int indiceSazonalidade = 1;  // comum (sem índice)
    switch (indice) {
      case 0:
        break;
      case 1:
        indiceSazonalidade = 20;
        break;
      case 2:
        indiceSazonalidade = 15;
        break;
      case 3:
        indiceSazonalidade = 10;
        break;
      case 4:
        indiceSazonalidade = 5;
        break;
      default:
        throw new IllegalArgumentException("O índice informado é inválido.");
    }    
    return indiceSazonalidade;
  }

  // Método para consultar a disponibilidade para alocação de um imóvel
  @Override
  public boolean disponibilidadeImovel(Imovel imovel, String dataInicio, String dataFim) {
    // Converter a String informada pelo usuário para LocalDate
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
    LocalDate inicio = LocalDate.parse(dataInicio, dateFormat);
    LocalDate fim = LocalDate.parse(dataFim, dateFormat);
    
    // Verificar se em algum dia no intervalo de datas informado o imóvel está alugado ou bloqueado
    long qtdDiasIntervalo = ChronoUnit.DAYS.between(inicio, fim);
    for (int i = 0; i<= qtdDiasIntervalo; i++) {
      if (
        imovel.getDatasAlugado().contains(inicio.plusDays(i)) ||
        imovel.getDatasBloqueado().contains(inicio.plusDays(i))
      )
        return false;
    }
    return true;
  }

  // Método para consultar o preço do aluguel dado uma data
  @Override
  public double consultarPrecoAluguel(Imovel imovel, String data) {
    Scanner sc = new Scanner(System.in);
    double precoAluguel = valorReferenciaAluguel(sc, imovel);
    return precoAluguel;
  }

  // Método para consultar o preço do aluguel dado um intervalo de dias
  @Override
  public double consultarPrecoAluguel(Imovel imovel, String dataInicio, String dataFim) {
    Scanner sc = new Scanner(System.in);
    // Converter a String informada pelo usuário para LocalDate
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
    LocalDate inicio = LocalDate.parse(dataInicio, dateFormat);
    LocalDate fim = LocalDate.parse(dataFim, dateFormat);
    // Verificar a quantidade total de dias
    long qtdDias = ChronoUnit.DAYS.between(inicio, fim);
    
    double precoTotalAluguel = 0;
    for (int i = 0; i <= qtdDias; i++) {
      System.out.println("Para o " + (i+1) + "º dia:");
      double precoDiaAluguel = valorReferenciaAluguel(sc, imovel);
      precoTotalAluguel += precoDiaAluguel;
    }
    
    return precoTotalAluguel;
  }
}
