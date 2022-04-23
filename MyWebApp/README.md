********** MyWbApp **********
Java project created with SpringBoot - JPA implemented with Hibernate - Thymeleaf
and MySql.

The project have tests but run by web executing MyWebAppApplication file

************* DATABASE CREATION *************
CREATE DATABASE `usersdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

************* TABLE CREATED BY HIBERNATE CODE IN THE PROJECT *************
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `first_name` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `last_name` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `password` varchar(15) COLLATE utf8mb4_spanish_ci NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;



