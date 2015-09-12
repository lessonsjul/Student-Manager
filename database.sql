CREATE USER studentmanager@localhost identified by '123123';
GRANT USAGE on  *.* to studentmanager@localhost identified by '123123';
create database if not EXISTS studentmanager;
GRANT ALL PRIVILEGES on studentmanager.* to studentmanager@localhost;
USE studentmanager;
CREATE TABLE disciplines(
id int PRIMARY KEY auto_increment,
name VARCHAR(50)
);

CREATE TABLE disciplines_has_semester(
disciplines_id INT,
semester_id INT,
idx INT
);

CREATE TABLE semester(
id int PRIMARY KEY auto_increment,
name VARCHAR(50),
duration INT
);

CREATE TABLE students(
id int PRIMARY KEY auto_increment,
  first_name VARCHAR(50),
  second_name VARCHAR(50),
  groupe VARCHAR(10),
  entrance_date DATE
);

CREATE TABLE progress(
  id int PRIMARY KEY auto_increment,
  value INT,
  students_id INT,
  disciplines_id INT
);