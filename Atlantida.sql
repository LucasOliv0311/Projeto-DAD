DROP TABLE IF EXISTS pedido_carrinho CASCADE;
DROP TABLE IF EXISTS Pedido CASCADE;
DROP TABLE IF EXISTS Produto CASCADE;
DROP TABLE IF EXISTS Cartao CASCADE;
DROP TABLE IF EXISTS Cliente CASCADE;
DROP TABLE IF EXISTS Carrinho CASCADE;

CREATE TABLE Cliente (
                         id_cliente SERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         cpf CHAR(11) UNIQUE NOT NULL,
                         telefone VARCHAR(20),
                         email VARCHAR(100) UNIQUE,
                         endereco TEXT
);

CREATE TABLE Cartao (
                        id_cartao SERIAL PRIMARY KEY,
                        numero_cartao CHAR(16) UNIQUE NOT NULL,
                        validade DATE NOT NULL,
                        cvv CHAR(3) NOT NULL,
                        bandeira VARCHAR(50) NOT NULL,
                        tipo VARCHAR(10),
                        id_cliente INT NOT NULL,
                        FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente)
);

CREATE TABLE Produto (
                         id_produto SERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         descricao TEXT,
                         preco DECIMAL(10,2) NOT NULL CHECK (preco >= 0),
                         estoque INT NOT NULL CHECK (estoque >= 0),
                         tipo VARCHAR(100) NOT NULL DEFAULT 'valor_default'
);

CREATE TABLE Carrinho (
                          id_carrinho SERIAL PRIMARY KEY,
                          id_produto INT NOT NULL,
                          quantidade INT NOT NULL,
                          FOREIGN KEY (id_produto) REFERENCES Produto(id_produto)
);

CREATE TABLE Pedido (
                        id_pedido SERIAL PRIMARY KEY,
                        id_cliente INT NOT NULL,
                        data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        valor_total DECIMAL(10,2) NOT NULL CHECK (valor_total >= 0),
                        id_cartao INT NOT NULL,
                        FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
                        FOREIGN KEY (id_cartao) REFERENCES Cartao(id_cartao)
);

CREATE TABLE pedido_carrinho (
                                 id_pedido INT NOT NULL,
                                 id_carrinho INT NOT NULL,
                                 PRIMARY KEY (id_pedido, id_carrinho),
                                 FOREIGN KEY (id_pedido) REFERENCES Pedido(id_pedido) ON DELETE CASCADE,
                                 FOREIGN KEY (id_carrinho) REFERENCES Carrinho(id_carrinho) ON DELETE CASCADE
);

INSERT INTO Cliente (nome, cpf, telefone, email, endereco) VALUES
                                                               ('João Silva', '12345678901', '11999999999', 'joao@email.com', 'Rua A, 123'),
                                                               ('Maria Souza', '98765432100', '21988888888', 'maria@email.com', 'Rua B, 456');

INSERT INTO Cartao (numero_cartao, validade, cvv, bandeira, tipo, id_cliente) VALUES
                                                                                  ('1234567812345678', '2026-12-01', '123', 'Visa', 'Crédito', 1),
                                                                                  ('8765432187654321', '2025-06-01', '456', 'Mastercard', 'Débito', 2);

INSERT INTO Produto (nome, descricao, preco, estoque, tipo) VALUES
                                                                ('Tilápia', 'Filé de tilápia fresca', 25.90, 50, 'Peixe'),
                                                                ('Salmão', 'Salmão fresco importado', 89.90, 30, 'Peixe'),
                                                                ('Camarão Cinza', 'Camarão cinza descascado', 45.00, 40, 'Frutos do Mar'),
                                                                ('Lula', 'Anéis de lula congelados', 39.90, 25, 'Frutos do Mar'),
                                                                ('Bacalhau', 'Bacalhau dessalgado em postas', 120.00, 15, 'Peixe');

INSERT INTO Carrinho (id_produto, quantidade) VALUES
                                                  (1, 2),
                                                  (2, 1),
                                                  (3, 3),
                                                  (4, 1),
                                                  (5, 2);

INSERT INTO Pedido (id_cliente, valor_total, id_cartao) VALUES
                                                            (1, 187.80, 1),
                                                            (2, 349.80, 2);

INSERT INTO pedido_carrinho (id_pedido, id_carrinho) VALUES
                                                         (1, 1),
                                                         (1, 3),
                                                         (2, 2),
                                                         (2, 4),
                                                         (2, 5);

UPDATE Produto SET tipo = 'valor_default' WHERE tipo IS NULL;

select * from pedido_carrinho
