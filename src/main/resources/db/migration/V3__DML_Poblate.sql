INSERT INTO materia(nombre, creditos) VALUES('Teoria de la computacion', 2);        --1
INSERT INTO materia(nombre, creditos) VALUES('Intro a inteligencia artificial', 3); --2
INSERT INTO materia(nombre, creditos) VALUES('Redes y comunicaciones', 4);          --3
INSERT INTO materia(nombre, creditos) VALUES('Arquitectura de software', 3);        --4
INSERT INTO materia(nombre, creditos) VALUES('Analisis de algoritmos', 2);          --5


INSERT INTO profesor(nombre, apellido, correo) VALUES('Jorge', 'Valenzuela', 'jorge@valen.com');        --1
INSERT INTO profesor(nombre, apellido, correo) VALUES('Juan Pablo', 'Delgado', 'pablo@del.com');        --2
INSERT INTO profesor(nombre, apellido, correo) VALUES('Leonardo', 'Florez', 'leona@florez.com');        --3
INSERT INTO profesor(nombre, apellido, correo) VALUES('Daniel', 'Suarez', 'dan@suarezgmol.com');        --4
INSERT INTO profesor(nombre, apellido, correo) VALUES('Mariela', 'Curiel', 'marielacur@gm.com');        --5
INSERT INTO profesor(nombre, apellido, correo) VALUES('Luis', 'Carreño', 'luis@carreño.com');           --6
INSERT INTO profesor(nombre, apellido, correo) VALUES('Andrea', 'Rueda', 'andrea@rueda.com');           --7
INSERT INTO profesor(nombre, apellido, correo) VALUES('Oscar', 'Martinez', 'oscar@m.com');              --8


INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(1, 1, 'TEO001', '2024-07-18', '2024-11-22');                         --1
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(2, 3, 'IAA001', '2024-07-18', '2024-11-22');                         --2
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(2, 5, 'IAA002', '2024-07-18', '2024-11-22');                         --3
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(2, 7, 'IAA003', '2024-07-18', '2024-11-22');                         --4
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(3, 2, 'RED001', '2024-07-18', '2024-11-22');                         --5
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(3, 8, 'RED002', '2024-07-18', '2024-11-22');                         --6
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(3, 3, 'RED003', '2024-07-18', '2024-11-22');                         --7
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(4, 4, 'ARQ001', '2024-07-18', '2024-11-22');                         --8
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(4, 6, 'ARQ002', '2024-07-18', '2024-11-22');                         --9
INSERT INTO curso(materia_id, profesor_id, codigo, fecha_inicio, fecha_fin)
VALUES(5, 1, 'ANA001', '2024-07-18', '2024-11-22');                         --10

INSERT INTO estudiante (nombre, apellido, correo) VALUES
('Juan', 'Perez', 'juan.perez@example.com'),
('Maria', 'Gonzalez', 'maria.gonzalez@example.com'),
('Carlos', 'Ramirez', 'carlos.ramirez@example.com'),
('Ana', 'Martinez', 'ana.martinez@example.com'),
('Pedro', 'Sanchez', 'pedro.sanchez@example.com'),
('Laura', 'Diaz', 'laura.diaz@example.com'),
('Luis', 'Fernandez', 'luis.fernandez@example.com'),
('Marta', 'Gomez', 'marta.gomez@example.com'),
('Jose', 'Lopez', 'jose.lopez@example.com'),
('Paula', 'Morales', 'paula.morales@example.com'),
('Miguel', 'Ortega', 'miguel.ortega@example.com'),
('Sara', 'Jimenez', 'sara.jimenez@example.com'),
('David', 'Ruiz', 'david.ruiz@example.com'),
('Carmen', 'Vargas', 'carmen.vargas@example.com'),
('Javier', 'Castro', 'javier.castro@example.com'),
('Raquel', 'Nunez', 'raquel.nunez@example.com'),
('Alberto', 'Pardo', 'alberto.pardo@example.com'),
('Sofia', 'Dominguez', 'sofia.dominguez@example.com'),
('Enrique', 'Blanco', 'enrique.blanco@example.com'),
('Isabel', 'Santos', 'isabel.santos@example.com');
