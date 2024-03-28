create table pais(
    id varchar(2),
    nombre varchar(50),
    primary key (id)
);

CREATE TABLE persona (
  id INT NOT NULL AUTO_INCREMENT,
  nombres VARCHAR(255) NOT NULL,
  apellidos VARCHAR(255) NOT NULL,
  pais VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

