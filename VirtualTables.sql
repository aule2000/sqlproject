CREATE VIEW Gydytojai AS
SELECT Vardas, Pavarde, Kvalifikacija FROM Gydytojas WHERE Kvalifikacija = 'Kardiologas';

CREATE VIEW "Medicininio iraso view" AS 
SELECT Liga, "Iraso data" FROM "Medicininis irasas" WHERE "Iraso data" = CURRENT_DATE;

CREATE MATERIALIZED VIEW Alga AS SELECT * FROM Gydytojas WHERE Alga > 1000 WITH DATA;
