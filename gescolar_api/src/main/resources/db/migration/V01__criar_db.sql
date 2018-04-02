-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema gescolar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gescolar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gescolar` DEFAULT CHARACTER SET utf8 ;
USE `gescolar` ;

-- -----------------------------------------------------
-- Table `gescolar`.`tipo_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`tipo_usuario` (
  `id_tipo_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `desc_tipo_usurio` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_tipo_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gescolar`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`usuario` (
  `id_usuario` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `senha` VARCHAR(45) NULL DEFAULT NULL,
  `id_tipo_usuario` INT(11) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  INDEX `fk_usuario_tipo_usuario_idx` (`id_tipo_usuario` ASC),
  CONSTRAINT `fk_usuario_tipo_usuario`
    FOREIGN KEY (`id_tipo_usuario`)
    REFERENCES `gescolar`.`tipo_usuario` (`id_tipo_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gescolar`.`periodo_letivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`periodo_letivo` (
  `id_periodo_letivo` INT NOT NULL AUTO_INCREMENT,
  `data_ini` DATE NOT NULL,
  `data_fim` DATE NOT NULL,
  `turno` VARCHAR(45) NOT NULL,
  `situacao` VARCHAR(45) NOT NULL,
  `minutos_periodo` INT NULL,
  PRIMARY KEY (`id_periodo_letivo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gescolar`.`truma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`truma` (
  `id_truma` INT NOT NULL AUTO_INCREMENT,
  `sala` VARCHAR(45) NULL,
  `quantidade_periodos` INT NULL,
  `quant_dias` INT NULL,
  `id_periodo_letivo` INT NOT NULL,
  `serie` VARCHAR(45) NULL,
  PRIMARY KEY (`id_truma`),
  INDEX `fk_truma_periodo_letivo1_idx` (`id_periodo_letivo` ASC),
  CONSTRAINT `fk_truma_periodo_letivo1`
    FOREIGN KEY (`id_periodo_letivo`)
    REFERENCES `gescolar`.`periodo_letivo` (`id_periodo_letivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gescolar`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`aluno` (
  `id_aluno` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NULL DEFAULT NULL,
  `foto` BLOB NULL DEFAULT NULL,
  `matricula` VARCHAR(50) NULL DEFAULT NULL,
  `id_usuario` INT(11) NOT NULL,
  `sexo` VARCHAR(2) NULL,
  `id_truma` INT NOT NULL,
  PRIMARY KEY (`id_aluno`),
  INDEX `fk_aluno_usuario1_idx` (`id_usuario` ASC),
  INDEX `fk_aluno_truma1_idx` (`id_truma` ASC),
  CONSTRAINT `fk_aluno_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gescolar`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_truma1`
    FOREIGN KEY (`id_truma`)
    REFERENCES `gescolar`.`truma` (`id_truma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gescolar`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`professor` (
  `id_professor` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `celular` VARCHAR(50) NULL DEFAULT NULL,
  `id_usuario` INT(11) NOT NULL,
  `foto` VARCHAR(1000) NULL DEFAULT NULL,
  `email` VARCHAR(50) NULL,
  `telefone` VARCHAR(50) NULL,
  `sexo` VARCHAR(2) NULL,
  PRIMARY KEY (`id_professor`),
  INDEX `fk_professor_usuario1_idx` (`id_usuario` ASC),
  INDEX `id_usurio` (`id_usuario` ASC),
  CONSTRAINT `fk_professor_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gescolar`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gescolar`.`responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`responsavel` (
  `id_responsavel` INT(11) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `parentesco` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(50) NULL DEFAULT NULL,
  `celular` VARCHAR(50) NULL DEFAULT NULL,
  `sexo` VARCHAR(1) NULL DEFAULT NULL,
  `id_usuario` INT(11) NOT NULL,
  `email` VARCHAR(50) NULL,
  PRIMARY KEY (`id_responsavel`),
  INDEX `fk_responsavel_usuario1_idx` (`id_usuario` ASC),
  CONSTRAINT `fk_responsavel_usuario1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `gescolar`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `gescolar`.`responsavel_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`responsavel_aluno` (
  `id_responsavel` INT(11) NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  PRIMARY KEY (`id_responsavel`, `id_aluno`),
  INDEX `fk_responsavel_has_aluno_aluno1_idx` (`id_aluno` ASC),
  INDEX `fk_responsavel_has_aluno_responsavel1_idx` (`id_responsavel` ASC),
  CONSTRAINT `fk_responsavel_has_aluno_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `gescolar`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_responsavel_has_aluno_responsavel1`
    FOREIGN KEY (`id_responsavel`)
    REFERENCES `gescolar`.`responsavel` (`id_responsavel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;





-- -----------------------------------------------------
-- Table `gescolar`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`disciplina` (
  `id_disciplina` INT NOT NULL AUTO_INCREMENT,
  `desc` VARCHAR(300) NULL,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_disciplina`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gescolar`.`discipliana_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`discipliana_turma` (
  `id_discipliana_turma` INT NOT NULL AUTO_INCREMENT,
  `quant_periodos` INT NULL,
  `id_disciplina` INT NOT NULL,
  `id_truma` INT NOT NULL,
  `id_professor` INT(11) NOT NULL,
  PRIMARY KEY (`id_discipliana_turma`),
  INDEX `fk_discipliana_turma_disciplina1_idx` (`id_disciplina` ASC),
  INDEX `fk_discipliana_turma_truma1_idx` (`id_truma` ASC),
  INDEX `fk_discipliana_turma_professor1_idx` (`id_professor` ASC),
  CONSTRAINT `fk_discipliana_turma_disciplina1`
    FOREIGN KEY (`id_disciplina`)
    REFERENCES `gescolar`.`disciplina` (`id_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_discipliana_turma_truma1`
    FOREIGN KEY (`id_truma`)
    REFERENCES `gescolar`.`truma` (`id_truma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_discipliana_turma_professor1`
    FOREIGN KEY (`id_professor`)
    REFERENCES `gescolar`.`professor` (`id_professor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gescolar`.`chamada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`chamada` (
  `id_chamada` INT NOT NULL,
  `presenca` TINYINT(1) NOT NULL,
  `data` DATE NOT NULL,
  `id_discipliana_turma` INT NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  PRIMARY KEY (`id_chamada`),
  INDEX `fk_chamada_discipliana_turma1_idx` (`id_discipliana_turma` ASC),
  INDEX `fk_chamada_aluno1_idx` (`id_aluno` ASC),
  CONSTRAINT `fk_chamada_discipliana_turma1`
    FOREIGN KEY (`id_discipliana_turma`)
    REFERENCES `gescolar`.`discipliana_turma` (`id_discipliana_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_chamada_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `gescolar`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gescolar`.`avaliacao_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`avaliacao_disciplina` (
  `id_avaliacao_disciplina` INT NOT NULL AUTO_INCREMENT,
  `peso` DECIMAL(1,1) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  `descriacao` VARCHAR(45) NOT NULL,
  `id_discipliana_turma` INT NOT NULL,
  PRIMARY KEY (`id_avaliacao_disciplina`),
  INDEX `fk_avaliacao_disciplina_discipliana_turma1_idx` (`id_discipliana_turma` ASC),
  CONSTRAINT `fk_avaliacao_disciplina_discipliana_turma1`
    FOREIGN KEY (`id_discipliana_turma`)
    REFERENCES `gescolar`.`discipliana_turma` (`id_discipliana_turma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gescolar`.`nota_aulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gescolar`.`nota_aulo` (
  `id_nota_aulo` INT NOT NULL AUTO_INCREMENT,
  `nota` DECIMAL(2,2) NOT NULL,
  `id_avaliacao_disciplina` INT NOT NULL,
  `id_aluno` INT(11) NOT NULL,
  PRIMARY KEY (`id_nota_aulo`, `id_avaliacao_disciplina`),
  INDEX `fk_nota_aulo_avaliacao_disciplina1_idx` (`id_avaliacao_disciplina` ASC),
  INDEX `fk_nota_aulo_aluno1_idx` (`id_aluno` ASC),
  CONSTRAINT `fk_nota_aulo_avaliacao_disciplina1`
    FOREIGN KEY (`id_avaliacao_disciplina`)
    REFERENCES `gescolar`.`avaliacao_disciplina` (`id_avaliacao_disciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_nota_aulo_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `gescolar`.`aluno` (`id_aluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


