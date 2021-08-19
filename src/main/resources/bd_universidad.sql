-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-08-2021 a las 06:26:29
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_universidad`
--
CREATE DATABASE IF NOT EXISTS `bd_universidad` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `bd_universidad`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(1, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `uni_alumnos`
--

DROP TABLE IF EXISTS `uni_alumnos`;
CREATE TABLE `uni_alumnos` (
  `id_alumno` int(11) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `celular` int(9) NOT NULL,
  `fecha_creacion` date NOT NULL DEFAULT current_timestamp(),
  `usuario_creacion` varchar(30) NOT NULL DEFAULT 'TEST'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `uni_curso`
--

DROP TABLE IF EXISTS `uni_curso`;
CREATE TABLE `uni_curso` (
  `id_curso` int(11) NOT NULL,
  `id_docente` int(11) NOT NULL,
  `nombre_curso` varchar(200) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  `fecha_creacion` date NOT NULL DEFAULT current_timestamp(),
  `usuario_creacion` varchar(30) NOT NULL DEFAULT 'TEST'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `uni_docente`
--

DROP TABLE IF EXISTS `uni_docente`;
CREATE TABLE `uni_docente` (
  `id_docente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `dni` varchar(8) NOT NULL,
  `celular` int(9) NOT NULL,
  `fecha_creacion` date NOT NULL DEFAULT current_timestamp(),
  `usuario_creacion` varchar(30) NOT NULL DEFAULT 'TEST'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `uni_especialidad`
--

DROP TABLE IF EXISTS `uni_especialidad`;
CREATE TABLE `uni_especialidad` (
  `id_especialidad` int(11) NOT NULL,
  `nombre_especialidad` varchar(120) NOT NULL,
  `fecha_creacion` date NOT NULL DEFAULT current_timestamp(),
  `usuario_creacion` varchar(30) NOT NULL DEFAULT 'TEST'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `uni_notas`
--

DROP TABLE IF EXISTS `uni_notas`;
CREATE TABLE `uni_notas` (
  `id_nota` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `nota` double NOT NULL,
  `usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `uni_usuarios`
--

DROP TABLE IF EXISTS `uni_usuarios`;
CREATE TABLE `uni_usuarios` (
  `usuario` varchar(255) NOT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `usuario_creacion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `uni_alumnos`
--
ALTER TABLE `uni_alumnos`
  ADD PRIMARY KEY (`id_alumno`);

--
-- Indices de la tabla `uni_curso`
--
ALTER TABLE `uni_curso`
  ADD PRIMARY KEY (`id_curso`);

--
-- Indices de la tabla `uni_docente`
--
ALTER TABLE `uni_docente`
  ADD PRIMARY KEY (`id_docente`);

--
-- Indices de la tabla `uni_especialidad`
--
ALTER TABLE `uni_especialidad`
  ADD PRIMARY KEY (`id_especialidad`);

--
-- Indices de la tabla `uni_notas`
--
ALTER TABLE `uni_notas`
  ADD PRIMARY KEY (`id_nota`);

--
-- Indices de la tabla `uni_usuarios`
--
ALTER TABLE `uni_usuarios`
  ADD PRIMARY KEY (`usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
