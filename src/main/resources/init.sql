SET NAMES 'utf8' COLLATE 'utf8_general_ci';

DROP DATABASE IF EXISTS `bfa`;

CREATE DATABASE `bfa` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `bfa`;

CREATE TABLE Team (
    `Team_id` INT NOT NULL AUTO_INCREMENT,
    `Name` VARCHAR(30) NOT NULL,
    `Country` VARCHAR(30) NOT NULL,
    `Coach` VARCHAR(30) NOT NULL,
    PRIMARY KEY (Team_id)
);

CREATE TABLE `Player` (
    `Player_id` INT NOT NULL AUTO_INCREMENT,
    `Player_name` VARCHAR(30) NOT NULL,
    `Age` INT NOT NULL,
    `Team` INT NOT NULL,
    PRIMARY KEY (Player_id),
    FOREIGN KEY (Team) REFERENCES Team (Team_id)
);

INSERT INTO Team (Name, Country, Coach)
    VALUES ("GYőri-ETO", "Hungary", "Kis Pista");

INSERT INTO Team (Name, Country, Coach)
VALUES ("Real Madrid", "Spain", "Jorge Diaz");

INSERT INTO Team (Name, Country, Coach)
VALUES ("Ajax", "Italy", "Eros Ram");

INSERT INTO Player (Player_name, Age, Team)
    VALUES ("Dudás Ádám", 28, 1);

INSERT INTO Player (Player_name, Age, Team)
VALUES ("Varga Róbert", 25, 1);

INSERT INTO Player (Player_name, Age, Team)
VALUES ("Christiano Ronaldo", 27, 2);

INSERT INTO Player (Player_name, Age, Team)
VALUES ("Gareth Bale", 28, 2);

INSERT INTO Player (Player_name, Age, Team)
VALUES ("Kasper Dolberg", 25, 3);

INSERT INTO Player (Player_name, Age, Team)
VALUES ("Lasse Schöne", 28, 3);

