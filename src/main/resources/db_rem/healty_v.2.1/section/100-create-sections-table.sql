create sequence sections_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE sections(
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('sections_id_seq'),
  description VARCHAR(255)
);

GO