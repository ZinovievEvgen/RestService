create sequence services_and_items_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE services_and_items(
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('services_and_items_id_seq'),
  description VARCHAR(255),
  web_view_link VARCHAR(255),
  location VARCHAR(255),
  section_id BIGINT
);

GO

ALTER TABLE services_and_items
ADD CONSTRAINT fk_services_and_items_section_id FOREIGN KEY (section_id) REFERENCES sections(id);

GO