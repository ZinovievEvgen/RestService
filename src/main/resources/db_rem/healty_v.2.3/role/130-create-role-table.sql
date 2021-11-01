create sequence roles_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE roles(
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('roles_id_seq'),
  name VARCHAR(255)
);