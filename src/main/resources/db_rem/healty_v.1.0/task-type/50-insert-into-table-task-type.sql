--liquibase formatted sql

insert into task_type(type) values ('Ежедневные'),
                                   ('Еженедельные'),
                                   ('Ежемесячные'),
                                   ('Закрепленные');
--rollback delete from task_type where value in ('Ежедневные','Еженедельные','Ежемесячные', 'Закрепленные');