--CREATE DATABASE `detodo` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

-- Especialidades
INSERT INTO `detodo`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('1', 'Gasfitería');
INSERT INTO `detodo`.`especialidad` (`id_especialidad`, `nombre`) VALUES ('2', 'Electricidad');

-- Clientes
INSERT INTO `detodo`.`cliente`
(`id_cliente`, `nombre`, `tipo_usuario`, `correo`, `contrasena`, `bloqueado`, `habilitado`) VALUES 
('1', 'Claudia', 'CLIENTE', 'claudia@mail.com', '$2a$10$8o2IG0RXudGPkv.LXzlE8uY5YgIXP4qi0Lpe1MLjOJkJ0rLoPPApa', b'0', b'1');

-- Especialistas
INSERT INTO `detodo`.`especialista`
(`id_especialista`, `nombre`, `tipo_usuario`, `correo`, `contrasena`, `bloqueado`, `habilitado`) VALUES 
('1', 'Esteban', 'ESPECIALISTA', 'esteban@mail.com', '$2a$10$8o2IG0RXudGPkv.LXzlE8uY5YgIXP4qi0Lpe1MLjOJkJ0rLoPPApa', b'0', b'1');

-- Administradores
INSERT INTO `detodo`.`administrador`
(`id_administrador`, `nombre`, `tipo_usuario`, `correo`, `contrasena`, `bloqueado`, `habilitado`) VALUES 
('1', 'Adan', 'ADMINISTRADOR', 'adan@mail.com', '$2a$10$8o2IG0RXudGPkv.LXzlE8uY5YgIXP4qi0Lpe1MLjOJkJ0rLoPPApa', b'0', b'1');
