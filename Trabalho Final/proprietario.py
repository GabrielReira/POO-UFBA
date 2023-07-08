class Proprietario:
  def __init__(self, nome, cpf, identidade, endereco):
    self.nome = nome
    self.cpf = cpf
    self.identidade = identidade
    self.endereco = endereco
    self.imoveis_disponiveis = []

  def __str__(self):
    return (
      f"Nome: {self.nome}\n" +
      f"CPF: {self.cpf}, RG: {self.identidade}\n" +
      f"Endereço:\n{str(self.endereco)}"
    )

  # Atualizar endereço
  def atualiza_endereco(self, nova_rua, novo_numero, novo_cep, novo_estado=None, nova_cidade=None):
    self.endereco.rua = nova_rua
    self.endereco.numero = novo_numero
    self.endereco.cep = novo_cep
    if (novo_estado is not None):
      self.endereco.set_estado(novo_estado)
    if (nova_cidade is not None):
      self.endereco.set_cidade(nova_cidade)

  # Adicionar imóvel ao proprietário
  def adiciona_imovel(self, imovel):
    self.imoveis_disponiveis.append(imovel)

  # Listar imóveis do proprietário dado seu tipo
  def lista_imoveis_por_tipo(self, tipo):
    print(f"O proprietário possui os seguintes imóveis do tipo '{tipo}': \n")
    for imovel in self.imoveis_disponiveis:
      if (imovel.get_tipo() == tipo):
        print(imovel)
        print()

  # GETs
  def get_nome(self):
    return self.nome

  def get_cpf(self):
    return self.cpf

  def get_identidade(self):
    return self.identidade

  def get_rua(self):
    return self.endereco.get_rua()

  def get_numero(self):
    return self.endereco.get_numero()

  def get_cep(self):
    return self.endereco.get_cep()

  def get_estado(self):
    return self.endereco.get_estado()

  def get_cidade(self):
    return self.endereco.get_cidade()

  # SETs
  def set_nome(self, novo_nome):
    self.nome = novo_nome

  def set_cpf(self, novo_cpf):
    self.cpf = novo_cpf

  def set_identidade(self, nova_identidade):
    self.identidade = nova_identidade

  def set_rua(self, nova_rua):
    self.endereco.set_rua(nova_rua)

  def set_numero(self, novo_numero):
    self.endereco.set_numero(novo_numero)

  def set_cep(self, novo_cep):
    self.endereco.set_cep(novo_cep)

  def set_estado(self, novo_estado):
    self.endereco.set_estado(novo_estado)

  def set_cidade(self, nova_cidade):
    self.endereco.set_cidade(nova_cidade)
