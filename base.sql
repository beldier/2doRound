
CREATE TABLE Estudiante (
    idEstudiante SERIAL  NOT NULL,
    CONSTRAINT PK_Estudiante PRIMARY KEY (idEstudiante)
);

CREATE TABLE Area (
    idArea SERIAL  NOT NULL,
    nombre TEXT,
    CONSTRAINT PK_Area PRIMARY KEY (idArea)
);

CREATE TABLE Material (
    idMaterial SERIAL  NOT NULL,
    nombre TEXT,
    cantidad INTEGER,
    CONSTRAINT PK_Material PRIMARY KEY (idMaterial)
);

CREATE TABLE Proveedor (
    idProveedor SERIAL  NOT NULL,
    nombre TEXT,
    CONSTRAINT PK_Proveedor PRIMARY KEY (idProveedor)
);

CREATE TABLE Empleado (
    ciEmpleado INTEGER  NOT NULL,
    nombre TEXT,
    apellido TEXT,
    fecha_contratacion DATE,
    activo BOOLEAN,
    idArea INTEGER,
    diasTomados INTEGER,
    cod_empleado TEXT,
    fecha DATE,
    hora TEXT,
    CONSTRAINT PK_Empleado PRIMARY KEY (ciEmpleado)
);

CREATE TABLE Docente (
    ciEmpleado INTEGER  NOT NULL,
    CONSTRAINT PK_Docente PRIMARY KEY (ciEmpleado)
);

CREATE TABLE Registro_Salida (
    idRegistroSalida SERIAL  NOT NULL,
    ciEmpleado INTEGER  NOT NULL,
    horaSalida DATE,
    CONSTRAINT PK_Registro_Salida PRIMARY KEY (idRegistroSalida, ciEmpleado)
);

CREATE TABLE Registro_Entrada (
    idRegistroEntrada SERIAL  NOT NULL,
    horaIngreso DATE,
    ciEmpleado INTEGER  NOT NULL,
    CONSTRAINT PK_Registro_Entrada PRIMARY KEY (idRegistroEntrada, ciEmpleado)
);

CREATE TABLE Ingreso (
    idIngreso SERIAL  NOT NULL,
    date DATE,
    idProveedor INTEGER  NOT NULL,
    idMaterial INTEGER  NOT NULL,
    cantidadIngreso INTEGER,
    CONSTRAINT PK_Ingreso PRIMARY KEY (idIngreso, idProveedor, idMaterial)
);

CREATE TABLE Salida (
    idSalida SERIAL  NOT NULL,
    fecha DATE,
    ciEmpleado INTEGER  NOT NULL,
    idMaterial INTEGER  NOT NULL,
    cantidadSalida INTEGER,
    CONSTRAINT PK_Salida PRIMARY KEY (idSalida, ciEmpleado, idMaterial)
);

CREATE TABLE RegistroAlmuerzo (
    idRegistroAlmuerzo SERIAL  NOT NULL,
    fecha DATE  NOT NULL,
    ciEmpleado INTEGER  NOT NULL,
    CONSTRAINT PK_RegistroAlmuerzo PRIMARY KEY (idRegistroAlmuerzo, ciEmpleado)
);

CREATE TABLE RegistroCena (
    idRegistroCena SERIAL  NOT NULL,
    fecha DATE  NOT NULL,
    ciEmpleado INTEGER  NOT NULL,
    CONSTRAINT PK_RegistroCena PRIMARY KEY (idRegistroCena, ciEmpleado)
);

CREATE TABLE Materia (
    idMateria SERIAL  NOT NULL,
    nombre TEXT,
    ciEmpleado INTEGER,
    CONSTRAINT PK_Materia PRIMARY KEY (idMateria)
);

CREATE TABLE Inscripcion (
    idInscripcion SERIAL  NOT NULL,
    idEstudiante INTEGER  NOT NULL,
    idMateria INTEGER  NOT NULL,
    promedioFinal INTEGER,
    CONSTRAINT PK_Inscripcion PRIMARY KEY (idInscripcion, idEstudiante, idMateria)
);

ALTER TABLE Empleado ADD CONSTRAINT Area_Empleado 
    FOREIGN KEY (idArea) REFERENCES Area (idArea);

ALTER TABLE Materia ADD CONSTRAINT Docente_Materia 
    FOREIGN KEY (ciEmpleado) REFERENCES Docente (ciEmpleado);

ALTER TABLE Docente ADD CONSTRAINT Empleado_Docente 
    FOREIGN KEY (ciEmpleado) REFERENCES Empleado (ciEmpleado);

ALTER TABLE Registro_Salida ADD CONSTRAINT Empleado_Registro_Salida 
    FOREIGN KEY (ciEmpleado) REFERENCES Empleado (ciEmpleado);

ALTER TABLE Registro_Entrada ADD CONSTRAINT Empleado_Registro_Entrada 
    FOREIGN KEY (ciEmpleado) REFERENCES Empleado (ciEmpleado);

ALTER TABLE Ingreso ADD CONSTRAINT Proveedor_Ingreso 
    FOREIGN KEY (idProveedor) REFERENCES Proveedor (idProveedor);

ALTER TABLE Ingreso ADD CONSTRAINT Material_Ingreso 
    FOREIGN KEY (idMaterial) REFERENCES Material (idMaterial);

ALTER TABLE Salida ADD CONSTRAINT Empleado_Salida 
    FOREIGN KEY (ciEmpleado) REFERENCES Empleado (ciEmpleado);

ALTER TABLE Salida ADD CONSTRAINT Material_Salida 
    FOREIGN KEY (idMaterial) REFERENCES Material (idMaterial);

ALTER TABLE Inscripcion ADD CONSTRAINT Estudiante_Inscripcion 
    FOREIGN KEY (idEstudiante) REFERENCES Estudiante (idEstudiante);

ALTER TABLE Inscripcion ADD CONSTRAINT Materia_Inscripcion 
    FOREIGN KEY (idMateria) REFERENCES Materia (idMateria);

ALTER TABLE RegistroAlmuerzo ADD CONSTRAINT Empleado_RegistroAlmuerzo 
    FOREIGN KEY (ciEmpleado) REFERENCES Empleado (ciEmpleado);

ALTER TABLE RegistroCena ADD CONSTRAINT Empleado_RegistroCena 
    FOREIGN KEY (ciEmpleado) REFERENCES Empleado (ciEmpleado);
