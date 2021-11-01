--liquibase formatted sql

insert into roles(name) values ('GUEST'),
                               ('USER'),
                               ('SPECIALIST'),
                               ('MODERATOR'),
                               ('ADMIN');
--rollback delete from roles where value in ('GUEST','USER','DOCTOR', 'MODER', 'ADMIN');