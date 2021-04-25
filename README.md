# Intern - obszar Technology
# Zadanie rekrutacyjne nr 3
# Software Enginer

Zadanie wykonane jest w modelu MVC z użyciem SpringMVC.

Projekt można zbuildować z użyciem Mavena do pliku war, lub wykorzystać gotowy plik war - http://michal.kronmar.eu/allegro.war 
Aplikację należy uruchomić na kontenerze aplikacyjnym np. tomcat.
Z działającego demo można korzystać pod adresem https://michal.vps.kronmar.net/allegro/

Za pomocą wyszukiwarki wyszukujemy konkretne konta Github, po kliknięciu enter na klawiaturze, pokaże nam się lista repozytoriów danego użytkownika wraz z liczbą gwiazdek z jego repozytoriów. Po klinknięciu na konkretne repozytorium przechodzimy do jego strony w serwisie Github. 
Po prawej widzimy podgląd ostatnich wyszukiwań w trakcie tej sesji. Po kliknięciu przechodzimy ponownie do tego zapytania.



W MVC.Controller.java w lini 71 jest możliwość zmiany długości strony. Im dłuższa strona tym mniej zapytań musimy wykonać żeby wyświetlić je wszystkie.
W ramach poprawy można dodać uwierzytelnianie do API Githuba co spowoduje wzrost liczby zapytań na godzinę z 60 do 5000. Po przekroczeniu limitu będzie wyświetlany komunikat o braku znalezienia takiego użytkownika.

W przypadku rozszerzenia aplikacji możnaby się zastanowić nad użyciem jakiegoś frameworka na froncie (np. Angulara), co jednak przy tak małym projekcie nie było opłacalne.
