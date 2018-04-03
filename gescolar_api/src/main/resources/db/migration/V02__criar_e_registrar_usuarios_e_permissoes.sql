INSERT INTO `gescolar`.`tipo_usuario` (`codigo`, `desc_tipo_usurio`, `role`) VALUES ('1', 'ADIM', 'ADM_ROLE');
INSERT INTO `gescolar`.`tipo_usuario` (`codigo`, `desc_tipo_usurio`, `role`) VALUES ('2', 'PROFESSOR', 'PRO_ROLE');
INSERT INTO `gescolar`.`tipo_usuario` (`codigo`, `desc_tipo_usurio`, `role`) VALUES ('3', 'ALUNO_RESPONSSAVEL', 'ALU_RESP_ROLE');

INSERT INTO `gescolar`.`usuario` (`codigo`, `login`, `senha`, `codigo_tipo_usuario`) VALUES ('1', 'teste', '$2a$10$6MVabyV/8iQ8TyTblTdtie2AZzESahwpqxAFjBDSON3PlXmZSHFzW', '1');
INSERT INTO `gescolar`.`usuario` (`codigo`, `login`, `senha`, `codigo_tipo_usuario`) VALUES ('2', 'teste2', '$2a$10$6MVabyV/8iQ8TyTblTdtie2AZzESahwpqxAFjBDSON3PlXmZSHFzW', '2');
INSERT INTO `gescolar`.`usuario` (`codigo`, `login`, `senha`, `codigo_tipo_usuario`) VALUES ('3', 'teste3', '$2a$10$6MVabyV/8iQ8TyTblTdtie2AZzESahwpqxAFjBDSON3PlXmZSHFzW', '3');
