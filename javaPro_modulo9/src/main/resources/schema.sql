CREATE TABLE animal(
    id Int AUTO_INCREMENT not null,
    nome_provisorio VARCHAR(255) not null,
    idade_estimada INT not null,
    raca VARCHAR(255) not null,
    data_entrada DATE not null,
    data_adocao DATE,
    condicoes_chegada VARCHAR(255) not null,
    nome_recebedor VARCHAR(255) not null,
    data_obito DATE,
    porte VARCHAR(255) not null,
    tipo_animal VARCHAR(30) not null,
    CONSTRAINT pk_animal PRIMARY KEY (id)
);