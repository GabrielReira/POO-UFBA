import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Aplicacao implements IAplicacao {
  public static void main() {
    Scanner sc = new Scanner(System.in);
    menuPrincipal(sc);
  }

  public static void menuPrincipal(Scanner sc) {
    System.out.println("Seja bem-vindo ao nosso sistema!");
    int opc = -1;
    while (opc != 0) {
      System.out.println("Digite 0 para sair.");
      System.out.println("Digite 1 para cadastrar um imóvel.");
      System.out.println("Digite 2 para cadastrar um proprietário.");
      opc = sc.nextInt();

      switch (opc) {
        case 0:
          System.out.println("Até mais.");
          break;
        case 1:
          menuCadastroImovel(sc);
          break;
        case 2:
          menuCadastroProprietario(sc);
          break;
        default:
          System.out.println("Opção inválida.");
      }
    }
  }

  public static void menuCadastroImovel(Scanner sc) {
    System.out.println("\t--------------  CADASTRO DE IMÓVEL --------------");
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
    Imovel imovelCriado = (Character.toUpperCase(tipoImovel) == 'A')
        ? menuCadastroUnidadeAutonoma(sc, iptu, tipo, utilizacao, enderecoImovel)
        : menuCadastroUnidadeCompartilhada(sc, iptu, tipo, utilizacao, enderecoImovel);

    // Perguntar ao usuário se ele gostaria de atribuir o imóvel a um Proprietário
    System.out.println("Você gostaria de atribuir este imóvel a um proprietário? (S/N)");
    char atribuirProprietario = sc.next().charAt(0);
    if (Character.toUpperCase(atribuirProprietario) == 'S') {
      menuCadastroProprietario(sc, imovelCriado);
      System.out.println("Imóvel atribuído com sucesso ao proprietário.");

      // Perguntar ao usuário se ele gostaria de agendar o bloqueio desse imóvel
      System.out.println("Você gostaria de agendar o bloqueio deste imóvel? (S/N)");
      char agendarBloqueio = sc.next().charAt(0);
      if (Character.toUpperCase(agendarBloqueio) == 'S') {
        System.out.println("Por quantos dias você gostaria de agendar o bloqueio deste imóvel?");
        int numeroDias = sc.nextInt();
        menuBloqueioImovel(sc, imovelCriado, numeroDias);
      }
    }

    // Perguntar ao usuário se ele gostaria de visualizar o valor de referência para
    // o imóvel
    System.out.println("Você gostaria de visualizar o valor de referência para o imóvel? (S/N)");
    char visualizarValorReferencia = sc.next().charAt(0);
    if (Character.toUpperCase(visualizarValorReferencia) == 'S')
      valorReferenciaAluguel(sc, imovelCriado);
  }

  public static UnidadeAutonoma menuCadastroUnidadeAutonoma(
      Scanner sc, double iptu, String tipo,
      String utilizacao, Endereco endereco) {
    sc.nextLine();
    System.out.println("Informe a área útil do imóvel:");
    double areaUtil = sc.nextDouble();
    System.out.println("Informe a área construída do imóvel:");
    double areaConstruida = sc.nextDouble();
    UnidadeAutonoma imovel = new UnidadeAutonoma(iptu, tipo, utilizacao, endereco, areaUtil, areaConstruida);
    System.out.println("Unidade autônoma cadastrada com sucesso.\n");
    return imovel;
  }

  public static UnidadeCompartilhada menuCadastroUnidadeCompartilhada(
      Scanner sc, double iptu, String tipo,
      String utilizacao, Endereco endereco) {
    System.out.println("Para realizar o cadastro de uma unidade compartilhada é necessário o condomínio.");
    Condominio condominio = menuCadastroCondominio(sc);
    System.out.println("Informe uma identificação para a unidade compartilhada:");
    String identificacao = sc.nextLine();
    UnidadeCompartilhada imovel = new UnidadeCompartilhada(iptu, tipo, utilizacao, endereco, identificacao, condominio);
    System.out.println("Unidade compartilhada cadastrada com sucesso.\n");
    return imovel;
  }

  public static Condominio menuCadastroCondominio(Scanner sc) {
    System.out.println("\t--------------  CADASTRO DE CONDOMÍNIO --------------");
    sc.nextLine();
    Endereco enderecoCondominio = menuCadastroEndereco(sc);
    Condominio condominio = new Condominio(enderecoCondominio);
    System.out.println("Condomínio cadastrado com sucesso.\n");
    return condominio;
  }

  public static void menuCadastroProprietario(Scanner sc) {
    System.out.println("\t--------------  CADASTRO DE PROPRIETÁRIO --------------");
    sc.nextLine();
    System.out.println("Informe o nome do proprietário:");
    String nome = sc.nextLine();
    System.out.println("Informe o CPF:");
    String cpf = sc.nextLine();
    System.out.println("Informe a identidade:");
    String identidade = sc.nextLine();
    Endereco enderecoProprietario = menuCadastroEndereco(sc);

    // Criar novo proprietário no sistema
    new Proprietario(nome, cpf, identidade, enderecoProprietario);
    System.out.println("Proprietário cadastrado com sucesso.\n");
  }

  // Cadastro de proprietário com imóvel
  public static void menuCadastroProprietario(Scanner sc, Imovel imovel) {
    System.out.println("\t--------------  CADASTRO DE PROPRIETÁRIO --------------");
    sc.nextLine();
    System.out.println("Informe o nome do proprietário:");
    String nome = sc.nextLine();
    System.out.println("Informe o CPF:");
    String cpf = sc.nextLine();
    System.out.println("Informe a identidade:");
    String identidade = sc.nextLine();
    Endereco enderecoProprietario = menuCadastroEndereco(sc);

    // Criar novo proprietário no sistema
    Proprietario proprietarioCriado = new Proprietario(nome, cpf, identidade, enderecoProprietario);
    proprietarioCriado.adicionaImovel(imovel); // cadastrar imóvel ao proprietário
    System.out.println("Proprietário com imóvel cadastrado com sucesso.\n");
  }

  // Cadastro de endereço
  public static Endereco menuCadastroEndereco(Scanner sc) {
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

  // Método para agendar o bloqueio de um determinado imóvel
  public static void menuBloqueioImovel(Scanner sc, Imovel imovel, int qtdDiasBloqueado) {
    for (int i = 1; i <= qtdDiasBloqueado; i++) {
      System.out.println("Informe a data do " + i + "º dia de bloqueio (dd/mm/yy):");
      String dataUsuario = sc.next();
      // Converter a String informada pelo usuário para LocalDate
      DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
      LocalDate data = LocalDate.parse(dataUsuario, dateFormat);
      imovel.adicionaDataBloqueado(data);
    }
    System.out.println("Imóvel bloqueado com sucesso para as datas informadas.");
  }

  // Método para retornar para o usuário o valor de referência de aluguel do imóvel
  public static double valorReferenciaAluguel(Scanner sc, Imovel imovel) {
    System.out.println("Qual índice de sazonalidade você gostaria de aplicar?");
    System.out.println(
        " 1 - Réveillon \n 2 - Carnaval \n 3 - Feriado alta estação \n 4 - Feriado baixa estação \n 0 - Comum (sem índice)"
    );
    int indice = sc.nextInt();
    int indiceSazonalidade = retornaIndiceSazonalidade(indice);
    double valorReferencia = imovel.valorReferenciaAluguel();
    
    System.out.print("O valor de referência para o aluguel deste imóvel é R$");

    // Se o imóvel for uma unidade compartilhada sem itens de lazer, reduzir 10% no
    // valor de referência
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
  
  public static int retornaIndiceSazonalidade(int indice) {
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
  public  double consultarPrecoAluguel(Imovel imovel, String data) {
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
