insert into person_friend(person_id, friend_id) values
    ((select id from persons where id = 1), (select id from persons where id = 2)),
    ((select id from persons where id = 1), (select id from persons where id = 3)),
    ((select id from persons where id = 2), (select id from persons where id = 3));