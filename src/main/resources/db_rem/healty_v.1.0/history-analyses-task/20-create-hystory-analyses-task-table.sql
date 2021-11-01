create sequence history_analyses_task_id_seq
      start with 1
      increment by 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1;

GO

CREATE TABLE history_analyses_task (
  id BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('history_analyses_task_id_seq'),
  date TIMESTAMP (8),
  task_id BIGINT,
  count_to_complete BIGINT
);

GO

ALTER TABLE history_analyses_task
ADD CONSTRAINT fk_history_analyses_task_task_id FOREIGN KEY (task_id) REFERENCES tasks(id);

GO