CREATE SEQUENCE "SEQUENCE_USUARIO"
MINVALUE 1
MAXVALUE 999999999
INCREMENT BY 1
START WITH 1
NOCACHE
NOCYCLE;
CREATE TABLE usuario(
    id Int not null,
    nome VARCHAR(255) not null,
    email VARCHAR(255) not null,
    data_cadastro DATE not null,
    CONSTRAINT pk_usuario PRIMARY KEY (id)
);