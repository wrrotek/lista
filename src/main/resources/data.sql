CREATE TABLE TASK
(
    description varchar(255),
    done varchar (255),
    category varchar (255)
);

INSERT INTO TASK(description, done, category)
VALUES ('Załadować zmywarkę', 'Nie', 'HOUSEWORK');
INSERT INTO TASK(description, done, category)
VALUES ('Odrobić lekcje', 'Nie', 'SCHOOL');
INSERT INTO TASK(description, done, category)
VALUES ('Złożyć wypowiedzenie', 'Nie', 'WORK');
INSERT INTO TASK(description, done, category)
VALUES ('Pościelić łóżko', 'Tak', 'HOUSEWORK');