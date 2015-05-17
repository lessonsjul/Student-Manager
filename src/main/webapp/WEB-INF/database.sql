CREATE USER studentmanager@localhost identified by '123123';
grant USAGE ON *.* TO studentmanager@localhost identified BY '123123';
CREATE DATABASE IF NOT exists studentmanager;
GRANT ALL privileges ON studentmanager.* TO studentmanager@localhost;
USE studentmanager;
CREATE TABLE students
(
	id INT PRIMARY KEY auto_increment,
    first_name VARCHAR(50),
    second_name VARCHAR(50),
    groupe VARCHAR(10),
    entrance_date DATE
);

CREATE TABLE disciplines
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

CREATE TABLE semesters
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    duration INT,
    discipline_id int(11)
);

CREATE TABLE discipl_semester
(
	discipline_id INT(11),
    semester_id int(11),
    FOREIGN KEY (discipline_id) REFERENCES disciplines(id)
	ON DELETE CASCADE,
    FOREIGN KEY (semester_id) REFERENCES semesters(id)
	ON DELETE CASCADE
);

CREATE TABLE progress
(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    value INT,
    student_id INT,
    discipline_id INT,
    FOREIGN KEY (student_id) REFERENCES students(id)
	ON DELETE CASCADE,
    FOREIGN KEY (discipline_id) REFERENCES discipl_semester(discipline_id)
	ON DELETE CASCADE
);