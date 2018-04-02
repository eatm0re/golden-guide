-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema golden_guide_schema
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `golden_guide_schema` ;

-- -----------------------------------------------------
-- Schema golden_guide_schema
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `golden_guide_schema` DEFAULT CHARACTER SET utf8 ;
USE `golden_guide_schema` ;

-- -----------------------------------------------------
-- Table `golden_guide_schema`.`USERS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `golden_guide_schema`.`USERS` (
  `USER_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `USER_LOGIN` VARCHAR(45) NOT NULL,
  `USER_PASSWORD` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE INDEX `USER_LOGIN_UNIQUE` (`USER_LOGIN` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `golden_guide_schema`.`USERS`
-- -----------------------------------------------------
START TRANSACTION;
USE `golden_guide_schema`;
INSERT INTO `golden_guide_schema`.`USERS` (`USER_ID`, `USER_LOGIN`, `USER_PASSWORD`) VALUES (DEFAULT, 'admin', 'admin123');
INSERT INTO `golden_guide_schema`.`USERS` (`USER_ID`, `USER_LOGIN`, `USER_PASSWORD`) VALUES (DEFAULT, 'user', 'qwerty');
INSERT INTO `golden_guide_schema`.`USERS` (`USER_ID`, `USER_LOGIN`, `USER_PASSWORD`) VALUES (DEFAULT, 'Petya', '1235');
INSERT INTO `golden_guide_schema`.`USERS` (`USER_ID`, `USER_LOGIN`, `USER_PASSWORD`) VALUES (DEFAULT, 'Vasya', 'lol');

COMMIT;

