create sequence complete_list_task_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE complete_list_task (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('complete_list_task_id_seq'),
  person_id BIGINT,
  task_id BIGINT,
  create_date TIMESTAMP (8),
  complete_date TIMESTAMP (8)
);

GO

ALTER TABLE complete_list_task
ADD CONSTRAINT fk_complete_list_task_person_id FOREIGN KEY (person_id) REFERENCES persons(id);

GO

ALTER TABLE complete_list_task
ADD CONSTRAINT fk_complete_list_task_task_id FOREIGN KEY (task_id) REFERENCES tasks(id);

GO