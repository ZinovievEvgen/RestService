create sequence persons_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE persons (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('persons_id_seq'),
  unique_id VARCHAR(255) UNIQUE,
  surname VARCHAR(255),
  username VARCHAR(255) UNIQUE,
  name VARCHAR(255),
  phone VARCHAR(255),
  email VARCHAR(255),
  password VARCHAR(255) UNIQUE,
  heal_point BIGINT,
  med_point BIGINT,
  date_birth timestamp(4),
  document VARCHAR(255),
  number_document VARCHAR(255),
  country VARCHAR(255),
  timezone VARCHAR(255),
  time TIMESTAMP without time zone,
  city VARCHAR(255)
);

GO