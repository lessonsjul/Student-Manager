/*CREATE USER studentmanager@localhost identified by '123123';
grant USAGE ON *.* TO studentmanager@localhost identified BY '123123';
CREATE DATABASE IF NOT exists studentmanager;
GRANT ALL privileges ON studentmanager.* TO studentmanager@localhost;*/
USE studentmanager;
/*CREATE TABLE students
(
	id INT PRIMARY KEY auto_increment,
    first_name VARCHAR(50),
    second_name VARCHAR(50),
    groupe VARCHAR(10),
    entrance_date DATE,
    created timestamp default NOW()
);*/
/*
CREATE TABLE disciplines
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    created TIMESTAMP DEFAULT now()
);

CREATE TABLE semesters
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    duration INT
);

CREATE TABLE semester_discipline
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    semester_id INT,
    discipline_id INT
);*/

CREATE TABLE progress
(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    value INT,
    student_id INT,
    discipline_id INT,
    semester_id INT
);