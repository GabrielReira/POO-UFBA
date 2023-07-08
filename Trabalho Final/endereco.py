class Endereco:
  # Siglas dos estados permitidos
  estados_permitidos = [
    "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", 
    "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", 
    "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
  ]

  def __init__(self, rua, numero, cep, estado="BA", cidade="Salvador"):
    if estado.upper() not in self.estados_permitidos:
      raise ValueError("A sigla do estado informado é inválida.")
    self.rua = rua
    self.numero = numero
    self.cep = cep
    self.estado = estado.upper()
    self.cidade = cidade

  def __str__(self):
    return (
      f"Rua/Avenida: {self.rua}, Número: {self.numero}\n" +
      f"CEP: {self.cep}, Estado: {self.estado}, Cidade: {self.cidade}"
    )
  
  # GETs
  def get_rua(self):
    return self.rua

  def get_numero(self):
    return self.numero

  def get_cep(self):
    return self.cep

  def get_estado(self):
    return self.estado

  def get_cidade(self):
    return self.cidade

  # SETs
  def set_rua(self, nova_rua):
    self.rua = nova_rua

  def set_numero(self, novo_numero):
    self.numero = novo_numero

  def set_cep(self, novo_cep):
    self.cep = novo_cep

  def set_estado(self, novo_estado):
    if novo_estado.upper() not in self.estados_permitidos:
      raise ValueError("A sigla do estado informado é inválida.")
    self.estado = novo_estado.upper()

  def set_cidade(self, nova_cidade):
    self.cidade = nova_cidade
