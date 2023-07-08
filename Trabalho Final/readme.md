# Trabalho Final

Implementação em **Python** seguindo os conceitos aprendidos em Java sobre POO (Programação Orientada a Objetos).

1. Implemente as classes *Imóvel* e *Proprietário* com métodos construtores e acessores.
    1. Um Imóvel tem um número de IPTU, rua, número, cep, estado, cidade, tipo (casa, apto) e a utilização (campo, praia);
    1. Um proprietário tem nome, cpf , identidade, rua, número, cep, estado, cidade;
    1. No momento da instanciação de um imóvel, quando estado e cidade não forem informados, devemos considerar "Bahia" e "Salvador". Implemente uma solução para isso;
    1. Nesta aplicação é comum realizar atualizações de endereço. Crie um (ou mais) método(s) para atualizar endereço (por exemplo: *atualiza_endereco*) para a classe Proprietário. O método pode receber como parâmetros os novos valores para rua, número, cep, estado e cidade ou pode receber apenas rua, número e cep. Caso cidade e estado não sejam informados, o estado e a cidade não devem ser alterados. Esse(s) método(s) não deve(m) retornar nada.

2. Devido a um novo requisito, o sistema deve ser refatorado de forma que não seja possível que Proprietários tentem disponibilizar para locação um Imóvel com o mesmo *Endereço* no qual residem. 
    1. Para isso, refatore as classes Proprietário e Imóvel de forma que ao invés de possuírem atributos para rua, número, cidade, estado e cep, possuam Endereços;
    1. Endereços irão possuir os atributos: rua, número, cidade, estado e cep. Cada Proprietario terá um Endereço (que representa o endereço de residência daquele Proprietario) e cada Imóvel terá um Endereço;
    1. Proprietários podem ter um ou mais Imóveis disponíveis para locação. Refatore o sistema para representar essa relação e implemente uma nova funcionalidade que permita que, dado um tipo de Imóvel (casa, apto, ...), liste na tela os Imóveis de um Proprietario com o tipo determinado;
    1. Imóveis podem ser cadastrados independentemente de Proprietários.

3. No sistema de locação de imóveis, os proprietários podem disponibilizar imóveis para locação, alugar imóveis de outros proprietários e também bloquear seus imóveis. 
    1. Para que o sistema seja capaz de realizar essas funcionalidades é necessário implementar a classe *Agenda*, que irá controlar os dias que o imóvel está disponível, alugado ou bloqueado;
    1. Cada Imóvel deve possuir uma Agenda.

4. O sistema de imóveis já está quase pronto, mas agora é necessário permitir que os usuários possam cadastrar imóveis/proprietários e também agendar o bloqueio de imóveis dado um proprietário.
    1. Para cadastrar um imóvel, o sistema deve perguntar ao usuário o valor do iptu, o nome da rua, o número da casa/prédio, o cep, o nome do estado, o nome da cidade, o tipo de imóvel, e sua utilização;
    1. Para cadastrar um proprietário, o sistema deve perguntar ao usuário o nome do proprietário, seu CPF, sua identidade, e seu endereço de residência (com o número da casa/prédio, CEP, o nome do estado e o nome da cidade);
    1. Implemente uma *Aplicação* que leia dados da entrada padrão e permita realizar estas novas funcionalidades.
