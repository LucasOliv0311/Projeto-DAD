DROP TABLE IF EXISTS Pedido, Produto, Cartao, Cliente CASCADE;

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
    tipo VARCHAR(10) CHECK (tipo IN ('Crédito', 'Débito')) NOT NULL,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente) ON DELETE CASCADE
);

CREATE TABLE Produto (
    id_produto SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL CHECK (preco >= 0),
    estoque INT NOT NULL CHECK (estoque >= 0)
);

CREATE TABLE Pedido (
    id_pedido SERIAL PRIMARY KEY,
    id_cliente INT NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_produto INT,
    valor_total DECIMAL(10,2) NOT NULL CHECK (valor_total >= 0),
    id_cartao INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente) ON DELETE CASCADE,
    FOREIGN KEY (id_cartao) REFERENCES Cartao(id_cartao) ON DELETE SET NULL
);

-- Inserção de dados para teste
INSERT INTO Cliente (nome, cpf, telefone, email, endereco) VALUES
('João Silva', '12345678901', '11999999999', 'joao@email.com', 'Rua A, 123'),
('Maria Souza', '98765432100', '21988888888', 'maria@email.com', 'Rua B, 456');

INSERT INTO Cartao (numero_cartao, validade, cvv, bandeira, tipo, id_cliente) VALUES
('1234567812345678', '2026-12-01', '123', 'Visa', 'Crédito', 1),
('8765432187654321', '2025-06-01', '456', 'Mastercard', 'Débito', 2);

INSERT INTO Produto (nome, descricao, preco, estoque) VALUES
('Notebook', 'Notebook potente com 16GB RAM', 4500.00, 10),
('Mouse', 'Mouse óptico sem fio', 150.00, 50);

INSERT INTO Pedido (id_cliente, valor_total, id_cartao) VALUES
(1, 4650.00, 1),
(2, 150.00, 2);

ALTER TABLE produto 
ADD COLUMN tipo varchar(100) NOT NULL DEFAULT 'valor_default';

UPDATE produto SET tipo = 'valor_default' WHERE tipo IS NULL;

ALTER TABLE produto ALTER COLUMN tipo SET NOT NULL;


