DROP DATABASE IF EXISTS rede_museu;
CREATE DATABASE IF NOT EXISTS rede_museu;

USE rede_museu;

CREATE TABLE IF NOT EXISTS curador(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    salario INT NOT NULL,
    formacao VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS artista(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    data_nasc DATE NOT NULL,
    data_obito DATE,
    qtde_premios INT DEFAULT 0,
    pais_origem VARCHAR(140) NOT NULL
);

CREATE TABLE IF NOT EXISTS museu(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(175) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    cep CHAR(8) NOT NULL,
    descricao TEXT
);

CREATE TABLE IF NOT EXISTS exposicao(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    descricao TEXT,
    data_inicio DATE NOT NULL,
    data_termino DATE NOT NULL,

    id_curador INT NOT NULL,
    id_museu INT NOT NULL,

    CONSTRAINT curador_FK FOREIGN KEY (id_curador) REFERENCES curador(id),
    CONSTRAINT museu_FK FOREIGN KEY (id_museu) REFERENCES museu(id)
);

CREATE TABLE IF NOT EXISTS obra(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    ano DATE NOT NULL,
    movimento VARCHAR(120) NOT NULL,
    designacao VARCHAR(80) NOT NULL,
    altura DOUBLE NOT NULL,
    comprimento DOUBLE NOT NULL,
    profundidade DOUBLE,
    id_exposicao INT,

    id_artista INT NOT NULL,

    CONSTRAINT artista_FK FOREIGN KEY (id_artista) REFERENCES artista(id),
    CONSTRAINT exposicao_FK_obra FOREIGN KEY (id_exposicao) REFERENCES exposicao(id),
    CONSTRAINT designacoes_CK CHECK (designacao IN ('Pintura', 'Escultura', 'Audiovisual', 'Ambiente', 'Gravura'))
);


CREATE TABLE IF NOT EXISTS premio(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    honorifico VARCHAR(100),

    id_exposicao INT NOT NULL,

    CONSTRAINT exposicao FOREIGN KEY (id_exposicao) REFERENCES exposicao(id)
);

CREATE TABLE IF NOT EXISTS obra_exposicao(
    id_obra INT NOT NULL,
    id_exposicao INT NOT NULL,

    CONSTRAINT obra_FK FOREIGN KEY (id_obra) REFERENCES obra(id),
    CONSTRAINT exposicao_FK FOREIGN KEY (id_exposicao) REFERENCES exposicao(id)
);

INSERT INTO curador(nome, salario, formacao) VALUES ('cassio1', 1000, 'belas artes');
INSERT INTO curador(nome, salario, formacao) VALUES ('cassio2', 1000, 'belas artes');
INSERT INTO curador(nome, salario, formacao) VALUES ('cassio3', 1000, 'belas artes');
INSERT INTO curador(nome, salario, formacao) VALUES ('cassio4', 1000, 'belas artes');
INSERT INTO curador(nome, salario, formacao) VALUES ('cassio5', 1000, 'belas artes');

INSERT INTO artista(nome, data_nasc, data_obito, qtde_premios, pais_origem) VALUES ('Moisés1', '2020-07-02', '2020-12-12', 190, 'Alemanha');
INSERT INTO artista(nome, data_nasc, data_obito, qtde_premios, pais_origem) VALUES ('Moisés2', '2020-07-02', '2020-12-12', 190, 'Alemanha');
INSERT INTO artista(nome, data_nasc, data_obito, qtde_premios, pais_origem) VALUES ('Moisés3', '2020-07-02', '2020-12-12', 190, 'Alemanha');
INSERT INTO artista(nome, data_nasc, data_obito, qtde_premios, pais_origem) VALUES ('Moisés4', '2020-07-02', '2020-12-12', 190, 'Alemanha');
INSERT INTO artista(nome, data_nasc, data_obito, qtde_premios, pais_origem) VALUES ('Moisés5', '2020-07-02', '2020-12-12', 190, 'Alemanha');