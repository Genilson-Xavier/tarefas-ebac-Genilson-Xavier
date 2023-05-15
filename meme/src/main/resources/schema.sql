CREATE SEQUENCE "SEQUENCE_MEME"
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;
CREATE TABLE meme(
    id Int not null,
    nome VARCHAR(255) not null,
    url VARCHAR(255) not null,
    descricao VARCHAR(255) not null,
    data_cadastro DATE not null,
    id_usuario int not null,
    id_categoria int not null,
    CONSTRAINT pk_meme PRIMARY KEY (id)
);