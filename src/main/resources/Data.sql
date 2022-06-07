
INSERT INTO Buren (username, password, email, enabled) VALUES ('user', '$2a$12$noB9MZ1JMsu6uCbjiPknMeeUyqOQU//YEaBQWNeRTNysvUhdV14XC','user@test.nl', TRUE);
INSERT INTO Buren (username, password, email, enabled) VALUES ('admin', '$2a$12$noB9MZ1JMsu6uCbjiPknMeeUyqOQU//YEaBQWNeRTNysvUhdV14XC', 'admin@test.nl', TRUE);


INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');