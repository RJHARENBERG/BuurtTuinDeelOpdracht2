
Stappen plan:
mappen:
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Controllers;
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Exceptions;
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Entiteiten;
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Repositorys;
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Services;
    [v] Het project bevat een ExceptionController;
    [v] Het project bevat een RecordNotFoundException;
    [] Het project bevat een data.sql voor de voor in gevulde data;

De ExceptionController bevat:
    [v] een exceptionhandler

De RecordNotFoundException bevat:
    [v] een default exception
    [v] een exception met message
    [v] Extent de klasse met de RunTimeException.
    [v] Vul de klasse aan aan de hand van het voorbeeld in hoofdstuk 5.11 van de cursus Spring Boot.

Controler:
    [] een GET-request
    [] een GET-request
    [] een POST-request
    [] een PUT-request
    [] een DELETE-request

klasse:
    [] Voorzie de klasse van de juiste annotatie.
    [] maak in de klasse een exceptionHandler met de juiste notatie en response entitiy.

Het project bevat de volgende dependencies:
    [v] Spring Web
    [v] Spring Data Jpa
    [v] PostgreSQL Driver
    [nvt] De Application.properties bevat de properties uit hoofdstuk 9.2 van de cursus Spring Boot(met aangepaste namen)
    [] De "Naam van de klasse"+Repository extends JpaRepository met de juiste parameters
    [] Voeg de benodigde dependencies toe aan je POM.xml en laat Maven deze instaleren
    [] Voeg aan de application.properties de benodigde properties toe
    [] Maak een nieuwe database aan in PgAdmin (zorg dat de naam overeenkomt met de properties in je_application.properties)

Atributten in Models:
    [] velden aan maken
    [] getters em setters als velden privet zijn
    [] verantwoorden in documentatie waar om wel of geen constructor te gebruiken
    [] @Entity aanmaken
    [] @Id aanmaken
    [] @GeneratedValue aanmaken

Service:
    [] De map Services bevat een klasse genaamd "KlasseNaam"+Service;
    [] de juiste annotatie
    [] een private variabele "KlasseNaam"+Repository
    [] de connectie van de Service en de Repository door middel van een autowired
    [] een metoden maken voor de toDto om de data om te schrijven
    [] een metode maken voor de fromDto om de data om te schrijven
    [] een functie voor het ophalen van data
    [] een functie voor het ophalen van 1 data set
    [] een functie voor het verwijderen van 1 data set
    [] een functie voor het updaten van 1 data set
    [] De Controller is door middel van een autowired gelinkt aan de Service;

Dto
    [] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Dtos;
    [] techniese keuzen verantwoorden in documentatie waarom veld privet met geters en seters of de dto public maken?
    [] Dto maken
    [] inputDto maken
    [] De requestMappings in de Controller worden aangepast zodat deze de juiste response doorgeven via de Service;
    [] De Service maakt gebruik van de gegevens die we via de Controller doorkrijgen van de Dtos;
    [] Het project bevat de validator dependency uit paragraaf 8.1 van de cursus Spring Boot in Edhub.

Data flow door de lagen geen:
Het is belangrijk om goed te begrijpen hoe de lagen in onze multi-tier application samenwerken:
    [] De Controller ontvangt een verzoek op een endpoint, als er variable worden meegeven aan dit verzoek komen die
        binnen via de "KlasseNaam"+InputDto ->
    [] De Controller geeft aan de hand van het verzoek en eventuele meegekregen variable dit door aan de Service ->
    [] De Service spreekt aan de hand van de geschreven functie de Repository aan met de juiste find functie/query ->
    [] De Repository gaat aan de hand van het bijbehorende Model zoeken naar de juiste gegevens en stuurt deze terug naar
        de Service ->
    [] De Service past de logica toe uit de functie en geeft de response aan de hand van de "KlasseNaam"+Dto terug aan de
        Controller (De controller wordt vanuit de front-end of vanuit Postman aangesproken, en geeft ook het antwoord weer
        terug.)

Relaties:
    [] one to one
    [] one to many
    [] many to one
    [] voor een many to many moet je twee one to many's gebruiken met een tussen klassen
    [] zie klassen dieagram voor relaties LET OP de Code en de klasse dieagram moeten met el kaar over een komen!!!

post man:
    [] maak in poost man een map ge naamt TestEindpointsBuurtTuin
    [] maak hier in voor alle entpoints een test reqwest
    [] maak een export aan om deze data toe te voegen aan de zip met documentatie
    [] TestEindpointsBuurtTuin -> ... -> export


dubbel/vervuiling van data:
    [] zoorg er voor dat de data niet vervuilt wordt met dubele profiellen
    [] chec bij het aan maken van een profiel of de gebruiker al bestaat
    [] verkom dubbel gereedschap chek bij het aan maken van gereedschap of de gebruiker die al heeft
    [] verkom dubbele afspraken chek bij het uit lenen of de afspraak al niet gemaakt is

data.sql:
    [] maak een bestand in de map resources met de naam data.sql
    [] voeg in deze map start data om de aplicatie te kunnen starten

Securetie:
    [] probeer met een json webtoken JWT auterication te werken

unittests:
    [] Tevens voert de student unittests uit die gebruikmaken van de drie A’s,
    [] waarbij de test coverage minimaal 50% is exclusief getters en setters).

Spring-Boot test:

WebMvc:


