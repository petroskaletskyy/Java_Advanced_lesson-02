DROP DATABASE IF EXISTS book_library;
CREATE DATABASE book_library CHAR SET utf8mb4;
USE book_library;

CREATE TABLE category_book (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE book (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    book_name VARCHAR(120) NOT NULL,
    book_description TEXT,
    price DECIMAL(5,2) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE
); 

CREATE TABLE author (
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    email VARCHAR(50) NOT NULL,
    address VARCHAR(60) NOT NULL,
    birthday_date INT NOT NULL
);