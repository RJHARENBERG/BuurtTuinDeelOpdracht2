
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
    [v] een GET-request
    [v] een GET-request
    [v] een POST-request
    [v] een PUT-request
    [v] een DELETE-request

klasse:
    [] Voorzie de klasse van de juiste annotatie.
    [v] maak in de klasse een exceptionHandler met de juiste notatie en response entitiy.

Het project bevat de volgende dependencies:
    [v] Spring Web
    [v] Spring Data Jpa
    [v] PostgreSQL Driver
    [nvt] De Application.properties bevat de properties uit hoofdstuk 9.2 van de cursus Spring Boot(met aangepaste namen)
    [v] De "Naam van de klasse"+Repository extends JpaRepository met de juiste parameters
    [] Voeg de benodigde dependencies toe aan je POM.xml en laat Maven deze instaleren
    [v] Voeg aan de application.properties de benodigde properties toe
    [v] Maak een nieuwe database aan in PgAdmin (zorg dat de naam overeenkomt met de properties in je_application.properties)

Atributten in Models:
    [v] velden aan maken
    [v] getters em setters als velden privet zijn
    [] verantwoorden in documentatie waar om wel of geen constructor te gebruiken
    [v] @Entity aanmaken
    [v] @Id aanmaken
    [v] @GeneratedValue aanmaken

Service:
    [v] De map Services bevat een klasse genaamd "KlasseNaam"+Service;
    [v] de juiste annotatie
    [v] een private variabele "KlasseNaam"+Repository
    [v] de connectie van de Service en de Repository door middel van een autowired
    [v] een metoden maken voor de toDto om de data om te schrijven
    [v] een metode maken voor de fromDto om de data om te schrijven
    [v] een functie voor het ophalen van data
    [v] een functie voor het ophalen van 1 data set
    [v] een functie voor het verwijderen van 1 data set
    [v] een functie voor het updaten van 1 data set
    [v] De Controller is door middel van een autowired gelinkt aan de Service;

Dto
    [v] Het project bevat, op de juiste plaats in de map-structuur, een map genaamd Dtos;
    [] techniese keuzen verantwoorden in documentatie waarom veld privet met geters en seters of de dto public maken?
    [v] Dto maken
    [v] inputDto maken
    [v] De requestMappings in de Controller worden aangepast zodat deze de juiste response doorgeven via de Service;
    [v] De Service maakt gebruik van de gegevens die we via de Controller doorkrijgen van de Dtos;
    [] Het project bevat de validator dependency uit paragraaf 8.1 van de cursus Spring Boot in Edhub.

Data flow door de lagen geen:
Het is belangrijk om goed te begrijpen hoe de lagen in onze multi-tier application samenwerken:
    [v] De Controller ontvangt een verzoek op een endpoint, als er variable worden meegeven aan dit verzoek komen die
        binnen via de "KlasseNaam"+InputDto ->
    [v] De Controller geeft aan de hand van het verzoek en eventuele meegekregen variable dit door aan de Service ->
    [v] De Service spreekt aan de hand van de geschreven functie de Repository aan met de juiste find functie/query ->
    [v] De Repository gaat aan de hand van het bijbehorende Model zoeken naar de juiste gegevens en stuurt deze terug naar
        de Service ->
    [v] De Service past de logica toe uit de functie en geeft de response aan de hand van de "KlasseNaam"+Dto terug aan de
        Controller (De controller wordt vanuit de front-end of vanuit Postman aangesproken, en geeft ook het antwoord weer
        terug.)

Relaties:
    [nvt] one to one
    [v] one to many
    [v] many to one
    [nvt] voor een many to many moet je twee one to many's gebruiken met een tussen klassen
    [] zie klassen dieagram voor relaties LET OP de Code en de klasse dieagram moeten met el kaar over een komen!!!
    [] als techniese keuze onder bouwen waar om er extra klassens zijn gemaakt zo als todo in projecten

post man:
    [v] maak in poost man een map ge naamt TestEindpointsBuurtTuin
    [v] maak hier in voor alle entpoints een test reqwest
    [] maak een export aan om deze data toe te voegen aan de zip met documentatie
        [] TestEindpointsBuurtTuin -> ... -> export


dubbel/vervuiling van data:
    [] zoorg er voor dat de data niet vervuilt wordt met dubele profiellen
    [] chec bij het aan maken van een profiel of de gebruiker al bestaat
    [] verkom dubbel gereedschap chek bij het aan maken van gereedschap of de gebruiker die al heeft
    [] verkom dubbele afspraken chek bij het uit lenen of de afspraak al niet gemaakt is

data.sql:
    [] maak een bestand in de map resources met de naam data.sql
        [] resourses -> maakt nieuw fill -> namme data.sql
    [] voeg in deze map start data om de aplicatie te kunnen starten

Securetie:
    [] probeer met een json webtoken JWT auterication te werken
    [] voor de techniese keuzes onder bouwen waar om een token een bepaalde tijd geldig is.
    [] voor de techniese keuzen onderbouwen waar om gekozen voor autorizatie key
    [] De POM bevat de _spring-boot-starter-security_ dependency  
    []De applicatie bevat:
        [] GlobalCorsConfiguration
        [] SpringSecurityConfig
        [] AuthenticationController
        [] UserController
        [] UserDto (of UserDto en UserInputDto)
        [] UsernameNotFoundException
        [] JWTFilter
        [] Authority
        [] AuthorityKey
        [] User
        [] AuthenticationRequest(vorm van inputDto)
        [] AuthenticationResponse(vorm van dto)
        [] UserRepository
        [] CustomUserDetailService
        [] UserService
        [] JwtUtil
        [] RandomStringGenerator
    [] Binnen de applicatie wordt rekening gehouden met CORS
    [] De applicatie moet draaien met toegang tot de endpoints voor de juiste gebruikers geven
    [v] Voeg de volgende dependencies toe aan je POM.XML.
        [v] <dependency>
             <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
            </dependency>
        [v] <dependency>
            <groupId>io.jsonwebtoken</groupId>
             <artifactId>jjwt</artifactId>
            <version>0.9.1</version>
            </dependency>
    [v] Voeg de `User`, `Authority` en de `AuthorityKey` toe als modellen.
    [v] Voeg de `UserDto` toe aan de applicatie.
    [v] Voeg een map toe genaamd `utils`. Voeg hier de `JwtUtil` en de `RandomStringGenerator` toe aan het project.
    [v] Voeg de `UserService` en de `CustomUserDetailService` toe aan het project.
    [v] Voeg de `BadRequestException` en de `UsernameNotFoundException` toe aan je project en zorg dat de exception 
        handlers zijn toegevoegd in je `ExceptionController`.
    [v] Voeg een nieuwe map genaamd `payload` met daarin de `AuthenticationRequest` en de `AuthenticationResponse` toe 
        aan het project.
    [v] Voeg de `AuthenticationController` en de `UserController` toe aan je project.
    [] Voeg de `JwtRequestFilter` toe aan je project in een map genaamd `filter`.
    [] Voeg als laatste de `SpringSecurityConfig` en de `GlobalCorsConfiguration` toe aan het project.
    [] Kijk goed of je in de `SpringSecurityConfig` nog antmatchers wil/moet toevoegen.
    [] Update de data.sql met users en authorities.
    [] Check goed of je alle opdracht-comments hebt uitgevoerd.

unittests:
    [] Tevens voert de student unittests uit die gebruikmaken van de drie A’s,
    [] waarbij de test coverage minimaal 50% is exclusief getters en setters).

Spring-Boot test:

WebMvc:


