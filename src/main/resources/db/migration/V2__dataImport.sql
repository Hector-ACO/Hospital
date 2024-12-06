INSERT INTO `especialidad` (`id`, `nombre`) VALUES
    (1, 'Cadiologia'),
    (2, 'Desmatologia'),
    (3, 'Pediatria');

INSERT INTO `consultorio` (`id`, `numero`, `piso`) VALUES
    (1, 101, 1),
    (2, 102, 1),
    (3, 201, 2),
    (4, 202, 2),
    (5, 103, 1);

INSERT INTO `doctores` (`id`, `nombre`, `apellido_paterno`, `apellido_materno`, `especialidad`) VALUES
    (1, 'Juan', 'Peres', 'Martinez', 1),
    (2, 'John', 'Smith', 'Smith', 2),
    (3, 'Marco', 'Hernandez', 'Juarez', 1),
    (4, 'Aaron', 'Baeza', 'Mesa', 1);

INSERT INTO `pacientes` (`id`, `nombre`, `apellido_paterno`, `apellido_materno`) VALUES
    (1, 'Hector', 'Carrasco', 'Ochoa');