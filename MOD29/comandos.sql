create table tb_cliente(
	id bigint primary key,
	codigo varchar(100),
	nome varchar(500)
);

CREATE SEQUENCE SQ_CLIENTE START 1;


CREATE SEQUENCE SQ_PRODUTO START 1;

create table tb_produto(
	id bigint primary key,
	nome varchar(500),
	preco numeric(10,2)
);
