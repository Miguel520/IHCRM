USE mfMain;

INSERT INTO cliente (IDCliente, NumeroContribuinte, PrNome, UltNome, DataAdr, NumCompras, DataUltimaCompra) 
VALUES ('1', '763546789', 'Miguel', 'Sousa', '2017-01-02', '2', '2017-12-26');

INSERT INTO contactoCliente (IDCliente, Morada, Cidade, CodigoPostal, Email, Telemovel, Telefone) 
VALUES ('1', 'Rua de Teste nº13', 'Lisboa', '1234-567', 'miguel.sousa@teste.com', '962435235', '213213213');

INSERT INTO produto (IDProduto, NomeProduto, Quantidade, Cor, Preco, Descricao) 
VALUES ('1', 'Produto 1', '13', 'Verde', '11.50', 'Produto de muito boa qualidade!');

INSERT INTO vendedor (IDVendedor, Password, PrNome, UltNome, DataCont, Posicao, NumVendas)
VALUES ('1', 'testeteste', 'João', 'Alves', '2017-02-15', 'Vendedor', '2');

INSERT INTO contactoVendedor (IDVendedor, Morada, Cidade, CodigoPostal, Email, Telemovel, Telefone)
VALUES ('1', 'Rua de Teste nº10', 'Lisboa', '1234-567', 'joao.alves@teste.com', '913564782', '213786435');

INSERT INTO compras (IDCompra, IDCliente, IDProduto, IDVendedor, Quantidade, Preco, DataCompra)
VALUES ('1', '1', '1', '1', '2', '23.00', '2017-12-26');