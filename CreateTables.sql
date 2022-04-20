CREATE TABLE Gydytojas (
Nr		INTEGER NOT NULL CHECK (Nr >= 1000),
Vardas		CHAR(30) NOT NULL,
Pavarde		VARCHAR(30) NOT NULL,
AK		CHAR(11) NOT NULL, 
"Gimimo data"	DATE  NOT NULL CONSTRAINT GimimoMetai CHECK ( EXTRACT(YEAR FROM "Gimimo data") < EXTRACT(YEAR FROM CURRENT_DATE) AND EXTRACT(YEAR FROM "Gimimo data") >= 1940),
Kvalifikacija 	CHAR(50) NOT NULL, 
Alga		FLOAT DEFAULT '800' CHECK (Alga BETWEEN 600 AND 1200),
"Telefono Nr"	CHAR(12) NOT NULL,
PRIMARY KEY(Nr)
);


CREATE TABLE Ligonine (
Nr				INTEGER NOT NULL,
Pavadinimas			VARCHAR(70) NOT NULL,
Adresas 			VARCHAR(32) NOT NULL,
PRIMARY KEY(Nr)
);


CREATE TABLE "Gydytojo Ligonine" (
"Gydytojo Nr"			INTEGER NOT NULL CHECK ("Gydytojo Nr" >= 1000),
"Registracijos Nr"		INTEGER NOT NULL,
PRIMARY KEY("Gydytojo Nr", "Registracijos Nr"),
CONSTRAINT Gydytojas_FK FOREIGN KEY("Gydytojo Nr") REFERENCES Gydytojas (Nr) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT Ligonine_FK FOREIGN KEY("Registracijos Nr") REFERENCES Ligonine (Nr) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Pacientas (
Nr				SERIAL,
Vardas 				CHAR(30) NOT NULL,
Pavarde				VARCHAR(30) NOT NULL,
AK				CHAR(11) NOT NULL,
Gatve				CHAR(30),
Namas				INTEGER,
Butas 				CHAR(5),
"Gimimo data"			DATE NOT NULL CHECK (EXTRACT(YEAR FROM "Gimimo data") >= 1880),
"Telefono Nr"			CHAR(12),
PRIMARY KEY(Nr)
);

CREATE TABLE "Paciento Ligonine" (
"Paciento Nr"			SERIAL,
"Registracijos Nr"		INTEGER NOT NULL,
PRIMARY KEY("Paciento Nr", "Registracijos Nr"),
CONSTRAINT Pacientas_FK FOREIGN KEY("Paciento Nr") REFERENCES Pacientas (Nr) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT Ligonine_FK FOREIGN KEY("Registracijos Nr") REFERENCES Ligonine (Nr) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE "Medicininis irasas" (
Nr		INTEGER NOT NULL,
Liga		CHAR(50) NOT NULL,
"Iraso data"	DATE DEFAULT CURRENT_DATE,
"Paciento Nr"	SERIAL,
PRIMARY KEY(Nr),
CONSTRAINT PACIENTAS_FK FOREIGN KEY("Paciento Nr") REFERENCES Pacientas (Nr) ON DELETE RESTRICT ON UPDATE RESTRICT
);