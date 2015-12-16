/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mabaw
 * Created: Dec 15, 2015
 */

CREATE TABLE `biblioteca` (
  `bibliotecaid` INTEGER PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE `livro` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `titulo` VARCHAR(255) NOT NULL,
  `editora` VARCHAR(255) NOT NULL,
  `autor` TIME NOT NULL
);

CREATE TABLE `exemplar` (
  `exemplarid` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `livro` INTEGER NOT NULL,
  `biblioteca` INTEGER NOT NULL
);

CREATE INDEX `idx_exemplar__biblioteca` ON `exemplar` (`biblioteca`);

CREATE INDEX `idx_exemplar__livro` ON `exemplar` (`livro`);

ALTER TABLE `exemplar` ADD CONSTRAINT `fk_exemplar__biblioteca` FOREIGN KEY (`biblioteca`) REFERENCES `biblioteca` (`bibliotecaid`);

ALTER TABLE `exemplar` ADD CONSTRAINT `fk_exemplar__livro` FOREIGN KEY (`livro`) REFERENCES `livro` (`id`);

CREATE TABLE `pessoa` (
  `matriculacelu` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(255) NOT NULL,
  `isresp` BOOLEAN NOT NULL,
  `periodoativo` VARCHAR(255),
  `multa` DOUBLE,
  `recom` VARCHAR(255),
    
);

CREATE TABLE `emprestimo` (
  `emprestimoid` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `usuario` INTEGER NOT NULL,
  `exemplar` INTEGER NOT NULL
);

CREATE INDEX `idx_emprestimo__exemplar` ON `emprestimo` (`exemplar`);

CREATE INDEX `idx_emprestimo__usuario` ON `emprestimo` (`usuario`);

ALTER TABLE `emprestimo` ADD CONSTRAINT `fk_emprestimo__exemplar` FOREIGN KEY (`exemplar`) REFERENCES `exemplar` (`exemplarid`);

ALTER TABLE `emprestimo` ADD CONSTRAINT `fk_emprestimo__usuario` FOREIGN KEY (`usuario`) REFERENCES `pessoa` (`matriculacelu`);

INSERT INTO pessoa (matriculaCELU, nome, telefone, isresp, periodoativo) values ("001", "ze", "0001", true, "terça-manhã");
INSERT INTO pessoa (matriculaCELU, nome, telefone, isresp) values ("02", "ca", "0002", false);