CREATE OR REPLACE FUNCTION MaxPacientuPerDiena()
  RETURNS TRIGGER 
  AS $$
BEGIN
	IF (SELECT COUNT (*) FROM "Medicininis irasas" WHERE NEW."Iraso data" = CURRENT_DATE) >=50
	THEN raise exception 'Pasiektas mediciniu irasu i sistema limitas per diena';
	END IF;
	RETURN NEW;
END; $$
language plpgsql;

CREATE TRIGGER MaxPacientuPerDiena
  BEFORE INSERT
  ON "Medicininis irasas"
  FOR EACH ROW
  EXECUTE PROCEDURE MaxPacientuPerDiena();


CREATE OR REPLACE FUNCTION MaxKvalifikaciju()
  RETURNS TRIGGER 
  AS $$
BEGIN
	IF (SELECT COUNT (*) FROM Gydytojas WHERE NEW.Kvalifikacija = Kvalifikacija) >=2
	THEN raise exception 'Daugiau sios kvalifikacijos zmoniu dirbti negali';
	END IF;
	RETURN NEW;
END; $$
language plpgsql;


CREATE TRIGGER MaxKvalifikaciju
  BEFORE INSERT
  ON Gydytojas 
  FOR EACH ROW
  EXECUTE PROCEDURE MaxKvalifikaciju();



