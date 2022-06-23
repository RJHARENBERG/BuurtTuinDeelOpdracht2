
INSERT INTO Buren (username, password, email, enabled, first_name, last_name, street_name, house_number, zipcode) VALUES ('user', '$2a$12$noB9MZ1JMsu6uCbjiPknMeeUyqOQU//YEaBQWNeRTNysvUhdV14XC','user@test.nl', TRUE, 'Tomas', 'Boom', 'Kruidenstraat', 53, '2424DD' );
INSERT INTO Buren (username, password, email, enabled, first_name, last_name, street_name, house_number, zipcode) VALUES ('user2', '$2a$12$noB9MZ1JMsu6uCbjiPknMeeUyqOQU//YEaBQWNeRTNysvUhdV14XC','user2@test.nl', TRUE, 'Anton', 'Weiers', 'Appelstraat', 2, '2424xD' );
INSERT INTO Buren (username, password, email, enabled, first_name, last_name, street_name, house_number, zipcode) VALUES ('admin', '$2a$12$noB9MZ1JMsu6uCbjiPknMeeUyqOQU//YEaBQWNeRTNysvUhdV14XC', 'admin@test.nl', TRUE, 'Danielle', 'van Dijk', 'GrasLaan', 88, '2424AC');


INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1001, 'Makita DLM432CT2','Grasmaaier', 'user','De Makita DLM432CT2 is dankzij zijn accu aandrijving en maaibreedte van 43 centimeter geschikt voor gazons tot 575 m². De maaier werkt op een dubbel accusysteem en je krijgt 2 Makita LXT 18 volt accu''s en een duolader meegeleverd.');
INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1002, 'Hozelock Superhoze Plus Uitrekbare Tuinslang 30 meter','Tuinslang', 'user','De Hozelock Superhoze Plus Uitrekbare Tuinslang 30 meter is een tuinslang geschikt voor het bewateren van grote tuinen. Hij rekt zichzelf tot 3 keer zijn formaat uit. Als je hem niet gebruikt, krimpt hij snel terug naar een formaat van 10 meter.');
INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1003, 'DeWalt D25134KP-QS','Boor', 'user','Van een houten schutting in elkaar zetten tot gaten boren in een betonnen muur en van het wegbikken van oude tegels in de keuken tot maken van doorvoergaten in metselwerk; met de DeWalt D25134KP-QS kan het allemaal');
INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1004, 'Bosch UniversalGardenTidy','Bladblazer', 'user','De Bosch UniversalGardenTidy bladblazer heeft een blaas- en zuigfunctie. Hierdoor bepaal je zelf of je de bladeren op een hoop blaast of opzuigt. De opgezogen bladeren worden vernipperd opgevangen. ');
INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1005, 'BLACK+DECKER GTC18502PC-QW','Heggenschaar', 'user','Ga je een middelgrote heg (die niet boven je hoofd uitkomt) snoeien met takken van maximaal 18 millimeter dik? Dan is de Black & Decker GTC18502PC-QW de heggenschaar voor jou.');
INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1006, 'Makita P-90635 118-delig','	Gereedschapskoffer', 'user2','Neem de Makita P-90635 118-delig mee als je gaat klussen en de kans dat je misgrijpt is bijzonder klein. De 118-delige set bestaat uit allerlei verschillende maten bits, doppen, ringsleutels en andere onmisbare accessoires voor de serieuze klusser.');
INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1007, 'Karcher K7 Premium Power Control Home','hogedrukreinigers', 'user2','Deze versie van de Karcher K7 Premium Power Control Home heeft een haspel, zodat je de 10 meter lange slang zonder knikken oprolt. Daarnaast krijg je een terrasreiniger en steen- en gevelreiniger meegeleverd. ');
INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1008, 'kruiwagen','Kruiwagen', 'user2','Let op: Door de afwijkende verpakkingsvorm van kruiwagens is het lastig onze artikelen extra beschermd aan te bieden bij onze vervoerders. Hierdoor kan het voorkomen dat er tijdens het vervoer lichte beschadigingen ontstaan.');
INSERT INTO tool (id, tool_name, type, user_id,description) VALUES (1009, 'Fiskars 1028542 Spade','Schop', 'user2','Voor het verplaatsen van zand, grond, gravel of bouwmaterialen is een robuuste schep nodig. Met dit gereedschap, sterk gebouwd en uitgerust met een breed blad, is de klus in een handomdraai geklaard.');




