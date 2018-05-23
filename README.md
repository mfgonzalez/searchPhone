# searchPhone 
[![Build Status](https://travis-ci.org/mfgonzalez/searchPhone.svg?branch=master)](https://travis-ci.org/mfgonzalez/searchPhone)

SearchPhone é um sistema de cadastro de clientes baseados no seu telefone de contato com o objetivo de agilizar o processo de recebimento e entrega de pedidos de delivery.

**US #01 - Cadastrar cliente**
-
Como usuário, quero cadastrar o cliente no sistema, de forma  a manter o registro dos meus clientes para futuras compras.
1. Não deve permitir cadastrar cliente sem nome e cpf;
2. Não deve permitir cadastrar cliente com um telefone já cadastrado;   
3. Não deve permitir cadastrar cliente com um CPF já cadastrado;

**US #02 - Buscar cliente cadastrado**
-
Como usuário, quero buscar por clientes já cadastrados, de forma que eu não precise requisitar seus dados novamente.
1. Quando buscar cliente por um telefone válido deve retornar dados do cliente;
2. Quando buscar cliente por um cpf válido deve retornar dados do cliente;
3. Quando buscar cliente por um telefone inválido ou inexistente deve retornar um erro;
4. Quando buscar cliente por um cpf inválido ou inexistente deve retornar um erro;

**US #03 - Registrar pedido para o cliente**
-
Como usuário, quero registrar um pedido para um cliente, de forma a agilizar o processo de compra (preparo e envio) e manter um histórico de consumo dos clientes.
1. Se pedido não conter descrição deve retornar um erro;
2. Se pedido não conter valor deve retornar um erro;
3. Não deve permitir cadastrar pedidos se valor for menor que R$5,00;
4. Não deve permitir pagamento no crédito se valor for menor que R$15,00;

**US #04 - Ver histórico de pedidos do cliente**
-
Como usuário, quero poder ver o histórico de pedidos do cliente, de forma que possam ser geradas ações para potencializar o seu consumo.
1. Se cliente possuir pedidos deve retornar lista com todos os pedidos realizados;
2. Deve apresentar o total de pedidos do cliente;
3. Deve apresentar o valor total de gastos do cliente;
4. Pedidos devem ser apresentados do mais recente para o mais antigo;

**US #05 - Cadastrar mais de um telefone para o mesmo cliente**
-
Como usuário, quero poder registrar mais de um número para o cliente, de forma que não seja preciso realizar um novo cadastro caso o cliente tenha trocado de número ou algum familiar deseje realizar um pedido.
1. Não deve permitir cadastrar um telefone que já esteja cadastrado no próprio cliente;
2. Não deve permitir cadastrar um telefone que já esteja cadastrado em outro cliente;
3. Não deve permitir cadastrar mais do que 3 telefones por cliente;