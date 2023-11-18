create table produtos (id INT AUTO_INCREMENT PRIMARY KEY,
                       nome_produto varchar (50) NOT NULL,
                       descricao_produto VARCHAR(100) NOT NULL,
                       preco_produto REAL,
                       data_validade VARCHAR(15),
                       estoque INT,
                       fornecedor VARCHAR(50),
                       ativo INT);