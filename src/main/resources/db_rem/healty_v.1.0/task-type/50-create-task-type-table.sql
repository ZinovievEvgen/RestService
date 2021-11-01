create sequence task_type_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE task_type (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('task_type_id_seq'),
  type VARCHAR(255)
);

GO