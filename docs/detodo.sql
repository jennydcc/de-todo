-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-06-2021 a las 01:59:06
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `detodo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_administrador` bigint(20) NOT NULL,
  `bloqueado` bit(1) DEFAULT NULL,
  `contrasena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `habilitado` bit(1) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_usuario` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` bigint(20) NOT NULL,
  `bloqueado` bit(1) DEFAULT NULL,
  `contrasena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `habilitado` bit(1) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `acepta_acuerdo` bit(1) DEFAULT NULL,
  `apellido_materno` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `apellido_paterno` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `distrito` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero_documento` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sexo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_documento` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_usuario` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `bloqueado`, `contrasena`, `correo`, `habilitado`, `nombre`, `acepta_acuerdo`, `apellido_materno`, `apellido_paterno`, `direccion`, `distrito`, `numero_documento`, `sexo`, `telefono`, `tipo_documento`, `tipo_usuario`) VALUES
(1, b'0', '$2a$10$B2yJJKlw8knVnNGquKQDSekFrPJb1ax7HqxXWboUymK77o/rnPhoC', 'karen@gmail.com', b'1', 'Karen', b'1', 'Muñoz', 'Anaya ', 'Jr. las orquideas', '1', '45651256', 'F', '984912074', 'DNI', 'CLIENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `confirmation_token`
--

CREATE TABLE `confirmation_token` (
  `id` bigint(20) NOT NULL,
  `add_date` date DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL,
  `role` bigint(20) DEFAULT NULL,
  `token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` bigint(20) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `nombre`) VALUES
(1, 'Gasfitería'),
(2, 'Electricidad'),
(3, 'Informática'),
(4, 'Carpinteria'),
(5, 'Albañilería'),
(6, 'Mecánica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialista`
--

CREATE TABLE `especialista` (
  `id_especialista` bigint(20) NOT NULL,
  `bloqueado` bit(1) DEFAULT NULL,
  `contrasena` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `habilitado` bit(1) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `acepta_acuerdo` bit(1) DEFAULT NULL,
  `apellido_materno` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `apellido_paterno` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `distrito` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `numero_documento` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sexo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_documento` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tipo_usuario` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `especialista`
--

INSERT INTO `especialista` (`id_especialista`, `bloqueado`, `contrasena`, `correo`, `habilitado`, `nombre`, `acepta_acuerdo`, `apellido_materno`, `apellido_paterno`, `direccion`, `distrito`, `numero_documento`, `sexo`, `telefono`, `tipo_documento`, `tipo_usuario`) VALUES
(1, b'0', '$2a$10$VNNt.zz4BTrJ7PvGaRhhCeofttT2v5geC7DMAWc5FDeIx.kRmukga', 'igomez@gmail.com', b'1', 'Ivan', NULL, 'Gomez', 'Gomez', 'Jr. las Vegonias', '3', '44852369', 'M', '984912074', 'DNI', 'ESPECIALISTA'),
(2, b'0', '$2a$10$IYd7h.jNPfPynQOWhXy2c.aKAKDFZQRUbj8Hpw.E6B64fDuZKBbau', 'martin@mail.com', b'1', 'Martin', NULL, 'Lopez', 'Paiva', 'Jr. las Vegonias', '2', '44586652', 'M', '98497563', 'DNI', 'ESPECIALISTA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `id_servicio` bigint(20) NOT NULL,
  `detalle` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `direccion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `telefono` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  `id_especialidad` bigint(20) DEFAULT NULL,
  `id_especialista` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id_servicio`, `detalle`, `direccion`, `fecha`, `telefono`, `id_cliente`, `id_especialidad`, `id_especialista`) VALUES
(2, 'Solicito servicio de reparación de impresora', 'Jr. las Vegonias', '2021-06-30', '984912074', 1, 3, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_administrador`),
  ADD UNIQUE KEY `UK_571pycikd1pkkvboiav3f69gp` (`correo`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `UK_k6i2j3upwar1uora4mgiol6b` (`correo`);

--
-- Indices de la tabla `confirmation_token`
--
ALTER TABLE `confirmation_token`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `especialista`
--
ALTER TABLE `especialista`
  ADD PRIMARY KEY (`id_especialista`),
  ADD UNIQUE KEY `UK_fsr2i03jehfcdnawp28suynrv` (`correo`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`id_servicio`),
  ADD KEY `FKme35howa1h3bdl6mw50ts2kxh` (`id_cliente`),
  ADD KEY `FKbltwx92gw3jf704owqvbots08` (`id_especialidad`),
  ADD KEY `FKogh5fk75xagkc2uxh3m7i5tf5` (`id_especialista`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id_administrador` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `confirmation_token`
--
ALTER TABLE `confirmation_token`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  MODIFY `id_especialidad` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `especialista`
--
ALTER TABLE `especialista`
  MODIFY `id_especialista` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `id_servicio` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `FKbltwx92gw3jf704owqvbots08` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`),
  ADD CONSTRAINT `FKme35howa1h3bdl6mw50ts2kxh` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `FKogh5fk75xagkc2uxh3m7i5tf5` FOREIGN KEY (`id_especialista`) REFERENCES `especialista` (`id_especialista`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
