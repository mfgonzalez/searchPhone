INSERT INTO cliente (id, nome, cpf) VALUES (1, 'Iago', '86730543540');
INSERT INTO cliente (id, nome, cpf) VALUES (2, 'Pedro', '55565893569');
INSERT INTO cliente (id, nome, cpf) VALUES (3, 'Cauê', '38767897100');
INSERT INTO cliente (id, nome, cpf) VALUES (4, 'Breno', '78673781620');
INSERT INTO cliente (id, nome, cpf) VALUES (5, 'Thiago', '72788740417');

INSERT INTO telefone (id, ddd, numero, id_cliente) VALUES (1, '41', '999570146', 1);
INSERT INTO telefone (id, ddd, numero, id_cliente) VALUES (2, '82', '39945903', 2);
INSERT INTO telefone (id, ddd, numero, id_cliente) VALUES (3, '86', '35006330', 3);
INSERT INTO telefone (id, ddd, numero, id_cliente) VALUES (4, '21', '997538804', 4);
INSERT INTO telefone (id, ddd, numero, id_cliente) VALUES (5, '95', '38416516', 5);

INSERT INTO endereco (id, logradouro, numero, complemento, bairro, cidade, estado, id_cliente) VALUES (1, 'Rua Orfanotrófio', 555, 'XXXX', 'Santa Tereza', 'Porto Alegre', 'RS', 1);
INSERT INTO endereco (id, logradouro, numero, complemento, bairro, cidade, estado, id_cliente) VALUES (2, 'Rua Orfanotrófio', 555, 'XXXX', 'Santa Tereza', 'Porto Alegre', 'RS', 2);
INSERT INTO endereco (id, logradouro, numero, complemento, bairro, cidade, estado, id_cliente) VALUES (3, 'Rua Orfanotrófio', 555, 'XXXX', 'Santa Tereza', 'Porto Alegre', 'RS', 3);
INSERT INTO endereco (id, logradouro, numero, complemento, bairro, cidade, estado, id_cliente) VALUES (4, 'Rua Orfanotrófio', 555, 'XXXX', 'Santa Tereza', 'Porto Alegre', 'RS', 4);
INSERT INTO endereco (id, logradouro, numero, complemento, bairro, cidade, estado, id_cliente) VALUES (5, 'Rua Orfanotrófio', 555, 'XXXX', 'Santa Tereza', 'Porto Alegre', 'RS', 5);