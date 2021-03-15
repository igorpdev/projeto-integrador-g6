CREATE TABLE `postagem` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`titulo` varchar(255),
	`data` DATETIME AUTO_INCREMENT,
	`conteudo` varchar(255),
	`midia` VARCHAR(255) NOT NULL,
	`tema_id` INT NOT NULL,
	`usuario_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tema` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`cursos` varchar(255),
	`vagas` varchar(255),
	`networking` varchar(255),
	PRIMARY KEY (`id`)
);

CREATE TABLE `usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(255),
	`email` varchar(255),
	`senha` varchar(255),
	PRIMARY KEY (`id`)
);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk0` FOREIGN KEY (`tema_id`) REFERENCES `tema`(`id`);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario`(`id`);

