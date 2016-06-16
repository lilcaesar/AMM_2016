/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  root
 * Created: 16-giu-2016
 */

CREATE TABLE cliente
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    cognome VARCHAR(128),
    username VARCHAR(128),
    password VARCHAR(32),
    saldo REAL
);

CREATE TABLE venditore
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    cognome VARCHAR(128),
    username VARCHAR(128),
    password VARCHAR(32),
    saldo REAL
);

CREATE TABLE cliente
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    cognome VARCHAR(128),
    username VARCHAR(128),
    password VARCHAR(32),
    saldo REAL
);

CREATE TABLE prodotto
(
    id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    nome VARCHAR(128),
    prezzo REAL,
    disponibilita INTEGER,
    descrizione VARCHAR(256),
    URLImmagine VARCHAR(128),
    FOREIGN KEY (idVenditore) REFERENCES venditore(id)
);

INSERT INTO cliente(id, nome, cognome, username, password, saldo)
VALUES (default, 'Davide', 'Spano', 'SpanoDavide', '0', 9999.9),
(default, 'Mattia', 'Mancosu', 'mattiamancosu', '1234', 9999.9),
(default, 'Riccardo', 'Scateni', 'RicScat', '99', 100.0);

INSERT INTO venditore(id, nome, cognome, username, password, saldo)
VALUES (default, 'Mario', 'Rossi', 'mariorossi', '0', 9999.9),
(default, 'Luca', 'Bianchi', 'lucabianchi', '1234', 9999.9),
(default, 'Marco', 'Trafalgar', 'marcotrafalgar<', '99', 100.0);

INSERT INTO prodotto(id, nome, prezzo, disponibilita, descrizione, URLImmagine, idVenditore)
VALUES (default, 'STORM Racing Drone (RTF / Type-A V2)', 399.0, 4, 'Drone da corsa da 280mm, batteria incassata, Video System da 200mw. Motori potenti e eliche 6045. Compreso di LED fontali e posteriori rossi','img/drone.jpg', 1),
(default, 'RadioLink AT9', 199.0, 5, 'Peso:880g; Formato:183*193*100mm; Tensione di funzionamento:8.6~15v; Banda del canale:5.0MHz; Corrente di funzionamento:<105mA; Rigetto di canale adiacente:>38dBm; Distanza di controllo:>600m; Canale:9 canali; Frequenza:ISM a 2.4GHz (2400MHz a 2485mhz)', 'img/radiocomando.jpg',2),
(default, 'Walkera FPV Goggle 2', 99.0, 3, 'Occhiali fpv combo 52 pollici portatile wide screen video occhiali 800tvl Fotocamera 5.8 ghz 600 mw tx e rx','img/visore.jpg',3),
(default, '5.8Ghz Clover Leaf Antenna(Female Receptacle/Angled)', 29.9, 3, '5.8 GHz Video/ Audio Antenna per qualunque tipo di drone FPV','img/antenna.jpg',1),
(default, 'Set Ricambi STORM Racing Drone (RTF / Type-A V2)', 120.0, 10, 'Set di ricambi vari per STORM Racing Drone RTF/Type-A V2', 'img/ricambio.jpg', 2);