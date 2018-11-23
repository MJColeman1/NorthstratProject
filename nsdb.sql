-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema nsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `nsdb` ;

-- -----------------------------------------------------
-- Schema nsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `nsdb` DEFAULT CHARACTER SET utf8 ;
USE `nsdb` ;

-- -----------------------------------------------------
-- Table `expense`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `expense` ;

CREATE TABLE IF NOT EXISTS `expense` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(500) NULL,
  `attendees` VARCHAR(250) NULL,
  `amount` DOUBLE UNSIGNED NULL,
  `gl_account` VARCHAR(100) NULL,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL,
  `status` VARCHAR(45) NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `travel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `travel` ;

CREATE TABLE IF NOT EXISTS `travel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `project_charge_code` VARCHAR(45) NULL,
  `trip_location` VARCHAR(100) NULL,
  `travel_dates` VARCHAR(100) NULL,
  `created_at` TIMESTAMP NULL,
  `updated_at` TIMESTAMP NULL,
  `status` VARCHAR(45) NULL,
  `total_cost` DOUBLE NULL,
  `user_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_id_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `admin` VARCHAR(45) NULL,
  `expense_id` INT NULL,
  `travel_id` INT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(100) NULL,
  `title` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `expense_id_idx` (`expense_id` ASC),
  INDEX `travel_id_idx` (`travel_id` ASC),
  CONSTRAINT `fk_expense`
    FOREIGN KEY (`expense_id`)
    REFERENCES `expense` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_travel`
    FOREIGN KEY (`travel_id`)
    REFERENCES `travel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO nsuser@localhost;
 DROP USER nsuser@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'nsuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'nsuser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `expense`
-- -----------------------------------------------------
START TRANSACTION;
USE `nsdb`;
INSERT INTO `expense` (`id`, `description`, `attendees`, `amount`, `gl_account`, `created_at`, `updated_at`, `status`, `user_id`) VALUES (1, 'test', 'testing', 100, '111000', NULL, NULL, 'Submitted', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `travel`
-- -----------------------------------------------------
START TRANSACTION;
USE `nsdb`;
INSERT INTO `travel` (`id`, `project_charge_code`, `trip_location`, `travel_dates`, `created_at`, `updated_at`, `status`, `total_cost`, `user_id`) VALUES (1, '1', 'Hawaii', '8/12/18-8/18/18', NULL, NULL, 'Submitted', 2000.00, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `nsdb`;
INSERT INTO `user` (`id`, `username`, `password`, `admin`, `expense_id`, `travel_id`, `first_name`, `last_name`, `email`, `title`) VALUES (1, 'Coleman', 'password', '1', 1, 1, 'Mark', 'Coleman', 'Mark.Coleman@northstrat.com', 'Software Engineer');

COMMIT;
