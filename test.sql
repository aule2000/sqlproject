--Gydytojas--
INSERT INTO Gydytojas (Nr, Vardas, Pavarde, AK, "Gimimo data", Kvalifikacija, Alga, "Telefono Nr")
VALUES (5, 'Jonas', 'Jonaitis', '50111598754 ','1987-01-01', 'Chirurgas', 880,'+37062582629');            //id

INSERT INTO Gydytojas (Nr, Vardas, Pavarde, AK, "Gimimo data", Kvalifikacija, Alga, "Telefono Nr")
VALUES (1785, 'Jonas', 'Jonaitis', '50111598754 ','2020-01-01', 'Chirurgas', 880,'+37062582629');     //data

INSERT INTO Gydytojas (Nr, Vardas, Pavarde, AK, "Gimimo data", Kvalifikacija, Alga, "Telefono Nr")   
VALUES (1787, 'Jonas', 'Jonaitis', '50111598754 ','1939-01-01', 'Ortopedas', 880,'+37062582629');    //data

INSERT INTO Gydytojas (Nr, Vardas, Pavarde, AK, "Gimimo data", Kvalifikacija, Alga, "Telefono Nr")
VALUES (1495, 'Jonas', 'Jonaitis', '50111598754 ','1987-01-01', 'Chirurgas', 580,'+37062582629');   //alga

INSERT INTO Gydytojas (Nr, Vardas, Pavarde, AK, "Gimimo data", Kvalifikacija, Alga, "Telefono Nr")
VALUES (1478, 'Jonas', 'Jonaitis', '50111598754 ','1987-01-01', 'Chirurgas', 1300,'+37062582629');  //alga

DELETE FROM Gydytojas WHERE Nr = 1000;

---Pacientas---
INSERT INTO Pacientas (Nr, Vardas, Pavarde, AK, Gatve, Namas, Butas, "Gimimo data", "Telefono Nr")
VALUES (74589, 'Jolanta','Petraityte', '47407231258','Vilniaus','23','2', '1879-07-23','+37062562837');   //data
DELETE FROM Pacientas WHERE Nr = 10001;



---Medicininis irasas---
INSERT INTO "Medicininis irasas" (Nr, Liga, "Paciento Nr")
VALUES (7856, 'Koronarine sirdies liga',5);     //default

DELETE FROM "Medicininis irasas" WHERE Nr = 7856;


--Triggers check--
INSERT INTO Gydytojas (Nr, Vardas, Pavarde, AK, "Gimimo data", Kvalifikacija, Alga, "Telefono Nr")
VALUES (1478, 'Jonas', 'Jonaitis', '50111598754 ','2001-01-01', 'Kardiologas', 880,'+37062582629');

--Materialized view check--
INSERT INTO Gydytojas (Nr, Vardas, Pavarde, AK, "Gimimo data", Kvalifikacija, Alga, "Telefono Nr")
VALUES (4752, 'Ieva', 'Papuskaite', '47401038798','1974-01-03', 'Stomatologe', 1150,'+37067452536');


DELETE FROM Gydytojas  WHERE Nr = 4752;


