-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema malishevskiy
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `malishevskiy` ;

-- -----------------------------------------------------
-- Schema malishevskiy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `malishevskiy` DEFAULT CHARACTER SET utf8 ;
USE `malishevskiy` ;

-- -----------------------------------------------------
-- Table `malishevskiy`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `malishevskiy`.`roles` ;

CREATE TABLE IF NOT EXISTS `malishevskiy`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `malishevskiy`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `malishevskiy`.`users` ;

CREATE TABLE IF NOT EXISTS `malishevskiy`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles_idx` (`roles_ID` ASC) VISIBLE,
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `malishevskiy`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `malishevskiy`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `malishevskiy`.`ads` ;

CREATE TABLE IF NOT EXISTS `malishevskiy`.`ads` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Animal` VARCHAR(45) NULL,
  `Weight (kg)` VARCHAR(45) NULL,
  `Color` VARCHAR(45) NULL,
  `Price ($)` INT NULL,
  `Description` VARCHAR(500) NULL,
  `Adress` VARCHAR(45) NULL,
  `users_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`users_ID` ASC) VISIBLE,
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `malishevskiy`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `malishevskiy`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `malishevskiy`;
INSERT INTO `malishevskiy`.`roles` (`ID`, `Role`) VALUES (1, 'admin');
INSERT INTO `malishevskiy`.`roles` (`ID`, `Role`) VALUES (2, 'user');
INSERT INTO `malishevskiy`.`roles` (`ID`, `Role`) VALUES (3, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `malishevskiy`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `malishevskiy`;
INSERT INTO `malishevskiy`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@it.by', 1);
INSERT INTO `malishevskiy`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user', 'puser', 'user@it.by', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `malishevskiy`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `malishevskiy`;
INSERT INTO `malishevskiy`.`ads` (`ID`, `Animal`, `Weight (kg)`, `Color`, `Price ($)`, `Description`, `Adress`, `users_ID`) VALUES (DEFAULT, 'Dog', '7', 'Black', 100, 'Добрая собака трех лет от роду ищет не менее добрую семью. Привитая, обожает играть со своим мячиком, кошками, и детьми)', 'ул. Западная 9-90', 2);
INSERT INTO `malishevskiy`.`ads` (`ID`, `Animal`, `Weight (kg)`, `Color`, `Price ($)`, `Description`, `Adress`, `users_ID`) VALUES (DEFAULT, 'Cat', '3', 'White', 75, 'Новорожденная русская голубая кошка. Документы - в наличии, как и очень добрый, ласковый характер. Когтедралка - в подарок.', 'ул. Сухаревская 12-74', 2);
INSERT INTO `malishevskiy`.`ads` (`ID`, `Animal`, `Weight (kg)`, `Color`, `Price ($)`, `Description`, `Adress`, `users_ID`) VALUES (DEFAULT, 'Parrot', '2', 'Red-White-Blue', 200, 'Годовалый (год от роду) разговаривающий попугай прямиком из Турции. Может запомнить до 500 слов, детишек особо радует. За лишние 30$ отдаем корм на месяц + стойку с клеткой', 'ул. Индустриальная 5-5', 2);

COMMIT;

