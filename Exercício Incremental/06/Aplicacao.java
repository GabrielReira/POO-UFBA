import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aplicacao
{
    public static void main()
    {
        Scanner sc = new Scanner(System.in);
        menuPrincipal(sc);
    }
    
    public static void menuPrincipal (Scanner sc) {
        System.out.println("Seja bem-vindo ao nosso sistema!");
        int opc = -1;
        while (opc != 0) {
            System.out.println("Digite 0 para sair.");
            System.out.println("Digite 1 para cadastrar um imóvel.");
            System.out.println("Digite 2 para cadastrar um proprietário.");
            opc = sc.nextInt();

            switch(opc) {
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
      System.out.println("Informe o valor do IPTU:");
      double iptu = sc.nextDouble();
      sc.nextLine();
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
      System.out.println("Informe o tipo de imóvel:");
      String tipo = sc.nextLine();
      System.out.println("Informe a sua utilização:");
      String utilizacao = sc.nextLine();
      
      // Criar novo imóvel no sistema
      Imovel imovelCriado = new Imovel(iptu, rua, numero, cep, estado, cidade, tipo, utilizacao);
      System.out.println("Imóvel cadastrado com sucesso.");
      
      // Perguntar ao usuário se ele gostaria de atribuir o imóvel a um Proprietário
      System.out.println("Você gostaria de atribuir este imóvel a um proprietário? (S/N)");
      char atribuirProprietario = sc.next().charAt(0);
      if (Character.toUpperCase(atribuirProprietario) == 'S'){
          menuCadastroProprietario(sc, imovelCriado);
          System.out.println("Imóvel atribuído com sucesso ao proprietário.");
          
          // Perguntar ao usuário se ele gostaria de agendar o bloqueio desse imóvel
          System.out.println("Você gostaria de agendar o bloqueio deste imóvel? (S/N)");
          char agendarBloqueio = sc.next().charAt(0);
          if (Character.toUpperCase(agendarBloqueio) == 'S'){
              System.out.println("Por quantos dias você gostaria de agendar o bloqueio deste imóvel?");
              int numeroDias = sc.nextInt();
              menuBloqueioImovel(sc, imovelCriado, numeroDias);
          }
      }
  }

  public static void menuCadastroProprietario(Scanner sc) {
      sc.nextLine();
      System.out.println("Informe o nome do proprietário:");
      String nome = sc.nextLine();
      System.out.println("Informe o CPF:");
      String cpf = sc.nextLine();
      System.out.println("Informe a identidade:");
      String identidade = sc.nextLine();
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
      
      // Criar novo proprietário no sistema
      new Proprietario(nome, cpf, identidade, rua, numero, cep, estado, cidade);
      System.out.println("Proprietário cadastrado com sucesso.");
  }
  
  // Cadastro de proprietário com imóvel
  public static void menuCadastroProprietario(Scanner sc, Imovel imovel) {
      sc.nextLine();
      System.out.println("Informe o nome do proprietário:");
      String nome = sc.nextLine();
      System.out.println("Informe o CPF:");
      String cpf = sc.nextLine();
      System.out.println("Informe a identidade:");
      String identidade = sc.nextLine();
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
      
      // Criar novo proprietário no sistema
      Proprietario proprietarioCriado = new Proprietario(nome, cpf, identidade, rua, numero, cep, estado, cidade);
      proprietarioCriado.adicionaImovel(imovel);  // cadastrar imóvel ao proprietário
      System.out.println("Proprietário cadastrado com sucesso.");
  }

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
}