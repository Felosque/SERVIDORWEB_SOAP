-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-08-2020 a las 22:04:15
-- Versión del servidor: 10.1.33-MariaDB
-- Versión de PHP: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `soa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `documento` varchar(100) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `genero` int(1) NOT NULL,
  `eps` varchar(100) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `correo` varchar(150) DEFAULT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`documento`, `nombres`, `apellidos`, `fecha_nacimiento`, `genero`, `eps`, `telefono`, `direccion`, `correo`, `estado`) VALUES
('111', 'Fabian', 'Lozano', '2010-08-10', 0, 'Salud Total', '29932342', 'Calle 90° Barrio Francisco', 'fabian.lozano@gmail.com', 1),
('222', 'Angela', 'Cuella', '2009-08-20', 1, 'Salud General', '20003231', 'Santa Marta del vació 222', 'angela.cuella@gmail.com', 1),
('333', 'Felipe', 'Lozano', '2007-08-25', 0, 'Salud Cop', '3001231231', 'Calle 12 Villa del rio', 'felipe.lozano@gmail.com', 1),
('444', 'Fernando', 'Cabello', '2005-08-26', 0, 'Sulitas', '3032132312', 'Falcon N¬ 3123', 'fernando.cabello@gmail.com', 1),
('555', 'Paola', 'Diaz', '2007-08-11', 1, 'Sulitas', '29993231', 'Costumer N° 32-321', 'paola.diaz@gmail.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materias`
--

CREATE TABLE `materias` (
  `codigo` int(10) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `grado` int(10) NOT NULL,
  `intensidad_horaria` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `materias`
--

INSERT INTO `materias` (`codigo`, `nombre`, `grado`, `intensidad_horaria`) VALUES
(1, 'Español', 1, 3.5),
(2, 'Matematicas', 1, 4.5),
(3, 'Ciencias Naturales', 1, 2.5),
(4, 'Etica y Religión', 1, 1),
(5, 'Educación Artistica', 1, 1),
(6, 'Español', 2, 2.5),
(7, 'Matematicas', 2, 3.5),
(8, 'Ciencias Naturales', 2, 2.3),
(9, 'Etica y Religión', 2, 1),
(10, 'Educación Artistica', 2, 1),
(11, 'Español', 3, 3.5),
(12, 'Matematicas', 3, 4),
(13, 'Ciencias Naturales', 3, 2.5),
(14, 'Etica y Religión', 3, 1.5),
(15, 'Educación Artistica', 3, 1.5),
(16, 'Geografía', 3, 2.5),
(17, 'Español', 4, 4),
(18, 'Matematicas', 4, 4.5),
(19, 'Ciencias Naturales', 4, 2.5),
(20, 'Etica y Religión', 4, 2),
(21, 'Educación Artistica', 4, 2),
(22, 'Geografía', 4, 3),
(23, 'Historia', 5, 3),
(24, 'Español', 5, 4),
(25, 'Matematicas', 5, 4.5),
(26, 'Ciencias Naturales', 5, 2.5),
(27, 'Etica y Religión', 5, 2),
(28, 'Educación Artistica', 5, 2),
(29, 'Geografía', 5, 3),
(30, 'Historia', 5, 3),
(31, 'Español', 6, 4.5),
(32, 'Matematicas', 6, 5),
(33, 'Ciencias Naturales', 6, 4.5),
(34, 'Geografia', 6, 3.5),
(35, 'Historia', 6, 3.5),
(36, 'Etica y Religion', 6, 4.5),
(37, 'Educacion Artistica', 6, 3),
(38, 'Español', 7, 4.5),
(39, 'Matematicas', 7, 5),
(40, 'Ciencias Naturales', 7, 4.5),
(41, 'Geografia', 7, 3.5),
(42, 'Historia', 7, 3.5),
(43, 'Etica y Religion', 7, 4.5),
(44, 'Educacion Artistica', 7, 3),
(45, 'Español', 8, 4.5),
(46, 'Matematicas', 8, 5),
(47, 'Ciencias Naturales', 8, 4.5),
(48, 'Geografia', 8, 3.5),
(49, 'Historia', 8, 3.5),
(50, 'Etica y Religion', 8, 4.5),
(51, 'Educacion Artistica', 8, 3),
(52, 'Español', 9, 4.5),
(53, 'Algebra', 9, 5),
(54, 'Ciencias Naturales', 9, 4.5),
(55, 'Geografia', 9, 3.5),
(56, 'Historia', 9, 3.5),
(57, 'Etica y Religion', 9, 4.5),
(58, 'Educacion Artistica', 9, 3),
(59, 'Español', 10, 4.5),
(60, 'Fisica', 10, 5),
(61, 'Quimica', 10, 4.5),
(62, 'Trigonometria', 10, 3.5),
(63, 'Filosofia', 10, 3.5),
(64, 'Etica y Religion', 10, 4.5),
(65, 'Ingles', 10, 3),
(66, 'Español', 11, 4.5),
(67, 'Fisica', 11, 6),
(68, 'Quimica', 11, 4.5),
(69, 'Trigonometria', 11, 3.5),
(70, 'Filosofia', 11, 3),
(71, 'Etica y Religion', 11, 2),
(72, 'Ingles', 11, 4),
(73, 'Calculo Basico', 11, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matriculas`
--

CREATE TABLE `matriculas` (
  `codigo` int(11) NOT NULL,
  `pkestudiante` varchar(100) NOT NULL,
  `pkMateria` int(10) NOT NULL,
  `fecha_inscripcion` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_final` date NOT NULL,
  `nota_definitiva` double NOT NULL,
  `estado` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`documento`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `materias`
--
ALTER TABLE `materias`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `matriculas`
--
ALTER TABLE `matriculas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `FKMATRICULAS256091` (`pkMateria`),
  ADD KEY `FKMATRICULAS767366` (`pkestudiante`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `materias`
--
ALTER TABLE `materias`
  MODIFY `codigo` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;

--
-- AUTO_INCREMENT de la tabla `matriculas`
--
ALTER TABLE `matriculas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `matriculas`
--
ALTER TABLE `matriculas`
  ADD CONSTRAINT `FKMATRICULAS256091` FOREIGN KEY (`pkMateria`) REFERENCES `materias` (`codigo`),
  ADD CONSTRAINT `FKMATRICULAS767366` FOREIGN KEY (`pkestudiante`) REFERENCES `estudiantes` (`documento`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
