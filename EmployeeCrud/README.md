******* EMPLOYEE CRUD *******
Java forms project with java swing and bd MySql

************* DATABASE CREATION *************
CREATE DATABASE `rbcompany` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `employee` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
`salary` int DEFAULT NULL,
`mobile` int DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;