DROP TABLE IF EXISTS Pedido CASCADE;
DROP TABLE IF EXISTS Carrinho CASCADE;
DROP TABLE IF EXISTS Produto CASCADE;
DROP TABLE IF EXISTS Cartao CASCADE;
DROP TABLE IF EXISTS Cliente CASCADE;

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
                        tipo VARCHAR(10) ,--CHECK (tipo IN ('Crédito', 'Débito')) NOT NULL
                        id_cliente INT NOT NULL,
                        FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente) ON DELETE CASCADE
);

CREATE TABLE Produto (
                         id_produto SERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         descricao TEXT,
                         preco DECIMAL(10,2) NOT NULL CHECK (preco >= 0),
                         estoque INT NOT NULL CHECK (estoque >= 0),
                         tipo VARCHAR(100) NOT NULL DEFAULT 'valor_default'
);

CREATE TABLE Pedido (
                        id_pedido SERIAL PRIMARY KEY,
                        id_cliente INT NOT NULL,
                        data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        id_produto JSON,
                        valor_total DECIMAL(10,2) NOT NULL CHECK (valor_total >= 0),
                        id_cartao INT NOT NULL,
                        FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente) ON DELETE CASCADE,
                        FOREIGN KEY (id_cartao) REFERENCES Cartao(id_cartao) ON DELETE SET NULL
);

