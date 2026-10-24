-- CREATE USER IF NOT EXISTS 'F26A'@'localhost' IDENTIFIED BY '1234';
-- GRANT ALL PRIVILEGES ON *.* TO 'F26A'@'localhost';
-- eller
-- GRANT ALL PRIVILEGES ON Projekt2_Gruppe_2.* TO 'F26A'@'localhost';

CREATE SCHEMA IF NOT EXISTS Projekt2_Gruppe_2;
USE Projekt2_Gruppe_2;

DROP TABLE IF EXISTS wishListSharedWith;
DROP TABLE IF EXISTS wish;
DROP TABLE IF EXISTS wishList;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS wishCategories;


CREATE TABLE user (
    userID   int auto_increment primary key,
    name     varchar(45) not null,
    email    varchar(45) not null unique,
    password varchar(45) not null
);

CREATE TABLE wishList (
    listID      int auto_increment primary key,
    title       varchar(45) not null,
    description varchar(200),
    userID      int not null,

    foreign key (userID) references user (userID)
);

CREATE TABLE wishCategories (
    categoryID int auto_increment primary key,
    title      varchar(45) not null,
    image      varchar(45) not null
);

CREATE TABLE wish (
    wishID      int auto_increment primary key,
    title       varchar(45) not null,
    description varchar(200),
    price       int not null,
    link        varchar(45),
    reserveID   int,
    listID      int not null,
    categoryID  int not null,

    foreign key (reserveID) references user (userID),
    foreign key (listID) references wishList (listID),
    foreign key (categoryID) references wishCategories (categoryID)
);

CREATE TABLE wishListSharedWith (
    userID int not null,
    listID int not null,

    foreign key (userID) references user (userID),
    foreign key (listID) references wishList (listID)
)

