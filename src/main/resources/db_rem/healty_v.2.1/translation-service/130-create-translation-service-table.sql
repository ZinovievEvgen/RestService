create sequence translation_services_and_items_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE translation_services_and_items(
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('translation_services_and_items_id_seq'),
  description_lang VARCHAR(255),
  view_links_lang VARCHAR(255),
  location_lang VARCHAR(255),
  language VARCHAR(255),
  lang VARCHAR(255),
  items_id BIGINT
);

GO

ALTER TABLE translation_services_and_items
ADD CONSTRAINT fk_translation_services_and_items_items_id FOREIGN KEY (items_id) REFERENCES services_and_items(id);

GO