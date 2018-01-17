USE mfMain;

INSERT INTO cliente (IDCliente, DataNascimento, Sexo, NumeroContribuinte, PrNome, UltNome, DataAdr, NumCompras, DataUltimaCompra) 
VALUES ('1', '1997-05-02', 'M', '763546789', 'Miguel', 'Sousa', '2017-01-02', '2', '2017-12-26'), ('2', '1992-10-16', 'M', '763546789', 'Bruno', 'Sousa', '2017-01-02', '2', '2017-12-26'), ('3', '1997-05-02', 'M', '763546789', 'Francisco', 'Sousa', '2017-01-02', '2', '2017-12-26'), ('4', '1993-06-03', 'M', '763546789', 'Miguel', 'Nunes', '2017-01-02', '2', '2017-12-26'), ('5', '1995-09-23', 'M', '763546789', 'Nunes', 'Sousa', '2017-01-02', '2', '2017-12-26'), ('6', '1995-09-23', 'F', '763546789', 'Joana', 'Pires', '2017-01-02', '2', '2017-12-26');

INSERT INTO contactoCliente (IDCliente, Morada, Cidade, CodigoPostal, Email, Telemovel, Telefone) 
VALUES ('1', 'Rua de Teste nº13', 'Lisboa', '1234-567', 'miguel.sousa@teste.com', '962435235', '213213213'), ('2', 'Rua de Teste nº14', 'Lisboa', '1234-567', 'miguel.sousa@teste.com', '962435235', '213213213'), ('3', 'Rua de Teste nº15', 'Lisboa', '1234-567', 'miguel.n@teste.com', '963546378', '213213213'), ('4', 'Rua de Teste nº16', 'Lisboa', '1234-567', 'miguel.nunes@teste.com', '962435255', '213213213'), ('5', 'Rua de Teste nº17', 'Lisboa', '1234-567', 'nunes.sousa@teste.com', '962435235', '213213213'), ('6', 'Rua de Teste nº18', 'Lisboa', '1234-567', 'miguel.sousa@teste.com', '962435235', '213213213');

INSERT INTO produto (IDProduto, NomeProduto, Quantidade, Cor, Preco, Descricao) 
VALUES ('1', 'Produto 1', '13', 'Verde', '11.50', 'Produto de muito boa qualidade!');

INSERT INTO vendedor (IDVendedor, Password, PrNome, UltNome, DataCont, Posicao, NumVendas)
VALUES ('1', 'testeteste', 'João', 'Alves', '2017-02-15', 'Vendedor', '2');

INSERT INTO contactoVendedor (IDVendedor, Morada, Cidade, CodigoPostal, Email, Telemovel, Telefone)
VALUES ('1', 'Rua de Teste nº10', 'Lisboa', '1234-567', 'joao.alves@teste.com', '913564782', '213786435');

INSERT INTO compras (IDCompra, IDCliente, IDProduto, IDVendedor, Quantidade, Preco, DataCompra)
VALUES ('1', '1', '1', '1', '2', '23.00', '2017-12-26');

INSERT INTO interacoes (IDInteracao, IDCliente, IDProduto, IDVendedor, Estado, Meio, DataInicio, DataFim)
VALUES ('1', '1', '1', '1', 'concluido', 'email', '2017-12-26', '2018-01-10');
