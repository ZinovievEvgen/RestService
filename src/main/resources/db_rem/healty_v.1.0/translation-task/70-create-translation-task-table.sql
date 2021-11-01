create sequence translation_task_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE translation_task(
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('translation_task_id_seq'),
  description_lang VARCHAR(255),
  recommendation_lang VARCHAR(255),
  view_links_lang VARCHAR(255),
  language VARCHAR(255),
  lang VARCHAR(255),
  task_id BIGINT
);

GO

ALTER TABLE translation_task
ADD CONSTRAINT fk_translation_task_task_id FOREIGN KEY (task_id) REFERENCES tasks(id);

GO