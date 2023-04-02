DROP DATABASE IF exists tienda_bici;
CREATE DATABASE tienda_bici;

CREATE TABLE Cliente(
ID INT NOT NULL,
Nombre VARCHAR(50),
Edad INT,
Genero VARCHAR (10),
PRIMARY KEY (ID)
);

INSERT INTO Cliente (ID,Nombre,Edad,Genero) VALUES (1,'Pablo Ruiz',19,'Hombre');
INSERT INTO Cliente (ID,Nombre,Edad,Genero) VALUES (2,'Miguel Rios',20,'Hombre');
INSERT INTO Cliente (ID,Nombre,Edad,Genero) VALUES (3,'Irene Ruiz',16,'Mujer');

CREATE TABLE Bicicleta(
ID INT NOT NULL,
Marca VARCHAR(60),
Num_Rueda INT NOT NULL,
Tipo_Bici VARCHAR(30),
Genero VARCHAR(1),
PRIMARY KEY(ID)
);

INSERT INTO Bicicleta (ID,Marca,Num_Rueda,Tipo_Bici,Genero) VALUES (1,'CONWAY',29,'Rigida','H');
INSERT INTO Bicicleta (ID,Marca,Num_Rueda,Tipo_Bici,Genero) VALUES (2,'SCOTT',26,'Doble','H');
INSERT INTO Bicicleta (ID,Marca,Num_Rueda,Tipo_Bici,Genero) VALUES (3,'CABE MOTOR',26,'Rigida','M');
INSERT INTO Bicicleta (ID,Marca,Num_Rueda,Tipo_Bici,Genero) VALUES (4,'TOTAL',20,'BMX','T');

CREATE TABLE Registro_Compra(
ID_Cliente INT NOT NULL,
ID_Bicicleta INT NOT NULL,
ID_Registro INT NOT NULL,
Fecha_Compra DATE,
PRIMARY KEY (ID_Registro),
FOREIGN KEY (ID_Cliente) REFERENCES Cliente (ID) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (ID_Bicicleta) REFERENCES Bicicleta (ID) ON DELETE CASCADE ON UPDATE CASCADE
);



