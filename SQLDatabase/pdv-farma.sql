-- MySQL Script generated by MySQL Workbench
-- 06/17/16 11:04:49
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Farmacia
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Farmacia` ;

-- -----------------------------------------------------
-- Schema Farmacia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Farmacia` DEFAULT CHARACTER SET utf8 ;
USE `Farmacia` ;

-- -----------------------------------------------------
-- Table `Farmacia`.`Pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`Pessoa` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`Pessoa` (
  `idPessoa` INT NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `nascimento` DATE NOT NULL,
  PRIMARY KEY (`idPessoa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia`.`Empregado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`Empregado` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`Empregado` (
  `idEmpregado` INT NOT NULL,
  `matricula` CHAR(4) NOT NULL,
  `cargo` VARCHAR(75) NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idEmpregado`, `idPessoa`),
  INDEX `fk_Empregado_Pessoa_idx` (`idPessoa` ASC),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC),
  CONSTRAINT `fk_Empregado_Pessoa`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `Farmacia`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia`.`Fabricante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`Fabricante` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`Fabricante` (
  `idFabricante` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(95) NOT NULL,
  `CNPJ` CHAR(15) NOT NULL,
  PRIMARY KEY (`idFabricante`),
  UNIQUE INDEX `CNPJ_UNIQUE` (`CNPJ` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia`.`Medicamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`Medicamento` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`Medicamento` (
  `idMedicamento` INT NOT NULL,
  `tarja` ENUM('Sem', 'Amarela', 'Vermelha', 'Preta') NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `valor` DECIMAL(5,2) NOT NULL,
  `retemReceita` TINYINT(1) NOT NULL,
  `idFabricante` INT NOT NULL,
  PRIMARY KEY (`idMedicamento`),
  INDEX `fk_Medicamento_Fabricante1_idx` (`idFabricante` ASC),
  CONSTRAINT `fk_Medicamento_Fabricante1`
    FOREIGN KEY (`idFabricante`)
    REFERENCES `Farmacia`.`Fabricante` (`idFabricante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia`.`ReceitaMedica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`ReceitaMedica` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`ReceitaMedica` (
  `idReceitaMedica` INT NOT NULL,
  `CRM` CHAR(10) NOT NULL,
  PRIMARY KEY (`idReceitaMedica`),
  UNIQUE INDEX `CRM_UNIQUE` (`CRM` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia`.`Estoque`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`Estoque` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`Estoque` (
  `idEstoque` INT NOT NULL,
  `quantidadeAtual` INT NOT NULL,
  `quantidadeMin` INT NOT NULL,
  `validade` DATE NOT NULL,
  `idMedicamento` INT NOT NULL,
  PRIMARY KEY (`idEstoque`),
  INDEX `fk_Estoque_Medicamento1_idx` (`idMedicamento` ASC),
  CONSTRAINT `fk_Estoque_Medicamento1`
    FOREIGN KEY (`idMedicamento`)
    REFERENCES `Farmacia`.`Medicamento` (`idMedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`Cliente` (
  `idCliente` INT NOT NULL,
  `endereco` VARCHAR(95) NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idCliente`, `idPessoa`),
  INDEX `fk_Cliente_Pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_Cliente_Pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `Farmacia`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia`.`Venda`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`Venda` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`Venda` (
  `idVenda` INT NOT NULL,
  `valorTotal` DECIMAL(7,2) NOT NULL,
  `idCliente` INT NOT NULL,
  `idEmpregado` INT NOT NULL,
  `idReceita` INT NOT NULL,
  PRIMARY KEY (`idVenda`),
  INDEX `fk_Venda_Cliente1_idx` (`idCliente` ASC),
  INDEX `fk_Venda_Empregado1_idx` (`idEmpregado` ASC),
  INDEX `fk_Venda_ReceitaMedica1_idx` (`idReceita` ASC),
  CONSTRAINT `fk_Venda_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `Farmacia`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Empregado1`
    FOREIGN KEY (`idEmpregado`)
    REFERENCES `Farmacia`.`Empregado` (`idEmpregado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_ReceitaMedica1`
    FOREIGN KEY (`idReceita`)
    REFERENCES `Farmacia`.`ReceitaMedica` (`idReceitaMedica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Farmacia`.`Transacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Farmacia`.`Transacao` ;

CREATE TABLE IF NOT EXISTS `Farmacia`.`Transacao` (
  `idTransacao` INT NOT NULL,
  `idVenda` INT NOT NULL,
  `idMedicamento` INT NOT NULL,
  `valorUnitario` DECIMAL(5,2) NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`idTransacao`),
  INDEX `fk_Venda_Medicamento_Venda1_idx` (`idVenda` ASC),
  INDEX `fk_Venda_Medicamento_Medicamento1_idx` (`idMedicamento` ASC),
  CONSTRAINT `fk_Venda_Medicamento_Venda1`
    FOREIGN KEY (`idVenda`)
    REFERENCES `Farmacia`.`Venda` (`idVenda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venda_Medicamento_Medicamento1`
    FOREIGN KEY (`idMedicamento`)
    REFERENCES `Farmacia`.`Medicamento` (`idMedicamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;