CREATE TABLE list
(
    description varchar(255),
    action varchar (255),
    category varchar (255)
);

INSERT INTO list(description, action, category)
VALUES ('Załadować zmywarkę', 'false', 'Obowiązki domowe');
INSERT INTO list(description, action, category)
VALUES ('Odrobić lekcje', 'false', 'Szkoła');
INSERT INTO list(description, action, category)
VALUES ('Złożyć wypowiedzenie', 'false', 'Praca');
INSERT INTO list(description, action, category)
VALUES ('Pościelić łóżko', 'true', 'Obowiązki domowe');