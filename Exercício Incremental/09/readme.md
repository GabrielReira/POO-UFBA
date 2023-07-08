# Exercício Incremental 9

Neste incremental precisamos tratar eventuais erros que podem acontecer na aplicação.

Caso o o usuário tente cadastrar um proprietário já existente, o sistema deve lançar uma exceção **UsuarioExistenteException**, que deve ser tratada no *loop* principal da aplicação.
