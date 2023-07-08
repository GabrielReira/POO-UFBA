from agenda import Agenda

class Imovel:
  def __init__(self, iptu, tipo, utilizacao, endereco):
    self.iptu = iptu
    self.tipo = tipo
    self.utilizacao = utilizacao
    self.endereco = endereco
    self.agenda = Agenda()

  def __str__(self):
    return (
      f"IPTU: {self.iptu}\n" +
      f"Tipo: {self.tipo}, Utilização: {self.utilizacao}\n"+
      f"Endereço:\n{self.endereco}"
    )

  # GETs
  def get_iptu(self):
    return self.iptu
  
  def get_tipo(self):
    return self.tipo

  def get_utilizacao(self):
    return self.utilizacao

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

  def get_datas_alugado(self):
    return self.agenda.get_datas_alugado()

  def get_datas_bloqueado(self):
    return self.agenda.get_datas_bloqueado()

  # SETs
  def set_iptu(self, novo_iptu):
    self.iptu = novo_iptu

  def set_tipo(self, novo_tipo):
    self.tipo = novo_tipo

  def set_utilizacao(self, nova_utilizacao):
    self.utilizacao = nova_utilizacao

  def set_rua(self, nova_rua):
    self.endereco.set_rua(nova_rua)

  def set_numero(self, novo_numero):
    self.endereco.set_numero(novo_numero)

  def set_cep(self, novo_cep):
    self.endereco.set_cep(novo_cep)

  def set_estado(self, novo_estado):
    self.set_estado(novo_estado)

  def set_cidade(self, nova_cidade):
    self.set_cidade(nova_cidade)

  def adiciona_data_alugado(self, data):
    self.agenda.adiciona_data_alugado(data)

  def remove_data_alugado(self, data):
    self.agenda.remove_data_alugado(data)

  def adiciona_data_bloqueado(self, data):
    self.agenda.adiciona_data_bloqueado(data)

  def remove_data_bloqueado(self, data):
    self.agenda.remove_data_bloqueado(data)
