# Exercício Incremental 7

Contexto para aplicar os conceitos de: **Classes Abstratas**, **Polimorfismo**, ***Cast*** e ***Instance Of***.

Um Imóvel pode ser uma **Unidade Autônoma** ou uma **Unidade Compartilhada** (situado em um condomínio). Uma unidade autônoma tem uma área útil e uma área construída. Uma unidade compartilhada tem uma identificação (exemplo: casa 10, unidade flores, etc) e  está associada a um condomínio. Um condomínio possui um endereço próprio e uma coleção de itens de lazer (piscina, academia, salão, etc). 

Um valor de referência para o aluguel é calculado para cada imóvel. Para unidades autônomas o cálculo é = (área construída)\*15. Para unidade compartilhadas é = (iptu\*qtd de itens de lazer). Caso não tenha itens de lazer, multiplicar por 0,1.

Um índice de sazonalidade é aplicado ao valor de referência ao longo do ano. O cálculo é feito através de um método que recebe um número inteiro com significado:
  - 1: Reveillon, índice 20;
  - 2: Carnaval, índice 15; 
  - 3: Feriado Alta Estação, índice 10; 
  - 4: Feriado Baixa Estação, índice 5;
  - 0: Comum (sem índice). 
O índice de sazonalidade é um percentual que deve ser aplicado ao valor de referência: *valor de referência + valor de referência * índice*.

Se o imóvel for uma unidade compartilhada SEM itens de lazer, deve-se aplicar uma redução de 10% no valor de referência. 

Implementar um método na aplicação para retornar para o usuário o valor de referência e o valor de referência com o índice de sazonalidade.
