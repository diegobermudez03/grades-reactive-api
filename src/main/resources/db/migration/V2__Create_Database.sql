DROP TABLE nota;
DROP TABLE curso;
DROP TABLE estudiante;
DROP TABLE materia;
DROP TABLE profesor;


CREATE TABLE materia(
    id serial primary key,
    nombre varchar(100) not null,
    creditos integer not null
);

CREATE TABLE profesor(
    id serial primary key,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    correo varchar(100) not null
);

CREATE TABLE curso(
    id serial primary key,
    materia_id integer references materia(id) not null,
    profesor_id integer references profesor(id) not null,
    codigo varchar(100),
    fecha_inicio date not null,
    fecha_fin date not null
);

CREATE TABLE estudiante(
    id serial primary key,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    correo varchar(100) not null
);

CREATE TABLE nota(
    id serial primary key,
    curso_id integer references curso(id) not null,
    estudiante_id integer references estudiante(id) not null,
    observacion varchar(100) not null,
    valor numeric(3,2) not null,
    porcentaje numeric(4,2) not null
);
