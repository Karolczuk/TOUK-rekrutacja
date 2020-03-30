# TOUK-rekrutacja.
Aby uruchomić program, należy utworzyć bazę danych ticket_db. W pliku appication.properties znajdują się ustawienia bazy danych.
System jest inicjalizowany przykładowymi danymi,które są w pliku data.sql. 

Użyte technologie:
Java 11, Spring Boot, Spring Data

Baza dancch: MySQL

Endpointy:

rezerwacja biletów: http://localhost:8080/seats/reserve 

zakup biletów - http://localhost:8080/user/pay

repertuar w podanym przedziale czasowym : http://localhost:8080/repertoire/findAll

repertuar o konkretnym dniu i czasie : http://localhost:8080/repertoire

dodawanie użytkownika : http://localhost:8080/user

dostępne miejsca: http://localhost:8080/seats/findSeats/{repertoireId}

zajęte miejsca: http://localhost:8080/seats/findReservedSeats/{repertoireId}




