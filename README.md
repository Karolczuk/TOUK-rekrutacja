# TOUK-rekrutacja.
Aby uruchomić program, należy utworzyć bazę danych ticket_db. W pliku appication.properties znajdują się ustawienia bazy danych.
System jest inicjalizowany przykładowymi danymi,które są w pliku data.sql. 

Użyte technologie:
Java 11, Spring Boot, Spring Data

Baza dancch: MySQL

Endpointy:

rezerwacja biletów: http://localhost:8080/seats/reserve

zakup biletów - http://localhost:8080/user/pay

filmy w podanym przedziale czasowym : http://localhost:8080/seats/findSeats/13

filmy na dany dzień i czas: http://localhost:8080/repertoire

dostępne miejsca: http://localhost:8080/seats/findSeats/13

zajęte miejsca: http://localhost:8080/seats/findReservedSeats/13

dodawanie użytkownika : http://localhost:8080/user




