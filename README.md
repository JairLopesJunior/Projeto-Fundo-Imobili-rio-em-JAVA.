# Projeto-Fundo-Imobili-rio-em-JAVA.
Projeto: “Fundo Imobiliário”
Um Fundo de Investimento Imobiliário ( também conhecido pela sigla FII) , nada
mais é que um grupo de pessoas que têm um objetivo em comum: investir em
ativos imobiliários. O dinheiro que todos investiram no fundo, em forma de cotas, é administrado por um
gestor, que é o responsável por encontrar e realizar os investimentos mais interessantes e garantir uma boa
rentabilidade para o fundo.
Um dos objetivos de um fundo imobiliário é encontrar pessoas ou empresas interessadas em utilizar os
imóveis adquiridos. Em troca, o fundo recebe uma renda mensal de aluguel para ser distribuída a seus
cotistas.
Para começar a investir em Fundos Imobiliários, primeiro é necessário abrir uma conta em uma corretora.
Para abrir a conta em uma corretora de valores é preciso realizar um cadastro com informações pessoais,
dados bancários e apresentar documentos como CPF e RG.
Feito o cadastro, para realizar qualquer operação no mercado, quem investe precisa antes enviar seu dinheiro
para a conta na corretora. Esta etapa é feito normalmente via TED bancário ou DOC.
Com o dinheiro na corretora, o investidor pode enviar uma ordem de compra para a cota do fundo a sua
escolha. Cada fundo é conhecido por um código e um valor da cota. Para isso, é preciso digitar o código do
fundo, a quantidade de cotas e o valor que você deseja pagar. A oferta segue para o mercado e se houver um
participante do fundo disposto a vender suas cotas por aquele valor, o negócio é fechado. Para fim de
simulação, será adotado como valor de compra a cotação atual.
Ao comprar um fundo imobiliário, esta cota passa a compor a carteira de investimento. Uma carteira de
investimentos é um grupo de ativos que pertence a um investidor, pessoa física ou pessoa jurídica.
Existem duas formas de se fazer dinheiro com cotas de FIIs: Com a valorização das cotas ou com os
dividendos. Dividendos são uma parcela do lucro apurado por uma sociedade anônima. No caso das FIIs,
vem dos alugueis dos imóveis pertencentes ao fundo.
O objetivo deste projeto é desenvolver um simulador de uma corretora especializada apenas em FIIs. Este
simulador deve gerir a carteira de investimento de apenas um investidor.
Abrindo uma conta em uma corretora
1) Permitir inserir o nome, CPF e dados bancários e saldo atual ( em reais) do investidor.
2) Permitir editar o nome, CPF e dados bancários do aplicador. Crie classes que achar pertinentes.
3) Validar ao menos um campo com uso de expressão regular.
Realizar aporte
O investidor não pode em nenhum momento ter um saldo negativo.
4) Simular um TED para a corretora, em que o valor enviado deva atualizar o saldo atual ( em reais).
5) Simular o resgate do saldo atual.
Cotações do dia, comprar e vender FIIs
6) Ler de um arquivo TXT as cotações do dia. Cada fundo será representado por um código e um valor de
cota. Outras informações não serão pertinentes aqui.
7) Ao enviar uma ordem de compra, o valor monetário deve ser debitado do saldo atual e um novo ativo deve
ser adicionado a carteira do investidor. O investidor pode adquirir quantos fundos desejar, tendo como único
limitador o saldo atual.
8) Ao enviar uma ordem de venda, o valor monetário será creditado no saldo atual e o ativo deve ser desfeito
da carteira do investidor.
Vamos fazer dinheiro.
9) Ler de um arquivo TXT as cotações do dia. Caso o valor da cota tenha sofrido alterações ( aumento ou
diminuição), o valor da carteira do investidor deve ser atualizada.
Exemplo, se o investidor possuia R$100,00, realizou a ordem de compra de cinco cotas de um fundo cotado
a R$20,00 e o fundo sofreu uma valorização, sendo cotado a R$21,00, o saldo atual do cliente será de
R$105,00.
10) Ler de um arquivo TXT os dividendos do mês. Baseado nos ativos que compõem a carteira do
investidor, os ganhos com dividendos devem ser incorporados ao saldo atual do investidor.
