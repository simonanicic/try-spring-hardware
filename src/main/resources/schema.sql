CREATE TABLE hardware (
    id IDENTITY PRIMARY KEY,
    sifra VARCHAR(50) NOT NULL,
    naziv VARCHAR(50) NOT NULL,
    cijena DECIMAL(10,2) NOT NULL,
    tip VARCHAR(50) NOT NULL,
    kolicina_na_stanju INT NOT NULL
);