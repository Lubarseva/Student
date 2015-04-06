DROP DATABASE IF EXISTS university;

CREATE DATABASE university DEFAULT CHARACTER SET 'utf8';

USE university;

CREATE TABLE student (
  id int(11) NOT NULL AUTO_INCREMENT,
  fullName varchar(50) DEFAULT NULL,
  faculty varchar(30) DEFAULT NULL,
  date date NOT NULL,
  sex char(1) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE subject (
  id int(11) NOT NULL AUTO_INCREMENT,
  subj varchar(30) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE test (
  id int(11) NOT NULL AUTO_INCREMENT,
  subjectId int(11) NOT NULL,
  studentId int(11) NOT NULL,
  mark int(11) NOT NULL,
  PRIMARY KEY (id),
  KEY subjectId ( subjectId),
  KEY studentId (studentId),
  CONSTRAINT test_ibfk_1 FOREIGN KEY (subjectId) REFERENCES subject (id),
  CONSTRAINT test_ibfk_2 FOREIGN KEY (studentId) REFERENCES student (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

