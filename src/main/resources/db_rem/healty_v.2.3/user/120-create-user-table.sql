create sequence users_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE users(
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('users_id_seq'),
  username VARCHAR(255) UNIQUE,
  asd VARCHAR(255) UNIQUE,
  email VARCHAR(255) UNIQUE
);

GO