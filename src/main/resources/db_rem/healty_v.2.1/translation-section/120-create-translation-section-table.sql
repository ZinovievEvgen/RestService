create sequence translation_section_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE translation_section(
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('translation_section_id_seq'),
  description_lang VARCHAR(255),
  language VARCHAR(255),
  lang VARCHAR(255),
  section_id BIGINT
);

GO

ALTER TABLE translation_section
ADD CONSTRAINT fk_translation_section_section_id FOREIGN KEY (section_id) REFERENCES sections(id);

GO