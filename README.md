Event Management System

Projekt systemu do zarządzania wydarzeniami, rozwijany w trzech etapach w ramach przedmiotu Programowanie .NET.

Opis Etapów

Etap I: Podstawy API
W pierwszym etapie stworzono fundamenty systemu w oparciu o architekturę REST.
- Implementacja modelu danych `Event`.
- Stworzenie kontrolera obsługującego podstawowe operacje CRUD.
- Przechowywanie danych w pamięci operacyjnej (ulotna lista).

Etap II: Walidacja i Obsługa Błędów
Drugi etap skupił się na zapewnieniu poprawności danych i profesjonalnej obsłudze błędów.
- Wprowadzenie walidacji biznesowej (m.in. limit uczestników).
- Implementacja dedykowanych wyjątków (np. `ResourceNotFoundException`).
- Integracja z Swagger UI dla ułatwienia testowania API.

Etap III: Persystencja Danych i Optymalizacja
Trzeci etap wprowadził trwałość danych oraz mechanizmy profesjonalnego zarządzania nimi.
- Integracja z bazą danych H2 przy użyciu Spring Data JPA.
- Wdrożenie paginacji wyników dla obsługi dużej skali danych.
- Implementacja mechanizmu "Soft Delete" (miękkie usuwanie) z wykorzystaniem flagi logicznej.


Po uruchomieniu aplikacji, dokumentacja Swagger dostępna jest pod adresem:
http://localhost:8080/swagger-ui/index.html
