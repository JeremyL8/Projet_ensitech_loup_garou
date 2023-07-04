CREATE DATABASE werewolf;
CREATE USER 'projet'@'localhost' IDENTIFIED BY 'Projet_LoupGarou1';
GRANT ALL ON werewolf.* TO 'projet'@'localhost';

USE werewolf;

CREATE TABLE users (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userName VARCHAR(100),
    pwd VARCHAR(100),
    levels VARCHAR(100)
);
CREATE TABLE role (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    roleName VARCHAR(100),
    descript VARCHAR(100),
    picture VARCHAR(1000)
);
CREATE TABLE player (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idUser INT ,
    statut VARCHAR(100),
    idRole INT,
    FOREIGN KEY (idUser) REFERENCES Users(id),
    FOREIGN KEY (idRole) REFERENCES Role(id)
);
