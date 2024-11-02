--I don't like the idea to have table "curso" with a composed key, since in table "nota" we have to reference the 3 fields
--I would prefer to use a surrogate key for "curso", however the only thing I was given for this project was the database schema
--and I need to respect it :(

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
    materia_id integer references materia(id),
    profesor_id integer references profesor(id),
    codigo varchar(100),
    fecha_inicio date not null,
    fecha_fin date not null,
    primary key(materia_id, profesor_id, codigo)
);

CREATE TABLE estudiante(
    id serial primary key,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    correo varchar(100) not null
);

CREATE TABLE nota(
    id serial primary key,
    materia_id integer not null,
    profesor_id integer not null,
    curso_codigo varchar(100) not null,
    estudiante_id integer references estudiante(id) not null,
    observacion varchar(100) not null,
    valor numeric(3,2) not null,
    porcentaje numeric(4,2) not null,
    foreign key (materia_id, profesor_id, curso_codigo) references curso(materia_id, profesor_id, codigo)
);
