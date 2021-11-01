insert into user_role(user_id, role_id) values
    ((select id from users where username = 'user'), (select id from roles where name = 'GUEST')),
    ((select id from users where username = 'user'), (select id from roles where name = 'USER')),
    ((select id from users where username = 'admin'), (select id from roles where name = 'GUEST')),
    ((select id from users where username = 'admin'), (select id from roles where name = 'USER')),
    ((select id from users where username = 'admin'), (select id from roles where name = 'SPECIALIST')),
    ((select id from users where username = 'admin'), (select id from roles where name = 'MODERATOR')),
    ((select id from users where username = 'admin'), (select id from roles where name = 'ADMIN'));