
CREATE TABLE POTRAWA(
NAZWA VARCHAR2(500), 
CENA NUMBER(10,0), 
ROZMIAR VARCHAR2(50)
 );
   
   
Create TABLE Pracownik(
login Varchar(10),
haslo Varchar(100),
typ Varchar(100)
);

CREATE TABLE Rezerwacja(
id number(10),
haslo varchar(10),
imie Varchar(100),
nazwisko Varchar(100),
pesel Number(12),
poczatekRezerwacji DATE,
koniecRezerwacji DATE,
rachunek NUMBER(10)
);

CREATE TABLE RezerwacjaPokoi(
id_rezerwacjaPokoj varchar(10),
id_goscia varchar(10),
id_pokoju varchar(10),
poczatekRezerwacji DATE,
koniecRezerwacji DATE
);


CREATE TABLE Pokoj1(
id Number(10),
ilosc_pokoi varchar2(20),
metraz varchar2(20),
cena Number(10),
klasa varchar2(20),
pietro Number(10),
wyposazenie varchar2(500),
stan varchar2(20)
);


CREATE TABLE Zlecenie(
id number(10),
nazwa varchar2(20),
typ varchar2(20),
cena Number(10),
datarozpoczecia DATE,
czastrwania  Number(10),
id_goscia number(10),
id_pracownika Varchar(10)
);

CREATE TABLE  "ZAMOWIENIE" 
   (	"ID" NUMBER(10), 
	
	"KOSZT" NUMBER(10,0), 
	"SZCZEGÃ“Å?Y" VARCHAR2(1000)
   ) ;