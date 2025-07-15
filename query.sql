CREATE DATABASE hardware_web_shop

USE hardware_web_shop

CREATE TABLE hardware (
    id int IDENTITY PRIMARY KEY,
    sifra VARCHAR(50) NOT NULL,
    naziv VARCHAR(50) NOT NULL,
    cijena DECIMAL(10,2) NOT NULL,
    tip VARCHAR(50) NOT NULL,
    kolicina_na_stanju INT NOT NULL
);

INSERT INTO hardware (sifra, naziv, cijena, tip, kolicina_na_stanju)
VALUES ('HW-CPU-001', 'Intel Core i7-12700K', 329.99, 'CPU', 10);

INSERT INTO hardware (sifra, naziv, cijena, tip, kolicina_na_stanju)
VALUES ('HW-GPU-001', 'NVIDIA GeForce RTX 4070', 599.00, 'GPU', 5);

INSERT INTO hardware (sifra, naziv, cijena, tip, kolicina_na_stanju)
VALUES ('HW-MBO-001', 'ASUS ROG STRIX B550-F', 189.50, 'MBO', 8);

INSERT INTO hardware (sifra, naziv, cijena, tip, kolicina_na_stanju)
VALUES ('HW-RAM-001', 'Corsair Vengeance 16GB DDR4', 79.99, 'RAM', 25);

INSERT INTO hardware (sifra, naziv, cijena, tip, kolicina_na_stanju)
VALUES ('HW-STO-001', 'Samsung 970 EVO 1TB SSD', 129.95, 'STORAGE', 12);

INSERT INTO hardware (sifra, naziv, cijena, tip, kolicina_na_stanju)
VALUES ('HW-OTH-001', 'Noctua NH-D15 CPU Cooler', 89.99, 'OTHER', 7);


SELECT * FROM hardware