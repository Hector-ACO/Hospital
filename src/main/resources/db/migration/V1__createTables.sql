CREATE TABLE `especialidad` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
    PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `doctores` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
    `apellido_paterno` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
    `apellido_materno` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_general_ci',
    `especialidad` INT(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `doctor_especialidad` (`especialidad`) USING BTREE,
    CONSTRAINT `doctor_especialidad` FOREIGN KEY (`especialidad`) REFERENCES `especialidad` (`id`) ON UPDATE NO ACTION ON DELETE SET NULL
);

CREATE TABLE `pacientes` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
    `apellido_paterno` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
    `apellido_materno` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
    PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `consultorio` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `numero` INT(11) NOT NULL,
    `piso` INT(11) NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE `citas` (
    `id` INT(11) NOT NULL,
    `id_doctor` INT(11) NOT NULL,
    `id_paciente` INT(11) NOT NULL,
    `id_consultorio` INT(11) NOT NULL,
    `hora_inicio` TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    `hora_fin` TIMESTAMP NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `cita_doctor` (`id_doctor`) USING BTREE,
    INDEX `cita_paciente` (`id_paciente`) USING BTREE,
    INDEX `cita_consultorio` (`id_consultorio`) USING BTREE,
    CONSTRAINT `cita_consultorio` FOREIGN KEY (`id_consultorio`) REFERENCES `consultorio` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT `cita_doctor` FOREIGN KEY (`id_doctor`) REFERENCES `doctores` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT `cita_paciente` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id`) ON UPDATE NO ACTION ON DELETE CASCADE
);