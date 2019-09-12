# projeto1
projeto 1 de techweb

Endereço de acesso: http://localhost:8080/Projeto_1/login.jsp

Criação de tabelas:

CREATE DATABASE projeto_1;

CREATE TABLE user(
id INT NOT NULL AUTO_INCREMENT,
nome VARCHAR(32) NOT NULL,
senha VARCHAR(32) NOT NULL,
PRIMARY KEY (ID));

CREATE TABLE postagem(
id INT NOT NULL AUTO_INCREMENT,
user_id INT NOT NULL REFERENCES user(id),
materia VARCHAR(32) NOT NULL,
professor VARCHAR(32) NOT NULL,
review VARCHAR(32) NOT NULL,
PRIMARY KEY(id)
);
