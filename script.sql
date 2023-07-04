CREATE DATABASE werewolf;
CREATE USER 'projet'@'localhost' IDENTIFIED BY 'Projet_LoupGarou1';
GRANT ALL ON werewolf.* TO 'projet'@'localhost';

USE werewolf;

CREATE TABLE users (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(100),
    pwd VARCHAR(100),
    levels VARCHAR(100)
);
CREATE TABLE role (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(100),
    descript VARCHAR(100),
    picture VARCHAR(1000)
);
CREATE TABLE player (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_user INT ,
    statut VARCHAR(100),
    id_role INT,
    FOREIGN KEY (id_user) REFERENCES users(id),
    FOREIGN KEY (id_role) REFERENCES role(id)
);
