CREATE DATABASE werewolf;
CREATE USER 'projet'@'localhost' IDENTIFIED BY 'Projet_LoupGarou1';
GRANT ALL ON werewolf.* TO 'projet'@'localhost';

CREATE TABLE Users ( 
    id INT PRIMARY KEY NOT NULL,
    userName VARCHAR(100),
    pwd VARCHAR(100),
    levels VARCHAR(100)
);
CREATE TABLE Player ( 
    id INT PRIMARY KEY NOT NULL,
    idUser INT REFERENCES Users(id),
    statut VARCHAR(100),
    idRole INT REFERENCES Role(id) 
);
CREATE TABLE Role ( 
    id INT PRIMARY KEY NOT NULL,
    roleName VARCHAR(100),
    descript VARCHAR(100),
    pic VARCHAR(1000)
);