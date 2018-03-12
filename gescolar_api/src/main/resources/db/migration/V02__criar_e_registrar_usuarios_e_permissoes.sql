ALTER TABLE `gescolar`.`tipo_usuario` 
ADD COLUMN `role` VARCHAR(45) NULL AFTER `desc_tipo_usurio`;

INSERT INTO `gescolar`.`tipo_usuario` (`id_tipo_usuario`, `desc_tipo_usurio`, `role`) VALUES ('1', 'Administrador', 'ADM_ROLE');
INSERT INTO `gescolar`.`tipo_usuario` (`id_tipo_usuario`, `desc_tipo_usurio`, `role`) VALUES ('2', 'Professor', 'PRO_ROLE');
INSERT INTO `gescolar`.`tipo_usuario` (`id_tipo_usuario`, `desc_tipo_usurio`, `role`) VALUES ('3', 'Aluno / Resposável', 'ALU_RESP_ROLE');


ALTER TABLE `gescolar`.`usuario` 
CHANGE COLUMN `senha` `senha` VARCHAR(300) NULL DEFAULT NULL ,
ADD UNIQUE INDEX `login_UNIQUE` (`login` ASC);

INSERT INTO `gescolar`.`usuario` (`id_usuario`, `login`, `senha`, `id_tipo_usuario`) VALUES ('1', 'teste', '$2a$10$6MVabyV/8iQ8TyTblTdtie2AZzESahwpqxAFjBDSON3PlXmZSHFzW', '1');
INSERT INTO `gescolar`.`usuario` (`id_usuario`, `login`, `senha`, `id_tipo_usuario`) VALUES ('2', 'teste2', '$2a$10$6MVabyV/8iQ8TyTblTdtie2AZzESahwpqxAFjBDSON3PlXmZSHFzW', '2');
INSERT INTO `gescolar`.`usuario` (`id_usuario`, `login`, `senha`, `id_tipo_usuario`) VALUES ('3', 'teste3', '$2a$10$6MVabyV/8iQ8TyTblTdtie2AZzESahwpqxAFjBDSON3PlXmZSHFzW', '3');
