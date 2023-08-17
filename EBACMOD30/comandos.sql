alter table tb_cliente add column cep varchar(9);

alter table tb_produto add column categoria varchar(100);

create sequence sq_estoque
start 1
increment 1
owned by tb_estoque.id;

create table tb_estoque(
	id bigint,
	id_produto_fk bigint not null,
	quantidade int not null,
	constraint pk_id_prod_estoque primary key(id),
	constraint fk_id_prod_estoque foreign key(id_produto_fk) references tb_produto(id)
);