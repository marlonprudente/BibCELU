
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema BibCELU
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BibCELU
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BibCELU` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `BibCELU` ;

-- -----------------------------------------------------
-- Table `BibCELU`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibCELU`.`usuarios` (
  `usuario_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `privilegios` INT(1) NOT NULL COMMENT '',
  `quarto` INT(3) NOT NULL COMMENT '',
  `curso` VARCHAR(45) NOT NULL COMMENT '',
  `telefone` INT(11) NOT NULL COMMENT '',
  `email` VARCHAR(45) NOT NULL COMMENT '',
  `login` VARCHAR(8) NOT NULL COMMENT '',
  `senha` VARCHAR(8) NOT NULL COMMENT '',
  PRIMARY KEY (`usuario_id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibCELU`.`generos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibCELU`.`generos` (
  `genero_id` INT NOT NULL COMMENT '',
  `descricao` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`genero_id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibCELU`.`livros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibCELU`.`livros` (
  `livro_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `titulo` VARCHAR(45) NOT NULL COMMENT '',
  `autor` VARCHAR(45) NOT NULL COMMENT '',
  `editora` VARCHAR(45) NOT NULL COMMENT '',
  `volume` INT NOT NULL COMMENT '',
  `ano` YEAR NOT NULL COMMENT '',
  `descricao` VARCHAR(45) NOT NULL COMMENT '',
  `genero_id` INT NOT NULL COMMENT '',
  `quantidade` INT NOT NULL COMMENT '',
  PRIMARY KEY (`livro_id`)  COMMENT '',
  INDEX `fk_livros_generos1_idx` (`genero_id` ASC)  COMMENT '',
  CONSTRAINT `fk_livros_generos1`
    FOREIGN KEY (`genero_id`)
    REFERENCES `BibCELU`.`generos` (`genero_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibCELU`.`livrosindicados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibCELU`.`livrosindicados` (
  `indicacao_id` INT NOT NULL COMMENT '',
  `titulo` VARCHAR(45) NOT NULL COMMENT '',
  `volume` INT NOT NULL COMMENT '',
  `ano` YEAR NOT NULL COMMENT '',
  `editora` VARCHAR(45) NOT NULL COMMENT '',
  `motivo` VARCHAR(45) NOT NULL COMMENT '',
  `usuario_id` INT NOT NULL COMMENT '',
  PRIMARY KEY (`indicacao_id`, `usuario_id`)  COMMENT '',
  INDEX `fk_livrosindicados_usuarios1_idx` (`usuario_id` ASC)  COMMENT '',
  CONSTRAINT `fk_livrosindicados_usuarios1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `BibCELU`.`usuarios` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BibCELU`.`reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BibCELU`.`reserva` (
  `reserva_id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `livro_id` INT NOT NULL COMMENT '',
  `usuario_id` INT NOT NULL COMMENT '',
  `datadeemprestimo` DATE NOT NULL COMMENT '',
  `datadedevolucao` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`reserva_id`)  COMMENT '',
  INDEX `fk_reserva_livros_idx` (`livro_id` ASC)  COMMENT '',
  INDEX `fk_reserva_usuarios1_idx` (`usuario_id` ASC)  COMMENT '',
  CONSTRAINT `fk_reserva_livros`
    FOREIGN KEY (`livro_id`)
    REFERENCES `BibCELU`.`livros` (`livro_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_usuarios1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `BibCELU`.`usuarios` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
