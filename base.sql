
CREATE TABLE Plan_area (
    nombre_area TEXT  NOT NULL,
    precio INTEGER,
    CONSTRAINT PK_Plan_area PRIMARY KEY (nombre_area)
);

CREATE TABLE Promocion (
    id_promocion SERIAL  NOT NULL,
    descuento DOUBLE PRECISION,
    nombre TEXT,
    activo BOOLEAN default false,
    CONSTRAINT PK_Promocion PRIMARY KEY (id_promocion)
);

CREATE TABLE Genero (
    id_genero SERIAL  NOT NULL,
    nombre TEXT,
    CONSTRAINT PK_Genero PRIMARY KEY (id_genero)
);

CREATE TABLE Cliente (
    ci_cliente TEXT  NOT NULL,
    nombre TEXT,
    apellido TEXT,
    fecha_nacimiento DATE,
    activo BOOLEAN default TRUE,
    id_genero INTEGER,
    CONSTRAINT PK_Cliente PRIMARY KEY (ci_cliente)
);

CREATE TABLE Suscripcion (
    id_suscripcion SERIAL  NOT NULL,
    fecha_suscripcion TEXT,
    cantidad_sesiones INTEGER,
    sesiones_restantes INTEGER,
    ci_cliente TEXT  NOT NULL,
    id_promocion INTEGER,
    nombre_area TEXT,
    CONSTRAINT PK_Suscripcion PRIMARY KEY (id_suscripcion, ci_cliente)
);

CREATE TABLE Registro_Entrada (
    id_registro_entrada SERIAL  NOT NULL,
    fecha DATE,
    id_suscripcion INTEGER  NOT NULL,
    ci_cliente TEXT  NOT NULL,
    CONSTRAINT PK_Registro_Entrada PRIMARY KEY (id_registro_entrada, id_suscripcion, ci_cliente)
);

ALTER TABLE Cliente ADD CONSTRAINT Genero_Cliente 
    FOREIGN KEY (id_genero) REFERENCES Genero (id_genero);

ALTER TABLE Suscripcion ADD CONSTRAINT Cliente_Suscripcion 
    FOREIGN KEY (ci_cliente) REFERENCES Cliente (ci_cliente);

ALTER TABLE Suscripcion ADD CONSTRAINT Plan_area_Suscripcion 
    FOREIGN KEY (nombre_area) REFERENCES Plan_area (nombre_area);

ALTER TABLE Suscripcion ADD CONSTRAINT Promocion_Suscripcion 
    FOREIGN KEY (id_promocion) REFERENCES Promocion (id_promocion);

ALTER TABLE Registro_Entrada ADD CONSTRAINT Suscripcion_Registro_Entrada 
    FOREIGN KEY (id_suscripcion, ci_cliente) REFERENCES Suscripcion (id_suscripcion,ci_cliente);

