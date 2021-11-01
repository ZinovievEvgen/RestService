create sequence tasks_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE tasks(
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('tasks_id_seq'),
  description VARCHAR(255),
  recommendation VARCHAR(255),
  id_task_type BIGINT,
  time_to_live BIGINT,
  quantity_success BIGINT,
  web_view_link VARCHAR(255)
);

GO

ALTER TABLE tasks
ADD CONSTRAINT fk_tasks_task_type_id FOREIGN KEY (id_task_type) REFERENCES task_type(id);

GO