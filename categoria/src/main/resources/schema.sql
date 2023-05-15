CREATE SEQUENCE "SEQUENCE_CATEGORIA_MEME"
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;
CREATE TABLE categoria(
    id Int not null,
    nome VARCHAR(255) not null,
    descricao VARCHAR(255) not null,
    data_cadastro DATE not null,
    id_usuario int not null,
    CONSTRAINT pk_categoria PRIMARY KEY (id)
);