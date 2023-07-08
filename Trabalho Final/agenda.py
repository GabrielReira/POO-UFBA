class Agenda:
  def __init__(self):
    self.datas_alugado = []
    self.datas_bloqueado = []

  # GETs
  def get_datas_alugado(self):
    return self.datas_alugado

  def get_datas_bloqueado(self):
    return self.datas_bloqueado

  # SETs
  def adiciona_data_alugado(self, data):
    self.datas_alugado.append(data)

  def remove_data_alugado(self, data):
    if data in self.datas_alugado:
      self.datas_alugado.remove(data)

  def adiciona_data_bloqueado(self, data):
    self.datas_bloqueado.append(data)

  def remove_data_bloqueado(self, data):
    if data in self.datas_bloqueado:
      self.datas_bloqueado.remove(data)
