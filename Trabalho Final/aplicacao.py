from imovel import Imovel
from proprietario import Proprietario
from endereco import Endereco
from datetime import datetime

class Aplicacao:
  db_imoveis, db_proprietarios = [], []

  @staticmethod
  def main():
    Aplicacao.menu_principal()

  @staticmethod
  def menu_principal():
    print("Seja bem-vindo ao nosso sistema!")
    opc = -1
    while opc != 0:
      print("\nDigite 0 para sair.")
      print("Digite 1 para cadastrar um imóvel.")
      print("Digite 2 para cadastrar um proprietário.")
      print("Digite 3 para agendar o bloqueio de um imóvel.")
      print("Digite 4 para listar todos os imóveis e proprietários cadastrados.")
      opc = int(input())

      if opc == 0:
        print("Até mais.")
      elif opc == 1:
        Aplicacao.menu_cadastro_imovel()
      elif opc == 2:
        Aplicacao.menu_cadastro_proprietario()
      elif opc == 3:
        Aplicacao.menu_bloqueio_imovel()
      elif opc == 4:
        Aplicacao.menu_lista_imoveis_proprietarios()
      else:
        print("Opção inválida.")

  @staticmethod
  def menu_cadastro_imovel():
    iptu = float(input("Informe o valor do IPTU: "))
    tipo = input("Informe o tipo de imóvel: ")
    utilizacao = input("Informe a sua utilização: ")
    endereco = Aplicacao.cadastro_endereco()

    # Criar novo imóvel no sistema
    imovel_criado = Imovel(iptu, tipo, utilizacao, endereco)
    Aplicacao.db_imoveis.append(imovel_criado)
    print("Imóvel cadastrado com sucesso.")

    # Perguntar ao usuário se ele gostaria de atribuir o imóvel a um proprietário
    print("Você gostaria de atribuir este imóvel a um proprietário? (S/N)")
    atribuir_proprietario = input().upper()
    if atribuir_proprietario == 'S':
      Aplicacao.menu_cadastro_proprietario(imovel_criado)
      print("Imóvel atribuído com sucesso ao proprietário.")

  @staticmethod
  def menu_cadastro_proprietario(imovel=None):
    nome = input("Informe o nome do proprietário: ")
    cpf = input("Informe o CPF: ")
    identidade = input("Informe a identidade: ")
    endereco = Aplicacao.cadastro_endereco()

    # Criar novo proprietário no sistema
    proprietario_criado = Proprietario(nome, cpf, identidade, endereco)
    Aplicacao.db_proprietarios.append(proprietario_criado)
    # Caso seja um proprietário com imóvel
    if (imovel != None):
      proprietario_criado.adiciona_imovel(imovel)

    print("Proprietário cadastrado com sucesso.")
  
  @staticmethod
  def menu_bloqueio_imovel():
    if (len(Aplicacao.db_proprietarios) == 0):
      print("Cadastre ao menos um imóvel com proprietário antes de acessar esta funcionalidade.")
    else:
      # Usuário precisa escolher um dos proprietários
      Aplicacao.menu_lista_imoveis_proprietarios(listar_apenas_proprietarios=True)
      indice_propprietario = int(input("Informe o índice do proprietário que você deseja: "))
      proprietario = Aplicacao.db_proprietarios[indice_propprietario-1]

      # Listar os imóveis daquele proprietário
      if (len(proprietario.imoveis_disponiveis) == 0):
        print("O proprietário escolhido não possui imóveis disponíveis.")
      else:
        for i, imovel in enumerate(proprietario.imoveis_disponiveis):
          print(f"\t{i+1}º imóvel:")
          print(imovel)
        indice_imovel = int(input("Informe o índice do imóvel que você deseja: "))
        imovel = Aplicacao.db_imoveis[indice_imovel-1]

        print("Por quantos dias você gostaria de agendar o bloqueio deste imóvel?")
        qtd_dias = int(input())
        for i in range(1, qtd_dias + 1):
          print(f"Informe a data do {i}º dia de bloqueio (dd/mm/yy):")
          data_usuario = input()
          # Converter a String informada pelo usuário para date
          data = datetime.strptime(data_usuario, "%d/%m/%y").date()
          imovel.adiciona_data_bloqueado(data)
        print("Imóvel bloqueado com sucesso para a(s) data(s) informada(s).")

  @staticmethod
  def menu_lista_imoveis_proprietarios(listar_apenas_imoveis=False, listar_apenas_proprietarios=False):
    if (len(Aplicacao.db_imoveis) + len(Aplicacao.db_proprietarios) == 0):
      print("Não há imóveis nem proprietários cadastrados no sistema.")
    else:
      if ((len(Aplicacao.db_imoveis) > 0) and not (listar_apenas_proprietarios)):
        print("---------- IMÓVEIS CADASTRADOS ----------")
        for i, imovel in enumerate(Aplicacao.db_imoveis):
          print(f"\t{i+1}º imóvel:")
          print(imovel)
      if (len(Aplicacao.db_proprietarios) > 0 and not (listar_apenas_imoveis)):      
        print("---------- PROPRIETÁRIOS CADASTRADOS ----------")
        for p, proprietario in enumerate(Aplicacao.db_proprietarios):
          print(f"\t{p+1}º proprietário:")
          print(proprietario)
  
  @staticmethod 
  def cadastro_endereco():
    rua = input("Informe o nome da rua: ")
    numero = int(input("Informe o número da casa/prédio: "))
    cep = input("Informe o CEP: ")
    estado = input("Informe o estado (sigla): ")
    cidade = input("Informe a cidade: ")
    return Endereco(rua, numero, cep, estado, cidade)
