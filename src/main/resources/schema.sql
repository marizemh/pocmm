create table pais(
    id varchar(2),
    nombre varchar(50),
    primary key (id)
);

create table persona (
  id varchar(2),
  nombres varchar(255),
  apellidos varchar(255),
  pais varchar(255),
  primary key (id)
);
