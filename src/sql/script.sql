-- Script para criar uma tabela de produtos em linguagem SQL
-- Nome de tabelas podem ser definidos no plural
CREATE TABLE produtos(
	id				SERIAL		PRIMARY KEY,
	nome			VARCHAR(100)	NOT NULL,
	preco			NUMERIC(10,2)	NOT NULL,
	quantidade		INTEGER		NOT NULL,
	data_cadastro	TIMESTAMP		NOT NULL DEFAULT NOW()
);
