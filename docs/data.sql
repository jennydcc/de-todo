-- CREATE DATABASE `detodo` CHARACTER SET utf8 COLLATE utf8_unicode_ci;

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
('1', 'Esteban', 'ESPECIALISTA', 'esteban@mail.com', '$2a$10$8o2IG0RXudGPkv.LXzlE8uY5YgIXP4qi0Lpe1MLjOJkJ0rLoPPApa', b'0', b'1')
('2', 'Juan', 'ESPECIALISTA', 'juan@mail.com', '$2a$10$8o2IG0RXudGPkv.LXzlE8uY5YgIXP4qi0Lpe1MLjOJkJ0rLoPPApa', b'0', b'1');

-- Administradores
INSERT INTO `detodo`.`administrador`
(`id_administrador`, `nombre`, `tipo_usuario`, `correo`, `contrasena`, `bloqueado`, `habilitado`) VALUES 
('1', 'Adan', 'ADMINISTRADOR', 'adan@mail.com', '$2a$10$8o2IG0RXudGPkv.LXzlE8uY5YgIXP4qi0Lpe1MLjOJkJ0rLoPPApa', b'0', b'1');

-- Distritos
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('1', 'Ancón');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('2', 'Ate Vitarte');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('3', 'Barranco');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('4', 'Breña');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('5', 'Carabayllo');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('6', 'Chaclacayo');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('7', 'Chorrillos');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('8', 'Cieneguilla');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('9', 'Comas');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('10', 'El Agustino');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('11', 'Independencia');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('12', 'Jesús María');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('13', 'La Molina');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('14', 'La Victoria');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('15', 'Lima');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('16', 'Lince');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('17', 'Los Olivos');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('18', 'Lurigancho');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('19', 'Lurín');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('20', 'Magdalena del Mar');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('21', 'Miraflores');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('22', 'Pachacamac');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('23', 'Pucusana');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('24', 'Pueblo Libre');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('25', 'Puente Piedra');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('26', 'Punta Hermosa');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('27', 'Punta Negra');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('28', 'Rímac');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('29', 'San Bartolo');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('30', 'San Borja');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('31', 'San Isidro');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('32', 'San Juan de Lurigancho');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('33', 'San Juan de Miraflores');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('34', 'San Luis');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('35', 'San Martín de Porres');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('36', 'San Miguel');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('37', 'Santa Anita');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('38', 'Santa María del Mar');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('39', 'Santa Rosa');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('40', 'Santiago de Surco');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('41', 'Surquillo');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('42', 'Villa El Salvador');
INSERT INTO `detodo`.`distrito` (`id_distrito`, `nombre`) VALUES ('43', 'Villa María del Triunfo');