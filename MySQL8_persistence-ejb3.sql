CREATE DATABASE IF NOT EXISTS `persistence-ejb3`
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE `persistence-ejb3`;

CREATE TABLE IF NOT EXISTS `persistence-ejb3`.`product` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `price` DECIMAL(10,2) NOT NULL
) ENGINE = InnoDB DEFAULT CHARSET=utf8mb4;

SELECT `id`, `name`, `price` FROM `product`;
