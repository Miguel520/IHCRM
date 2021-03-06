DROP DATABASE IF EXISTS mfMain;
CREATE DATABASE IF NOT EXISTS mfMain;
USE mfMain;

DROP TABLE IF EXISTS cliente, contactoCliente, compras, produto, vendedor, contactoVendedor, interacoes;

CREATE TABLE cliente (
    IDCliente INT(11)           NOT NULL AUTO_INCREMENT,
    DataNascimento DATE			NOT NULL,
    Sexo VARCHAR(1)				NOT NULL,
    NumeroContribuinte INT(9)   NOT NULL,
    PrNome VARCHAR(14)          NOT NULL, 
    UltNome VARCHAR(20)         NOT NULL,
    DataAdr DATE                NOT NULL, 
    NumCompras INT(11)          NOT NULL,
    DataUltimaCompra DATE       NOT NULL,
    PRIMARY KEY (IDCliente)
);

CREATE TABLE contactoCliente (
    IDCliente INT(11)           NOT NULL,
    Morada VARCHAR(50)          NOT NULL,
    Cidade VARCHAR(50)          NOT NULL,
    CodigoPostal VARCHAR(8)     NOT NULL,         
    Email VARCHAR(50)           NOT NULL,
    Telemovel INT(9)            NOT NULL,
    Telefone INT(9)             NOT NULL,
    FOREIGN KEY (IDCliente)  REFERENCES cliente (IDCliente)    ON DELETE CASCADE,
    PRIMARY KEY (IDCliente)
);

CREATE TABLE produto (
    IDProduto INT(11)           NOT NULL AUTO_INCREMENT,
    NomeProduto VARCHAR(20)     NOT NULL,
    Quantidade INT(7)           NOT NULL, 
    Cor VARCHAR(20)             NOT NULL, 
    Preco FLOAT(7,2)            NOT NULL,
    Descricao VARCHAR(100)      NOT NULL,
    PRIMARY KEY (IDProduto)
);

CREATE TABLE vendedor (
    IDVendedor INT(11)          NOT NULL AUTO_INCREMENT,
    Password VARCHAR(60)		NOT NULL,
    PrNome VARCHAR(14)          NOT NULL, 
    UltNome VARCHAR(20)         NOT NULL,
    DataCont DATE               NOT NULL, 
    Posicao VARCHAR(20)         NOT NULL, 
    NumVendas INT(5)            NOT NULL,
    PRIMARY KEY (IDVendedor)
);

CREATE TABLE contactoVendedor (
    IDVendedor INT(11)          NOT NULL, 
    Morada VARCHAR(100)         NOT NULL,
    Cidade VARCHAR(50)          NOT NULL,
    CodigoPostal VARCHAR(8)     NOT NULL,  
    Email VARCHAR(50)           NOT NULL, 
    Telemovel INT(9)            NOT NULL, 
    Telefone INT(9)             NOT NULL,
    FOREIGN KEY (IDVendedor) REFERENCES vendedor (IDVendedor) ON DELETE CASCADE,
    PRIMARY KEY (IDVendedor)
);

CREATE TABLE compras (
    IDCompra INT(11)            NOT NULL AUTO_INCREMENT,
    IDCliente INT(11)           NOT NULL, 
    IDProduto INT(11)           NOT NULL,
    IDVendedor INT(11)          NOT NULL,
    Quantidade INT(5)           NOT NULL,
    Preco FLOAT(10,2)           NOT NULL,
    DataCompra DATE             NOT NULL,
    FOREIGN KEY (IDCliente)  REFERENCES cliente (IDCliente),
    FOREIGN KEY (IDProduto) REFERENCES produto (IDProduto),
    FOREIGN KEY (IDVendedor) REFERENCES vendedor (IDVendedor),
    PRIMARY KEY (IDCompra,IDCliente,IDProduto,IDVendedor)
);

CREATE TABLE interacoes (
    IDInteracao INT(11)            NOT NULL AUTO_INCREMENT,
    IDCliente INT(11)           NOT NULL, 
    IDProduto INT(11)           NOT NULL,
    IDVendedor INT(11)          NOT NULL,
    Meio VARCHAR(50)           NOT NULL,
    Estado VARCHAR(50)           NOT NULL,
    DataInicio DATE             NOT NULL,
    DataFim DATE             NOT NULL,
    FOREIGN KEY (IDCliente)  REFERENCES cliente (IDCliente),
    FOREIGN KEY (IDProduto) REFERENCES produto (IDProduto),
    FOREIGN KEY (IDVendedor) REFERENCES vendedor (IDVendedor),
    PRIMARY KEY (IDInteracao,IDCliente,IDProduto,IDVendedor)
);