CREATE TABLE Carrinho(
    id_carrinho SERIAL PRIMARY KEY,
    id_pedido INT NOT NULL,
    id_produto INT NOT NULL,
    quantidade_produtos INT NOT NULL
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
                                                                ('Bacalhau', 'Bacalhau dessalgado em postas', 120.00, 15, 'Peixe'),
                                                                ('Polvo', 'Tentáculos de polvo congelados', 98.00, 10, 'Frutos do Mar'),
                                                                ('Tainha', 'Tainha fresca inteira', 32.00, 20, 'Peixe'),
                                                                ('Pirarucu', 'Filé de pirarucu amazônico', 55.00, 18, 'Peixe'),
                                                                ('Atum', 'Posta de atum fresco', 75.00, 22, 'Peixe'),
                                                                ('Caranguejo', 'Caranguejo cozido e congelado', 49.90, 35, 'Frutos do Mar'),
                                                                ('Mexilhão', 'Mexilhão sem casca congelado', 29.90, 40, 'Frutos do Mar'),
                                                                ('Ostra', 'Ostras frescas em meia casca', 19.90, 50, 'Frutos do Mar'),
                                                                ('Lagosta', 'Cauda de lagosta congelada', 150.00, 10, 'Frutos do Mar'),
                                                                ('Pintado', 'Filé de pintado do Pantanal', 47.00, 25, 'Peixe'),
                                                                ('Cação', 'Posta de cação fresca', 35.00, 30, 'Peixe'),
                                                                ('Robalo', 'Filé de robalo premium', 65.00, 15, 'Peixe'),
                                                                ('Dourado', 'Filé de dourado selvagem', 58.00, 20, 'Peixe'),
                                                                ('Marisco', 'Mariscos frescos selecionados', 27.90, 45, 'Frutos do Mar'),
                                                                ('Enguia', 'Enguia fresca importada', 110.00, 12, 'Peixe'),
                                                                ('Siri', 'Siri inteiro congelado', 33.00, 40, 'Frutos do Mar'),
                                                                ('Anchova', 'Filé de anchova grelhada', 42.00, 25, 'Peixe'),
                                                                ('Curimatã', 'Peixe curimatã fresco', 22.00, 30, 'Peixe'),
                                                                ('Bagre', 'Filé de bagre desossado', 28.00, 40, 'Peixe'),
                                                                ('Truta', 'Truta salmonada fresca', 49.00, 20, 'Peixe'),
                                                                ('Peixe-Espada', 'Posta de peixe-espada', 85.00, 18, 'Peixe'),
                                                                ('Arraia', 'Filé de arraia congelado', 33.90, 22, 'Peixe'),
                                                                ('Tamboril', 'Filé de tamboril premium', 90.00, 15, 'Peixe'),
                                                                ('Peixe-Panga', 'Filé de peixe-panga', 20.00, 40, 'Peixe'),
                                                                ('Sardinha', 'Sardinha fresca inteira', 15.00, 50, 'Peixe'),
                                                                ('Sururu', 'Sururu fresco ao natural', 18.00, 30, 'Frutos do Mar'),
                                                                ('Cavaquinha', 'Mini lagosta cavaquinha', 95.00, 12, 'Frutos do Mar'),
                                                                ('Lambari', 'Pequeno peixe lambari', 12.00, 60, 'Peixe'),
                                                                ('Aratu', 'Caranguejo aratu cozido', 40.00, 25, 'Frutos do Mar'),
                                                                ('Tubarão', 'Posta de tubarão', 125.00, 8, 'Peixe'),
                                                                ('Peixe-Gato', 'Filé de peixe-gato', 27.00, 35, 'Peixe'),
                                                                ('Tilápia Vermelha', 'Tilápia vermelha premium', 30.00, 28, 'Peixe'),
                                                                ('Pescada', 'Filé de pescada branca', 35.00, 22, 'Peixe'),
                                                                ('Peixe-Borboleta', 'Peixe-borboleta inteiro', 55.00, 18, 'Peixe'),
                                                                ('Merluza', 'Filé de merluza', 24.00, 40, 'Peixe'),
                                                                ('Raia', 'Filé de raia fresca', 38.00, 25, 'Peixe'),
                                                                ('Cação-Lixa', 'Posta de cação-lixa', 48.00, 20, 'Peixe'),
                                                                ('Peixe-Porquinho', 'Peixe-porquinho inteiro', 29.00, 30, 'Peixe'),
                                                                ('Baiacu', 'Filé de baiacu', 50.00, 12, 'Peixe'),
                                                                ('Matrinxã', 'Filé de matrinxã', 44.00, 20, 'Peixe'),
                                                                ('Pacu', 'Pacu inteiro fresco', 39.00, 28, 'Peixe'),
                                                                ('Tilápia Defumada', 'Tilápia defumada artesanal', 55.00, 15, 'Peixe'),
                                                                ('Salmão Defumado', 'Salmão defumado premium', 130.00, 10, 'Peixe'),
                                                                ('Peixe-Peixe', 'Peixe raro do oceano', 99.00, 8, 'Peixe'),
                                                                ('Caramujo do Mar', 'Caramujo marinho fresco', 21.00, 30, 'Frutos do Mar'),
                                                                ('Ovas de Peixe', 'Ovas selecionadas de peixe', 120.00, 5, 'Frutos do Mar'),
                                                                ('Tilápia Orgânica', 'Tilápia cultivada sem antibióticos', 32.00, 25, 'Peixe'),
                                                                ('Truta Defumada', 'Truta defumada artesanal', 75.00, 12, 'Peixe'),
                                                                ('Filhote', 'Filé de filhote do Amazonas', 60.00, 18, 'Peixe'),
                                                                ('Pirarucu Defumado', 'Pirarucu defumado artesanal', 85.00, 15, 'Peixe'),
                                                                ('Enguia Defumada', 'Enguia defumada premium', 150.00, 8, 'Peixe'),
                                                                ('Camarão Rosa', 'Camarão rosa fresco', 95.00, 20, 'Frutos do Mar'),
                                                                ('Camarão GG', 'Camarão gigante descascado', 120.00, 15, 'Frutos do Mar'),
                                                                ('Lagosta Selvagem', 'Lagosta selvagem fresca', 200.00, 5, 'Frutos do Mar'),
                                                                ('Marisco Fresco', 'Marisco fresco da costa brasileira', 32.00, 30, 'Frutos do Mar'),
                                                                ('Bacalhau Norueguês', 'Bacalhau norueguês de alta qualidade', 250.00, 10, 'Peixe');


INSERT INTO Pedido (id_cliente, valor_total, id_cartao) VALUES
                                                            (1, 89.90, 1),
                                                            (2, 150.00, 2),
                                                            (1, 45.00, 1),
                                                            (2, 32.00, 2),
                                                            (1, 75.00, 1),
                                                            (2, 49.90, 2),
                                                            (1, 120.00, 1),
                                                            (2, 98.00, 2),
                                                            (1, 55.00, 1),
                                                            (2, 65.00, 2),
                                                            (1, 33.00, 1),
                                                            (2, 39.90, 2),
                                                            (1, 150.00, 1),
                                                            (2, 19.90, 2),
                                                            (1, 130.00, 1),
                                                            (2, 27.90, 2),
                                                            (1, 47.00, 1),
                                                            (2, 28.00, 2),
                                                            (1, 42.00, 1),
                                                            (2, 22.00, 2),
                                                            (1, 55.00, 1),
                                                            (2, 33.90, 2),
                                                            (1, 24.00, 1),
                                                            (2, 75.00, 2),
                                                            (1, 60.00, 1),
                                                            (2, 85.00, 2),
                                                            (1, 32.00, 1),
                                                            (2, 40.00, 2),
                                                            (1, 110.00, 1),
                                                            (2, 48.00, 2),
                                                            (1, 27.00, 1),
                                                            (2, 125.00, 2),
                                                            (1, 39.00, 1),
                                                            (2, 50.00, 2),
                                                            (1, 120.00, 1),
                                                            (2, 150.00, 2),
                                                            (1, 200.00, 1),
                                                            (2, 95.00, 2),
                                                            (1, 90.00, 1),
                                                            (2, 130.00, 2),
                                                            (1, 33.00, 1),
                                                            (2, 55.00, 2),
                                                            (1, 85.00, 1),
                                                            (2, 99.00, 2),
                                                            (1, 250.00, 1),
                                                            (2, 75.00, 2),
                                                            (1, 44.00, 1),
                                                            (2, 110.00, 2),
                                                            (1, 65.00, 1),
                                                            (2, 45.00, 2);

UPDATE Produto SET tipo = 'valor_default' WHERE tipo IS NULL;

DELETE FROM pedido_id_produto WHERE pedido_id_pedido NOT IN (SELECT id_pedido FROM pedido);


