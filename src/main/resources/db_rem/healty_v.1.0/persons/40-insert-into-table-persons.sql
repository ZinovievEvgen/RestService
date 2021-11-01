--liquibase formatted sql

insert into persons(unique_id, surname, name, email, heal_point, med_point, password, username, date_birth, document, number_document, country, timezone, city)
            values('d302f18a-4ca0-4dbd-940b-2b4dfb7a74ec', 'Ivanov', 'Sergo', 'user1@mail.ru', 70, 100,'user1', 'user1', '1994-06-15' ,'passport','4356 789456', 'Russia', 'MSK','Moscow');

insert into persons(unique_id, surname, name, email, heal_point, med_point, password, username, date_birth, document, number_document, country, timezone, city)
            values('ecaebd33-7049-4702-8c36-5a844d8d1386', 'Petrov', 'Nestor', 'user2@mail.ru', 70, 100,'user2', 'user2', '1992-02-13' ,'passport','4356 789456', 'Russia', 'MSK','Moscow');

insert into persons(unique_id, surname, name, email, heal_point, med_point, password, username, date_birth, document, number_document, country, timezone, city)
            values('2fcdfb07-c0f5-4152-bcd7-fe35a6240e57', 'Sidorov', 'Sanya', 'user3@mail.ru', 70, 100, 'user3', 'user3', '1991-05-06' ,'passport','4356 789456', 'Russia', 'MSK','Moscow');

insert into persons(unique_id, surname, name, email, heal_point, med_point, password, username, date_birth, document, number_document, country, timezone, city)
            values('a1fb1d3d-28de-4011-ab82-42f74501a2bf', 'Sorokin', 'Aleksey', 'user4@mail.ru', 70, 100, 'user4', 'user4', '1996-11-29' ,'passport','4356 789456', 'Russia', 'MSK','Moscow');